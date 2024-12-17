package com.hercode.jobportal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hercode.jobportal.entity.RecruiterProfile;
import com.hercode.jobportal.entity.Users;
import com.hercode.jobportal.repository.RecruiterProfileRepository;
import com.hercode.jobportal.repository.UsersRepository;

@Service
public class RecruiterProfileService {

	private final RecruiterProfileRepository recruiterProfileRepository;
	private final UsersRepository usersRepository;

    @Autowired
    public RecruiterProfileService(
    		RecruiterProfileRepository recruiterProfileRepository,
    		UsersRepository usersRepository
    		) {
        this.recruiterProfileRepository = recruiterProfileRepository;
        this.usersRepository = usersRepository;
    }

    public Optional<RecruiterProfile> getOne(Integer id) {
        return recruiterProfileRepository.findById(id);
    }

	public RecruiterProfile addNew(RecruiterProfile recruiterProfile) {
		// TODO Auto-generated method stub
		return recruiterProfileRepository.save(recruiterProfile);
	}

	public RecruiterProfile getCurrentRecruiterProfile() {
	 Authentication authentication =	SecurityContextHolder.getContext().getAuthentication();
	 if(!(authentication instanceof AnonymousAuthenticationToken)) {
		 String currentUsername = authentication.getName();
		 Users users = 
				 usersRepository.findByEmail(currentUsername).
				 orElseThrow(()-> new UsernameNotFoundException("User not found"));
		 Optional<RecruiterProfile> recruiterProfile = getOne(users.getUserId());
		 return recruiterProfile.orElse(null);
	 } 
	 else return null;
	}
	
	
}
