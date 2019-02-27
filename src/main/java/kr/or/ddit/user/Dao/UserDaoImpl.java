package kr.or.ddit.user.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


@Repository("userdao")
public class UserDaoImpl implements IUserDao {

	@Override
	public List<String> getUsers() {
		List<String> users = new ArrayList<String>();
		users.add("user1");
		users.add("user2");
		users.add("user3");
		
		
		return users;
	}

}
