package com.skilldistillery.photonerds.data;

import java.util.List;

import com.skilldistillery.photonerds.entities.Photographer;
import com.skilldistillery.photonerds.entities.User;

public interface UserDAO {

	User findByUsername(String username);
	User updateUserInfo(int id);
	List<Photographer> findPhotographers(int id); 
	
}
