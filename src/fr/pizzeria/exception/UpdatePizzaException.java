package fr.pizzeria.exception;

public class UpdatePizzaException extends StockageException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9181053071332463432L;

	public UpdatePizzaException(){
		super("Impossible de modifier la pizza");
	}
	
	public UpdatePizzaException(String msg){
		super(msg);
	}
}
