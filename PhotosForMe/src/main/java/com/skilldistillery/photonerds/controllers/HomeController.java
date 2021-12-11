package com.skilldistillery.photonerds.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.skilldistillery.photonerds.data.UserDAO;

@Controller
public class HomeController {

	@Autowired
	private UserDAO userDAO;
	
}
