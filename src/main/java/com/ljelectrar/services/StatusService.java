package com.ljelectrar.services;

import java.util.List;

import com.ljelectrar.models.Status;

public interface StatusService {
	
	public void save(Status status);
	public List<Status> findAll();
	
}
