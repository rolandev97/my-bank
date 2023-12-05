package com.mabanque;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mabanque.dao.ClientRepository;
import com.mabanque.dao.CompteRepository;
import com.mabanque.dao.OperationRepository;
import com.mabanque.entities.Client;
import com.mabanque.entities.Compte;
import com.mabanque.entities.CompteCourant;
import com.mabanque.entities.CompteEpargne;
import com.mabanque.entities.Operation;
import com.mabanque.entities.Retrait;
import com.mabanque.entities.Versemment;
import com.mabanque.metier.IBanqueMetier;

@SpringBootApplication
public class MaBanqueSpringApplication{

	@Autowired
	private ClientRepository clientRepos;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired 
	private IBanqueMetier banqueMetier;
	
	public static void main(String[] args) {
		SpringApplication.run(MaBanqueSpringApplication.class, args);
	}

}
