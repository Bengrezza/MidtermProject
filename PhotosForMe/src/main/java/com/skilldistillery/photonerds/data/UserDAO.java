package com.skilldistillery.photonerds.data;

import java.util.List;

import com.skilldistillery.photonerds.entities.Address;
import com.skilldistillery.photonerds.entities.ContractHasPhotographer;
import com.skilldistillery.photonerds.entities.Gallery;
import com.skilldistillery.photonerds.entities.Photographer;
import com.skilldistillery.photonerds.entities.User;

public interface UserDAO {

	User findByUsername(String username);
	User updateUserInfo(int id);
	Photographer findPhotographerByID(int id); 
	List<Photographer> findAllPhotographers(); 
	Gallery findGalleryFromPhotographer(int id);
	User registerUser(User newUser, Address newAddr);
	Photographer findByUserId(int userId);
	List<ContractHasPhotographer> findContractsByPhotographerId(int photoGId);
}
