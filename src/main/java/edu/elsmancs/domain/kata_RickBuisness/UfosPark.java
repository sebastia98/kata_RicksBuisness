package edu.elsmancs.domain.kata_RickBuisness;

import java.util.HashMap;
import java.util.Map;

public class UfosPark implements GuestDispatcher {
	
	private final double fee = 500d;
	private Map<String, String> flota = new HashMap <String, String>(); 

	public String toString(){
		return flota.keySet().toString();
	}
	
	public void add(String ovniID) {
		this.flota.put(ovniID, null);
	}
	
	public Map<String, String> getFlota(){
		return this.flota;
	}

	public void dispatch(CreditCard abradolph) {
		if (this.getFlota().containsKey(abradolph.number())) {
			
		}
		else if (abradolph.credit() >= this.fee) {
			for (String ovniID: this.getFlota().keySet()) {
				if (this.getFlota().get(ovniID) == null) {
					abradolph.pay(fee);
					this.getFlota().put(ovniID, abradolph.number());
					break;
				}
			}
		}
		
	}
	
	public String getUfoOf(String nombrePersonaje) {
		String ovni = null;
		for (String ovniID: this.getFlota().keySet()) {
			if (this.getFlota().get(ovniID) == nombrePersonaje) {
				ovni = ovniID;
			}
		}
		return ovni;
	}

}
