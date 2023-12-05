package com.offserv.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Notifications implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Attribut
	@Id @GeneratedValue
	private int idNotification;
	private String contenu;
	private int statut;
	private int sender;
	private int receiver;
	private int type;
	private String datePoste;
	private String heurePoste;
	private int lister;
	
	@ManyToOne
	@JoinColumn(name = "id_probleme")
	private Problemes probleme;
	@ManyToOne
	@JoinColumn(name = "id_users")
	private Users userType;
	@ManyToOne
	@JoinColumn(name = "id_commentaire")
	private Commentaires comment;
	
	public Notifications() {
		// TODO Auto-generated constructor stub
	}

	public Notifications(String contenu, int statut, int sender, int receiver, int type, String datePoste,
			String heurePoste, int lister, Problemes probleme, Users userType, Commentaires comment) {
		super();
		this.contenu = contenu;
		this.statut = statut;
		this.sender = sender;
		this.receiver = receiver;
		this.type = type;
		this.datePoste = datePoste;
		this.heurePoste = heurePoste;
		this.lister = lister;
		this.probleme = probleme;
		this.userType = userType;
		this.comment = comment;
	}

	public int getIdNotification() {
		return idNotification;
	}

	public void setIdNotification(int idNotification) {
		this.idNotification = idNotification;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	public int getSender() {
		return sender;
	}

	public void setSender(int sender) {
		this.sender = sender;
	}

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDatePoste() {
		return datePoste;
	}

	public void setDatePoste(String datePoste) {
		this.datePoste = datePoste;
	}

	public String getHeurePoste() {
		return heurePoste;
	}

	public void setHeurePoste(String heurePoste) {
		this.heurePoste = heurePoste;
	}

	public int getLister() {
		return lister;
	}

	public void setLister(int lister) {
		this.lister = lister;
	}

	public Problemes getProbleme() {
		return probleme;
	}

	public void setProbleme(Problemes probleme) {
		this.probleme = probleme;
	}

	public Users getUserType() {
		return userType;
	}

	public void setUserType(Users userType) {
		this.userType = userType;
	}

	public Commentaires getComment() {
		return comment;
	}

	public void setComment(Commentaires comment) {
		this.comment = comment;
	}
	
	
}
