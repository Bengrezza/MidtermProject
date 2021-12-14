package com.skilldistillery.photonerds.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.photonerds.data.UserDAO;

@Controller
public class GalleryController {
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(path={"gallery", "gallery.do"})
	public String loginPage() {
		
		return "gallery";
	}
	
}
