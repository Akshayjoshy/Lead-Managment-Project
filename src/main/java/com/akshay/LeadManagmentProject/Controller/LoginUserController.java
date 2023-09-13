package com.akshay.LeadManagmentProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.akshay.LeadManagmentProject.Model.LeadModel;
import com.akshay.LeadManagmentProject.Repository.LeadRepository;
import com.akshay.LeadManagmentProject.Service.LoginUserService;

@Controller
public class LoginUserController {
	
	@Autowired
	private LoginUserService loginUserService;
	
	@Autowired
	LeadRepository leadRepository;
	
	
	
	
	// display list of LoginUsers
    @GetMapping("/loginUser")
    public String viewHomePage(Model model) {
    	//List<LoginUser> loginUsers = loginUserService.getAllLoginUser();
		model.addAttribute("listLoginUsers", loginUserService.getAllLoginUser());
	    return "leadlist";
		
        
    }
	
	@GetMapping("/loginUser/showNewLoginUserForm")
	public String showNewLoginUserForm(Model model) {
		// create model attribute to bind form data
		LeadModel loginUser = new LeadModel();
		model.addAttribute("loginUser", loginUser);
		return "loginUser_new";
	}
	@PostMapping("/loginUser/saveLoginUser")
	public String saveLoginUser(@ModelAttribute("loginUser") LeadModel loginUser, Model model) {
		// save LoginUser to database
		
		LeadModel storedDetailzz= leadRepository.findByEmail(loginUser.getEmail());
		
		if(storedDetailzz!=null) {
			model.addAttribute("messages", "EMAIL ALREADYT EXSISTS.");
			return "loginUser_new";
		}
		loginUserService.saveLoginUser(loginUser);
		
		return "redirect:/loginUser";
	}
	///////////////////////////////////////////
	
	
	
	

	@GetMapping("/loginUser/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model,LeadModel loginUser) {
		LeadModel loginUsers=loginUserService.getLoginUserById(id);
		// set LoginUser as a model attribute to pre-populate the form
			
		model.addAttribute("loginUser", loginUsers);
		
		return "loginUser_update";
	}
	@PostMapping("/loginUser/saveUser")
	public String saveUpdateLoginUser(@ModelAttribute("lead_model") LeadModel loginUser, Model model) {
		// save LoginUser to database
		
		loginUserService.saveLoginUser(loginUser);
		
		return "redirect:/loginUser";
	}
	
	@GetMapping("/loginUser/deleteLoginUser/{id}")
	public String deleteLoginUser(@PathVariable (value = "id") int id) {
		
		// call delete employee method 
		this.loginUserService.deleteLoginUserById(id);
		return "redirect:/loginUser";
	}
}
