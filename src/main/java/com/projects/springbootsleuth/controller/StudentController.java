package com.projects.springbootsleuth.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.springbootsleuth.service.IStudentService;
import com.projects.springbootsleuth.util.StudentResponse;

@RestController
@RequestMapping(value="students")
public class StudentController {

	@Autowired
	private IStudentService studentService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	
	@GetMapping
	public ResponseEntity<?> getStudents(HttpHeaders httpHeaders) {
		
		LOGGER.info("Retrieving student details(sleuth service) ----- ");
		
		String traceId = MDC.get("X-B3-TraceId");
		httpHeaders.set("traceId", traceId);

		List<StudentResponse> studentResponseList = studentService.getStudents();

		LOGGER.info("Retrieved student details(sleuth service) ----- ");
		
		return new ResponseEntity<>(studentResponseList,httpHeaders,HttpStatus.OK);
	}
}
