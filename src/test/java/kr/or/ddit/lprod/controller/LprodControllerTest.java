package kr.or.ddit.lprod.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.model.ProdVO;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.test.WebTestConfig;
import kr.or.ddit.user.model.UserVO;

public class LprodControllerTest extends WebTestConfig{

	/**
	* Method : testUserAllList
	* 작성자 : leemjaewoo
	* 변경이력 :
	* Method 설명 : 사용자 전체 조회 테스트
	 * @throws Exception 
	*/
	@Test
	public void testLProdAllList() throws Exception {
		
		/***Given***/
		
		
		
		/***When***/

		MvcResult mvcResult = mockMvc.perform(get("/lprod/lprodAllList")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		
		List<LprodVO> lprodList = (List<LprodVO>)mav.getModel().get("allLprod");
		
		/***Then***/
		
		assertEquals("lprod/lprodAllList", viewName);
		assertNotNull(lprodList);

		
	}
	
	
	
	@Test
	public void testlprodPagingList() throws Exception {
		
		/***Given***/
		
		MvcResult mvcResult = mockMvc.perform(get("/lprod/lprodpagingList")).andReturn();
		
		
		/***When***/

		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		
		ModelMap modelMap = mav.getModelMap();
		
		List<LprodVO> lprodList = (List<LprodVO>) mav.getModel().get("lprodList");
		int lprodCnt = (int) modelMap.get("lprodCnt");
		int page = (int) modelMap.get("page");
		int pageSize = (int) modelMap.get("pageSize");
		
		/***Then***/
		
		assertEquals("lprod/lprodPagingList", viewName);
		assertNotNull(lprodList);
		assertNotNull(lprodCnt);
		assertNotNull(page);
		assertNotNull(pageSize);

		
	}
	
	
	@Test
	public void testLprodDetail() throws Exception {
		

		MvcResult mvcResult = mockMvc.perform(get("/lprod/lprod").param("lprod", "P101")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		
		
		/***Then***/
		
		assertEquals("lprod/lprod", viewName);

		
	}
	
	
	
	
	
	
	
	
	

}
