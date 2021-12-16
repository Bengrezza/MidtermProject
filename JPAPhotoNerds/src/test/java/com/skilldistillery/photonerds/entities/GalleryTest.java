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

class GalleryTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Gallery gallery;

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
		gallery = em.find(Gallery.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		gallery = null;

	}

	@Test
	void test_Gallery() {
		assertNotNull(gallery);
		assertEquals("Basic Display", gallery.getTitle());
		assertEquals("First photo", gallery.getImages().get(0).getTitle());
		assertEquals("second photo", gallery.getImages().get(1).getTitle());
		assertEquals("third photo", gallery.getImages().get(2).getTitle());
	}

	@Test
	void test_Gallery_Image_ManyToMany_mapping() {
		assertNotNull(gallery);
		assertEquals("First photo", gallery.getImages().get(0).getTitle());
	}

	@Test
	void test_AddImage_method() {
		assertNotNull(gallery);
		gallery.addImage(new Image());
		assertEquals(4, gallery.getImages().size());
	}
	
	@Test
	void test_RemoveImage_method() {
		assertNotNull(gallery);
		gallery.removeImage(gallery.getImages().get(2));
		assertTrue(gallery.getImages().size() < 3);
	}

}
