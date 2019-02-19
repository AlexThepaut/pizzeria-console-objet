package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Alex Thepaut
 *
 */
public class PizzaMemDao implements IPizzaDao{

	// Initialisation du tableau des pizzas
	private static List<Pizza> pizzas = new ArrayList<Pizza>();

	/**
	 * Ce constructeur initialise les pizzas de base.
	 */
	public PizzaMemDao() {

		// Initialisation des premieres pizzas
		pizzas.add(new Pizza("PEP", "Peperoni", 12.50d, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("MAR", "Margherita", 14.00d, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("REIN", "La Reine", 11.50d, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("FRO", "La 4 fromages", 12.00d, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("CAN", "La cannibale", 12.50d, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("SAV", "La savoyarde", 13.00d, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("ORI", "L'orientale", 13.50d, CategoriePizza.POISSON));
		pizzas.add(new Pizza("IND", "L'indienne", 14.00d, CategoriePizza.POISSON));
	}

	/**
	 * @return Retourne la liste des pizzas
	 */
	public List<Pizza> findAllPizzas() {
		return pizzas;
	}

	/**
	 * @param newPizza Prends un objet de type Pizza.
	 * 
	 * Ajoute une nouvelle pizza passée en paramètre à la liste actuelle.
	 */
	public void saveNewPizza(Pizza newPizza) throws SavePizzaException{
		if(pizzaExists(newPizza.getCode()) == true){
			throw new SavePizzaException("La pizza existe déjà");
		}else{
			pizzas.add(newPizza);			
		}
	}

	/**
	 * @param codePizza Code de la pizza à modifier.
	 * @param pizza Nouvelles données de la pizza à modifier.
	 */
	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException{
		for(int i = 0; i < pizzas.size(); i++){
			if(pizzas.get(i).getCode().equals(codePizza)){
				PizzaMemDao.pizzas.get(i).setInfoPizza(pizza.getCode(), pizza.getNom(), pizza.getPrix());
			}
		}
	}

	/**
	 * @param codePizza Code de la pizza à supprimer.
	 */
	public void deletePizza(String codePizza) throws DeletePizzaException{
		if(pizzaExists(codePizza) == true){
			pizzas.remove(findPizzaByCode(codePizza));
		}else{
			throw new DeletePizzaException("La pizza à supprimer n'existe pas");
		}
	}

	/**
	 * @param codePizza Code de la pizza à trouver.
	 * @return Retourne la pizza avec le code demandé.
	 */
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

	/**
	 * @param codePizza Code de la pizza à trouver.
	 * @return Retourne un boolean.
	 */
	public boolean pizzaExists(String codePizza) {
		for(int i = 0; i < pizzas.size(); i++){
			if(pizzas.get(i).getCode().equals(codePizza)){
				return true;
			}
		}
		return false;
	}
}
