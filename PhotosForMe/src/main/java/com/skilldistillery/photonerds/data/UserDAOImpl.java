package com.skilldistillery.photonerds.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

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
			System.err.println("invalid photographer");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Photographer> findPhotographers(int id) {
		String jpql = "SELECT p FROM Photographer p WHERE p.id = :id";

		try {
			return em.createQuery(jpql, Photographer.class).setParameter("id", id).getResultList();
		} catch (Exception e) {
			System.err.println("invalid photographer");
			e.printStackTrace();
			return null;
		}
	}

}
