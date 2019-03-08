package kr.or.ddit.user.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.test.LogicTestConfig;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

public class UserServiceImplTest extends LogicTestConfig{
	
	
private SqlSession sqlSession;
	
	
	@Resource(name="userService")
	private IUserService userservice;
	@Before
	public void setup() {
	}
	
	@After
	public void tearDown() {
		
	}


	@Test
	public void testGetAlluser() {
		//***Given***//*
		
		//***When***//*
		List<UserVO> a = userservice.getAllUser();
		
		//***Then***//*
		assertNotNull(a);

	}
	
	@Test
	public void testPagingList() {
		
		//***Given***//*
		
		PageVO pagevo = new PageVO(1,10);
		
		//***When***//*
		
		Map<String, Object> resultMap = userservice.selectUserPagingList(pagevo);
		
		
		
		//***Then***//*

		assertNotNull(resultMap);
		

	}
	
	
	
	@Test
	public void UserInsert() {
		//***Given***//
		UserVO vo = new UserVO();
		
		//***When***//
		vo.setUserId("6678");
		vo.setUserNm("1");
		vo.setPass("1");
		vo.setAlias("1");
		vo.setAddr1("1");
		vo.setAddr2("1");
		vo.setZipcode("1");
		
	
	int cnt = userservice.insertUser(vo);
	assertNotNull(cnt);
	}
	
	
	
	@Test
	public void UserIdCheck() {
		//***Given***//
		
		//***When***//
		UserVO user = userservice.selectUser("brown");
		
		//***Then***//
		assertNotNull(user);
		
	}

	@Test
	public void updateUser() {
		//***Given***//
		UserServiceImpl dao = new UserServiceImpl();
		UserVO vo = new UserVO();
		vo.setUserId("userId3");
		vo.setUserNm("2");
		vo.setAlias("1");
		vo.setAddr1("1");
		vo.setAddr2("1");
		vo.setZipcode("1");
		vo.setPass("1");
		
		//***When***//
		int a = dao.updateUser(vo);
		
		//***Then***//
		assertNotNull(a);
		
	}





}
