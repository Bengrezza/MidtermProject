package com.skilldistillery.photonerds.data;

import com.skilldistillery.photonerds.entities.User;

public interface UserDAO {

	User findByUsername(String username);
	
}
