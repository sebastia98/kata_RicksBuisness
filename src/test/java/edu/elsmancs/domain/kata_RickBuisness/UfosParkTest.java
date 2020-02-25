package edu.elsmancs.domain.kata_RickBuisness;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UfosParkTest {
	
	UfosPark ufos = null;
    String[] ovnis = { "unx", "dox", "trex" };
    
    @Before
    public void before() {
    	ufos = new UfosPark();
    	for (String ovni : ovnis) {
        	ufos.add(ovni);
    	}
    }

    /**
     * Testea el metodo añadir ovni 
     * a la flota de ufos
     */
    @Test
    public void addUfoTest() {
    	assertArrayEquals(ufos.getFlota().toArray(), ovnis);
    }

    /**
     * Testea el metodo reservar ovni 
     * y cargar el pago en la tarjeta 
     * de crédito.
     * El crédito de la tarjeta varía.
     */
    @Test
    public void dispatchTest() {
    	CreditCard abradolph = new CreditCard("Abradolph Lincler", "4916119711304546");
    	ufos.dispatch(abradolph);
    	assertEquals(abradolph.credit(), abradolph.credit(), 0);
    	assertEquals(ufos.getFlotaReserva().get("4916119711304546"), "unx");
    	String[] ovnisTest = { "dox", "trex" };
    	assertArrayEquals(ufos.getFlota().toArray(), ovnisTest);
    }

    /**
     * Testea que no se pueda reservar un ovni 
     * si no hay crédito suficiente en la tarjeta.
     * El crédito de la tarjeta no varía.
     */
    @Test
    public void dispatchNoCreditTest() {
    	CreditCard abradolph = new CreditCard("Abradolph Lincler", "4916119711304546");
    	abradolph.pay(3000d);
    	assertEquals(abradolph.credit(), 0, 0);
    	assertArrayEquals(ufos.getFlota().toArray(), ovnis);
    }

    /**
     * Testea que no se pueda reservar un ovni 
     * si ya existe un ovni reservado para esa tarjeta.
     * El crédito de la tarjeta no varía.
     */
    @Test
    public void dispatchUfoAlreadyReservedTest() {
    	CreditCard abradolph = new CreditCard("Abradolph Lincler", "4916119711304546");
    	CreditCard sebas = new CreditCard("Sebas Adrover", "4916119711304547");
    	ufos.dispatch(abradolph);
    	ufos.dispatch(sebas);
    	assertEquals(ufos.getFlotaReserva().get("4916119711304546"), "unx");
    	assertEquals(ufos.getFlotaReserva().get("4916119711304547"), "dox");
    	
    }

    /**
     * Testea que no se pueda reservar un ovni 
     * si no existe ninguno disponible (sin reservar).
     * El crédito de la tarjeta no varía.
     */
    @Test
    public void dispatchNoUfoAvaliableTest() {
    	CreditCard abradolph = new CreditCard("Abradolph Lincler", "4916119711304546");
    	CreditCard jarjar = new CreditCard("JarJar", "4916119711304547");
    	CreditCard toni = new CreditCard("Toni Adrover", "4916119711304548");
    	CreditCard sebas = new CreditCard("Sebas Adrover", "4916119711304549");
    	ufos.dispatch(abradolph);
    	ufos.dispatch(jarjar);
    	ufos.dispatch(toni);
    	ufos.dispatch(sebas);
    	assertEquals(sebas.credit(), 3000d, 0);
    }

    /**
     * Devuelve el UFO reservado para la tarjeta.
     */
    @Test
    public void getUfoOfTest() {
    	CreditCard abradolph = new CreditCard("Abradolph Lincler", "4916119711304546");
    	ufos.dispatch(abradolph);
    	assertEquals(ufos.getUfoOf(abradolph.number()), "unx");
    }
	

}
