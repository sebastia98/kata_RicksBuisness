package edu.elsmancs.domain.kata_RickBuisness;

public class CreditCard {
	
	private String nombreInvitado = null;
	private String numeroTarjeta = null;
	private double credito = 3000;
	final private String symbol = "EZIS";

	public CreditCard(String nombreInvitado, String numeroTarjeta) {
		this.nombreInvitado = nombreInvitado;
		this.numeroTarjeta = nombreInvitado;
	}
	
	public String toString() {
		return "Owner: " + this.nombreInvitado +
				"\nNumber: " + this.numeroTarjeta +
				"Credit: " + this.credito + " " + this.symbol;
	}

}
