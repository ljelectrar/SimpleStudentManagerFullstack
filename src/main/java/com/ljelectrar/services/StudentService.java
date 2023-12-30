package com.ljelectrar.services;

import java.util.List;

import com.ljelectrar.models.Student;

public interface StudentService {
	
	public void save(Student student);
	public void remove(Student student);
	public List<Student> findAll();
	public List<Student> find(String substring);
}
