package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

/**
 * 
 * @author Alex Thepaut
 *
 */
public abstract class MenuService {
	/**
	 * 
	 * @see ListerPizzasService
	 * @see AjouterPizzaService
	 * @see ModifierPizzaService
	 * @see SupprimerPizzaService
	 * 
	 * @param pizzaDonne Données de l'interface.
	 * @param scan Objet Scanner pour les entrées de l'utilisateur.
	 */
	public abstract void executeUC(IPizzaDao pizzaDonne, Scanner scan);
}
