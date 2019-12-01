package com.projects.springbootsleuth.exception;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class StudentException{

	
	private HttpStatus statusCode;
	private String error;
	private String timeStamp;
	
	public StudentException(HttpStatus statusCode, String error, Date timeStamp) {
	
		this.statusCode = statusCode;
		this.error = error;
		this.timeStamp = ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT);
	}
	
	public StudentException(HttpStatus statusCode, String error) {
		
		this.statusCode = statusCode;
		this.error = error;
		
	}
	
}
