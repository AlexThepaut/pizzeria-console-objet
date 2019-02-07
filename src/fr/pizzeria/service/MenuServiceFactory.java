package fr.pizzeria.service;

public class MenuServiceFactory {
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
}
