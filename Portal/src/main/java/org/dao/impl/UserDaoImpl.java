package org.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.dao.UserDao;
import org.model.User;


public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	
	public void save(User user1) {
		getHibernateTemplate().save(user1);
		
	}

	public void update(User user1) {
		getHibernateTemplate().update(user1);
		
	}

	public User findByUserName(String userName) {
		
		List list = getHibernateTemplate().find("from User where userName=?",userName);
		return (User) list.get(0);
	}

}
