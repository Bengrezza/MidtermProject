package com.skilldistillery.photonerds.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.photonerds.data.UserDAO;
import com.skilldistillery.photonerds.entities.Gallery;
import com.skilldistillery.photonerds.entities.Photographer;

@Controller
public class GalleryController {
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(path={"gallery"})
	public String gallery(Model model) {
		
		List<Photographer> photographers = userDAO.findAllPhotographers();
		List<Gallery> galleries = new ArrayList<>();
		for (Photographer photographer : photographers) {
			galleries.add(userDAO.findGalleryFromPhotographer(photographer.getId()));
		}
		
		model.addAttribute("photographers", photographers);
		model.addAttribute("galleries", galleries);
		
		return "gallery";
	}
	
	@RequestMapping(path={"gallery.do"})
	public String galleryDo(Model model, int photographerid, HttpSession session) {
	
		Photographer photographer = userDAO.findPhotographerByID(photographerid);
		
		session.setAttribute("photographer", photographer);
		session.setAttribute("user", photographer.getUser());
		session.setAttribute("chs", photographer.getChps());
		
		
		return "account";
	}
}
