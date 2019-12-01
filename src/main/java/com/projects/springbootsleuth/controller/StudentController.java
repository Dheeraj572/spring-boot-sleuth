package com.projects.springbootsleuth.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.springbootsleuth.exception.StudentException;
import com.projects.springbootsleuth.service.IStudentService;
import com.projects.springbootsleuth.util.StudentResponse;

@RestController
@RequestMapping(value="students")
public class StudentController {

	@Autowired
	private IStudentService studentService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	
	@GetMapping
	public ResponseEntity<?> getStudents() {

		LOGGER.info("Retrieving student details(sleuth service) ----- ");
		List<StudentResponse> studentResponseList = null;
		try {

			studentResponseList = studentService.getStudents();

		} catch (Exception e) {

			LOGGER.error("Unable to retrieve student details ------");
			return new ResponseEntity<>(new StudentException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to retrieve student details",new Date()), HttpStatus.INTERNAL_SERVER_ERROR);

		}
		LOGGER.info("Retrieved student details(sleuth service) ----- ");
		
		return new ResponseEntity<>(studentResponseList, HttpStatus.OK);
	}
}
