package com.skilldistillery.photonerds.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

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

}
