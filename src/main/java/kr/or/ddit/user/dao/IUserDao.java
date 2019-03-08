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
	List<UserVO> getAllUser();
	
	
	UserVO selectUser(String user);
	
	
	/**
	* Method : selectUserPagingList
	* 작성자 : leemjaewoo
	* 변경이력 :
	* @param pagevo
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	*/
	List<UserVO> selectUserPagingList(PageVO pagevo);
	
	
	
	/**
	* Method : getUserCnt
	* 작성자 : leemjaewoo
	* 변경이력 :
	* @return
	* Method 설명 : 전체 사용자 수를 조회
	*/
	int getUserCnt();
	
	
	 int insert(UserVO vo);
	 
	 int deleteUser(String userId);
	 
	 int updateUser(UserVO uservo);
	 
	 void encryptPass(UserVO uservo);
	
	

}
