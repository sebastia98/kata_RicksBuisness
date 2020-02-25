package edu.elsmancs.domain.kata_RickBuisness;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UfosPark implements GuestDispatcher {
	
	private final double fee = 500d;
	private Map<String, String> flotaReservada = new HashMap <String, String>();
	private ArrayList<String> flota = new ArrayList<String>();
	private ArrayList<String> nombresNaves = new ArrayList<String>(); 

	public String toString(){
		return nombresNaves.toString();
	}
	
	public void add(String ovniID) {
		this.flota.add(ovniID);
		this.nombresNaves.add(ovniID);
	}
	
	public Map<String, String> getFlotaReserva(){
		return this.flotaReservada;
	}
	
	public ArrayList<String> getFlota(){
		return flota;
	}

	public void dispatch(CreditCard abradolph) {
		if (this.getFlotaReserva().containsKey(abradolph.number())) {
			
		}
		else {
			if (abradolph.credit() >= this.fee && this.flota.size() > 0 ) {
				abradolph.pay(fee);
				this.flotaReservada.put(abradolph.number(), this.flota.remove(0));
			}
		}
		
	}
	
	public String getUfoOf(String nombrePersonaje) {
		return this.flotaReservada.get(nombrePersonaje);
	}

}
