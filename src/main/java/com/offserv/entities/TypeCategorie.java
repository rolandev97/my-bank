package com.offserv.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TypeCategorie implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int idTypeCat;
	private String nomTypeCat;
	
	@OneToMany(mappedBy = "typeCat",fetch = FetchType.LAZY)
	private Professions metier;
	@OneToMany(mappedBy = "typeCat",fetch = FetchType.LAZY)
	private Problemes problemes;
	
	public TypeCategorie() {
		// TODO Auto-generated constructor stub
	}

	public TypeCategorie(String nomTypeCat, Professions metier) {
		super();
		this.nomTypeCat = nomTypeCat;
		this.metier = metier;
	}

	public int getIdTypeCat() {
		return idTypeCat;
	}

	public void setIdTypeCat(int idTypeCat) {
		this.idTypeCat = idTypeCat;
	}

	public String getNomTypeCat() {
		return nomTypeCat;
	}

	public void setNomTypeCat(String nomTypeCat) {
		this.nomTypeCat = nomTypeCat;
	}

	public Professions getMetier() {
		return metier;
	}

	public void setMetier(Professions metier) {
		this.metier = metier;
	}
	
	
}
