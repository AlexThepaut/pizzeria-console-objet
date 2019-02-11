package fr.pizzeria.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaComparator;

class ListerPizzasService extends MenuService {

	public void executeUC(IPizzaDao pizzaDonne, Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("Liste des pizzas par : ");
		System.out.println("1. ID");
		System.out.println("2. Libelle");
		System.out.println("3. Nom");
		System.out.println("4. Prix");
		System.out.println("5. Catégories");
		int choix = scan.nextInt();
		// Boucle pour afficher le tableau d'objet pizzas
		
		
		switch(choix){
		case 1 :
			List<Pizza> tempAllPizza = pizzaDonne.findAllPizzas();
			for (Pizza temp : tempAllPizza) {
				System.out.println(temp.toString());
			}
			break;
		case 2 : 
			//List<Pizza> ma_liste = pizzaDonne.findAllPizzas();
			//break;
		}
		
//		List<Object> ma_liste = new ArrayList<Object>();
//		Collections.sort(ma_liste);
//
//		Collections.sort(ma_liste, Collections.reverseOrder()); 
		
		
		System.out.println("");
	}
}
