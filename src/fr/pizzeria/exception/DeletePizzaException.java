package fr.pizzeria.exception;

public class DeletePizzaException extends StockageException{
	public DeletePizzaException(){
		super("Impossible d'�ffacer la pizza");
	}
	public DeletePizzaException(String msg){
		super(msg);
	}
}
