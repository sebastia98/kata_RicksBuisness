package edu.elsmancs.domain.kata_RickBuisness;

public class CrystalExpender {
	private int unidades = 0;
	private double costeUnidad = 0d;

	public CrystalExpender(int unidades, int costeUnidad) {
		this.unidades = unidades;
		this.costeUnidad = costeUnidad;
	}
	
	public String toString() {
		return "Stock: " + stock() +
				"\nCoste Unidad: " + costeUnidad();
	}
	
	public int stock() {
		return this.unidades;
	}
	
	public double costeUnidad() {
		return costeUnidad;
	}

	public void dispatch(CreditCard personaje) {
		if (personaje.credit() >= this.costeUnidad && stock() > 0) {
			personaje.pay(costeUnidad);
			this.unidades = this.unidades - 1;
		}
		
	}
}
