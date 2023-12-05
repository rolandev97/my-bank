package com.offserv.entities;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.catalina.User;

public class FichiersTechniciens implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//ATTRIBUT 
	private int idFichier;
	private String nomPhoto;
	private String cheminPhoto;
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User userType;
	
	public FichiersTechniciens() {
		// TODO Auto-generated constructor stub
	}

	public FichiersTechniciens(String nomPhoto, String cheminPhoto, User userType) {
		super();
		this.nomPhoto = nomPhoto;
		this.cheminPhoto = cheminPhoto;
		this.userType = userType;
	}

	public int getIdFichier() {
		return idFichier;
	}

	public void setIdFichier(int idFichier) {
		this.idFichier = idFichier;
	}

	public String getNomPhoto() {
		return nomPhoto;
	}

	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}

	public String getCheminPhoto() {
		return cheminPhoto;
	}

	public void setCheminPhoto(String cheminPhoto) {
		this.cheminPhoto = cheminPhoto;
	}

	public User getUserType() {
		return userType;
	}

	public void setUserType(User userType) {
		this.userType = userType;
	}
	
	
}
