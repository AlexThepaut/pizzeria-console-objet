package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizzeria.model.*;

public class PizzeriaAdminConsoleApp {
	
	private static Pizza[] pizzas = new Pizza[8];
	
	
	public static void main(String[] args) {
		
		pizzas[0] = new Pizza(0, "PEP", "Peperoni", 12.50f);
		pizzas[1] = new Pizza(1, "MAR", "Margherita", 14.00f);
		pizzas[2] = new Pizza(2, "REIN", "La Reine", 11.50f);
		pizzas[3] = new Pizza(3, "FRO", "La 4 fromages", 12.00f);
		pizzas[4] = new Pizza(4, "CAN", "La cannibale", 12.50f);
		pizzas[5] = new Pizza(5, "SAV", "La savoyarde", 13.00f);
		pizzas[6] = new Pizza(6, "ORI", "L'orientale", 13.50f);
		pizzas[7] = new Pizza(7, "IND", "L'indienne", 14.00f);
		
		Scanner choixUtilisateur = new Scanner(System.in);
		
		boolean fermeture = false;
		
		while(fermeture != true){
			System.out.println("***** Pizzeria Administration *****");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre a jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");
			
			int choix = choixUtilisateur.nextInt();
			
			switch(choix){
			case 1: 
				System.out.println("Liste des pizzas");
				
				for(int i = 0; i < pizzas.length; i++){
					System.out.println(pizzas[i].code + " -> " + pizzas[i].libelle + " (" + pizzas[i].prix + ")");
				}
				System.out.println("");
				
				break;
			case 2: 
				System.out.println("Ajout d'une nouvelle pizza");
				
				Pizza[] pizzasTemp = new Pizza[pizzas.length+1];
				for(int i=0; i < pizzas.length; i++){
					pizzasTemp[i] = pizzas[i];
				}
				
				System.out.println("Veuiler saisir le code : ");
				String codeTemp = choixUtilisateur.next();
				System.out.println("Veuiler saisir le nom (sans espace) : ");
				String nomTemp = choixUtilisateur.next();
				System.out.println("Veuiler saisir le prix : ");
				Double prixTemp = Double.parseDouble(choixUtilisateur.next());
				
				pizzasTemp[pizzas.length] = new Pizza(pizzas.length, codeTemp, nomTemp, prixTemp);
				pizzas = pizzasTemp;
				
				break;
			case 3: 
				
				System.out.println("Mise a jour d'une pizza");
				
				System.out.println("Veuiller choisir le code de la pizza à modifier : ");
				String codeModifTempUtilisateur = choixUtilisateur.next();
				
				int idFind = -1;
				for(int i = 0; i < pizzas.length; i++){
					if(pizzas[i].code.equals(codeModifTempUtilisateur)){
						idFind = i;
						break;
					}
				}
				
				System.out.println("Veuiler saisir le nouveau code : ");
				pizzas[idFind].code = choixUtilisateur.next();
				System.out.println("Veuiler saisir le nouveau nom (sans espace) : ");
				pizzas[idFind].libelle = choixUtilisateur.next();
				System.out.println("Veuiler saisir le nouveau prix : ");
				pizzas[idFind].prix = Double.parseDouble(choixUtilisateur.next());
				
				break;
			case 4: 
				System.out.println("Suppression d'une pizza");
				System.out.println("Veuiler choisir le code de la pizza a supprimer : ");
				String codeSupTemp = choixUtilisateur.next();
				
				Pizza[] pizzasSupTemp = new Pizza[pizzas.length-1];
				for(int i=0, j=0; i < pizzas.length; i++){
					if(!pizzas[i].code.equals(codeSupTemp)){
						pizzasSupTemp[j] = pizzas[i];	
						j++;
					}
				}
				pizzas = pizzasSupTemp;
				
				break;
			case 99: 
			default: 
				System.out.println("Au revoir :(");
				fermeture = true;
				break;
			}
		}
		choixUtilisateur.close();
	}
}
