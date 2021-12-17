package com.skilldistillery.photonerds.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.photonerds.data.UserDAO;

@Controller
public class AccountController {

	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(path="account")
	public String accountPage(HttpSession session, Model model) {
		
		return "account";
	}
	
	@RequestMapping(path="account.do")
	public String accountAction(HttpSession session, Model model) {
		
		return "home";
	}
	
	@RequestMapping(path="logout.do")
	public String accountlogout(HttpSession session, Model model) {
		session.setAttribute("username", null);
		
		return "home";
	}
}
