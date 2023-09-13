package com.akshay.LeadManagmentProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.akshay.LeadManagmentProject.Model.LoginModel;



public interface LoginRepository extends JpaRepository<LoginModel,Integer> {

	LoginModel getByUsernameAndPassword(String username, String password);
	
	LoginModel findByUsername(String username);
}
