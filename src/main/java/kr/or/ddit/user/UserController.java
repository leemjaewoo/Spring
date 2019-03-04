package kr.or.ddit.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.util.model.PageVO;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Resource(name="userService")
	private IUserService userService;
	
	/**
	* Method : userAllList
	* 작성자 : leemjaewoo
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	*/
	@RequestMapping("/userAllList")
	public String userAllList(Model model){
		
		List<UserVO> userList = userService.getAllUser();
		
		
		model.addAttribute("userList", userList);
		
		return "user/userAllList";
		
	}
	
	
	/**
	* Method : userPagingList
	* 작성자 : leemjaewoo
	* 변경이력 :
	* @param pageVo
	* @param model
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	*/
	@RequestMapping("/userPagingList")
	public String userPagingList(PageVO pageVo, Model model ){
		
		
		//PageVO pageVo = new PageVO(page, pageSize);
		
		Map<String, Object> resultMap =  userService.selectUserPagingList(pageVo);
		model.addAllAttributes(resultMap);
		
		model.addAttribute("pageSize", pageVo.getPageSize());
		model.addAttribute("page", pageVo.getPage());
		
		return "user/userPagingList";
		
	
	}
	
	@RequestMapping(path="/user",method=RequestMethod.GET )
	public String user(@RequestParam("userId")String userId, Model model){
		
		
		UserVO userVo = userService.selectUser(userId);
		model.addAttribute("uservo", userVo);
		
		return "user/user";
	}
	
	
	@RequestMapping("/profileImg")
	public void profileImg(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("userId")String userId) throws IOException{
		
		response.setHeader("content-Disposition", "attachment; filename=profile.png");
		response.setContentType("image.png");
		
		
		UserVO vo = userService.selectUser(userId);
		FileInputStream fis;
		if(vo != null && vo.getRealFilename() != null) {
			 fis = new FileInputStream(new File(vo.getRealFilename()));
		}else {
			
			
			
			
			ServletContext application =  request.getServletContext();
			String noimgPath = application.getRealPath("/upload/noimage.jpg");
			fis = new FileInputStream(new File(noimgPath));
		}
		
		ServletOutputStream sos = response.getOutputStream();
		
		
		byte[] buff = new byte[512];
		int len = 0;
		while( (len = fis.read(buff)) > -1 ) {
			sos.write(buff);
		}
		
		sos.close();
		fis.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
