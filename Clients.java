package dataProject;

import java.util.LinkedList;

public class Clients {
	public String clientName;
	public String clientEmail;
	public String clientPhoneNumber;
	public int clientPay = 0;
	
	public LinkedList<Seats> reservedSeats = new LinkedList<Seats>();
	
	Clients(String clientName, String clientEmail, String clientPhoneNumber) {
		this.clientName = clientName;
		this.clientEmail = clientEmail;
		this.clientPhoneNumber = clientPhoneNumber;
	}
	
	public String getClientName() {
		return this.clientName;
	}
	
	public void setClientName(String newClientName) {
		this.clientName = newClientName;
	}
	
	public String getClientEmail() {
		return this.clientEmail;
	}
	
	public void setClientEmail(String newClientEmail) {
		this.clientEmail = newClientEmail;
	}
	
	public String getClientPhoneNumber() {
		return this.clientPhoneNumber;
	}
	
	public void setClientPhoneNumber(String newClientPhoneNumber) {
		this.clientPhoneNumber = newClientPhoneNumber;
	}
	
	public int getClientPay() {
		return this.clientPay;
	}
	
	public void setClientPay(int newClientPay) {
		this.clientPay = newClientPay;
	}
	
	public void printClientData() {
		System.out.println("Nombre: " + this.clientName);
		System.out.println("Correo Electrónico: " + this.clientEmail);
		System.out.println("Número de Teléfono: " + this.clientPhoneNumber);
	}
	
	@Override
	public String toString() {
		return this.clientName;
	}
}
