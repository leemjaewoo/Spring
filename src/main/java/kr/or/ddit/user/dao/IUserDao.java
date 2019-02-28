package kr.or.ddit.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

public interface IUserDao {
	
	/**
	* Method : getAllUser
	* 작성자 : leemjaewoo
	* 변경이력 :
	* @return
	* Method 설명 : 전체 사용자 조회
	*/
	List<UserVO> getAllUser(SqlSession sqlSession);
	
	
	UserVO selectUser(SqlSession sqlSession,String user);
	
	
	/**
	* Method : selectUserPagingList
	* 작성자 : leemjaewoo
	* 변경이력 :
	* @param pagevo
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	*/
	List<UserVO> selectUserPagingList(SqlSession sqlSession,PageVO pagevo);
	
	
	
	/**
	* Method : getUserCnt
	* 작성자 : leemjaewoo
	* 변경이력 :
	* @return
	* Method 설명 : 전체 사용자 수를 조회
	*/
	int getUserCnt(SqlSession sqlSession);
	
	
	 int insert(SqlSession sqlSession,UserVO vo);
	 
	 int deleteUser(SqlSession sqlSession,String userId);
	 
	 int updateUser(SqlSession sqlSession,UserVO uservo);
	 
	 void encryptPass(SqlSession sqlSession,UserVO uservo);
	
	

}
