package com.tns.onlineshopping.entities;

public class User {
	private int userId;
	private String username;
	private String email;
	private String address;
	
	public User(int userId, String username, String email, String address) {
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.address = address;
	}
	
	public int getUserId()  { return userId; }
	
	public void setUserId (int userId)  {    this.userId = userId;  }
	
	public String getUsername()  {  return username;   }
	
	public void setUsername(String username)   {    this.username = username;  }
	
	public String getEmail() {
		return email;	
	}
	public void setEmail(String email) {
		this.email = email;	
	}
	public String getaddress()  {  return address;   }
	
	public void setaddress(String address)   {    this.address = address;  }
	
	@Override
	public String toString() {
		return "[userId=" + userId + ", username=" + username + ", email=" +email+", address=" +address+"]";
	}

}
