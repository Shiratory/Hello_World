package com.yedam.project;

public class Userdata {
	private String userId;
	private String userName;
	private String passWord;
	
	public Userdata(String userId, String userName, String passWord) {
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
}
