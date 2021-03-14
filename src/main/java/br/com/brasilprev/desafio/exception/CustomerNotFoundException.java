package br.com.brasilprev.desafio.exception;

public class CustomerNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -1834628122815743385L;

	public CustomerNotFoundException(String message) {
		super(message);
	}
	
	public CustomerNotFoundException(String message, Throwable exception) {
		super(message, exception);
	}
}
