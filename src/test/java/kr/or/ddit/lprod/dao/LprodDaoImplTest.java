package kr.or.ddit.lprod.dao;

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
import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.model.ProdVO;
import kr.or.ddit.test.LogicTestConfig;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

public class LprodDaoImplTest extends LogicTestConfig{
	
	@Resource(name="lprodDao")
	private ILprodDao dao;
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
	public void getAllLprod() {
				
				
				
				/***Given***/
				
				/***When***/

				List<LprodVO> list = dao.getAllLprod();
				/***Then***/

				assertNotNull(list);
		
		
	}
	
	
	@Test
	public void selectLprod() {
		/***Given***/
		
		/***When***/
		List<ProdVO> selectLprod = dao.selectLprod("P101");

		/***Then***/

		assertNotNull(selectLprod);
	}




	@Test
	public void selectUserPagingList() {
		
		
		
		/***Given***/
		PageVO pagevo = new PageVO(1,10);
		
		/***When***/
		List<LprodVO> selectLprodPagingList = dao.selectLprodPagingList(pagevo);

		/***Then***/
		assertNotNull(selectLprodPagingList);

	}
	





}
