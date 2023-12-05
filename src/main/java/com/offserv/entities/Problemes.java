package com.offserv.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Problemes implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private int idProbleme;
	private String description;
	private int statut;
	private String datePoste;
	private String dateResolution;
	private String heurePoste;
	private String titre;
	
	@ManyToOne
	@JoinColumn(name = "id_users")
	private Users userType;
	@ManyToOne
	@JoinColumn(name = "id_type_categorie")
	private TypeCategorie typeCat;
	@OneToMany(mappedBy = "prob",fetch =  FetchType.LAZY)
	private Devis devis;
	@OneToMany(mappedBy = "probleme",fetch = FetchType.LAZY)
	private Notifications notifcations;
	@OneToMany(mappedBy = "probleme",fetch = FetchType.LAZY)
	private Commentaires comment;
	@OneToMany(mappedBy = "probleme",fetch = FetchType.LAZY)
	private Fichiers fichiers;
	
	
	//CONSTRUCTORS
	public Problemes() {
		// TODO Auto-generated constructor stub
	}

	public Problemes(String description, int statut, String datePoste, String dateResolution, Users userType,
			TypeCategorie typeCat, String heurePoste, String titre) {
		super();
		this.description = description;
		this.statut = statut;
		this.datePoste = datePoste;
		this.dateResolution = dateResolution;
		this.userType = userType;
		this.typeCat = typeCat;
		this.heurePoste = heurePoste;
		this.titre = titre;
	}

	public int getIdProbleme() {
		return idProbleme;
	}

	public void setIdProbleme(int idProbleme) {
		this.idProbleme = idProbleme;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	public String getDatePoste() {
		return datePoste;
	}

	public void setDatePoste(String datePoste) {
		this.datePoste = datePoste;
	}

	public String getDateResolution() {
		return dateResolution;
	}

	public void setDateResolution(String dateResolution) {
		this.dateResolution = dateResolution;
	}

	public Users getUserType() {
		return userType;
	}

	public void setUserType(Users userType) {
		this.userType = userType;
	}

	public TypeCategorie getTypeCat() {
		return typeCat;
	}

	public void setTypeCat(TypeCategorie typeCat) {
		this.typeCat = typeCat;
	}

	public String getHeurePoste() {
		return heurePoste;
	}

	public void setHeurePoste(String heurePoste) {
		this.heurePoste = heurePoste;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Devis getDevis() {
		return devis;
	}

	public void setDevis(Devis devis) {
		this.devis = devis;
	}

	public Notifications getNotifcations() {
		return notifcations;
	}

	public void setNotifcations(Notifications notifcations) {
		this.notifcations = notifcations;
	}

	public Commentaires getComment() {
		return comment;
	}

	public void setComment(Commentaires comment) {
		this.comment = comment;
	}

	public Fichiers getFichiers() {
		return fichiers;
	}

	public void setFichiers(Fichiers fichiers) {
		this.fichiers = fichiers;
	}
	
	
}
