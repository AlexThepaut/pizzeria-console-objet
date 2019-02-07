package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizzeria.dao.*;
import fr.pizzeria.service.MenuService;
import fr.pizzeria.service.MenuServiceFactory;

public class PizzeriaAdminConsoleApp{
	
	public static PizzaMemDao pizzaMem = new PizzaMemDao();
	
	public static void main(String[] args) {
		
		// Creation de la factory
		MenuServiceFactory menu = new MenuServiceFactory();
		
		// Ouverture du Scanner
		Scanner choixUtilisateur = new Scanner(System.in);	
		
		boolean fermeture = false;
		
		// Debut de la boucle du programme
		while(fermeture != true){
			//Affichage du menu
			System.out.println("***** Pizzeria Administration *****");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre a jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");
			
			// Selection de l'action à faire suivant le choix de l'utilisateur
			
			int choix = choixUtilisateur.nextInt();
			MenuService menuService = menu.controlleur(choix);
			
			if(menuService != null){
				menuService.executeUC(pizzaMem, choixUtilisateur);
			}else{
				System.out.println("Au revoir :(");
				// Variable pour sortir de programme
				fermeture = true;					
				break;
			}
		}
		
		// Fermeture du Scanner
		choixUtilisateur.close();	
	}
}
