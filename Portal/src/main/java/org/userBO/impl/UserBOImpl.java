package org.userBO.impl;

import org.model.User;
import org.userBO.UserBO;
import org.dao.UserDao;

public class UserBOImpl implements UserBO  {

	UserDao userDao1;
	
	public void setUserDao1(UserDao userDao1) {
		this.userDao1 = userDao1;
	}

	@Override
	public void save(User user1) {
		userDao1.save(user1);
	}

	@Override
	public void update(User user1) {
		userDao1.update(user1);
		
	}

	@Override
	public User findByUserName(String userName) {
		return userDao1.findByUserName(userName);
	}

}
