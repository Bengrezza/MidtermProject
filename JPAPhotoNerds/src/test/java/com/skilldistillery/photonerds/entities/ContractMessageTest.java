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

class ContractMessageTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private ContractMessage cmt;

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
		cmt = em.find(ContractMessage.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		cmt = null;

	}

	@Test
	void test_ContractMessageTest() {
		assertNotNull(cmt);
//		assertEquals(2, cmt.getId());
//		assertEquals("second test message", cmt.getMessage());
//		assertEquals(1, cmt.getReply());
		assertNull(cmt.getReply());

	}

}
