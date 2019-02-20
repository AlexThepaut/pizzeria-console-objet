package fr.pizzeria.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.bdd.BddMySql;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaBddDao implements IPizzaDao{

	//private static List<Pizza> pizzasBase = new ArrayList<Pizza>();
	private BddMySql bdd = new BddMySql();
	
	public PizzaBddDao() {
		/*bdd.modificationBdd("DELETE FROM pizzabdd.pizzas WHERE id_pizzas>0");
		bdd.fermeture();

		// Initialisation des premieres pizzas
		pizzasBase.add(new Pizza("PEP", "Peperoni", 12.50d, CategoriePizza.SANS_VIANDE));
		pizzasBase.add(new Pizza("MAR", "Margherita", 14.00d, CategoriePizza.SANS_VIANDE));
		pizzasBase.add(new Pizza("REIN", "La Reine", 11.50d, CategoriePizza.VIANDE));
		pizzasBase.add(new Pizza("FRO", "La 4 fromages", 12.00d, CategoriePizza.SANS_VIANDE));
		pizzasBase.add(new Pizza("CAN", "La cannibale", 12.50d, CategoriePizza.VIANDE));
		pizzasBase.add(new Pizza("SAV", "La savoyarde", 13.00d, CategoriePizza.VIANDE));
		pizzasBase.add(new Pizza("ORI", "L`orientale", 13.50d, CategoriePizza.POISSON));
		pizzasBase.add(new Pizza("IND", "L`indienne", 14.00d, CategoriePizza.POISSON));
		
		for (Pizza pizza : pizzasBase) {
			bdd.modificationBdd("INSERT INTO pizzabdd.pizzas (code_pizzas, nom_pizzas, prix_pizzas, categorie_pizzas) VALUES('"
						+ pizza.getCode() + "', '"
						+ pizza.getNom() + "', "
						+ pizza.getPrix() + ", '"
						+ pizza.getCategorie() + "')");
			bdd.fermeture();
		}*/
	}
	
	public List<Pizza> findAllPizzas() {
		List<Pizza> pizzasTemp = new ArrayList<Pizza>();
		Statement connexion = bdd.initConnection();
		ResultSet resultat = bdd.recupererBdd(connexion, "SELECT * FROM pizzas");

		try {
			while(resultat.next()){
				String code = resultat.getString("code_pizzas");
				String nom = resultat.getString("nom_pizzas");
				float prix = resultat.getFloat("prix_pizzas");
				pizzasTemp.add(new Pizza(code, nom, prix, CategoriePizza.valueOf(resultat.getString("categorie_pizzas"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bdd.fermeture(connexion);
		return pizzasTemp;
	}

	public void saveNewPizza(Pizza pizza) throws SavePizzaException {
		// TODO Auto-generated method stub
		Statement connexion = bdd.initConnection();
		bdd.modificationBdd(connexion, "INSERT INTO pizzabdd.pizzas (code_pizzas, nom_pizzas, prix_pizzas, categorie_pizzas) VALUES('"
				+ pizza.getCode() + "', '"
				+ pizza.getNom() + "', "
				+ pizza.getPrix() + ", '"
				+ pizza.getCategorie() + "')");
		bdd.fermeture(connexion);
	}

	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		// TODO Auto-generated method stub
		Statement connexion = bdd.initConnection();
		bdd.modificationBdd(connexion, "UPDATE pizzabdd.pizzas SET "
				+ "code_pizzas='" + pizza.getCode() + "', "
				+ "nom_pizzas='" + pizza.getNom() + "', "
				+ "prix_pizzas=" + pizza.getPrix() + ", "
				+ "categorie_pizzas='" + pizza.getCategorie() + "' WHERE code_pizzas LIKE '"+ codePizza + "'");
		bdd.fermeture(connexion);
	}

	public void deletePizza(String codePizza) throws DeletePizzaException {
		// TODO Auto-generated method stub
		Pizza pizzaTemp = findPizzaByCode(codePizza);
		Statement connexion = bdd.initConnection();
		bdd.modificationBdd(connexion, "DELETE FROM pizzabdd.pizzas WHERE id_pizzas=" + pizzaTemp.getId());
		bdd.fermeture(connexion);
	}

	public Pizza findPizzaByCode(String codePizza) {
		Statement connexion = bdd.initConnection();
		ResultSet resultat = bdd.recupererBdd(connexion, "SELECT * FROM pizzabdd.pizzas WHERE code_pizzas LIKE '" + codePizza + "'");
		int id;
		String code;
		String nom;
		float prix;
		try {
			Pizza pizzaTemp = null;
			while(resultat.next()){
				id = resultat.getInt("id_pizzas");
				code = resultat.getString("code_pizzas");
				nom = resultat.getString("nom_pizzas");
				prix = resultat.getFloat("prix_pizzas");
				pizzaTemp = new Pizza(id, code, nom, prix, CategoriePizza.valueOf(resultat.getString("categorie_pizzas")));				
			}
			return pizzaTemp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bdd.fermeture(connexion);
		return null;
	}

	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		Statement connexion = bdd.initConnection();
		bdd.recupererBdd(connexion, "SELECT code_pizzas FROM pizzabdd.pizzas WHERE code_pizzas LIKE '" + codePizza + "'");
		bdd.fermeture(connexion);
		return true;
	}
}
