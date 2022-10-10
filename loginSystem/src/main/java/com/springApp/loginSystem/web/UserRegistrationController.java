package com.springApp.loginSystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springApp.loginSystem.service.UserService;
import com.springApp.loginSystem.web.dto.UserRegisterationDtoa;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	@Autowired
	private UserService userService;
	
	public UserRegistrationController(UserService service) {
		super();
		this.userService = service;
	}
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	@ModelAttribute("user")
	public UserRegisterationDtoa userRegistrationDto() {
		return new UserRegisterationDtoa();
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegisterationDtoa registerationDtoa) {
		userService.save(registerationDtoa);
		return "redirect:/registration?success";
	}
	
}
