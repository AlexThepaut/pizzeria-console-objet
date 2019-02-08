package fr.pizzeria.exception;

public class SavePizzaException extends StockageException{
	public SavePizzaException(){
		super("Impossible d'enregistrer la pizza");
	}
	public SavePizzaException(String msg){
		super(msg);
	}
}
