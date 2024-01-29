package com.vikram.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptions {
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetails> UserExceptionHandler(UserException ue, 
			WebRequest req){
		
		ErrorDetails error = new ErrorDetails(ue.getMessage(), req.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> otherExceptionHandler(Exception ue, 
			WebRequest req){
		
		ErrorDetails error = new ErrorDetails(ue.getMessage(), req.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<ErrorDetails> BadCredentialsExceptionHandler(BadCredentialsException ue, 
			WebRequest req){
		
		ErrorDetails error = new ErrorDetails(ue.getMessage(), req.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	
}
