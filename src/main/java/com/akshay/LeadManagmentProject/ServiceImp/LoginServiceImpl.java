package com.akshay.LeadManagmentProject.ServiceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshay.LeadManagmentProject.Model.LoginModel;
import com.akshay.LeadManagmentProject.Repository.LoginRepository;
import com.akshay.LeadManagmentProject.Service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public List<LoginModel> getAllLoginUser() {
		
		return loginRepository.findAll();
	}

	@Override
	public void saveLoginUser(LoginModel UserModel) {
		loginRepository.save(UserModel);
		
	}

	@Override
	public LoginModel getLoginUserById(int id) {
		Optional<LoginModel> optional=loginRepository.findById( id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new RuntimeException("LoginUser not found");
		}
	}

	@Override
	public void deleteLoginUserById(int id) {
		this.loginRepository.deleteById(id);
	}

}
