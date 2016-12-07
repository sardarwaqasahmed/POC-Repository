package org.dao;

import org.model.User;

public interface UserDao {
	
	
	void save(User user1);
	void update(User user1);
	User findByUserName(String userName);
	

}
