package fr.pizzeria.service;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

class ListerPizzasService extends MenuService {
	public void executeUC(IPizzaDao pizzaDonne, Scanner scan) {
		// Boucle pour afficher le tableau d'objet pizzas
		
		List<Pizza> tempAllPizza = pizzaDonne.findAllPizzas();
		for (Pizza temp : tempAllPizza) {
			System.out.println(temp.toString());
		}
		
		System.out.println("");
	}
}


