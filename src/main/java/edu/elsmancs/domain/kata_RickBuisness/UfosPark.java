package edu.elsmancs.domain.kata_RickBuisness;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UfosPark {
	
	private final double fee = 500d;
	private Map<String, String> flotaReservada = new HashMap <String, String>();
	private ArrayList<String> flota = new ArrayList<String>();

	public void add(String ovniID) {
		this.flota.add(ovniID);
	}
	
	public Map<String, String> getFlotaReserva(){
		return this.flotaReservada;
	}
	
	public ArrayList<String> getFlota(){
		return flota;
	}

	public void dispatch(CreditCard abradolph) {
		if (abradolph.credit() >= this.fee && this.flota.size() > 0) {
			abradolph.pay(fee);
			this.flotaReservada.put(abradolph.getNombre(), this.flota.remove(0));
		}
		
	}
	
	public String getUfosOf(String nombrePersonaje) {
		return this.flotaReservada.get(nombrePersonaje);
	}

}
