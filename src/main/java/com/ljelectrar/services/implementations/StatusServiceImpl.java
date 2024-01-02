package com.ljelectrar.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljelectrar.models.Status;
import com.ljelectrar.repositories.StatusRepository;
import com.ljelectrar.services.StatusService;

@Service
public class StatusServiceImpl implements StatusService{

	@Autowired
	private StatusRepository repository;
	
	@Override
	public void save(Status status) {
		repository.save(status);		
	}

	@Override
	public List<Status> findAll() {
		return repository.findAll();
	}

}
