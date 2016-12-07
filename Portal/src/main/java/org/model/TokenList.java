package org.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlRootElement
public class TokenList {
	private List<String> list;
	private String message = null;
	private static TokenList tokenList = null;

	public TokenList() {

	}

	public String getMessage() {
		return message;
	}

	@XmlAttribute
	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getList() {
		return list;
	}

	@XmlElement
	public void setList(List<String> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "TokenList [list=" + list + ", message=" + message + "]";
	}

	

}
