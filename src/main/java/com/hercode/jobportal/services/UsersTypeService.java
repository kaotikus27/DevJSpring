package com.hercode.jobportal.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hercode.jobportal.entity.UsersType;
import com.hercode.jobportal.repository.UsersTypeRepository;

@Service
public class UsersTypeService {

	
	private final UsersTypeRepository usersTypeRepository;
	
	
	@Autowired
	public UsersTypeService(UsersTypeRepository usersTypeRepository) {
		this.usersTypeRepository = usersTypeRepository;
	}
	
	public List<UsersType> getAll(){
		return usersTypeRepository.findAll();
	}
	 
}
