package fr.pizzeria.exception;

public class StockageException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6615343078607224741L;

	public StockageException(){
		System.out.println("Problème de stockage");
	}
	
	public StockageException(String msg) {
		System.out.println(msg);
	}
}
