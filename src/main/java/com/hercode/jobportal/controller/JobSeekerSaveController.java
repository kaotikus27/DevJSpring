package com.hercode.jobportal.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

import com.hercode.jobportal.entity.JobPostActivity;
import com.hercode.jobportal.entity.JobSeekerProfile;
import com.hercode.jobportal.entity.JobSeekerSave;
import com.hercode.jobportal.entity.Users;
import com.hercode.jobportal.services.JobPostActivityService;
import com.hercode.jobportal.services.JobSeekerProfileService;
import com.hercode.jobportal.services.JobSeekerSaveService;
import com.hercode.jobportal.services.UserService;

@Controller
public class JobSeekerSaveController {

	 private final UserService usersService;
	    private final JobSeekerProfileService jobSeekerProfileService;
	    private final JobPostActivityService jobPostActivityService;
	    private final JobSeekerSaveService jobSeekerSaveService;

	    public JobSeekerSaveController(UserService usersService, JobSeekerProfileService jobSeekerProfileService, JobPostActivityService jobPostActivityService, JobSeekerSaveService jobSeekerSaveService) {
	        this.usersService = usersService;
	        this.jobSeekerProfileService = jobSeekerProfileService;
	        this.jobPostActivityService = jobPostActivityService;
	        this.jobSeekerSaveService = jobSeekerSaveService;
	    }

	    @PostMapping("job-details/save/{id}")
	    public String save(@PathVariable("id") int id, JobSeekerSave jobSeekerSave) {
//			Exsisting entity (binded)
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        if (!(authentication instanceof AnonymousAuthenticationToken)) 
	        {
	            String currentUsername = authentication.getName();
	            Users user = usersService.findByEmail(currentUsername);
	            
	            Optional<JobSeekerProfile> seekerProfile = 
	            		jobSeekerProfileService.getOne(user.getUserId());
	            
	            JobPostActivity jobPostActivity = jobPostActivityService.getOne(id);
	            
	            JobSeekerSave jobSaveSeeker = new JobSeekerSave(); 
	            jobSaveSeeker.setId(jobSaveSeeker.getId());
	          
//	            New Entity (Unbided)
	            
	            if (seekerProfile.isPresent() && jobPostActivity != null) {
	                jobSaveSeeker.setJob(jobPostActivity);
		            jobSaveSeeker.setUserId(seekerProfile.get());
	            } else {
	                throw new RuntimeException("User not found");
	            }
	            		
	            		 jobSeekerSaveService.addNew(jobSaveSeeker);
	        }
	        return "redirect:/dashboard/";
	    }

	    @GetMapping("saved-jobs/")
	    public String savedJobs(Model model) {

	        List<JobPostActivity> jobPost = new ArrayList<>();
	        Object currentUserProfile = usersService.getCurrentUserProfile();

	        List<JobSeekerSave> jobSeekerSaveList = jobSeekerSaveService.getCandidatesJob((JobSeekerProfile) currentUserProfile);
	        for (JobSeekerSave jobSeekerSave : jobSeekerSaveList) {
	            jobPost.add(jobSeekerSave.getJob());
	        }

	        model.addAttribute("jobPost", jobPost);
	        model.addAttribute("user", currentUserProfile);

	        return "saved-jobs";
	    }

}
