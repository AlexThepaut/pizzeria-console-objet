package fr.pizzeria.tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class TestPizzaMemDao {
private PizzaMemDao pizzaDaoTest ; 
	@Before
	public void setUp() throws Exception {
		pizzaDaoTest = new PizzaMemDao();
		pizzaDaoTest.saveNewPizza(new Pizza("CHO","Chorizo",13.5, CategoriePizza.VIANDE));
	}
	@Test
	public void testAjout() throws SavePizzaException {
		pizzaDaoTest.saveNewPizza(new Pizza("BBQ","Barbecue",14.0, CategoriePizza.VEGAN));
		assertTrue("il y a une pizza",pizzaDaoTest.pizzaExists("BBQ"));
	}
	@Test
	public void testModif() throws SavePizzaException, UpdatePizzaException {
		pizzaDaoTest.updatePizza("CHO", new Pizza("CHA","Chorizal",14.0, CategoriePizza.VIANDE));
		assertTrue("la pizza a été modifié",pizzaDaoTest.pizzaExists("CHA"));
	}
	@Test
	public void testSuppr() throws SavePizzaException, DeletePizzaException {
		pizzaDaoTest.deletePizza("CHO");
		assertFalse("la pizza a été supprimé",pizzaDaoTest.pizzaExists("CHO"));
	}
}
