package kr.or.ddit.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {
	
	@Resource(name="SqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * Method : getAllUser 작성자 : leemjaewoo 변경이력 :
	 * 
	 * @return Method 설명 : 전체 사용자 조회
	 */
	public List<UserVO> getAllUser() {


		List<UserVO> a = sqlSessionTemplate.selectList("user.getAllUser");
		return a;
 
	}

	@Override
	public UserVO selectUser(String user) {
		UserVO a = sqlSessionTemplate.selectOne("user.selectUser", user);
		return a;
	}

	@Override
	public List<UserVO> selectUserPagingList(PageVO pagevo) {


		List<UserVO> a = sqlSessionTemplate.selectList("user.selectUserPagingList",pagevo);
		return a;
	}

	/**
	* Method : getUserCnt
	* 작성자 : leemjaewoo
	* 변경이력 :
	* @return
	* Method 설명 :전체 사용자 수를 조회
	*/
	@Override
	public int getUserCnt() {
		
		int getcnt = sqlSessionTemplate.selectOne("user.getUserCnt");
		
		return getcnt;
	}

	@Override
	public int insert(UserVO vo) {
		
		
		int insertcnt = sqlSessionTemplate.insert("user.insertUser", vo);
		return insertcnt;
	}

	@Override
	public int deleteUser(String userId) {
		
		
		int deletecnt = sqlSessionTemplate.delete("user.deleteUser", userId);
		return deletecnt;
	}

	@Override
	public int updateUser(UserVO uservo) {
		int updatecnt = sqlSessionTemplate.update("user.updateUser", uservo);
		return updatecnt;
	}

	@Override
	public void encryptPass(UserVO uservo) {
		sqlSessionTemplate.update("user.encryptPass", uservo);
	}

	

	
	
	
	

}
