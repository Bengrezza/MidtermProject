package com.skilldistillery.photonerds.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.photonerds.data.UserDAO;

@Controller
public class AccountController {

	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(path="account")
	public String accountPage() {
		
		return "account";
	}
	
	@RequestMapping(path="account.do")
	public String accountAction() {
		
		return "home";
	}
}
