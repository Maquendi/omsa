package application.exceptions;

public class InvalidModelException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public InvalidModelException(String message) {
		super(message);
	}
}
