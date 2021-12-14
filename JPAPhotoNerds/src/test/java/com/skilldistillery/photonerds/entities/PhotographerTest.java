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
	
	@Test
	void test_Photographer_OneToOne_User_mapping() {
		assertNotNull(photographer);
		assertEquals("pete", photographer.getUser().getFirstName());
		
		
	}
	
	@Test
	void test_Photographer_OneToMany_Gallery_mapping() {
		assertNotNull(photographer);
		assertNotNull(photographer.getGallery());
		assertEquals("Basic Display", photographer.getGallery().get(0).getTitle());
	}
	
	@Test
	void test_Photographer_PhotoShootType_ManyToMany_mapping() {
		assertNotNull(photographer);
		assertNotNull(photographer.getPhotoShootTypes());
		assertEquals("Weddings", photographer.getPhotoShootTypes().get(0).getName());
	}
	@Test
	void test_Photographer_Contract_ManyToMany_mapping() {
		assertNotNull(photographer);
		assertNotNull(photographer.getContracts());
		assertEquals("30 min session", photographer.getContracts().get(0).getDescription());
		assertEquals("Family Photo ", photographer.getContracts().get(0).getTitle());
	}

}
