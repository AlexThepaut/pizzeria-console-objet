package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

class SupprimerPizzaService extends MenuService{

	public void executeUC(IPizzaDao pizzaDonne, Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("Suppression d'une pizza");
		System.out.println("Veuiler choisir le code de la pizza a supprimer : ");
		String codeSupTemp = scan.next();
		
		pizzaDonne.deletePizza(codeSupTemp);
	}

}
