package com.mabanque.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mabanque.dao.ClientRepository;
import com.mabanque.dao.CompteRepository;
import com.mabanque.dao.OperationRepository;
import com.mabanque.entities.Client;
import com.mabanque.entities.Compte;
import com.mabanque.entities.CompteCourant;
import com.mabanque.entities.Operation;
import com.mabanque.entities.Retrait;
import com.mabanque.entities.Versemment;

@Service
@Transactional
public class BanqueMetierImpl implements IBanqueMetier
{
	@Autowired
	private CompteRepository cpteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public Compte consulterCpte(String code) {
		Compte cp = cpteRepository.findById(code).orElse(null);
		if(cp == null) throw new RuntimeException("Compte Introuvable");
		return cp;
	}

	@Override
	public void verser(String codeCpte, double montant) {
		Compte cp = consulterCpte(codeCpte);
		Versemment v = new Versemment(new Date(), montant, cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde()+montant);
		cpteRepository.save(cp);
	}

	@Override
	public void retirer(String codeCpte, double montant) {
		Compte cp = consulterCpte(codeCpte);
		double faciliteCaisse = 0;
		if(cp instanceof CompteCourant)
			faciliteCaisse = ((CompteCourant) cp).getDecouvert();
		if(cp.getSolde()+faciliteCaisse < montant)
			throw new RuntimeException("Solde insufisant");
		Retrait v = new Retrait(new Date(), montant, cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde()-montant);
		cpteRepository.save(cp);
		
	}

	@Override
	public void virement(String codeCpte1, String codeCpte2, double montant) {
		if(codeCpte1.equals(codeCpte2))
			throw new RuntimeException("Impossible d'effectuer un virement sur le meme compte");
		retirer(codeCpte1, montant);
		verser(codeCpte2, montant);
	}

	@Override
	public Page<Operation> listOperation(String codeOperation, int page, int size) {
		// TODO Auto-generated method stub
		return operationRepository.listOperation(codeOperation, PageRequest.of(page, size)); 
	}

	@Override
	public void creerClient(Client c) {
		clientRepository.save(c);
	}

	@Override
	public Page<Client> listerClient(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Compte> listerComptes(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
