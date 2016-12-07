package org.auth;


import javax.jws.WebService;
import org.model.ReturnUser;
import org.model.TokenList;
import org.model.User;
import org.model.UserList;
@WebService

public interface AuthenticationService {
	public ReturnUser  AuthService1 (User user) throws Exception;
	public TokenList GetUserList() throws Exception;
	public UserList	GetUserNameList() throws Exception;
}
