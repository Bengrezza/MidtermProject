package com.skilldistillery.photonerds.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.photonerds.data.UserDAO;
import com.skilldistillery.photonerds.entities.ContractHasPhotographer;
import com.skilldistillery.photonerds.entities.Gallery;
import com.skilldistillery.photonerds.entities.Image;
import com.skilldistillery.photonerds.entities.Photographer;

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
		
		List<Photographer> photographers = userDAO.findAllPhotographers();
		for (Photographer photographer : photographers) {
			System.out.println(photographer);
		}

		List<ContractHasPhotographer> chphotographers = userDAO.findAllReviews();
		
		model.addAttribute("chphotographers", chphotographers);
		model.addAttribute("photographers", photographers);
		return "home";
	}
	
	@RequestMapping(path="remove.do")
	public String removeImage(HttpSession session, Model model, int imageId, int galleryId) {
		
		Image image = userDAO.findImageById(imageId);
		Gallery gallery = userDAO.findGalleryById(galleryId);
		Boolean deleted = userDAO.removeImageFromGallery(image, gallery);
		
		System.err.println(deleted);
		
		return "account";
	}
}
