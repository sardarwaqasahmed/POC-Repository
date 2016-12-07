package org.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlRootElement
public class ReturnUser {

	private String userName;
	private String token;
	private static ReturnUser returnUser = null;
	
	
	public ReturnUser()
	{
		
	}
	
	public String getUser() {
		return userName;
	}
	
	@XmlAttribute
	public void setUser(String user) {
		this.userName = user;
	}

	public String getToken() {
		return token;
	}
	
	@XmlAttribute
	public void setToken(String token) {
		this.token = token;
	}
	
//	@Override
//	public String toString() {
//		return "ReturnUser [user=" + user + ", token=" + token + "]";
//	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReturnUser [userName=");
		builder.append(userName);
		builder.append(", Token=");
		builder.append(token);
		builder.append("]");
		return builder.toString();
	}

}
