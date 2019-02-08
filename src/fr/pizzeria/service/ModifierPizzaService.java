package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

class ModifierPizzaService extends MenuService{

	public void executeUC(IPizzaDao pizzaDonne, Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("Mise a jour d'une pizza");
		
		System.out.println("Veuiller choisir le code de la pizza à modifier : ");
		String codeModifTempUtilisateur = scan.next();
		
		// Modification de la pizza avec les nouvelles données de l'utilisateur
		System.out.println("Veuiler saisir le nouveau code : ");
		String codeModTemp = scan.next();
		System.out.println("Veuiler saisir le nouveau nom (sans espace) : ");
		String nomModTemp = scan.next();
		System.out.println("Veuiler saisir le nouveau prix : ");
		double prixModTemp = Double.parseDouble(scan.next());
		
		pizzaDonne.updatePizza(codeModifTempUtilisateur, new Pizza(codeModTemp, nomModTemp, prixModTemp));
	}

}
