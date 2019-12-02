package com.projects.springbootsleuth.global.exception.handler;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.projects.springbootsleuth.exception.StudentException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handlerException(Exception e){
		LOGGER.error(e.getMessage());
		HttpHeaders headers =new HttpHeaders();
		String traceId = MDC.get("X-B3-TraceId");
		headers.set("traceId", traceId);
		return new ResponseEntity<>(new StudentException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(),new Date()),headers, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
