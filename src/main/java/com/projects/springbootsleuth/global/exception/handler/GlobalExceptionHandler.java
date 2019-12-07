package com.projects.springbootsleuth.global.exception.handler;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.projects.springbootsleuth.exception.StudentException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handlerException(Exception e){
		
		log.error(e.getMessage());
		
		return new ResponseEntity<>(new StudentException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(),new Date()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
