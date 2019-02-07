package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizzeria.service.AjouterPizzaService;
import fr.pizzeria.service.ListerPizzasService;
import fr.pizzeria.service.ModifierPizzaService;
import fr.pizzeria.service.SupprimerPizzaService;
import fr.pizzeria.dao.*;

public class PizzeriaAdminConsoleApp{
	
	public static PizzaMemDao pizzaMem = new PizzaMemDao();
	
	public static void main(String[] args) {
		
		
		
		Scanner choixUtilisateur = new Scanner(System.in);	// Ouverture du Scanner
		
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
			
			// Attente du choix de l'utilisateur
			int choix = choixUtilisateur.nextInt();
			
			// Selection de l'action à faire suivant le choix de l'utilisateur
			switch(choix){
			case 1: 															// Cas d'affichage de la liste
				ListerPizzasService liste = new ListerPizzasService();
				liste.executeUC(pizzaMem, choixUtilisateur);
				break;
			case 2: 															// Cas de l'ajout d'une pizza
				AjouterPizzaService ajout = new AjouterPizzaService();
				ajout.executeUC(pizzaMem, choixUtilisateur);
				break;
			case 3: 															// Cas de modification d'une pizza
				ModifierPizzaService modif = new ModifierPizzaService();
				modif.executeUC(pizzaMem, choixUtilisateur);
				break;
			case 4: 
				SupprimerPizzaService sup = new SupprimerPizzaService();
				sup.executeUC(pizzaMem, choixUtilisateur);
				break;
			case 99: 															// Cas de sortie du programme et Default
			default: 
				System.out.println("Au revoir :(");
				fermeture = true;					// Variable pour sortir de programme
				break;
			}
		}
		choixUtilisateur.close();	// Fermeture du Scanner
	}
}
