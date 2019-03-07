package kr.or.ddit.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.util.model.PageVO;

@RequestMapping("/user")
@Controller
public class UserController {

	@Resource(name = "userService")
	private IUserService userService;

	/**
	 * Method : userAllList 작성자 : leemjaewoo 변경이력 :
	 * 
	 * @return Method 설명 : 사용자 전체 리스트 조회
	 */
	@RequestMapping("/userAllList")
	public String userAllList(Model model) {

		List<UserVO> userList = userService.getAllUser();

		model.addAttribute("userList", userList);
		return "userAllListTiles";
		//return "user/userAllList";

	}

	/**
	 * Method : userPagingList 작성자 : leemjaewoo 변경이력 :
	 * 
	 * @param pageVo
	 * @param model
	 * @return Method 설명 : 사용자 페이징 리스트 조회
	 */
	@RequestMapping("/userPagingList")
	public String userPagingList(PageVO pageVo, Model model) {

		// PageVO pageVo = new PageVO(page, pageSize);

		Map<String, Object> resultMap = userService.selectUserPagingList(pageVo);
		model.addAllAttributes(resultMap);

		model.addAttribute("pageSize", pageVo.getPageSize());
		model.addAttribute("page", pageVo.getPage());
		return "userPagingListTiles";
		//return "user/userPagingList";

	}

	@RequestMapping(path = "/user", method = RequestMethod.GET)
	public String user(@RequestParam("userId") String userId, Model model) {

		UserVO userVo = userService.selectUser(userId);
		model.addAttribute("uservo", userVo);
		return "userTiles";
		//return "user/user";
	}

	@RequestMapping("/profileImg")
	public void profileImg(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("userId") String userId) throws IOException {

		response.setHeader("content-Disposition", "attachment; filename=profile.png");
		response.setContentType("image.png");

		UserVO vo = userService.selectUser(userId);
		FileInputStream fis;
		if (vo != null && vo.getRealFilename() != null) {
			fis = new FileInputStream(new File(vo.getRealFilename()));
		} else {

			ServletContext application = request.getServletContext();
			String noimgPath = application.getRealPath("/upload/noimage.jpg");
			fis = new FileInputStream(new File(noimgPath));
		}

		ServletOutputStream sos = response.getOutputStream();

		byte[] buff = new byte[512];
		int len = 0;
		while ((len = fis.read(buff)) > -1) {
			sos.write(buff);
		}

		sos.close();
		fis.close();

	}

	/**
	 * Method : userForm 작성자 : leemjaewoo 변경이력 :
	 * 
	 * @return Method 설명 : 사용자 등록폼 요청
	 */
	@RequestMapping(path = "/userForm", method = RequestMethod.GET)
	public String userForm() {
		return "user/userForm";
	}

	@RequestMapping(path = "/userForm", method = RequestMethod.POST)
	public String userForm(UserVO userVo, @RequestPart("profile") MultipartFile profile, HttpSession session,
			Model model) throws IllegalStateException, IOException {

		UserVO selectUser = userService.selectUser(userVo.getUserId());

		// 중복체크 통과(신규등록)
		if (selectUser == null) {
			// 사용자 프로파일 업로드 한경우

			String filename = "";
			String realFilename = "";

			if (profile.getSize() > 0) {
				filename = profile.getOriginalFilename();
				realFilename = ("c:\\picture\\" + UUID.randomUUID().toString());
				profile.transferTo(new File(realFilename));

			}
			userVo.setFilename(filename);
			userVo.setRealFilename(realFilename);

			int cnt = 0;
			try {
				cnt = userService.insertUser(userVo);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 정상입력 성공
			if (cnt == 1) {
				session.setAttribute("msg", "정상 등록 되었습니다");
				return "redirect:/user/userPagingList"; // contextPath 작업필요

			}
			// 정상입력 실패
			else {

				return "/user/userForm";
			}

		}
		// 중복체크 실패
		else {
			model.addAttribute("msg", "중복체크에 실패 했습니다.");
			return "/user/userForm";
		}

	}

	@RequestMapping(path = "/usermodifyformcontroller", method = RequestMethod.GET)
	public String userModify_get(@RequestParam("userId") String userId, Model model) {

		UserVO uservo = userService.selectUser(userId);

		model.addAttribute("uservo", uservo);

		return "user/userModify";
	}

	@RequestMapping(path = "/usermodifyformcontroller", method = RequestMethod.POST)
	public String userModify_post(UserVO uservo, @RequestPart("profile") MultipartFile profile, HttpSession session,
			Model model, HttpServletRequest request, RedirectAttributes ra) throws IllegalStateException, IOException {

		

			String filename = "";
			String realFilename = "";

			
				if(profile.getSize()>0){
					
				filename = profile.getOriginalFilename();
				realFilename = ("c:\\picture\\" + UUID.randomUUID().toString());
				profile.transferTo(new File(realFilename));
				}

				uservo.setFilename(filename);
				uservo.setRealFilename(realFilename);
				
				//사용자 비밀번호 암호화
				
				//비밀번호 수정 요청여부
				//사용자가 값을 입력하지 않은경우 => 기존 비밀번호 유지
				if(uservo.getPass().equals("")){
					UserVO userVoForPass = userService.selectUser(uservo.getUserId());
					uservo.setPass(userVoForPass.getPass());
				}
				//사용자가 비밀번호를 신규 등록한 경우
				else{
					uservo.setPass(KISA_SHA256.encrypt(uservo.getPass()));
				}
				
				
				

			int cnt = 0;
			try {
				cnt = userService.updateUser(uservo);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 정상입력 성공
			// 사용자 정보 수정 정상 : 사용자 상세 조회 페이지 이동
			if (cnt == 1) {
				/*
				  
				 redirect 파라미터를 보내는 방법
				1.url로 작성
				 "redirect:/user/user?userId=" + userVo.getUserId();
				2.model객체의 속성 : 저장된 속성을 자동으로 파라미터 변환
				model.addAttrubute("userId", userVo.getUserId());
				 return "redirect:/user/user";
				3. RedirectAtrribute(ra) 객체를 이용
				 return "redirect:/user/user";
				 */
				ra.addAttribute("userId" , uservo.getUserId());
				ra.addFlashAttribute("msg", "정상 등록 되었습니다");
				//session.setAttribute("msg", "정상 등록 되었습니다");
				//model.addAttribute("userId", uservo.getUserId());
				//return "redirect" + request.getContextPath() + " :/user/user"; // contextPath 작업필요
				return "redirect:/user/user"; // contextPath 작업필요

			}
			// 정상입력 실패
			else {

				return "/user/userForm";
			}


	}
	
	















}
