package fr.pizzeria.service;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;


class ListerPizzasService extends MenuService {

	@Override
	public void executeUC(IPizzaDao pizzaDonne, Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("Liste des pizzas");
		
		// Boucle pour afficher le tableau d'objet pizzas
		List<Pizza> tempAllPizza = pizzaDonne.findAllPizzas();
		for (Pizza temp : tempAllPizza) {
			temp.getInfos();
		}
		System.out.println("");
	}
}
