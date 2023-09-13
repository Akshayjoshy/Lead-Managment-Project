package com.akshay.LeadManagmentProject.Service;

import java.util.List;

import com.akshay.LeadManagmentProject.Model.LoginModel;



public interface LoginService {

	List<LoginModel> getAllLoginUser();
	void saveLoginUser(LoginModel UserModel);
	LoginModel getLoginUserById(int id);
	void deleteLoginUserById(int id);
}
