package com.projects.springbootsleuth.global.exception.handler;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.projects.springbootsleuth.exception.StudentException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handlerException(Exception e){
		LOGGER.error(e.getMessage());
		
		return new ResponseEntity<>(new StudentException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(),new Date()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
