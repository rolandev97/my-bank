package com.mabanque.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mabanque.entities.Compte;
import com.mabanque.entities.Operation;
import com.mabanque.metier.IBanqueMetier;

@Controller
public class BanqueController 
{
	@Autowired
	private IBanqueMetier banqueMetier;
	
	//Methode qui permet d'acceder a l'accueil
	@RequestMapping("/mabanque/operations")
	public String index()
	{
		return "comptes";
	}
	
	@RequestMapping("/mabanque/consulterCompte")
	public String consulter(Model model,String codeCompte,@RequestParam(name = "page",defaultValue = "0")int page,@RequestParam(name = "size",defaultValue = "5")int size)
	{
		model.addAttribute("codeCpte", codeCompte);
		try {
			Compte cp = banqueMetier.consulterCpte(codeCompte);
			Page<Operation> listOperation = banqueMetier.listOperation(codeCompte, page, size);
			int [] pages = new int[listOperation.getTotalPages()];
			
			//Transfert vers la vue
			model.addAttribute("compte",cp);
			model.addAttribute("pages", pages);
			model.addAttribute("listOperation", listOperation.getContent());
		} catch (Exception e) {
			model.addAttribute("exc", e);
		}
		
		return "comptes";
	}
	
	@RequestMapping(value = "/mabanque/saveOperation",method = RequestMethod.POST)
	public String saveOperation(Model model,String typeOperation,String codeCpte,String codeCompte2,String montant)
	{
		double convertMontant = Double.parseDouble(montant);
		try {
			if(typeOperation.equals("VERS"))
			{
				banqueMetier.verser(codeCpte, convertMontant);
			}
			if(typeOperation.equals("RETR"))
			{
				banqueMetier.retirer(codeCpte, convertMontant);
			}
			if(typeOperation.equals("VIR"))
			{
				banqueMetier.virement(codeCpte, codeCompte2, convertMontant);
			}
		} catch (Exception e) {
			model.addAttribute("error", e);
			return "redirect:/mabanque/consulterCompte?codeCompte="+codeCpte+"&error="+e.getMessage();
		}
		return "redirect:/mabanque/consulterCompte?codeCompte="+codeCpte;
	}
	
}
