package fr.pizzeria.exception;

public class StockageException extends Exception{
	public StockageException(){
		System.out.println("Probl�me de stockage");
	}
	
	public StockageException(String msg) {
		System.out.println(msg);
	}
}
