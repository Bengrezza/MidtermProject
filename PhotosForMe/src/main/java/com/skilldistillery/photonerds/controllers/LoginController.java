package com.skilldistillery.photonerds.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.photonerds.data.UserDAO;

@Controller
public class LoginController {
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(path="login")
	public String loginPage() {
		
		return "login";
	}
	@RequestMapping(path="login.do")
	public String loginAction() {
		
		return "account";
	}
	
}
