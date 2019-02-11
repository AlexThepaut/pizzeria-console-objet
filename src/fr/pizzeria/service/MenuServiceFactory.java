package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class MenuServiceFactory {
	/**
	 * La méthode controlleur sert d'aiguillage vers chaque fonctionnalité
	 * suivant le choix de l'utilisateur.
	 * 
	 * @param choix Choix de l'action de l'utilisateur.
	 * @return Petourne un objet de type <b>MenuService</b> qui sera exécuté dans <b>PizzeriaAdminConsoleApp</b> ou bien NULL pour sortie de l'app.
	 */
	public MenuService controlleur(int choix){
		
		// Selection de l'action à faire suivant le choix de l'utilisateur
		switch(choix){
		case 1: 															// Cas d'affichage de la liste
			return new ListerPizzasService();
		case 2: 															// Cas de l'ajout d'une pizza
			return new AjouterPizzaService();
		case 3: 															// Cas de modification d'une pizza
			return new ModifierPizzaService();
		case 4: 															// Cas de suppression d'une pizza
			return new SupprimerPizzaService();
		case 99: 															// Cas de sortie du programme et Default
		default: 
			return null;
		}
	}
	
	public static CategoriePizza categorieControlleur (Scanner scan){
		CategoriePizza[] listCategorie = Pizza.getListCategoriePizza();
		for(int i = 0; i < listCategorie.length; i ++){
			System.out.println((i+1) + "." + listCategorie[i]);
		}
		
		int choixCategorie = scan.nextInt() - 1;
		for(int i = 0; i < listCategorie.length ; i ++)
		{
			if(choixCategorie == i)
			{
				return listCategorie[i];
			}
		}
		return null;
	}
}
