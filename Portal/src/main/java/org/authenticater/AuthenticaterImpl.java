package org.authenticater;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

import org.local.service.impl.rest.AuthService;
import org.model.User;
import org.apache.log4j.Logger;
import org.context.SpringUtil;
import org.userBO.UserBO;

public class AuthenticaterImpl implements Authenticater {

	private static final Logger logger = Logger
			.getLogger(AuthenticaterImpl.class);
	private static AuthenticaterImpl auth = null;

	private static ConcurrentMap<String, User> concurrentMap = new ConcurrentHashMap<String, User>();

	UserBO userBO1 = (UserBO) SpringUtil.getInstance().getBeanById("userBo");

	private AuthenticaterImpl() {

	}

	public static AuthenticaterImpl getInstance() {
		if (auth == null) {
			auth = new AuthenticaterImpl();
		}
		return auth;
	}

	@Override
	public String authenticate(String userName, String pwd1) throws Exception {

		User user2 = userBO1.findByUserName(userName);
		if (user2 == null) {
			return null;
		} else {

			if (user2.pwd.equals(pwd1)) {
				String tkn = UUID.randomUUID().toString();
				concurrentMap.put(tkn, user2);
				return tkn;

				// return "The User is authenticated";
			} else {

				return null;
			}
		}
	}

	@Override
	public User verfiyToken(String token) throws Exception {

		for (java.util.Map.Entry<String, User> a : concurrentMap.entrySet()) {

			if (a.getKey().equals(token)) {
				return a.getValue();

			}
		}

		return null;

	}

	@Override
	public List<String> getuserList() {

		List<String> list = new ArrayList();

		for (java.util.Map.Entry<String, User> a : concurrentMap.entrySet()) {

			list.add(a.getKey());
		}
		return list;

	}

	@Override
	public List<String> getuserNameList() {

		List<String> list = new ArrayList();

		for (java.util.Map.Entry<String, User> a : concurrentMap.entrySet()) {

			list.add(a.getValue().getUserName());
		}
		return list;
	}

}
