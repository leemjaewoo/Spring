package kr.or.ddit.user.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.test.LogicTestConfig;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

public class UserServiceImplTest extends LogicTestConfig{
	
	
private SqlSession sqlSession;
	
	
	@Resource(name="userService")
	private IUserService userservice;
	@Before
	public void setup() {
		//userservice = new UserServiceImpl();
		SqlSessionFactory sqlsessionfactory	 =new MybatisSqlSessionFactory().getSqlSessionFactory();
		
		sqlSession = sqlsessionfactory.openSession();
	}
	
	@After
	public void tearDown() {
		sqlSession.close(); 
		
	}


	@Test
	public void test1() {
		//***Given***//*
		UserServiceImpl dao = new UserServiceImpl();
		
		//***When***//*
		List<UserVO> a = dao.getAllUser();
		
		//***Then***//*
		assertNotNull(a);

	}
	@Test
	public void test2() {
		//***Given***//
		//UserServiceImpl dao = new UserServiceImpl();
		
		//***When***//
		List<UserVO> list = userservice.getAllUser();
		
		//***Then***//
		assertNotNull(list);
		
	}
	
	@Test
	public void test3() {
		
		//***Given***//*
		
		PageVO pagevo = new PageVO(1,10);
		
		//***When***//*
		
		Map<String, Object> resultMap = userservice.selectUserPagingList(pagevo);
		
		List<UserVO> userList =(List<UserVO> )resultMap.get("userList");
		int usercnt = (Integer)resultMap.get("userCnt");
		
		
		
		for(UserVO user : userList) {
			System.out.println(user);
		}
		
		System.out.println("usercnt :" + usercnt);
		
		
		//***Then***//*

		assertNotNull(userList);
		

	}
	
	
	
	@Test
	public void userInsert() {
		//***Given***//
		UserVO vo = new UserVO();
		
		//***When***//
		vo.setUserId("999");
		vo.setUserNm("1");
		vo.setAlias("1");
		vo.setAddr1("1");
		vo.setAddr2("1");
		vo.setZipcode("1");
		vo.setPass("1");
		
	
	int cnt = userservice.insertUser(vo);
	assertNotNull(cnt);
	}
	
	
	
	@Test
	public void UserIdCheck() {
		//***Given***//
		UserServiceImpl dao = new UserServiceImpl();
		
		//***When***//
		UserVO a = dao.selectUser("brown");
		System.out.println(a.getUserId());
		
		//***Then***//
		assertNotNull(a);
		
	}

//	@Test
//	public void updateUser() {
//		//***Given***//
//		UserServiceImpl dao = new UserServiceImpl();
//		UserVO vo = new UserVO();
//		vo.setUserId("leemjw87");
//		vo.setUserNm("2");
//		vo.setAlias("1");
//		vo.setAddr1("1");
//		vo.setAddr2("1");
//		vo.setZipcode("1");
//		vo.setPass("1");
//		
//		//***When***//
//		int a = dao.updateUser(vo);
//		System.out.println(a);
//		
//		//***Then***//
//		assertNotNull(a);
//		
//	}
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
		System.out.println(a);
		
		//***Then***//
		assertNotNull(a);
		
	}





}
