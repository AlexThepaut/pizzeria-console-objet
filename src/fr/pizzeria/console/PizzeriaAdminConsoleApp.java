package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {
	
	public Scanner choixUtilisateur = new Scanner(System.in);
	
	public static void main(String[] args) {
		affMenu();
		choixMenu();
	}
	
	public static void affMenu(){
		System.out.println("***** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
	}
	
	public void choixMenu(){
		int choix = choixUtilisateur.nextInt();
		
		switch(choix){
		case 1: 
			liste();
			break;
		case 2: 
			Ajouter();
			break;
		case 3: 
			Maj();
			break;
		case 4: 
			Supprimer();
			break;
		case 99: 
		default: 
			
			break;
		}
	}
}
