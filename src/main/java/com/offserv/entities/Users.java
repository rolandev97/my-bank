package com.offserv.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Users implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private int idUser;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private String email;
	private String motDePasse;
	private String date_naiss;
	private String date_inscris;
	private String nom_photo;
	private String chemin_photo;
	private int statut;
	
	@OneToMany(mappedBy = "userType",fetch = FetchType.LAZY)
	private Problemes problemes;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "avoir")
	private Set<Professions> professions;
	@ManyToMany(mappedBy = "users")
	private Set<Roles> roles;
	@ManyToMany
	@JoinTable(name = "noter",joinColumns = @JoinColumn(name = "valeur"))
	private Set<Users> referenceTo;
	@ManyToMany(mappedBy = "referenceTo")
	private Set<Users> referenceFrom;
	@OneToMany(mappedBy = "userType",fetch = FetchType.LAZY)
	private FichiersTechniciens fichiersTech;
	@ManyToOne
	@JoinColumn(name = "id_devis")
	private Devis devis;
	@OneToMany(mappedBy = "userType",fetch = FetchType.LAZY)
	private Notifications notifications;
	@OneToMany(mappedBy = "userType",fetch = FetchType.LAZY)
	private Commentaires comment;
	
	
	//CONSTRUCTORS
	public Users() {
		// TODO Auto-generated constructor stub
	}
	
	public Users(String nom, String prenom, String adresse, String telephone, String email, String motDePasse,
			String date_naiss, String date_inscris, String nom_photo, String chemin_photo, int statut) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.motDePasse = motDePasse;
		this.date_naiss = date_naiss;
		this.date_inscris = date_inscris;
		this.nom_photo = nom_photo;
		this.chemin_photo = chemin_photo;
		this.statut = statut;
	}

	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public String getDate_naiss() {
		return date_naiss;
	}
	public void setDate_naiss(String date_naiss) {
		this.date_naiss = date_naiss;
	}
	public String getDate_inscris() {
		return date_inscris;
	}
	public void setDate_inscris(String date_inscris) {
		this.date_inscris = date_inscris;
	}
	public String getNom_photo() {
		return nom_photo;
	}
	public void setNom_photo(String nom_photo) {
		this.nom_photo = nom_photo;
	}
	public String getChemin_photo() {
		return chemin_photo;
	}
	public void setChemin_photo(String chemin_photo) {
		this.chemin_photo = chemin_photo;
	}
	public int getStatut() {
		return statut;
	}
	public void setStatut(int statut) {
		this.statut = statut;
	}
	
	
	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	public Problemes getProblemes() {
		return problemes;
	}

	public void setProblemes(Problemes problemes) {
		this.problemes = problemes;
	}

	public Set<Professions> getProfessions() {
		return professions;
	}

	public void setProfessions(Set<Professions> professions) {
		this.professions = professions;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<Users> getReferenceTo() {
		return referenceTo;
	}

	public void setReferenceTo(Set<Users> referenceTo) {
		this.referenceTo = referenceTo;
	}

	public Set<Users> getReferenceFrom() {
		return referenceFrom;
	}

	public void setReferenceFrom(Set<Users> referenceFrom) {
		this.referenceFrom = referenceFrom;
	}

	public FichiersTechniciens getFichiersTech() {
		return fichiersTech;
	}

	public void setFichiersTech(FichiersTechniciens fichiersTech) {
		this.fichiersTech = fichiersTech;
	}

	public Devis getDevis() {
		return devis;
	}

	public void setDevis(Devis devis) {
		this.devis = devis;
	}

	public Notifications getNotifications() {
		return notifications;
	}

	public void setNotifications(Notifications notifications) {
		this.notifications = notifications;
	}

	public Commentaires getComment() {
		return comment;
	}

	public void setComment(Commentaires comment) {
		this.comment = comment;
	}
	
	
}
