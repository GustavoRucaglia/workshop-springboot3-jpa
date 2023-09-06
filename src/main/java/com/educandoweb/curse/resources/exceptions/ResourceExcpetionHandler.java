package com.educandoweb.curse.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.curse.services.exceptions.ResourceNotFoundExcpetion;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExcpetionHandler {
	
	@ExceptionHandler(ResourceNotFoundExcpetion.class)
	public ResponseEntity<StandardError> ResourceNotFound(ResourceNotFoundExcpetion e, HttpServletRequest request){
		String error = "Resorce not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
		}
}
