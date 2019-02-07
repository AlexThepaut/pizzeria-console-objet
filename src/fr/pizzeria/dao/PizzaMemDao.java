package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDao{

	// Initialisation du tableau des pizzas
	private static Pizza[] pizzas = new Pizza[8];
	
	
	public PizzaMemDao() {
		
		// Initialisation des premieres pizzas
		pizzas[0] = new Pizza(0, "PEP", "Peperoni", 12.50f);
		pizzas[1] = new Pizza(1, "MAR", "Margherita", 14.00f);
		pizzas[2] = new Pizza(2, "REIN", "La Reine", 11.50f);
		pizzas[3] = new Pizza(3, "FRO", "La 4 fromages", 12.00f);
		pizzas[4] = new Pizza(4, "CAN", "La cannibale", 12.50f);
		pizzas[5] = new Pizza(5, "SAV", "La savoyarde", 13.00f);
		pizzas[6] = new Pizza(6, "ORI", "L'orientale", 13.50f);
		pizzas[7] = new Pizza(7, "IND", "L'indienne", 14.00f);
	}

	@Override
	public Pizza[] findAllPizzas() {
		return pizzas;
	}

	@Override
	public void saveNewPizza(Pizza newPizza) {
		Pizza[] pizzasTemp = new Pizza[pizzas.length+1];
		for(int i=0; i < pizzas.length; i++){
			pizzasTemp[i] = pizzas[i];
		}
		pizzasTemp[pizzas.length] = newPizza;
		pizzas = pizzasTemp;
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		// Recherche de la pizza
		int idFind = -1;
		for(int i = 0; i < pizzas.length; i++){
			if(pizzas[i].code.equals(codePizza)){
				idFind = i;
				break;
			}
		}
		pizzas[idFind] = pizza;
		
	}

	@Override
	public void deletePizza(String codePizza) {
		// Creation d'un tableau temporaire moins grand qui stoque toutes les valeurs sauf celle que l'on veut supprimer
		Pizza[] pizzasSupTemp = new Pizza[pizzas.length-1];
		for(int i=0, j=0; i < pizzas.length; i++){    // j -> variable qui se décale au moment du passage sur la valeur a supprimer pour ne pas avoir de déplacement
			if(!pizzas[i].code.equals(codePizza)){
				pizzasSupTemp[j] = pizzas[i];	
				j++;
			}
		}
		
		// Redefinition du tableau par celui de taille inferieur
		pizzas = pizzasSupTemp;
		
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}

}
