package com.hercode.jobportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hercode.jobportal.entity.JobPostActivity;
import com.hercode.jobportal.entity.JobSeekerApply;
import com.hercode.jobportal.entity.JobSeekerProfile;
import com.hercode.jobportal.repository.JobSeekerApplyRepository;

@Service
public class JobSeekerApplyService {

	private final JobSeekerApplyRepository jobSeekerApplyRepository;

	@Autowired
	public JobSeekerApplyService(JobSeekerApplyRepository jobSeekerApplyRepository) {
		this.jobSeekerApplyRepository = jobSeekerApplyRepository;
	}
	
	public List<JobSeekerApply> getCandidatesJobs(JobSeekerProfile userAccountId){
		return jobSeekerApplyRepository.findByUserId(userAccountId);
	}
	
	public List<JobSeekerApply> getJobCandidates(JobPostActivity job){
		return jobSeekerApplyRepository.findByJob(job);
	}

	public void addNew(JobSeekerApply jobSeekerApply) {
		// TODO Auto-generated method stub
		jobSeekerApplyRepository.save(jobSeekerApply);
	}
	
	
}
