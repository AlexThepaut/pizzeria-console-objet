package fr.pizzeria.console;

<<<<<<< HEAD
import java.util.Scanner;

public class PizzeriaAdminConsoleApp {
	
	public static void main(String[] args) {
		Scanner choixUtilisateur = new Scanner(System.in);
		boolean fermeture = false;
		
		while(fermeture != true){
			System.out.println("***** Pizzeria Administration *****");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre � jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");
			
			int choix = choixUtilisateur.nextInt();
			
			switch(choix){
			case 1: 
				System.out.println("Liste des pizzas");
				break;
			case 2: 
				System.out.println("Ajout d�une nouvelle pizza");
				break;
			case 3: 
				System.out.println("Mise � jour d�une pizza");
				break;
			case 4: 
				System.out.println("Suppression d�une pizza");
				break;
			case 99: 
			default: 
				System.out.println("Au revoir :(");
				fermeture = true;
				break;
			}
		}
	}
=======
public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		
	}

>>>>>>> master
}
