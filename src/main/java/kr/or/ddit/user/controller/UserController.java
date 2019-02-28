package kr.or.ddit.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/User")
public class UserController extends HttpServlet {
	
	private IUserService userService;
	
	
	
	
	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//userid확인
		
		String userId = request.getParameter("userId");
		
		//해당 파라미터로 userService.selectUser(userId);
		
		UserVO uservo = userService.selectUser(userId);
		
		
		//조회된 user객체를 request객체에 속성으로 저장
		
		request.setAttribute("uservo", uservo);
		
		
		request.getRequestDispatcher("/user/user.jsp").forward(request, response);
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
	}
}
