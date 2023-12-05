package com.offserv.entities;

import java.io.Serializable;

public class UsersRoles implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Roles roles;
	private Users user;
	
	public UsersRoles() {
		// TODO Auto-generated constructor stub
	}

	public UsersRoles(Roles roles, Users user) {
		super();
		this.roles = roles;
		this.user = user;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
}
