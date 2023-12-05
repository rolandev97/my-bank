package com.mabanque.metier;

import org.springframework.data.domain.Page;

import com.mabanque.entities.Client;
import com.mabanque.entities.Compte;
import com.mabanque.entities.Operation;

public interface IBanqueMetier {
	public Compte consulterCpte(String code);
	public void verser(String codeCpte,double montant);
	public void retirer(String codeCpte,double montant);
	public void virement(String codeCpte1,String codeCpte2,double montant);
	public Page<Operation> listOperation(String codeOperation,int page,int size);
	public void creerClient(Client c);
	public Page<Client> listerClient(int page,int size);
	public Page<Compte> listerComptes(int page,int size);
}
