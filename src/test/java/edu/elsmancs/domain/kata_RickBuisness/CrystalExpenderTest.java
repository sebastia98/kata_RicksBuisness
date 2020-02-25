package edu.elsmancs.domain.kata_RickBuisness;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CrystalExpenderTest {
	
	CrystalExpender packExpender = null;
	
	
	@Before
	public void before() {
		packExpender = new CrystalExpender(3, 50);
	}

	@Test
	public void crearDispenserTest() {
		assertEquals(packExpender.stock(), 3, 0);
		assertEquals(packExpender.costeUnidad(), 50, 0);
	}
	
	@Test
	public void dispatchTest() {
		CreditCard squanchy = new CreditCard("Squanchy", "4444444444444444");
		packExpender.dispatch(squanchy);
		assertEquals(packExpender.stock(), 2, 0);
	}
	@Test
	public void dispatchNoCreditTest() {
		CreditCard squanchy = new CreditCard("Squanchy", "4444444444444444");
		squanchy.pay(3000);
		packExpender.dispatch(squanchy);
		assertEquals(packExpender.stock(), 3, 0);
	}
	@Test
	public void dispatchNoStockTest() {
		CreditCard squanchy = new CreditCard("Squanchy", "4444444444444444");
		packExpender.dispatch(squanchy);
		packExpender.dispatch(squanchy);
		packExpender.dispatch(squanchy);
		packExpender.dispatch(squanchy);
		assertEquals(packExpender.stock(), 0, 0);
		assertEquals(squanchy.credit(), 2850d, 0);		
	}

}
