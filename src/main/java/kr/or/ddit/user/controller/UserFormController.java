package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.UserServiceImpl;
import kr.or.ddit.util.PartUtil;

@WebServlet("/userForm")
@MultipartConfig(maxFileSize=5*1024*1024, maxRequestSize=5*5*1024*1024)
public class UserFormController extends HttpServlet {
	
	
	
	
	/**
	* Method : doGet
	* 작성자 : leemjaewoo
	* 변경이력 :
	* @param request
	* @param response
	* @throws ServletException
	* @throws IOException
	* Method 설명 : 사용자 등록 폼
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
		
		
	
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
			
			
			if(profilePart.getSize() > 0) {
				//사용자 테이블 파일명을 저장(실제 업로드한 파일명, 파일 충돌을 방지하기 위해 사용한 uuid)
				String contentDisposition = profilePart.getHeader("Content-Disposition");
				 filename = PartUtil.getFileNameFromPart(contentDisposition);
				 realFilename = "c:\\picture\\" + UUID.randomUUID().toString();
				
				
				//디스크에 기록 
				profilePart.write(realFilename);
				
				
			}
			//사용자가 사진을 올리지 않은 경우
			
			vo.setFilename(filename);
			vo.setRealFilename(realFilename);
			
			
			
			if(uservo == null) {
			int cnt = userServiceImpl.insertUser(vo);
				if(cnt == 1) {
					//request.getRequestDispatcher("/userpagingList").forward(request, response);
					
					request.getSession().setAttribute("msg", "정상 등록 되었습니다");
					response.sendRedirect(request.getContextPath() +  "/userpagingList");
					
				}else {
					
					doGet(request, response);
				}
				
			}else {
				request.setAttribute("msg", "중복체크에 실패했습니다");
				
				doGet(request, response);
			}
		
		
	
			
			
			
		/*
		 * 1. 사용자 아이디 중복체크
		 * 2. 중복체크 통과 : 사용자 정보를 db에 입력
		 * 3. 사용자 페이징 리스트 1 페이지로 이동
		 * 4. 중복체크 통과 실패 : 사용자 등록페이지로 이동
		 */
		
		
	
		
		
		
		
		
		
		
	}

}
