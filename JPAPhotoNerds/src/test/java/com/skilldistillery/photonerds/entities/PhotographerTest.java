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

class PhotographerTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Photographer photographer;	

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
		photographer = em.find(Photographer.class, 1);
		}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		photographer = null;
		
	}

	@Test
	void test_Photographer() {
		assertNotNull(photographer);
		assertEquals(1, photographer.getActive());
		assertEquals("Picture Perfect", photographer.getBusiness());
		assertEquals("Capturing moments for a life time to see!", photographer.getDescription());
	}

}
