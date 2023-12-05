package com.offserv.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Devis implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int idDevis;
	private String titre;
	private String prix;
	private String detail;
	private String datePoste;
	@OneToMany(mappedBy = "devis")
	private Users userType;
	@ManyToOne
	@JoinColumn(name = "id_probleme")
	private Problemes prob;
	
	
	public Devis() {
		// TODO Auto-generated constructor stub
	}

	public Devis(String titre, String prix, String detail, String datePoste, Users userType, Problemes prob) {
		super();
		this.titre = titre;
		this.prix = prix;
		this.detail = detail;
		this.datePoste = datePoste;
		this.userType = userType;
		this.prob = prob;
	}

	public int getIdDevis() {
		return idDevis;
	}

	public void setIdDevis(int idDevis) {
		this.idDevis = idDevis;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getDatePoste() {
		return datePoste;
	}

	public void setDatePoste(String datePoste) {
		this.datePoste = datePoste;
	}

	public Users getUserType() {
		return userType;
	}

	public void setUserType(Users userType) {
		this.userType = userType;
	}

	public Problemes getProb() {
		return prob;
	}

	public void setProb(Problemes prob) {
		this.prob = prob;
	}
	
	
	
}
