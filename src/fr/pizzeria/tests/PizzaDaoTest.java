package fr.pizzeria.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoTest {

	private PizzaMemDao pizzaDaoTest;
	
	@Before
	public void setUp() throws Exception {
		pizzaDaoTest = new PizzaMemDao();
	}

	@Test
	public void testDao() throws StockageException {
		pizzaDaoTest.saveNewPizza(new Pizza("CHO", "Chorizo", 13.5d, null));
		assertTrue("La nouvelle pizza existe", pizzaDaoTest.pizzaExists("CHO"));
		pizzaDaoTest.updatePizza("CHO", new Pizza("CHO", "Chorizal", 13.0d, null));
		assertTrue("La pizza est modifiée", pizzaDaoTest.findPizzaByCode("CHO").getNom().equals("Chorizal"));
		assertTrue("La pizza est modifiée", pizzaDaoTest.findPizzaByCode("CHO").getPrix().equals(13.0d));
		pizzaDaoTest.deletePizza("CHO");
		assertFalse("La nouvelle pizza n'existe plus", pizzaDaoTest.pizzaExists("CHO"));
	}
}