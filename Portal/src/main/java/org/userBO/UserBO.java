package org.userBO;

import org.model.User;


public interface UserBO {
	
	void save(User user1);
	void update(User user1);
	User findByUserName(String userName);
	

}
