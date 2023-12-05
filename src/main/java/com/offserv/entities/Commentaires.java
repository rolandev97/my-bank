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
public class Commentaires implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//ATTRIBUT
	@Id @GeneratedValue
	private int idComment;
	private String contenu;
	private String datePoste;
	private int sender;
	private int receiver;
	
	@ManyToOne()
	@JoinColumn(name = "id_user")
	private Users userType;
	@ManyToOne
	@JoinColumn(name = "id_probleme")
	private Problemes probleme;
	@OneToMany(mappedBy = "notification",fetch = FetchType.LAZY)
	private Notifications notification;
	
	
	
	public Commentaires() {
		// TODO Auto-generated constructor stub
	}

	public Commentaires(String contenu, String datePoste, int sender, int receiver, Users userType,
			Problemes probleme) {
		super();
		this.contenu = contenu;
		this.datePoste = datePoste;
		this.sender = sender;
		this.receiver = receiver;
		this.userType = userType;
		this.probleme = probleme;
	}

	public int getIdComment() {
		return idComment;
	}

	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}
	
	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getDatePoste() {
		return datePoste;
	}

	public void setDatePoste(String datePoste) {
		this.datePoste = datePoste;
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

	public Users getUserType() {
		return userType;
	}

	public void setUserType(Users userType) {
		this.userType = userType;
	}

	public Problemes getProbleme() {
		return probleme;
	}

	public void setProbleme(Problemes probleme) {
		this.probleme = probleme;
	}

	public Notifications getNotification() {
		return notification;
	}

	public void setNotification(Notifications notification) {
		this.notification = notification;
	}
	
}
