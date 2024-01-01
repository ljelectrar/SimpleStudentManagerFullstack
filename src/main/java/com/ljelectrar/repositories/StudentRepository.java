package com.ljelectrar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ljelectrar.models.Student;

@Repository // optional
public interface StudentRepository extends JpaRepository<Student, Integer> {

	//JPQL that find all the students that includes the substring that the user define typing
	@Query("select s from Student s where lower(s.name) like lower(concat('%', :substring, '%'))")
	List<Student> findStudents(String substring);
	// All the CRUD operations are implemented by default
}
