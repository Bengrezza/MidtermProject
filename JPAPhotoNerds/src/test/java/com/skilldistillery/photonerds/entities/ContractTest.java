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

class ContractTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Contract contract;

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
		contract = em.find(Contract.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		contract = null;

	}

	@Test
	void test_Contract() {
		assertNotNull(contract);
		assertEquals(1, contract.getId());
		assertEquals("Family Photo ", contract.getTitle());
		assertEquals("30 min session", contract.getDescription());
		assertEquals("Woodland Park city center out front", contract.getLocation());
		assertEquals(2021, contract.getEventStart().getYear());
		assertEquals(12, contract.getEventStart().getMonthValue());
		assertEquals(13, contract.getEventStart().getDayOfMonth());

	}

}
