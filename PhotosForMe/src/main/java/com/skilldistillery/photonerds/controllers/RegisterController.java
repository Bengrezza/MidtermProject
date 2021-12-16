package com.skilldistillery.photonerds.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.photonerds.data.UserDAO;
import com.skilldistillery.photonerds.entities.Address;
import com.skilldistillery.photonerds.entities.Country;
import com.skilldistillery.photonerds.entities.User;

@Controller
public class RegisterController {

	@Autowired
	private UserDAO userDAO;

	@RequestMapping(path = "register")
	public String registerPage() {
		return "register";
	}

	@RequestMapping(path = "register.do")
	public String registerAction(Model model, HttpSession session, String username, String password, String firstname,
			String lastname, String email, String role, String street, String street2, String city, String state,
			int postalcode, String phone) {
		User newUser = userDAO.findByUsername(username);
		if (newUser == null|| !newUser.getEmail().equals(username))  {
			newUser = new User();
			session.setAttribute("user", newUser);
			newUser.setUsername(username);
			newUser.setPassword(password);
			newUser.setFirstName(firstname);
			newUser.setLastName(lastname);
			newUser.setEmail(email);
			newUser.setRole(role);

			Address addr = new Address();
			addr.setCity(city);
			addr.setState(state);
			addr.setStreet(street);
			addr.setStreet2(street2);
			addr.setPostalCode(postalcode);
			addr.setPhone(phone);
			try{newUser = userDAO.registerUser(newUser, addr);
			}	catch (Exception e) {
				return "register";
			}
			
			session.setAttribute("user", newUser);
			return "account";
		} else {

			return "register";
		}

	}

}
