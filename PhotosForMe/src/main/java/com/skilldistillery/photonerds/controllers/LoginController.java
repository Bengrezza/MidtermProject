package com.skilldistillery.photonerds.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.photonerds.data.UserDAO;
import com.skilldistillery.photonerds.entities.ContractHasPhotographer;
import com.skilldistillery.photonerds.entities.Photographer;
import com.skilldistillery.photonerds.entities.User;

@Controller
public class LoginController {

	@Autowired
	private UserDAO userDAO;

	@RequestMapping(path = "login")
	public String loginPage() {

		return "login";
	}

	@RequestMapping(path = "login.do")
	public String loginAction(Model model, HttpSession session, String username, String password) {
		User user;
		Photographer photoG;
		user = userDAO.findByUsername(username);
		if (user != null) {

			if (user.getPassword().equals(password)) {

				if (user.getPhotographer() != null) {
					photoG = user.getPhotographer();
					session.setAttribute("photographer", photoG);
					List <ContractHasPhotographer> chs;
					chs = userDAO.findContractsByPhotographerId(photoG.getId());
					if(chs != null) {
						session.setAttribute("chs", chs);
					}
					else {
						chs = new ArrayList<>();
						session.setAttribute("chs", chs);
					}
					
				}
				else {
					photoG = null;
					session.setAttribute("photographer", photoG);
				}
				session.setAttribute("user", user);
				return "account";
			} else {

				return "login";
			}

		}
		return "login";
	}

}
