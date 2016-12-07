package org.authenticater;

import java.util.List;

import org.model.User;

public interface Authenticater {
	
	public String authenticate(String userName,String pwd) throws Exception;
	public User verfiyToken(String token) throws Exception;
	public List<String> getuserList();
	public List<String> getuserNameList();
	
	
}
