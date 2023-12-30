package com.ljelectrar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ljelectrar.models.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
	
	// All the CRUD operations are implemented by default
	// We can implements our methods using JPQL
	
	//Creating queries
	//@Query("select s from Status where s.id < 5 ") // We can use entities instead SQL db tables
	//public List<Status> getSpecificStatus();
	
}
