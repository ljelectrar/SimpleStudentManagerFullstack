package com.ljelectrar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ljelectrar.models.Student;

@Repository // optional
public interface StudentRepository extends JpaRepository<Student, Integer> {
	// All the CRUD operations are implemented by default
}
