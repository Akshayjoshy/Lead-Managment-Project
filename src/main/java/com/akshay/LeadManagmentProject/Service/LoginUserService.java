package com.akshay.LeadManagmentProject.Service;

import java.util.List;

import com.akshay.LeadManagmentProject.Model.LeadModel;



public interface LoginUserService {

	List<LeadModel> getAllLoginUser();
	void saveLoginUser(LeadModel LeadModel);
	LeadModel getLoginUserById(int id);
	void deleteLoginUserById(int id);

}
