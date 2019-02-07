package fr.pizzeria.model;

public class Pizza {
	
	private String code;
	private String libelle;
	private double prix;
	
	public Pizza(){
		
	}
	
	public Pizza(String code, String libelle, double prix){
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	public void getInfos(){
		System.out.println(this.code + " -> " + this.libelle + " (" + this.prix + ")");
	}
	
	public void setInfoPizza(String code, String libelle, double prix){
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	public String getCode(){
		return this.code;
	}
	public String getNom(){
		return this.libelle;
	}
	public Double getPrix(){
		return this.prix;
	}
}
