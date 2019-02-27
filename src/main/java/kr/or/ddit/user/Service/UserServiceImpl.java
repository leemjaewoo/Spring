package kr.or.ddit.user.Service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.ranger.dao.IRangerDao;
import kr.or.ddit.user.Dao.IUserDao;

@Service("UserServiceImpl")
public class UserServiceImpl implements IUserService {

	
	@Resource(name="userdao")
	private IUserDao userDao;
	
	
	
	public UserServiceImpl(IUserDao userDao) {
		super();
		this.userDao = userDao;
	}



	@Override
	public List<String> getUsers() {
		return userDao.getUsers();
	}



	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	

}
