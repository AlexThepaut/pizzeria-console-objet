package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

/**
 * 
 * @author Diginamic
 *
 */
public abstract class MenuService {
	/**
	 * 
	 * @param pizzaDonne Données de l'interface
	 * @param scan Objet Scanner pour l'utilisateur
	 */
	public abstract void executeUC(IPizzaDao pizzaDonne, Scanner scan);
}
