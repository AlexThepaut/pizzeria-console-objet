package fr.pizzeria.exception;

public class UpdatePizzaException extends StockageException{
	public UpdatePizzaException(){
		super("Impossible de modifier la pizza");
	}
	
	public UpdatePizzaException(String msg){
		super(msg);
	}
}
