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
	private CategoriePizza categorie;
	
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
	 * @param categorie CategoriePizza
	 */
	public Pizza(String code, String libelle, double prix, CategoriePizza categorie){
		id = nbPizza++;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;
	}
	
	public Pizza(int id, String code, String libelle, double prix, CategoriePizza categorie){
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;
	}
	
	/**
	 * Méthode d'affichage des infos de la pizza.
	 * @return 
	 */
	public String toString(){
		StringBuilder stringEnvoie = new StringBuilder();
		stringEnvoie.append(this.code).append(" -> ").append(this.libelle).append(" (").append(this.prix).append(") ").append(this.categorie.toString());
		return stringEnvoie.toString();
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

	public CategoriePizza getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}
	
	public static CategoriePizza[] getListCategoriePizza(){
		return CategoriePizza.values();
	}
}
