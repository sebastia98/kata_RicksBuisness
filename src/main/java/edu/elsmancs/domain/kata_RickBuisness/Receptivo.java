package edu.elsmancs.domain.kata_RickBuisness;

import java.util.ArrayList;

public class Receptivo {
	
	ArrayList<GuestDispatcher> guest = new ArrayList<GuestDispatcher>();
	
	public Receptivo() {}
	/*Registra los objetos que implementan la interfaz en una estructura de datos ya que así almacenamos todos los datos que usa guestDispatcher*/
	public void registra(GuestDispatcher gestDispatcher) {
		this.guest.add(gestDispatcher);
	}
	
	public ArrayList<GuestDispatcher> getGuest(){
		return this.guest;
	}
	public void dispatch(CreditCard personaje) {
		for (GuestDispatcher objeto: guest) {
			objeto.dispatch(personaje);
		}
		
	}
	
	
}
