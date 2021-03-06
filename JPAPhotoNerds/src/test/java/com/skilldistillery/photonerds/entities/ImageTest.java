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

class ImageTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Image image;

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
		image = em.find(Image.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		image = null;

	}

	// still need to make image entity test
	@Test
	void test_Image() {
		assertNotNull(image);
		assertEquals(1, image.getId());
		assertEquals("First photo", image.getTitle());
		assertEquals(2021, image.getUploadDate().getYear());
		assertNotNull(image.getUrlLink());

	}

	@Test
	void test_AddGallery_method() {
		assertNotNull(image);
		image.addGallery(new Gallery());
		assertTrue(image.getGallery().size() > 1);
		assertEquals("First photo", image.getGallery().get(1).getImages().get(0).getTitle());
		image.getGallery().get(1).setTitle("Best wedding photos");
		assertEquals("Best wedding photos", image.getGallery().get(1).getTitle());
	}

}
