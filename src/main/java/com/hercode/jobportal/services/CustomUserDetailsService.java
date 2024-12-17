package com.hercode.jobportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hercode.jobportal.entity.Users;
import com.hercode.jobportal.repository.UsersRepository;
import com.hercode.jobportal.util.CustomeUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	private final UsersRepository usersRepository;
	
	@Autowired
	public CustomUserDetailsService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Tell Spring Security how to retrieve the users from the database
		Users user= usersRepository.findByEmail(username).orElseThrow(()-> 
		new UsernameNotFoundException("could not found user"));
		return new CustomeUserDetails(user);
	}

	
}
