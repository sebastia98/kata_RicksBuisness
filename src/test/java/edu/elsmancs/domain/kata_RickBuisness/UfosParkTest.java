package edu.elsmancs.domain.kata_RickBuisness;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UfosParkTest {
	
	UfosPark ufos = null;
    String[] ovnis = { "unx", "dox", "trex" };
    String[] ovnisTest = {"trex", "dox", "unx"};
    
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
    	assertArrayEquals(ufos.getFlota().keySet().toArray(), ovnisTest);
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
    	assertEquals(abradolph.credit(), 2500d, 0);
    	assertEquals(ufos.getFlota().get("trex"), "4916119711304546");
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
    	assertEquals(ufos.getFlota().containsValue(abradolph.number()), false);
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
    	assertEquals(ufos.getFlota().get("trex"), "4916119711304546");
    	assertEquals(ufos.getFlota().get("dox"), "4916119711304547");
    	
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
    	assertEquals(ufos.getUfoOf(abradolph.number()), "trex");
    }
	

}
