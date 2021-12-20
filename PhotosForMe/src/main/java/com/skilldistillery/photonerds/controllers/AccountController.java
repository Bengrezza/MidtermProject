package com.skilldistillery.photonerds.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.photonerds.data.UserDAO;
import com.skilldistillery.photonerds.entities.ContractHasPhotographer;
import com.skilldistillery.photonerds.entities.Gallery;
import com.skilldistillery.photonerds.entities.Image;
import com.skilldistillery.photonerds.entities.Photographer;
import com.skilldistillery.photonerds.entities.User;

@Controller
public class AccountController {

	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(path="account")
	public String accountPage(HttpSession session, Model model) {

		
		return "account";
	}
	
	@RequestMapping(path="account.do")
	public String accountAction(HttpSession session, Model model, String username, String password, String email) {
		
		Photographer photographer = userDAO.findPhotographerByID(((Photographer) session.getAttribute("photographer")).getId());
		User user = photographer.getUser();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		user = userDAO.updateAccount(user);
		session.setAttribute("user", user);
		session.setAttribute("username", null);
		return "login";
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
	
	@RequestMapping(path="remove.do", method = RequestMethod.POST)
	public String removeImage(HttpSession session, Model model, int imageId, int galleryId) {
		
		Image image = userDAO.findImageById(imageId);
		Gallery gallery = userDAO.findGalleryById(galleryId);
		Boolean deleted = userDAO.removeImageFromGallery(image, gallery);
		Photographer photographer = (Photographer) session.getAttribute("photographer");
		photographer = userDAO.findPhotographerByID(photographer.getId());
		session.setAttribute("photographer", photographer);
		return "account";
	}
}
