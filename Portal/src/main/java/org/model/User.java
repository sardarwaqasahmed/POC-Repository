package org.model;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class User {
	
	//private static final long serialVersionUID = 1L;
	
	public int userID;
	public String userName;
	public String pwd;
	
	public int getUserID() {
		return userID;
	}
	
	@XmlAttribute
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	
	public String getUserName() {
		return userName;
	}
	
	@XmlAttribute
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public String getPwd() {
		return pwd;
	}
	
	@XmlAttribute
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	
	
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", pwd="
				+ pwd + "]";
	}
	

}
