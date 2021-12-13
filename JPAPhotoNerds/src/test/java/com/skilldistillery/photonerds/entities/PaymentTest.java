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

class PaymentTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Payment payment;	

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
		payment = em.find(Payment.class, 1);
		}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		payment = null;
		
	}

	@Test
	void test_Payment() {
		assertNotNull(payment);
		assertEquals(1, payment.getId());
		assertEquals(2021, payment.getPaymentDate().getYear());
		assertEquals(12, payment.getPaymentDate().getMonthValue());
		assertEquals(11, payment.getPaymentDate().getDayOfMonth());
		assertEquals(16, payment.getPaymentDate().getHour());
		assertEquals(10, payment.getPaymentDate().getMinute());
		assertEquals(200.75, payment.getAmount());
		
		
	}

}
