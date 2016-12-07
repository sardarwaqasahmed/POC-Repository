package org.local.service.impl.rest;

import java.util.List;
import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.apache.log4j.Logger;
import org.auth.AuthenticationService;
import org.authenticater.AuthenticaterImpl;
import org.model.ReturnUser;
import org.model.TokenList;
import org.model.User;
import org.model.UserList;

@Resource
@Produces("application/json")
public class AuthServiceJasonImpl implements AuthenticationService {

	public static boolean messageFlag = true;
	private static final Logger logger = Logger
			.getLogger(AuthServiceJasonImpl.class);
	private String token = null;

	// 127.0.0.1:8080/portal/api/auth/jason/getAuthenticate?userID=1&userName=rehan&pwd=1234

	@Override
	@GET
	@Path(value = "getAuthenticate")
	public ReturnUser AuthService1(@QueryParam(value = "") User user)
			throws Exception {
		ReturnUser returnUser = new ReturnUser();
		if (user.userName == null || user.pwd == null) {

			return null;
		} else {
			token = AuthenticaterImpl.getInstance().authenticate(user.userName,
					user.pwd);
			returnUser.setToken(token);
			returnUser.setUser(user.getUserName());
		}
		return returnUser;

	}

	@GET
	@Path(value = "getTokenList")
	@Override
	public TokenList GetUserList() throws Exception {

		TokenList tokenList = new TokenList();
		if (messageFlag == true) {
			List<String> list = AuthenticaterImpl.getInstance().getuserList();
			tokenList.setList(list);
			tokenList.setMessage("OK");
		}
		else{
			tokenList.setList(null);
			tokenList.setMessage("Invalid token! Re-Authenticate");
		}
		return tokenList;
	}

	@GET
	@Path(value = "getuserNameList")
	@Override
	public UserList GetUserNameList() throws Exception {

		UserList userList = new UserList();
		if(messageFlag==true){
		List<String> list = AuthenticaterImpl.getInstance().getuserNameList();
		userList.setList(list);
		userList.setMessage("OK");
		}
		else{
			userList.setList(null);
			userList.setMessage("Invalid token! Re-Authenticate");
		}
		return userList;
	}

}
