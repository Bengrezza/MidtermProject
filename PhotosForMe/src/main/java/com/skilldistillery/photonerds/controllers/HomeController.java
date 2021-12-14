package com.skilldistillery.photonerds.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.photonerds.data.UserDAO;

@Controller
public class HomeController {

	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(path = {"/", "home", "home.do"})
	public String home(Model model) {
		model.addAttribute("DEBUG", userDAO.findByUsername("customer1"));
		return "home";
	}
	
}
