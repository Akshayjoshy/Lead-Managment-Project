package com.akshay.LeadManagmentProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.akshay.LeadManagmentProject.Model.LoginModel;
import com.akshay.LeadManagmentProject.Repository.LoginRepository;
import com.akshay.LeadManagmentProject.Service.LoginService;




@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	@Autowired
	private LoginRepository loginRepository;
	
	@GetMapping("/myhome")
	public String home(Model model) {
		//LoginModel loginModel=new LoginModel();
		//model.addAttribute("loginModel", loginModel);
		return "home";
				
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		LoginModel loginModel=new LoginModel();
		model.addAttribute("loginModel", loginModel);
		return "Login";
				
	}
	@GetMapping("/loginAdmin")
	public String loginAdmin(Model model) {
		model.addAttribute("adminlist",loginService.getAllLoginUser());
		return "Adminlist";
				
	}
	@GetMapping("/loginAdmin/addAdmin")
	public String addAdmin(Model model) {
		LoginModel userModel=new LoginModel();
		model.addAttribute("userModel", userModel);
		return "AddAdmin";
	}
	
	
	@PostMapping("/loginAdmin/saveAdmin")
	public String saveAdmin(@ModelAttribute("userModel") LoginModel userModel, Model model) {
	
		LoginModel storedDetailz= loginRepository.findByUsername(userModel.getUsername());
		
		if(storedDetailz!=null) {
			
			model.addAttribute("message", "USERNAME ALREADYT EXSISTS.");
			
			return "AddAdmin";
		} 
		loginService.saveLoginUser(userModel);
		return "redirect:/loginAdmin";
		}
	
	@PostMapping("/home")
	public String homeList(@RequestParam String username,@RequestParam String password) {
		
		LoginModel loginModel1=loginRepository.getByUsernameAndPassword(username, password);
		
		if(loginModel1!=null) {
			System.out.println("user found");
			return "home";
		}else {
			return "Error";
		}
		
	}
	
	@PostMapping("/loginAdmin/saveUser")
	public String saveUpdatedAdmin(@ModelAttribute("login_model") LoginModel userModel, Model model) {
	
		loginService.saveLoginUser(userModel);
		return "redirect:/loginAdmin";
		}
	
	@GetMapping("/loginAdmin/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model,LoginModel userModel) {
		LoginModel userModels=loginService.getLoginUserById(id);
		// set LoginUser as a model attribute to pre-populate the form
			
		model.addAttribute("userModel",userModels);
		
		return "Adminupdate";
	}
	
	@GetMapping("/loginAdmin/deleteLoginUser/{id}")
	public String deleteLoginUser(@PathVariable (value = "id") int id) {
		
		// call delete employee method 
		this.loginService.deleteLoginUserById(id);
		return "redirect:/loginAdmin";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
