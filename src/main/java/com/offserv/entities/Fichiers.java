package com.offserv.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Fichiers implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int idFichier;
	private String nomPhoto;
	private String cheminPhoto;
	
	@ManyToOne
	@JoinColumn(name = "id_probleme")
	private Problemes probleme;
	
	public Fichiers() {
		// TODO Auto-generated constructor stub
	}

	public Fichiers(String nomPhoto, String cheminPhoto, Problemes probleme) {
		super();
		this.nomPhoto = nomPhoto;
		this.cheminPhoto = cheminPhoto;
		this.probleme = probleme;
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

	public Problemes getProbleme() {
		return probleme;
	}

	public void setProbleme(Problemes probleme) {
		this.probleme = probleme;
	}
	
}
