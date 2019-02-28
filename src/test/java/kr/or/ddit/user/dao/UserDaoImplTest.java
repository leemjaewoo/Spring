package kr.or.ddit.user.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.test.LogicTestConfig;
import kr.or.ddit.user.model.UserVO;

public class UserDaoImplTest extends LogicTestConfig{
	
	@Resource(name="userDao")
	private IUserDao userdao;
	private SqlSession sqlSession;
	
	@Before
	public void setup() {
				
		SqlSessionFactory sqlsessionfactory	 =new MybatisSqlSessionFactory().getSqlSessionFactory();
	
		sqlSession = sqlsessionfactory.openSession();
	
	
	}
	
	@After
	public void tearDown() {
		sqlSession.close(); 
		
	}
	
	
	
	
	
	@Test
	public void test() {
		UserDaoImpl dao = new UserDaoImpl();
		
		List<UserVO> a = dao.getAllUser(sqlSession);
		
		assertNotNull(a);

	}
	
	
	
	
	/*@Test
	public void test() {
		//***Given***//*
		ILprodDao dao = new LprodDaoImpl();
		
		//***When***//*
		List<ProdVO> a = dao.selectLprod("P101");
		
		System.out.println(a);
		
		System.out.println(a.size());
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i).getProd_buyer());
		}
	
		//***Then***//*
		assertNotNull(a);
		
	}*/
	
	
	/*@Test
	public void testSelectUserPagingList() {
		UserDaoImpl dao = new UserDaoImpl();
		
		*//***Given***//*
		
		PageVO pagevo = new PageVO(1,10);
		
		*//***When***//*
		
		List<UserVO> list = dao.selectUserPagingList(pagevo);
		for(UserVO user : list) {
			System.out.println(user);
		}
		
		
		*//***Then***//*

		assertNotNull(list);
		assertEquals(10, list.size());
		
		
	}*/
	
	
	/**
	* Method : testgetUsercnt
	* 작성자 : leemjaewoo
	* 변경이력 :
	* Method 설명 : 전체 사용자 수를 조회
	*/
	/*@Test
	public void testgetUsercnt() {
		
		int cnt = userdao.getUserCnt();
		System.out.println(cnt);
		
		assertNotNull(cnt);
		
	}*/
	
	/*@Test
	public void testPagination() {
		
	
	



		*//***Given***//*
		int userCnt = 105;
		int pageSize = 10;
		
		
		*//***When***//*
		
		int lastPage = userCnt/pageSize + (userCnt%pageSize > 0 ? 1 : 0);
		
		//int lastPage = (int)Math.incrementExact(userCnt/pageSize);
		
		*//***Then***//*
		assertEquals(11, lastPage);

	}*/
	
	
	
/*	@Test
	public void LprodPagination() {
		
		
		*//***Given***//*
		PageVO vo = new PageVO(1,5);
		
		*//***When***//*
		List<LprodVO> list = lproddao.selectLprodPagingList(vo);
		
		for (int i = 0; i < list.size(); i++) {
			list.get(i).getLprod_gu();
		}
		
		*//***Then***//*

		assertNotNull(list);
		assertEquals(5, list.size());




	}*/
	
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
		
		
		
		
		//int cnt = userdao.deleteUser(sqlSession,"userId2");
		int cnt = userdao.insert(sqlSession, vo);
		
		
		/***Then***/

		assertNotNull(cnt);




	}




}
