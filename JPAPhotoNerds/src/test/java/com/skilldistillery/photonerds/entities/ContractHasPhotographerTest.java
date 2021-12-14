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

class ContractHasPhotographerTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private ContractHasPhotographer chp;

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
		ContractHasPhotographerId chpId = new ContractHasPhotographerId();
		chpId.setContractId(1);
		chpId.setPhotographerId(1);
		chp = em.find(ContractHasPhotographer.class, chpId);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		chp = null;

	}

	@Test
	void test_Contract_Has_Photographer() {
		assertNotNull(chp);

	}

	@Test
	void test_Contract_Has_Photographer_To_Payment_mapping() {
		assertNotNull(chp);
		assertNotNull(chp.getPayments().get(0).getAmount());
		assertEquals(200.75, chp.getPayments().get(0).getAmount());

	}

}
