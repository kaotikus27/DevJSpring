package com.hercode.jobportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hercode.jobportal.entity.JobPostActivity;
import com.hercode.jobportal.entity.JobSeekerApply;
import com.hercode.jobportal.entity.JobSeekerProfile;


@Repository
public interface JobSeekerApplyRepository extends JpaRepository<JobSeekerApply, Integer>{

	
	List<JobSeekerApply> findByUserId(JobSeekerProfile userId);
	List<JobSeekerApply> findByJob(JobPostActivity job);
}
