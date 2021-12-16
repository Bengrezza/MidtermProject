package com.skilldistillery.photonerds.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.photonerds.data.UserDAO;
import com.skilldistillery.photonerds.entities.User;

@Controller
public class LoginController {
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(path="login")
	public String loginPage() {
		
		return "login";
	}
	@RequestMapping(path="login.do")
	public String loginAction(Model model, HttpSession session, String username, String password) {
		User user;
		
		user = userDAO.findByUsername(username);
		if(user != null) {
			
			if(user.getPassword().equals(password)) {
				session.setAttribute("user", user);
				return "account";
			}
			else {
				
				return "login";
			}
			
		}
		return "login";
	}
	
}
