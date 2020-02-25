package edu.elsmancs.domain.kata_RickBuisness;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UfosPark {
	
	private Map<String, String> flotaReservada = new HashMap <String, String>();
	private ArrayList<String> flota = new ArrayList<String>();

	public void add(String ovniID) {
		this.flota.add(ovniID);
	}
	
	public ArrayList<String> getFlota(){
		return flota;
	}

	public void dispatch(CreditCard abradolph) {
		
		
	}

}
