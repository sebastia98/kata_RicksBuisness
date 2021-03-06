package edu.elsmancs.domain.kata_RickBuisness;

public class CreditCard {
	
	private String nombreInvitado = null;
	private String numeroTarjeta = null;
	private double credito = 3000d;
	final private String symbol = "EZIS";

	public CreditCard(String nombreInvitado, String numeroTarjeta) {
		this.nombreInvitado = nombreInvitado;
		this.numeroTarjeta = numeroTarjeta;
	}
	
	public String toString() {
		return "Owner: " + getNombre() +
				"\nNumber: " + number() +
				"\nCredit: " + credit() + " " + this.symbol;
	}
	public String getNombre() {
		return this.nombreInvitado;
	}
	public String number() {
		return this.numeroTarjeta;
	}
	
	public double credit() {
		if (this.credito <= 0) {
			return 0d;
		}
		else {
			return this.credito;
		}
		
	}
	public void pay(double coste) {
		this.credito = this.credito - coste;
	}

}
