package com.akshay.LeadManagmentProject.ServiceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshay.LeadManagmentProject.Model.LeadModel;
import com.akshay.LeadManagmentProject.Repository.LeadRepository;
import com.akshay.LeadManagmentProject.Service.LeadService;


@Service
public class LeadServiceImp implements LeadService {

/*	@Autowired
	LeadRepository leadRepository;
	
	@Override
	public List<LeadModel> getAllLoginUser() {
		
		return leadRepository.findAll();
	}

	@Override
	public void saveLoginUser(LeadModel LeadModel) {
		leadRepository.save(LeadModel);
		
	}

	@Override
	public LeadModel getLoginUserById(int id) {
		
		Optional<LeadModel> optional=leadRepository.findById( id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new RuntimeException("LoginUser not found");
		}
	}

	@Override
	public void deleteLoginUserById(int id) {
		
		this.leadRepository.deleteById(id);
	}
*/
}
