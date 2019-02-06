package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizzeria.model.*;

public class PizzeriaAdminConsoleApp {
	
	// Initialisation du tableau des pizzas
	private static Pizza[] pizzas = new Pizza[8];
	
	
	public static void main(String[] args) {
		
		// Initialisation des premieres pizzas
		pizzas[0] = new Pizza(0, "PEP", "Peperoni", 12.50f);
		pizzas[1] = new Pizza(1, "MAR", "Margherita", 14.00f);
		pizzas[2] = new Pizza(2, "REIN", "La Reine", 11.50f);
		pizzas[3] = new Pizza(3, "FRO", "La 4 fromages", 12.00f);
		pizzas[4] = new Pizza(4, "CAN", "La cannibale", 12.50f);
		pizzas[5] = new Pizza(5, "SAV", "La savoyarde", 13.00f);
		pizzas[6] = new Pizza(6, "ORI", "L'orientale", 13.50f);
		pizzas[7] = new Pizza(7, "IND", "L'indienne", 14.00f);
		
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
				System.out.println("Liste des pizzas");
				
				// Boucle pour afficher le tableau d'objet pizzas
				for(int i = 0; i < pizzas.length; i++){
					System.out.println(pizzas[i].code + " -> " + pizzas[i].libelle + " (" + pizzas[i].prix + ")");
				}
				System.out.println("");
				
				break;
			case 2: 															// Cas de l'ajout d'une pizza
				System.out.println("Ajout d'une nouvelle pizza");
				
				// Creation du tableau plus grand et remplissage avec les valeur du precedent plus petit
				Pizza[] pizzasTemp = new Pizza[pizzas.length+1];
				for(int i=0; i < pizzas.length; i++){
					pizzasTemp[i] = pizzas[i];
				}
				
				// Acquisition des données de la nonuvelle pizzas de l'utilisateur
				System.out.println("Veuiler saisir le code : ");
				String codeTemp = choixUtilisateur.next();
				System.out.println("Veuiler saisir le nom (sans espace) : ");
				String nomTemp = choixUtilisateur.next();
				System.out.println("Veuiler saisir le prix : ");
				Double prixTemp = Double.parseDouble(choixUtilisateur.next());
				
				// Ecrasement du petit tableau par le plus grand
				pizzasTemp[pizzas.length] = new Pizza(pizzas.length, codeTemp, nomTemp, prixTemp);
				pizzas = pizzasTemp;
				
				break;
			case 3: 
				
				System.out.println("Mise a jour d'une pizza");					// Cas de la mise à jour d'une pizza
				
				System.out.println("Veuiller choisir le code de la pizza à modifier : ");
				String codeModifTempUtilisateur = choixUtilisateur.next();
				
				// Recherche de la pizza
				int idFind = -1;
				for(int i = 0; i < pizzas.length; i++){
					if(pizzas[i].code.equals(codeModifTempUtilisateur)){
						idFind = i;
						break;
					}
				}
				
				// Modification de la pizza avec les nouvelles données de l'utilisateur
				System.out.println("Veuiler saisir le nouveau code : ");
				pizzas[idFind].code = choixUtilisateur.next();
				System.out.println("Veuiler saisir le nouveau nom (sans espace) : ");
				pizzas[idFind].libelle = choixUtilisateur.next();
				System.out.println("Veuiler saisir le nouveau prix : ");
				pizzas[idFind].prix = Double.parseDouble(choixUtilisateur.next());
				
				break;
			case 4: 
				System.out.println("Suppression d'une pizza");					// Cas de la suppression d'une pizza
				System.out.println("Veuiler choisir le code de la pizza a supprimer : ");
				String codeSupTemp = choixUtilisateur.next();
				
				// Creation d'un tableau temporaire moins grand qui stoque toutes les valeurs sauf celle que l'on veut supprimer
				Pizza[] pizzasSupTemp = new Pizza[pizzas.length-1];
				for(int i=0, j=0; i < pizzas.length; i++){    // j -> variable qui se décale au moment du passage sur la valeur a supprimer pour ne pas avoir de déplacement
					if(!pizzas[i].code.equals(codeSupTemp)){
						pizzasSupTemp[j] = pizzas[i];	
						j++;
					}
				}
				
				// Redefinition du tableau par celui de taille inferieur
				pizzas = pizzasSupTemp;
				
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
