package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDao{

	// Initialisation du tableau des pizzas
	private static List<Pizza> pizzas = new ArrayList<Pizza>();
	
	
	public PizzaMemDao() {
		
		// Initialisation des premieres pizzas
		
		pizzas.add(new Pizza("PEP", "Peperoni", 12.50d));
		pizzas.add(new Pizza("MAR", "Margherita", 14.00d));
		pizzas.add(new Pizza("REIN", "La Reine", 11.50d));
		pizzas.add(new Pizza("FRO", "La 4 fromages", 12.00d));
		pizzas.add(new Pizza("CAN", "La cannibale", 12.50d));
		pizzas.add(new Pizza("SAV", "La savoyarde", 13.00d));
		pizzas.add(new Pizza("ORI", "L'orientale", 13.50d));
		pizzas.add(new Pizza("IND", "L'indienne", 14.00d));
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return pizzas;
	}

	@Override
	public void saveNewPizza(Pizza newPizza) {
		pizzas.add(newPizza);
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		for(int i = 0; i < pizzas.size(); i++){
			if(pizzas.get(i).getCode().equals(codePizza)){
				PizzaMemDao.pizzas.get(i).setInfoPizza(pizza.getCode(), pizza.getNom(), pizza.getPrix());
			}
		}
	}

	@Override
	public void deletePizza(String codePizza) {
		pizzas.remove(findPizzaByCode(codePizza));
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		int idFind = -1;
		for(int i = 0; i < pizzas.size(); i++){
			if(pizzas.get(i).getCode().equals(codePizza)){
				idFind = i;
				break;
			}
		}
		return pizzas.get(idFind);
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		for(int i = 0; i < pizzas.size(); i++){
			if(pizzas.get(i).getCode().equals(codePizza)){
				return true;
			}
		}
		return false;
	}

}
