package com.offserv.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Roles implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int idRoles;
	private String roles;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles")
	private Set<Users> users;
	
	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Roles(String roles) {
		super();
		this.roles = roles;
	}


	public int getIdRoles() {
		return idRoles;
	}


	public void setIdRoles(int idRoles) {
		this.idRoles = idRoles;
	}


	public String getRoles() {
		return roles;
	}


	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	
}
