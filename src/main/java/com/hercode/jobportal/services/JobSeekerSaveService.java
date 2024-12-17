package com.hercode.jobportal.services;

import org.springframework.stereotype.Service;

import java.util.List;

import com.hercode.jobportal.entity.JobPostActivity;
import com.hercode.jobportal.entity.JobSeekerProfile;
import com.hercode.jobportal.entity.JobSeekerSave;
import com.hercode.jobportal.repository.JobSeekerSaveRepository;

@Service
public class JobSeekerSaveService {
	

    private final JobSeekerSaveRepository jobSeekerSaveRepository;

    public JobSeekerSaveService(JobSeekerSaveRepository jobSeekerSaveRepository) {
        this.jobSeekerSaveRepository = jobSeekerSaveRepository;
    }

    public List<JobSeekerSave> getCandidatesJob(JobSeekerProfile userAccountId) {
        return jobSeekerSaveRepository.findByUserId(userAccountId);
    }

    public List<JobSeekerSave> getJobCandidates(JobPostActivity job) {
        return jobSeekerSaveRepository.findByJob(job);
    }

    public void addNew(JobSeekerSave jobSeekerSave) {
        jobSeekerSaveRepository.save(jobSeekerSave);
    }
	
}
