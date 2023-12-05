package com.offserv.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Professions implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//ATTRIBUT
	@Id @GeneratedValue
	private int idProfession;
	private String nom;
	@ManyToOne
	@JoinColumn(name = "id_type_categorie")
	private TypeCategorie typeCat;
	@ManyToMany(mappedBy = "professions")
	private Set<Users> userType;
	
	public Professions() {
		// TODO Auto-generated constructor stub
	}

	public Professions(String nom) {
		super();
		this.nom = nom;
	}

	public int getIdProfession() {
		return idProfession;
	}

	public void setIdProfession(int idProfession) {
		this.idProfession = idProfession;
	}

	public String getNom() {
		return nom;
	}

	public TypeCategorie getTypeCat() {
		return typeCat;
	}

	public void setTypeCat(TypeCategorie typeCat) {
		this.typeCat = typeCat;
	}

	public Set<Users> getUserType() {
		return userType;
	}

	public void setUserType(Set<Users> userType) {
		this.userType = userType;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
