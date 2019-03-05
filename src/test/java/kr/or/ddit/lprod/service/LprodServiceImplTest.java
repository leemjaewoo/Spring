package kr.or.ddit.lprod.service;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.model.ProdVO;
import kr.or.ddit.test.LogicTestConfig;
import kr.or.ddit.util.model.PageVO;

public class LprodServiceImplTest extends LogicTestConfig{
	
	
private SqlSession sqlSession;
	
	
	@Resource(name="lprodService")
	private ILprodService lprodservice;
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
	public void getAllLprod() {
				
				
				
				/***Given***/
				
				/***When***/

				List<LprodVO> list = lprodservice.getAllLprod();
				/***Then***/

				assertNotNull(list);
		
		
	}
	
	
	@Test
	public void selectLprod() {
		/***Given***/
		
		/***When***/
		List<ProdVO> prod = lprodservice.selectLprod("P101");

		/***Then***/

		assertNotNull(prod);
	}




	@Test
	public void selectUserPagingList() {
		
		
		
		/***Given***/
		PageVO pagevo = new PageVO(1,10);
		
		/***When***/
		Map<String, Object> selectUserPagingList = lprodservice.selectUserPagingList(pagevo);

		/***Then***/
		assertNotNull(selectUserPagingList);

	}
	







}
