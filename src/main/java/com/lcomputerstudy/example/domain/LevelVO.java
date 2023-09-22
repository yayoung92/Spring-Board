package com.lcomputerstudy.example.domain;

public class LevelVO {
	private String username;
	private int uLevel;
	
	public LevelVO() {
		
	}
	public LevelVO(String username, int uLevel) {
		this.uLevel = uLevel;
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getuLevel() {
		return uLevel;
	}
	public void setuLevel(int uLevel) {
		this.uLevel = uLevel;
	}
	@Override
	public String toString() {
		return "LevelVO [username=" + username + ", uLevel=" + uLevel + "]";
	}
	
}
