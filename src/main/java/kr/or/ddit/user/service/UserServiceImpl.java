package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.util.model.PageVO;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource(name = "userDao")
	private IUserDao userDao;

	public UserServiceImpl() {
		// userDao = new UserDaoImpl();
	}

	/**
	 * Method : getAllUser 작성자 : leemjaewoo 변경이력 :
	 * 
	 * @return Method 설명 : 전체 사용자 조회
	 */
	public List<UserVO> getAllUser() {

		List<UserVO> userList = userDao.getAllUser();

		return userList;

	}

	@Override
	public UserVO selectUser(String user) {

		UserVO a = userDao.selectUser(user);

		return a;
	}

	/**
	 * Method : selectUserPagingList 작성자 : leemjaewoo 변경이력 :
	 * 
	 * @param pagevo
	 * @return Method 설명 : 사용자 페이징 리스트 조회
	 */
	@Override
	public Map<String, Object> selectUserPagingList(PageVO pagevo) {

		Map<String, Object> resultMap = new HashMap<String, Object>();

		resultMap.put("userList", userDao.selectUserPagingList(pagevo));
		resultMap.put("userCnt", userDao.getUserCnt());

		return resultMap;

	}

	@Override
	public int insertUser(UserVO vo) {

		int cnt = userDao.insert(vo);
		return cnt;
	}

	@Override
	public int deleteUser(String userId) {

		int cnt = userDao.deleteUser(userId);
		return cnt;
	}

	@Override
	public int updateUser(UserVO uservo) {

		int cnt = userDao.updateUser(uservo);
		return cnt;
	}

	@Override
	public void encryptPass(UserVO uservo) {

		userDao.encryptPass(uservo);
	}

}
