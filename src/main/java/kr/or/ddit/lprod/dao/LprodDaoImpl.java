package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.model.ProdVO;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;
@Repository("lprodDao")
public class LprodDaoImpl implements ILprodDao {

	
	
	
	
	
	@Override
	public List<LprodVO> getAllLprod() {
		
		
		
		
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		
		SqlSession sqlSession = sessionFactory.openSession();
		
		List<LprodVO> a = sqlSession.selectList("lprod.getAllLprod");
		sqlSession.close();
		return a;
	
	
	
	
	}

	@Override
	public List<ProdVO> selectLprod(String prod_lgu) {
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		
		SqlSession sqlSession = sessionFactory.openSession();
		
		List<ProdVO> a = sqlSession.selectList("lprod.selectLprod",prod_lgu);
		sqlSession.close();
		return a;
	
	
	}

	@Override
	public List<LprodVO> selectLprodPagingList(PageVO pagevo) {
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();

		SqlSession sqlSession = sessionFactory.openSession();

		List<LprodVO> a = sqlSession.selectList("lprod.selectLprodPagingList",pagevo);
		sqlSession.close();
		return a;
	}

	@Override
	public int getLprodCnt() {
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		
		int usercnt = sqlSession.selectOne("lprod.getlprodCnt");
		sqlSession.close();
		
		return usercnt;
	}
	
	



}
