package com.projects.springbootsleuth.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.springbootsleuth.service.IStudentService;
import com.projects.springbootsleuth.util.StudentResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value="students")
@Slf4j
public class StudentController {

	@Autowired
	private IStudentService studentService;
	
	@GetMapping
	public ResponseEntity<?> getStudents() {
		
		log.info("Retrieving student details(sleuth service) ----- ");

		List<StudentResponse> studentResponseList = studentService.getStudents();

		log.info("Retrieved student details(sleuth service) ----- ");
		
		return new ResponseEntity<>(studentResponseList,HttpStatus.OK);
	}
}
