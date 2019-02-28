package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	
	@Resource(name="userDao")
	private IUserDao userDao;
	public UserServiceImpl() {
		//userDao = new UserDaoImpl();
	}
	
	
	
	/**
	* Method : getAllUser
	* 작성자 : leemjaewoo
	* 변경이력 :
	* @return
	* Method 설명 : 전체 사용자 조회
	*/
	public List<UserVO> getAllUser(){
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		
		SqlSession sqlSession = sessionFactory.openSession();
		
		
		
		List<UserVO> userList = userDao.getAllUser(sqlSession);
		sqlSession.close();
		
		return userList;
		
	}


	@Override
	public UserVO selectUser(String user) {
		
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		
		SqlSession sqlSession = sessionFactory.openSession();
		
		
		
		UserVO a = userDao.selectUser(sqlSession,user);
		sqlSession.close();

		return a;
	}



	/**
	* Method : selectUserPagingList
	* 작성자 : leemjaewoo
	* 변경이력 :
	* @param pagevo
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	*/
	@Override
	public Map<String, Object> selectUserPagingList(PageVO pagevo) {
		
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		
		SqlSession sqlSession = sessionFactory.openSession();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		
		
		
		
		resultMap.put("userList",userDao.selectUserPagingList(sqlSession,pagevo));
		resultMap.put("userCnt",userDao.getUserCnt(sqlSession));
		
		sqlSession.close();
		return resultMap;
		 
		 
	}



	@Override
	public int insertUser(UserVO vo) {
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		
		SqlSession sqlSession = sessionFactory.openSession();
			
		int cnt = userDao.insert(sqlSession,vo);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}



	@Override
	public int deleteUser(String userId) {
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();

		SqlSession sqlSession = sessionFactory.openSession();

		int cnt = userDao.deleteUser(sqlSession, userId);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}



	@Override
	public int updateUser(UserVO uservo) {
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		
		SqlSession sqlSession = sessionFactory.openSession();
			
		int cnt = userDao.updateUser(sqlSession, uservo);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}



	@Override
	public void encryptPass(UserVO uservo) {
		SqlSessionFactory sessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();

		SqlSession sqlSession = sessionFactory.openSession();

		userDao.encryptPass(sqlSession, uservo);
		sqlSession.commit();
		sqlSession.close();
	}


	


}
