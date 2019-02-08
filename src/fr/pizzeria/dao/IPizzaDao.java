package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.*;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Alex Thepaut
 *
 */
public interface IPizzaDao {
	List<Pizza> findAllPizzas();
	void saveNewPizza(Pizza pizza) throws SavePizzaException;
	void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException;
	void deletePizza(String codePizza) throws DeletePizzaException;
	Pizza findPizzaByCode(String codePizza);
	boolean pizzaExists(String codePizza);
}
