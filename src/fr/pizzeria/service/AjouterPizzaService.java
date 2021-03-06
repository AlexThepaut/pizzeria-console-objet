package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

class AjouterPizzaService extends MenuService{

	public void executeUC(IPizzaDao pizzaDonne, Scanner scan) throws SavePizzaException{
		// TODO Auto-generated method stub
		System.out.println("Ajout d'une nouvelle pizza");
		
		// Acquisition des donn�es de la nonuvelle pizzas de l'utilisateur
		System.out.println("Veuiler saisir le code : ");
		String codeTemp = scan.next();
		System.out.println("Veuiler saisir le nom (sans espace) : ");
		String nomTemp = scan.next();
		System.out.println("Veuiler saisir le prix : ");
		Double prixTemp = Double.parseDouble(scan.next());
		System.out.println("Veuiler choisir la cat�gorie : ");
		CategoriePizza categoriePizza = MenuServiceFactory.categorieControlleur(scan);
		pizzaDonne.saveNewPizza(new Pizza(codeTemp, nomTemp, prixTemp, categoriePizza));
	}

}
