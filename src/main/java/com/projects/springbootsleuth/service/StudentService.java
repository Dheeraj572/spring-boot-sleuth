package com.projects.springbootsleuth.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.projects.springbootsleuth.util.StudentResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentService implements IStudentService{

	@Autowired
	private RestTemplate restTemplate;
	
	ParameterizedTypeReference<List<StudentResponse>> studentParameterizedTypeList = new ParameterizedTypeReference<List<StudentResponse>>() {
	};
	
	public List<StudentResponse> getStudents() {

		log.info("Retrieving student details in sleuth service -------");
		ResponseEntity<List<StudentResponse>> response = restTemplate.exchange("http://springboot-dockerized-application/students",
				HttpMethod.GET, null, studentParameterizedTypeList);

		List<StudentResponse> studentResponseList = Optional.ofNullable(response).map(mapper -> mapper.getBody()).orElse(new ArrayList<>());

		log.info("Retrieved student details in sleuth service -------");
		return studentResponseList;
	}

}
