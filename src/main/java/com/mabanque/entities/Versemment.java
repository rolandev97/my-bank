package com.mabanque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class Versemment extends Operation
{
	public Versemment() {
		// TODO Auto-generated constructor stub
	}

	public Versemment(Date dateOperation, double montant, Compte compte) {
		super(dateOperation, montant, compte);
		// TODO Auto-generated constructor stub
	}
	
	
}
