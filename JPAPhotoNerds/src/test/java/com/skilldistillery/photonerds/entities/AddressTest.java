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

class AddressTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Address address;	

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
		address = em.find(Address.class, 1);
		}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		address = null;
		
	}

	@Test
	void test_Address() {
		assertNotNull(address);
		assertEquals("10435 walle dr", address.getStreet());
		assertNull(address.getStreet2());
		assertEquals("Portland", address.getCity());
		assertEquals("OR", address.getState());
		assertEquals(53291, address.getPostalCode());
		assertEquals("123456789", address.getPhone());
	}
	
	@Test
	void test_Address_Country_ManyToOne_relationship_mapping() {
		assertNotNull(address);
		assertEquals("US", address.getCountry().getId());
		assertEquals("United States", address.getCountry().getName());
	}

}
