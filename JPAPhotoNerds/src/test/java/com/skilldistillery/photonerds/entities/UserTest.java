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

class UserTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user;	

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
		user = em.find(User.class, 1);
		}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		user = null;
		
	}

	@Test
	void test_User() {
		assertNotNull(user);
		assertEquals("billyjoe", user.getUsername());
		assertEquals("goat", user.getPassword());
		assertEquals(1, user.getEnabled());
		assertEquals("basic", user.getRole());
		assertEquals("billydagoat@gmail.com", user.getEmail());
		assertEquals(2021, user.getJoinDate().getYear());
		assertEquals(12, user.getJoinDate().getMonthValue());
		assertEquals(11, user.getJoinDate().getDayOfMonth());
	}
	
	@Test
	void test_User_To_Address_Mapping() {
		assertNotNull(user);
		assertEquals("Portland", user.getAddress().getCity());
	}
	@Test
	void test_User_To_Contract_Mapping() {
		assertNotNull(user.getContracts());
		assertEquals(1, user.getContracts().get(0).getUser().getId());
	}
	@Test
	void test_User_To_ContractMessage_Mapping() {
		assertNotNull(user.getContractMessages());
		assertEquals("Testing message", user.getContractMessages().get(0).getMessage());
		assertEquals(2021, user.getContractMessages().get(0).getMessageDate().getYear());
	}
	
	@Test
	void test_User_AddContract_method() {
		assertNotNull(user.getContracts());
		user.addContract(new Contract());
		assertTrue(user.getContracts().size() > 1);
	}
	
	@Test
	void test_User_AddContractMessage_method() {
		assertNotNull(user.getContractMessages());
		user.addContractMessage(new ContractMessage());
		assertTrue(user.getContractMessages().size() == 2);
		user.getContractMessages().get(1).setMessage("It works whoever is reading this");
		assertEquals("It works whoever is reading this", user.getContractMessages().get(1).getMessage());
	}

}
