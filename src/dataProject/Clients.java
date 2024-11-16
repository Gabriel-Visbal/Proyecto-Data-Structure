package dataProject;

import java.util.LinkedList;
import java.util.ArrayList;

public class Clients {
	public String clientName;
	public String clientEmail;
	public String clientPhoneNumber;
	
	public ArrayList<String> reservationHistory = new ArrayList<String>();

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
	
	public void printClientData() {
		System.out.println("Nombre: " + this.clientName);
		System.out.println("Correo Electronico: " + this.clientEmail);
		System.out.println("Numero de Telefono: " + this.clientPhoneNumber);
	}

	public boolean isSameClient(Clients otherClient) {
		return this.clientName.toLowerCase().equals(otherClient.clientName.toLowerCase()) && this.clientEmail.toLowerCase().equals(otherClient.clientEmail.toLowerCase()) && this.clientPhoneNumber.toLowerCase().equals(otherClient.clientPhoneNumber.toLowerCase());
	}
	
	@Override
	public String toString() {
		return this.clientName;
	}
}
