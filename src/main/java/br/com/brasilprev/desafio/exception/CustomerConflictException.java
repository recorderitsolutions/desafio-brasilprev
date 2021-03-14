package br.com.brasilprev.desafio.exception;

public class CustomerConflictException extends RuntimeException {
	private static final long serialVersionUID = -1834628122815743385L;

	public CustomerConflictException(String message) {
		super(message);
	}
	
	public CustomerConflictException(String message, Throwable exception) {
		super(message, exception);
	}
}
