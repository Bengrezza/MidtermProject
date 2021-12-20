package com.skilldistillery.photonerds.data;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.skilldistillery.photonerds.entities.Address;
import com.skilldistillery.photonerds.entities.ContractHasPhotographer;
import com.skilldistillery.photonerds.entities.Country;
import com.skilldistillery.photonerds.entities.Gallery;
import com.skilldistillery.photonerds.entities.Image;
import com.skilldistillery.photonerds.entities.Photographer;
import com.skilldistillery.photonerds.entities.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public User findByUsername(String username) {
		String jpql = "SELECT u FROM User u WHERE u.username= :n";

		try {
			return em.createQuery(jpql, User.class).setParameter("n", username).getSingleResult();
		} catch (Exception e) {
			System.err.println("invalid user");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User updateUserInfo(int id) {
		String jpql = "SELECT u FROM User u WHERE u.id = :id";

		try {
			return em.createQuery(jpql, User.class).setParameter("id", id).getSingleResult();
		} catch (Exception e) {
			System.err.println("invalid user");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Photographer> findAllPhotographers() {
		String jpql = "SELECT p FROM Photographer p";

		try {
			return em.createQuery(jpql, Photographer.class).getResultList();
		} catch (Exception e) {
			System.err.println("invalid photographers");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Photographer findPhotographerByID(int id) {
		String jpql = "SELECT p FROM Photographer p WHERE p.id = :id";

		try {
			return em.createQuery(jpql, Photographer.class).setParameter("id", id).getSingleResult();
		} catch (Exception e) {
			System.err.println("invalid photographer");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Gallery findGalleryFromPhotographer(int id) {
		String jpql = "SELECT g FROM Gallery g where g.photographer.id = :id";

		try {
			return em.createQuery(jpql, Gallery.class).setParameter("id", id).getSingleResult();
		} catch (Exception e) {
			System.err.println("invalid photographer");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User registerUser(User newUser, Address newAddr) {

		Country country = em.find(Country.class, "US");
		newAddr.setCountry(country);
		try {
		em.persist(newAddr);
		newUser.setAddress(newAddr);
		newUser.setEnabled(1);
		newUser.setJoinDate(LocalDateTime.now());
		em.persist(newUser);
		} catch (Exception e) {
			return null;
		}
		System.err.println(newUser.getId());
		
		return newUser;
	}

	@Override
	public Photographer findByUserId(int userId) {
		String jpql = "SELECT u FROM User u WHERE u.id = :id";

		try {
			return em.createQuery(jpql, Photographer.class).setParameter("id", userId).getSingleResult();
		} catch (Exception e) {
			System.err.println("invalid photographer");
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<ContractHasPhotographer> findContractsByPhotographer(int photoGId) {
		String jpql = "SELECT chp FROM ContractHasPhotographer chp WHERE chp.photographer.id = :id ";
		List<ContractHasPhotographer> chs = em.createQuery(jpql, ContractHasPhotographer.class).setParameter("id", photoGId).getResultList();
		
		return chs;
	}
	
	@Override
	public List<ContractHasPhotographer> findAllReviews() {
		String jpql = "SELECT chp FROM ContractHasPhotographer chp";
		List<ContractHasPhotographer> chp = em.createQuery(jpql, ContractHasPhotographer.class).getResultList();
		return chp;
	}

	@Override
	public Boolean removeImageFromGallery(Image image, Gallery gallery) {
		gallery.removeImage(image);
		Boolean deleted = false;
		if( !gallery.getImages().contains(image)) {
			deleted = true;
		}
		
		return deleted;
	}

	@Override
	public Image findImageById(int id) {
		String jpql = "SELECT i FROM Image i WHERE i.id = :id";
		Image image = em.createQuery(jpql, Image.class).setParameter("id", id).getSingleResult();
		return image;
	}
	@Override
	public Gallery findGalleryById(int id) {
		String jpql = "SELECT g FROM Gallery g WHERE g.id = :id";
		Gallery gallery = em.createQuery(jpql, Gallery.class).setParameter("id", id).getSingleResult();
		return gallery;
	}

	@Override
	public User updateAccount(User user) {
		em.persist(user);
		return user;
	}
	


}
