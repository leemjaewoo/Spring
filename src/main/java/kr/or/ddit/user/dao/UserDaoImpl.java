package kr.or.ddit.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {

	/**
	 * Method : getAllUser 작성자 : leemjaewoo 변경이력 :
	 * 
	 * @return Method 설명 : 전체 사용자 조회
	 */
	public List<UserVO> getAllUser(SqlSession sqlSession) {


		List<UserVO> a = sqlSession.selectList("user.getAllUser");
		return a;
 
	}

	@Override
	public UserVO selectUser(SqlSession sqlSession,String user) {
		UserVO a = sqlSession.selectOne("user.selectUser", user);
		return a;
	}

	@Override
	public List<UserVO> selectUserPagingList(SqlSession sqlSession,PageVO pagevo) {


		List<UserVO> a = sqlSession.selectList("user.selectUserPagingList",pagevo);
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
	public int getUserCnt(SqlSession sqlSession) {
		
		int getcnt = sqlSession.selectOne("user.getUserCnt");
		
		return getcnt;
	}

	@Override
	public int insert(SqlSession sqlSession,UserVO vo) {
		
		
		int insertcnt = sqlSession.insert("user.insertUser", vo);
		return insertcnt;
	}

	@Override
	public int deleteUser(SqlSession sqlSession,String userId) {
		
		
		int deletecnt = sqlSession.delete("user.deleteUser", userId);
		return deletecnt;
	}

	@Override
	public int updateUser(SqlSession sqlSession, UserVO uservo) {
		int updatecnt = sqlSession.update("user.updateUser", uservo);
		return updatecnt;
	}

	@Override
	public void encryptPass(SqlSession sqlSession, UserVO uservo) {
		sqlSession.update("user.encryptPass", uservo);
	}

	

	
	
	
	

}
