package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizzeria.model.*;
import fr.pizzeria.service.AjouterPizzaService;
import fr.pizzeria.service.ListerPizzasService;
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
			case 3: 
				
				System.out.println("Mise a jour d'une pizza");					// Cas de la mise à jour d'une pizza
				
				System.out.println("Veuiller choisir le code de la pizza à modifier : ");
				String codeModifTempUtilisateur = choixUtilisateur.next();
				
				// Modification de la pizza avec les nouvelles données de l'utilisateur
				System.out.println("Veuiler saisir le nouveau code : ");
				String codeModTemp = choixUtilisateur.next();
				System.out.println("Veuiler saisir le nouveau nom (sans espace) : ");
				String nomModTemp = choixUtilisateur.next();
				System.out.println("Veuiler saisir le nouveau prix : ");
				double prixModTemp = Double.parseDouble(choixUtilisateur.next());
				
				pizzaMem.updatePizza(codeModifTempUtilisateur, new Pizza(codeModTemp, nomModTemp, prixModTemp));
				
				break;
			case 4: 
				System.out.println("Suppression d'une pizza");					// Cas de la suppression d'une pizza
				System.out.println("Veuiler choisir le code de la pizza a supprimer : ");
				String codeSupTemp = choixUtilisateur.next();
				
				pizzaMem.deletePizza(codeSupTemp);
				
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
