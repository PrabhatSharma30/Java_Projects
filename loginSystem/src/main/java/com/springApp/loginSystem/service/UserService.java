package com.springApp.loginSystem.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.springApp.loginSystem.model.User;
import com.springApp.loginSystem.web.dto.UserRegisterationDtoa;

public interface UserService extends UserDetailsService{
	
	User save(UserRegisterationDtoa registrationDto);

}
