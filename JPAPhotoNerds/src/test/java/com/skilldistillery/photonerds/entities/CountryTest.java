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

class CountryTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Country country;	

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
		country = em.find(Country.class, "US");
		}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		country = null;
		
	}

	@Test
	void test_Address() {
		assertNotNull(country);
		assertEquals("US", country.getId());
		assertEquals("United States", country.getName());
		
	}

}
