package kr.or.ddit.mvc;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.File;
import java.io.FileInputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.test.WebTestConfig;
import kr.or.ddit.user.service.IUserService;

public class MvcControllerTest extends WebTestConfig {
	private static final String USER_INSERT_TEST_ID = "sallyTest2";	
	
	
	@Resource(name="userService")
	private IUserService userService;
	@Before
	public void initData(){
		userService.deleteUser(USER_INSERT_TEST_ID);
	}
	
	
	
	
	

	/**
	 * Method : testView 작성자 : leemjaewoo 변경이력 : Method 설명 : 파일 업로드 테스트 뷰 요청 테스트
	 * 
	 * @throws Exception
	 */
	@Test
	public void testView() throws Exception {
		/*** Given ***/
		mockMvc.perform(get("/mvc/view")).andExpect(status().isOk()).andExpect(view().name("mvc/view"));

		/*** When ***/

		/*** Then ***/

	}

	/**
	* Method : testFileupLoad
	* 작성자 : leemjaewoo
	* 변경이력 :
	* Method 설명 : 파일 업로드 테스트
	 * @throws Exception 
	*/
	@Test
	public void testFileupLoad() throws Exception{
		
		/***Given***/
		File profileFile = new File("C:\\Users\\leemjaewoo\\Desktop\\레인저스사진\\sally.png");
		
		FileInputStream fis = new FileInputStream(profileFile);
		
		MockMultipartFile file = new MockMultipartFile("profile", "sally.png", "image/png", fis);
		mockMvc.perform(fileUpload("/mvc/fileupload").file(file).param("userId", "brown"))
		.andExpect(status().isOk()).andExpect(view().name("mvc/view"));
		
		/***When***/

		
		
		
		/***Then***/

		
		
		
		
	}
	
	/**
	* Method : testUserForm_post
	* 작성자 : leemjaewoo
	* 변경이력 :
	* Method 설명 : 사용자 등록 요청 테스트
	 * @throws Exception 
	*/
	@Test
	public void testUserForm_post_success() throws Exception{
		
		/***Given***/
		
		File profileFile = new File("C:\\Users\\leemjaewoo\\Desktop\\레인저스사진\\moon.png");
		FileInputStream fis = new FileInputStream(profileFile);
		
		
		
		MockMultipartFile file = new MockMultipartFile
				("profile", "moon.png", "image/png", fis);
		
		
		MvcResult mvcResult =
		mockMvc.perform(fileUpload("/user/userForm").file(file)
				.param("userId", USER_INSERT_TEST_ID)
				.param("userNm", "샐리테스트")
				.param("alias", "병아리")
				.param("addr1", "대전시 중구 대흥로 76")
				.param("addr2", "2층 DDIT")
				.param("zipcode", "34942")
				.param("pass", "testpass")).andExpect(view().name("redirect:/user/userPagingList")).andReturn();
				
		
		/***When***/
		
		HttpSession session = mvcResult.getRequest().getSession();
		
		
		/***Then***/
		assertEquals("정상 등록 되었습니다", session.getAttribute("msg"));

		
	}
	
	/**
	* Method : testUserForm_post_fail_duplicateUser
	* 작성자 : leemjaewoo
	* 변경이력 :
	* @throws Exception
	* Method 설명 : 사용자 등록요청(중복 사용자로 인한 등록 실패 케이스) 테스트
	*/
	@Test
	public void testUserForm_post_fail_duplicateUser() throws Exception{
		
		/***Given***/
		
		File profileFile = new File("C:\\Users\\leemjaewoo\\Desktop\\레인저스사진\\moon.png");
		FileInputStream fis = new FileInputStream(profileFile);
		
		
		
		MockMultipartFile file = new MockMultipartFile
				("profile", "moon.png", "image/png", fis);
		
		
		MvcResult mvcResult =
		mockMvc.perform(fileUpload("/user/userForm").file(file)
				.param("userId", "sally")
				.param("userNm", "샐리테스트")
				.param("alias", "병아리")
				.param("addr1", "대전시 중구 대흥로 76")
				.param("addr2", "2층 DDIT")
				.param("zipcode", "34942")
				.param("pass", "testpass")).andExpect(view().name("/user/userForm")).andReturn();
				
		
		/***When***/
		
		ModelAndView mav = mvcResult.getModelAndView();
		String msg = (String) mav.getModel().get("msg");
		
		/***Then***/
		assertEquals("중복체크에 실패 했습니다.", msg);

		
	}
	
	
	/**
	* Method : testUserForm_post_fail_insertError
	* 작성자 : leemjaewoo
	* 변경이력 :
	* @throws Exception
	* Method 설명 : 사용자 등록(zipcode 사이즈 에러 sql에러)
	*/
	@Test
	public void testUserForm_post_fail_insertError() throws Exception{
		
		/***Given***/
		
		File profileFile = new File("C:\\Users\\leemjaewoo\\Desktop\\레인저스사진\\moon.png");
		FileInputStream fis = new FileInputStream(profileFile);
		
		
		
		MockMultipartFile file = new MockMultipartFile
				("profile", "moon.png", "image/png", fis);
		
		
		MvcResult mvcResult =
		mockMvc.perform(fileUpload("/user/userForm").file(file)
				.param("userId", USER_INSERT_TEST_ID)
				.param("userNm", "샐리테스트")
				.param("alias", "병아리")
				.param("addr1", "대전시 중구 대흥로 76")
				.param("addr2", "2층 DDIT")
				.param("zipcode", "34942349421111111111111111")
				.param("pass", "testpass")).andExpect(view().name("/user/userForm")).andReturn();
				
		
		/***When***/
		
		
		
		/***Then***/

		
	}

}
