package kr.or.ddit.user.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.test.WebTestConfig;
import kr.or.ddit.user.model.UserVO;

public class UserControllerTest extends WebTestConfig{

	/**
	* Method : testUserAllList
	* 작성자 : leemjaewoo
	* 변경이력 :
	* Method 설명 : 사용자 전체 조회 테스트
	 * @throws Exception 
	*/
	@Test
	public void testUserAllList() throws Exception {
		
		/***Given***/
		
		
		
		/***When***/

		MvcResult mvcResult = mockMvc.perform(get("/user/userAllList")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		
		List<UserVO> userList = (List<UserVO>)mav.getModel().get("userList");
		
		/***Then***/
		
		assertEquals("user/userAllList", viewName);
		assertNotNull(userList);
		assertTrue(userList.size() > 100 );

		
	}
	
	
	
	@Test
	public void testUserPagingList() throws Exception {
		
		/***Given***/
		
		MvcResult mvcResult = mockMvc.perform(get("/user/userPagingList")).andReturn();
		
		
		/***When***/

		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		
		ModelMap modelMap = mav.getModelMap();
		
		List<UserVO> resultMap =  (List<UserVO>) mav.getModel().get("userList");
		int userCnt = (int) modelMap.get("userCnt");
		int page = (int) modelMap.get("page");
		int pageSize = (int) modelMap.get("pageSize");
		
		/***Then***/
		
		assertEquals("user/userPagingList", viewName);
		assertNotNull(resultMap);
		assertNotNull(userCnt);
		assertNotNull(page);
		assertNotNull(pageSize);

		
	}

}
