package com.skilldistillery.photonerds.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PhotoShootTypeTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private PhotoShootType pst;	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAPhotoNerds");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		pst = em.find(PhotoShootType.class, 1);
		}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		pst = null;
		
	}

	@Test
	void test_Photo_Shoot_Type() {
		assertNotNull(pst);
		assertEquals(1, pst.getId());
		assertEquals("Weddings", pst.getName());
		
	}

}
