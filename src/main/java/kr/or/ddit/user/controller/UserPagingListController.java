package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;
import kr.or.ddit.util.model.PageVO;

/**
 * Servlet implementation class UserPagingListController
 */
@WebServlet("/userpagingList")
public class UserPagingListController extends HttpServlet {
	
	
	private IUserService userService;
	
	
	@Override
	public void init() throws ServletException {
		
		userService = new UserServiceImpl();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//page, pagesize에 해당하는 파라미터 받기 ==> pageVO
		//단 파라미터가 없을경우 page : 1 , pageSize :10
		
		
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		int pageSize = request.getParameter("pageSize") == null ? 10 : Integer.parseInt(request.getParameter("pageSize"));
		
		PageVO pagevo = new PageVO(page,pageSize);
		
		//userService객체를 이용 userPagingList 를 조회
		Map<String, Object> resultMap = userService.selectUserPagingList(pagevo);
		List<UserVO> userlist = (List<UserVO>)resultMap.get("userList");
		int userCnt = (Integer)resultMap.get("userCnt");
		//request객체에 조회된 결과를 속성으로 설정
		
		request.setAttribute("userlist", userlist);
		request.setAttribute("userCnt", userCnt);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("page", page);
		
		//userPagingList를 화면으로 출력할 jsp로 위임(forward)
		request.getRequestDispatcher("/user/userPagingList.jsp").forward(request, response);
		
	
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	
	
	
	}

}