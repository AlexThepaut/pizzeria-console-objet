package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasService extends MenuService {

	@Override
	public void executeUC(IPizzaDao pizzaDonne, Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("Liste des pizzas");
		
		// Boucle pour afficher le tableau d'objet pizzas
		Pizza[] tempAllPizza = pizzaDonne.findAllPizzas();
		for(int i = 0; i < tempAllPizza.length; i++){
			tempAllPizza[i].getInfos();
		}
		System.out.println("");
	}
}
