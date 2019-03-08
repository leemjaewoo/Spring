package kr.or.ddit.user.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.test.LogicTestConfig;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

public class UserDaoImplTest extends LogicTestConfig{
	
	@Resource(name="userDao")
	private IUserDao userdao;
	
	@Before
	public void setup() {
	
	
	}
	
	@After
	public void tearDown() {
		
	}
	
	
	
	
	
	@Test
	public void testGetUser() {
		UserDaoImpl dao = new UserDaoImpl();
		
		List<UserVO> a = dao.getAllUser();
		
		assertNotNull(a);

	}
	
	
	
	
	
	@Test
	public void testSelectUserPagingList() {
		UserDaoImpl dao = new UserDaoImpl();
		
		//***Given***//*
		
		PageVO pagevo = new PageVO(1,10);
		
		//***When***//*
		
		List<UserVO> list = dao.selectUserPagingList(pagevo);
		for(UserVO user : list) {
			System.out.println(user);
		}
		
		
		//***Then***//*

		assertNotNull(list);
		
		
	}
	
	
	/**
	* Method : testgetUsercnt
	* 작성자 : leemjaewoo
	* 변경이력 :
	* Method 설명 : 전체 사용자 수를 조회
	*/
	@Test
	public void testgetUsercnt() {
		
		int cnt = userdao.getUserCnt();
		System.out.println(cnt);
		
		assertNotNull(cnt);
		
	}
	
	@Test
	public void testPagination() {
		
	
	



		//***Given***//
		int userCnt = 105;
		int pageSize = 10;
		
		
		//***When***//
		
		int lastPage = userCnt/pageSize + (userCnt%pageSize > 0 ? 1 : 0);
		
		
		//***Then***//*

	}
	
	
	
	@Test
	public void userInsert() {
		
		
		/***Given***/
		UserVO vo = new UserVO();
		
		/***When***/
		vo.setUserId("1");
		vo.setUserNm("1");
		vo.setAlias("1");
		vo.setAddr1("1");
		vo.setAddr2("1");
		vo.setZipcode("1");
		vo.setPass("1");
		
		
		
		
		int cnt = userdao.insert( vo);
		
		
		/***Then***/

		assertNotNull(cnt);




	}




}
