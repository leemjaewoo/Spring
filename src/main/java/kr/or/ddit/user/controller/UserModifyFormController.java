package kr.or.ddit.user.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;
import kr.or.ddit.util.PartUtil;

@WebServlet("/usermodifyformcontroller")
@MultipartConfig(maxFileSize = 5*1024*1024, maxRequestSize = 5*5*1024*1024)
public class UserModifyFormController extends HttpServlet {
	private IUserService userService;
	
	
	
	
	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}
	
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
				
		   String vo = request.getParameter("userId");
		
		
		    System.out.println(vo);
		
		
		
		
		
				String userId = request.getParameter("userId");
				
				//해당 파라미터로 userService.selectUser(userId);
				
				UserVO uservo = userService.selectUser(userId);
				
				
				//조회된 user객체를 request객체에 속성으로 저장
				
				request.setAttribute("uservo", uservo);
				
				
				request.getRequestDispatcher("/user/userModify.jsp").forward(request, response);
	
	
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		request.setCharacterEncoding("utf-8");
		
		
		String userId = request.getParameter("userId");
		
		
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		UserVO uservo =  userServiceImpl.selectUser(userId);
		
		UserVO vo = new UserVO();
		
		vo.setUserId(request.getParameter("userId"));
		vo.setUserNm(request.getParameter("userNm"));
		vo.setAlias(request.getParameter("alias"));
		vo.setAddr1(request.getParameter("addr1"));
		vo.setAddr2(request.getParameter("addr2"));
		vo.setZipcode(request.getParameter("zipcode"));
		vo.setPass(request.getParameter("pass"));
		
		
		
		//사용자 사진
		Part profilePart =  request.getPart("profile");
		//사용자가 사진을 올린 경우
		
		
		
		String filename = "";
		String realFilename = "";
		
		URLEncoder.encode(vo.getUserId(), "utf-8");
			
		
		
		if(profilePart.getSize() > 0) {
			//사용자 테이블 파일명을 저장(실제 업로드한 파일명, 파일 충돌을 방지하기 위해 사용한 uuid)
			String contentDisposition = profilePart.getHeader("Content-Disposition");
			 filename = PartUtil.getFileNameFromPart(contentDisposition);
			 realFilename = "c:\\picture\\" + UUID.randomUUID().toString();
			
			
			//디스크에 기록 
			profilePart.write(realFilename);
			
		}
		
		vo.setFilename(filename);
		vo.setRealFilename(realFilename);
		
		
		
		
		
		
		int cnt = userServiceImpl.updateUser(vo);
			if(cnt == 1) {
				//request.getRequestDispatcher("/userpagingList").forward(request, response);
				
				request.getSession().setAttribute("msg", "정상 등록 되었습니다");
				response.sendRedirect(request.getContextPath() +  "/User?userId=" + vo.getUserId());
				
			}else {
				
				doGet(request, response);
			}
			
	
	
	
		
		
		
		
		
		
	
	}

}
