package kr.or.ddit.user.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
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
	
	
	@Test
	public void testUserDetail() throws Exception {
		
		/***Given***/
		
		
		
		/***When***/

		MvcResult mvcResult = mockMvc.perform(get("/user/user").param("userId", "brown")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		
		UserVO uservo = (UserVO)mav.getModel().get("uservo");
		
		/***Then***/
		
		assertEquals("user/user", viewName);
		assertNotNull(uservo);

		
	}
	
	//@Test
	//public void testProfileImg(){}
	
	
	@Test
	public void testUserForm() throws Exception{
		/***Given***/
		
		MvcResult mvcResult = mockMvc.perform(get("/user/userForm")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		
		
		/***Then***/
		
		assertEquals("user/userForm", viewName);

	}
	
	
	@Test
	public void testUserModify() throws Exception{
		/***Given***/
		
		MvcResult mvcResult = mockMvc.perform(get("/user/usermodifyformcontroller").param("userId", "brown")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		
		
		/***Then***/
		
		assertEquals("user/userModify", viewName);

	}
	@Test
	public void testUserModify2() throws Exception{
		/***Given***/
		
		File profileFile = new File("C:\\Users\\leemjaewoo\\Desktop\\레인저스사진\\moon.png");
		FileInputStream fis = new FileInputStream(profileFile);
		
		
		
		MockMultipartFile file = new MockMultipartFile
				("profile", "moon.png", "image/png", fis);
		
		
		MvcResult mvcResult =
		mockMvc.perform(fileUpload("/user/usermodifyformcontroller").file(file)
				.param("userId", "sally")
				.param("userNm", "샐리테스트")
				.param("alias", "병아리")
				.param("addr1", "대전시 중구 대흥로 76")
				.param("addr2", "2층 DDIT")
				.param("zipcode", "34942")
				.param("pass", "testpass")).andReturn();
				
		
		/***When***/
		
		HttpSession session = mvcResult.getRequest().getSession();
		
		
		/***Then***/
		assertEquals("정상 등록 되었습니다", session.getAttribute("msg"));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
