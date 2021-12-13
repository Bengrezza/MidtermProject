package com.skilldistillery.photonerds.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.photonerds.data.UserDAO;

@Controller
public class RegisterController {

		@Autowired
		private UserDAO userDAO;
		
		@RequestMapping(path="register")
		public String registerPage() {
			return "register";
		}
		
		@RequestMapping(path="register.do")
		public String registerAction() {
			
			return "home";
		}
}
