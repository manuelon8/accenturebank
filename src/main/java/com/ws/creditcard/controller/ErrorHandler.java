package com.ws.creditcard.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ws.creditcard.exception.CardNoFoundException;

 

@ControllerAdvice
public class ErrorHandler {
	
	 

	@ExceptionHandler(CardNoFoundException.class)
	   public ResponseEntity<?> exception(HttpServletRequest request, MethodArgumentNotValidException e ) {
		System.out.println("Card is empty");
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(),"***Card is empty***", request.getRequestURI());
	      return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.BAD_REQUEST);
	   }
	  
 
	   public String HostException(HttpServletRequest request ) {
		System.out.println("**Host Invalid**");
		ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_GATEWAY.value(),"*****Host Invalid*****", request.getRequestURI());
	      return "Hubo un error*****************";
	   }
	  
}
