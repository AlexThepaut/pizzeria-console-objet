package fr.pizzeria.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class PizzaDaoTest {

	private PizzaMemDao pizzaDaoTest;
	
	@Before
	public void setUp() throws Exception {
		pizzaDaoTest = new PizzaMemDao();
	}

	@Test
	public void test() {
		pizzaDaoTest.saveNewPizza(new Pizza("CHO", "Chorizo", 13.5d));
		assertTrue("La nouvelle pizza existe", pizzaDaoTest.pizzaExists("CHO"));
		pizzaDaoTest.updatePizza("CHO", new Pizza("CHO", "Chorizal", 13.0d));
		assertTrue("La pizza est modifiée", pizzaDaoTest.findPizzaByCode("CHO").getNom().equals("Chorizal"));
		pizzaDaoTest.deletePizza("CHO");
		assertFalse("La nouvelle pizza n'existe plus", pizzaDaoTest.pizzaExists("CHO"));
	}

}
