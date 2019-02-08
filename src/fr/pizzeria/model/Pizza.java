package fr.pizzeria.model;

/**
 * 
 * @author Alex Thepaut
 *
 */
public class Pizza {
	
	public static int nbPizza;
	
	private int id;
	private String code;
	private String libelle;
	private double prix;
	
	/**
	 * Constructeur par défaut
	 */
	public Pizza(){
		
	}
	
	/**
	 * 
	 * @param code	String
	 * @param libelle String
	 * @param prix double
	 */
	public Pizza(String code, String libelle, double prix){
		id = nbPizza++;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	/**
	 * Méthode d'affichage des infos de la pizza.
	 */
	public void getInfos(){
		System.out.println(this.code + " -> " + this.libelle + " (" + this.prix + ")");
	}
	
	/**
	 * Setter des infos de la pizza.
	 * @param code String
	 * @param libelle String
	 * @param prix double
	 */
	public void setInfoPizza(String code, String libelle, double prix){
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	/**
	 * Getter du code de la pizza.
	 * @return Retourne une String.
	 */
	public int getId(){
		return this.id;
	}
	
	/**
	 * Getter du code de la pizza.
	 * @return Retourne une String.
	 */
	public String getCode(){
		return this.code;
	}
	
	/**
	 * Getter du nom de la pizza.
	 * @return Retourne une String.
	 */
	public String getNom(){
		return this.libelle;
	}
	
	/**
	 * Getter du prix de la pizza.
	 * @return Retourne un double.
	 */
	public Double getPrix(){
		return this.prix;
	}
}
