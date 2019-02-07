package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

class AjouterPizzaService extends MenuService{

	@Override
	public void executeUC(IPizzaDao pizzaDonne, Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("Ajout d'une nouvelle pizza");
		
		// Acquisition des données de la nonuvelle pizzas de l'utilisateur
		System.out.println("Veuiler saisir le code : ");
		String codeTemp = scan.next();
		System.out.println("Veuiler saisir le nom (sans espace) : ");
		String nomTemp = scan.next();
		System.out.println("Veuiler saisir le prix : ");
		Double prixTemp = Double.parseDouble(scan.next());
		
		pizzaDonne.saveNewPizza(new Pizza(codeTemp, nomTemp, prixTemp));
	}

}
