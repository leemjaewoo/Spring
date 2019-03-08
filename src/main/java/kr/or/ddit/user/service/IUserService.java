package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

public interface IUserService {
	
	/**
	* Method : getAllUser
	* 작성자 : leemjaewoo
	* 변경이력 :
	* @return
	* Method 설명 : 전체 사용자 조회
	*/
	List<UserVO> getAllUser();
	
	UserVO selectUser(String user);

	Map<String, Object> selectUserPagingList(PageVO pagevo);

	/**
	* Method : insertUser
	* 작성자 : leemjaewoo
	* 변경이력 :
	* @param vo
	* @return
	* Method 설명 : 사용자 등록
	*/
	int insertUser(UserVO vo);
	
	
	
	int deleteUser(String userId);
	
	int updateUser(UserVO uservo);
	
	void encryptPass(UserVO uservo);

}
