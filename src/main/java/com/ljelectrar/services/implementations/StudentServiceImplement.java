package com.ljelectrar.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljelectrar.models.Student;
import com.ljelectrar.repositories.StudentRepository;
import com.ljelectrar.services.StudentService;

@Service
public class StudentServiceImplement implements StudentService {

	@Autowired
	private StudentRepository repository;
	
	@Override
	public void save(Student student) {
		repository.save(student);
	}

	@Override
	public void remove(Student student) {
		repository.delete(student);
		
	}

	@Override
	public List<Student> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Student> find(String substring) {
		
		return repository.findStudents(substring);
	}

}
