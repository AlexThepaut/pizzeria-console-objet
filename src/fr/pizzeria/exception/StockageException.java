package fr.pizzeria.exception;

public class StockageException extends Exception{
	public StockageException(){
		System.out.println("Problème de stockage");
	}
	
	public StockageException(String msg) {
		System.out.println(msg);
	}
}
