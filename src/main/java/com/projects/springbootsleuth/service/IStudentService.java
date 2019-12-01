package com.projects.springbootsleuth.service;

import java.util.List;

import com.projects.springbootsleuth.util.StudentResponse;

public interface IStudentService {

	List<StudentResponse> getStudents();
}
