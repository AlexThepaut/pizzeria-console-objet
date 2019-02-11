package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

class ModifierPizzaService extends MenuService{

	public void executeUC(IPizzaDao pizzaDonne, Scanner scan) throws UpdatePizzaException {
		// TODO Auto-generated method stub
		System.out.println("Mise a jour d'une pizza");
		System.out.println("Veuiller choisir le code de la pizza à modifier : ");
		String codeModifTempUtilisateur = scan.next();
		if(pizzaDonne.pizzaExists(codeModifTempUtilisateur) != true){
			throw new UpdatePizzaException("La pizza n'existe pas");
		}else{
			// Modification de la pizza avec les nouvelles données de l'utilisateur
			System.out.println("Veuiler saisir le nouveau code : ");
			String codeModTemp = scan.next();
			System.out.println("Veuiler saisir le nouveau nom (sans espace) : ");
			String nomModTemp = scan.next();
			System.out.println("Veuiler saisir le nouveau prix : ");
			double prixModTemp = Double.parseDouble(scan.next());
			System.out.println("Veuiler choisir la nouvelle catégorie : ");
			
			
			CategoriePizza[] listCategorie = Pizza.getListCategoriePizza();
			for(int i = 0; i < listCategorie.length; i ++){
				System.out.println((i+1) + "." + listCategorie[i]);
			}
			
			int choixCategorie = scan.nextInt() - 1;
			CategoriePizza categoriePizza = null;
			for(int i = 0; i < listCategorie.length ; i ++)
			{
				if(choixCategorie == i)
				{
					categoriePizza = listCategorie[i];
				}
			}
			
			pizzaDonne.updatePizza(codeModifTempUtilisateur, new Pizza(codeModTemp, nomModTemp, prixModTemp, categoriePizza));
		}			
	}
}
