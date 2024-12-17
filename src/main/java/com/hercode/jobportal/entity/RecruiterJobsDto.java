package com.hercode.jobportal.entity;




public class RecruiterJobsDto {

	private Long totalCandidates;
	private Integer jobPostId;
	private String jobTitle;
	private JobLocation jobLocationId;
	private JobCompany jobCompanyId;
	
	
	
	public RecruiterJobsDto(Long totalCandidate, Integer jobPostId, String jobTitle, JobLocation jobLocation,
			JobCompany jobCompanyId) {
		this.totalCandidates = totalCandidate;
		this.jobPostId = jobPostId;
		this.jobTitle = jobTitle;
		this.jobLocationId = jobLocation;
		this.jobCompanyId = jobCompanyId;
	}



	public Long getTotalCandidate() {
		return totalCandidates;
	}



	public void setTotalCandidate(Long totalCandidate) {
		this.totalCandidates = totalCandidate;
	}



	public Integer getJobPostId() {
		return jobPostId;
	}



	public void setJobPostId(Integer jobPostId) {
		this.jobPostId = jobPostId;
	}



	public String getJobTitle() {
		return jobTitle;
	}



	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}



	public JobLocation getJobLocation() {
		return jobLocationId;
	}



	public void setJobLocation(JobLocation jobLocation) {
		this.jobLocationId = jobLocation;
	}



	public JobCompany getJobCompanyId() {
		return jobCompanyId;
	}



	public void setJobCompanyId(JobCompany jobCompanyId) {
		this.jobCompanyId = jobCompanyId;
	}



	public Long getTotalCandidates() {
		return totalCandidates;
	}



	public void setTotalCandidates(Long totalCandidates) {
		this.totalCandidates = totalCandidates;
	}



	public JobLocation getJobLocationId() {
		return jobLocationId;
	}



	public void setJobLocationId(JobLocation jobLocationId) {
		this.jobLocationId = jobLocationId;
	}
	
	
	
	
	
}
