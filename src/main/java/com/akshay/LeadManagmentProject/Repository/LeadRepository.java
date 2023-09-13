package com.akshay.LeadManagmentProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshay.LeadManagmentProject.Model.LeadModel;




public interface LeadRepository extends JpaRepository<LeadModel,Integer> {

	LeadModel findByEmail(String email);
}
