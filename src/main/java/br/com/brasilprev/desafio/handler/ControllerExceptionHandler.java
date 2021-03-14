package br.com.brasilprev.desafio.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.brasilprev.desafio.exception.CustomerConflictException;
import br.com.brasilprev.desafio.exception.CustomerNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity handleCustomerNotFoundException(CustomerNotFoundException e, HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(CustomerConflictException.class)
	public ResponseEntity handleCustomerConflictException(CustomerConflictException e, HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity handleDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity handleIllegalArgumentException(IllegalArgumentException e, HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}
