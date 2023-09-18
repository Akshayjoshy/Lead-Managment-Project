package com.akshay.LeadManagmentProject.Model;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class LeadModel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 	
	private int id;
	
	private int numberOfEmployee;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	 @Temporal(TemporalType.DATE)
	private Date date;
	
	private String lastContactedDateAndTime;
	
	private String leadSolutionSuggested;
	
	private String leadGenerated;
	
	private String leadStatus;
	
	private String leadSource;
	
	private String lifeCycleStages;
	
	private String CompanyName;
	
	private String website;
	
	private String CompanyLinkedIn;
	
	private String contactNumber;
	
	private String industry;
	
	private String stateAndCountry;
	
	private String annualRevenue;
	
	private String partners;
	
	private String use;

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String designation;
	
	private String mailingCountry;
	
	private String personLinkedInn;
	
	private String phoneNumber;

	private String additionalDetails;

	private String latestComment;
	
	private String personSolutionSuggested;
	
	private String leadManager;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	} 
	public String getLeadSolutionSuggested() {
		return leadSolutionSuggested;
	}
	public void setLeadSolutionSuggested(String leadSolutionSuggested) {
		this.leadSolutionSuggested = leadSolutionSuggested;
	}
	public String getLeadGenerated() {
		return leadGenerated;
	}
	public void setLeadGenerated(String leadGenerated) {
		this.leadGenerated = leadGenerated;
	}
	public String getLeadStatus() {
		return leadStatus;
	}
	public void setLeadStatus(String leadStatus) {
		this.leadStatus = leadStatus;
	}
	public String getLeadSource() {
		return leadSource;
	}
	public void setLeadSource(String leadSource) {
		this.leadSource = leadSource;
	}
	public String getLifeCycleStages() {
		return lifeCycleStages;
	}
	public void setLifeCycleStages(String lifeCycleStages) {
		this.lifeCycleStages = lifeCycleStages;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getCompanyLinkedIn() {
		return CompanyLinkedIn;
	}
	public void setCompanyLinkedIn(String companyLinkedIn) {
		CompanyLinkedIn = companyLinkedIn;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getStateAndCountry() {
		return stateAndCountry;
	}
	public void setStateAndCountry(String stateAndCountry) {
		this.stateAndCountry = stateAndCountry;
	}
	public String getAnnualRevenue() {
		return annualRevenue;
	}
	public void setAnnualRevenue(String annualRevenue) {
		this.annualRevenue = annualRevenue;
	}
	public int getNumberOfEmployee() {
		return numberOfEmployee;
	}
	public void setNumberOfEmployee(int numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}
	public String getPartners() {
		return partners;
	}
	public void setPartners(String partners) {
		this.partners = partners;
	}
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getMailingCountry() {
		return mailingCountry;
	}
	public void setMailingCountry(String mailingCountry) {
		this.mailingCountry = mailingCountry;
	}
	public String getPersonLinkedInn() {
		return personLinkedInn;
	}
	public void setPersonLinkedInn(String personLinkedInn) {
		this.personLinkedInn = personLinkedInn;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAdditionalDetails() {
		return additionalDetails;
	}
	public void setAdditionalDetails(String additionalDetails) {
		this.additionalDetails = additionalDetails;
	}
	public String getLastContactedDateAndTime() {
		return lastContactedDateAndTime;
	}
	public void setLastContactedDateAndTime(String lastContactedDateAndTime) {
		this.lastContactedDateAndTime = lastContactedDateAndTime;
	} 
	
	public String getLatestComment() {
		return latestComment;
	}
	public void setLatestComment(String latestComment) {
		this.latestComment = latestComment;
	}
	public String getPersonSolutionSuggested() {
		return personSolutionSuggested;
	}
	public void setPersonSolutionSuggested(String personSolutionSuggested) {
		this.personSolutionSuggested = personSolutionSuggested;
	}
	public String getLeadManager() {
		return leadManager;
	}
	public void setLeadManager(String leadManager) {
		this.leadManager = leadManager;
	}
}
