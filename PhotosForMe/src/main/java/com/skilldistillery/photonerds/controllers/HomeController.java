package com.skilldistillery.photonerds.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.photonerds.data.UserDAO;
import com.skilldistillery.photonerds.entities.ContractHasPhotographer;
import com.skilldistillery.photonerds.entities.Photographer;

@Controller
public class HomeController {

	@Autowired
	private UserDAO userDAO;

//	@RequestMapping(path = { "/", "home", "home.do" })
//	public String home(Model model) {
//		return "home";
//	}

	@RequestMapping(path = { "/", "home", "home.do" })
	public String home(Model model, HttpSession session) {
			
		List<Photographer> photographers = userDAO.findAllPhotographers();
		for (Photographer photographer : photographers) {
			System.out.println(photographer);
		}

		List<ContractHasPhotographer> chphotographers = userDAO.findAllReviews();
		
		model.addAttribute("chphotographers", chphotographers);
		model.addAttribute("photographers", photographers);

		return "home";
	}

}
