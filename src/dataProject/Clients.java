package dataProject;

import java.util.ArrayList;
import java.util.LinkedList;

public class Clients {
	public String clientName;
	public String clientEmail;
	public String clientPhoneNumber;
	
	//Guarda las reservaciones del cliente en strings
	public ArrayList<String> reservationHistory = new ArrayList<>();

	//Guarda los asientos que actualmente tiene reservado el cliente
	public LinkedList<Seats> reservedSeats = new LinkedList<>();
	
	Clients(String clientName, String clientEmail, String clientPhoneNumber) {
		this.clientName = clientName;
		this.clientEmail = clientEmail;
		this.clientPhoneNumber = clientPhoneNumber;
	}
	
	//Devuelve el string del nombre completo del cliente
	public String getClientName() {
		return this.clientName;
	}
	//Setter de un nuevo nombre para el cliente (No se usa pero si en algun momento queremos editar el cliente, es bastante util)
	public void setClientName(String newClientName) {
		this.clientName = newClientName;
	}
	//Devuelve el string del email del cliente
	public String getClientEmail() {
		return this.clientEmail;
	}
	//Setter de un nuevo email para el cliente (No se usa pero si en algun momento queremos editar el cliente, es bastante util)
	public void setClientEmail(String newClientEmail) {
		this.clientEmail = newClientEmail;
	}
	
	//Devuelve el string del nombre de telefono del cliente
	public String getClientPhoneNumber() {
		return this.clientPhoneNumber;
	}
	
	//Setter de un nuevo numero de telefono para el cliente (No se usa pero si en algun momento queremos editar el cliente, es bastante util)
	public void setClientPhoneNumber(String newClientPhoneNumber) {
		this.clientPhoneNumber = newClientPhoneNumber;
	}
	
	//Printea todos los datos del cliente
	public void printClientData() {
		System.out.println("Nombre: " + "\u001B[32m" + this.clientName + "\u001B[0m");
		System.out.println("Correo Electronico: " + "\u001B[32m" + this.clientEmail + "\u001B[0m");
		System.out.println("Numero de Telefono: " + "\u001B[32m" + this.clientPhoneNumber + "\u001B[0m");
	}

	//Verifica si dos clientes tienen exactamente los mismos datos, basicamente un (.equals)
	public boolean isSameClient(Clients otherClient) {
		return this.clientName.toLowerCase().equals(otherClient.clientName.toLowerCase()) && this.clientEmail.toLowerCase().equals(otherClient.clientEmail.toLowerCase()) && this.clientPhoneNumber.toLowerCase().equals(otherClient.clientPhoneNumber.toLowerCase());
	}
	
	//Por si queremos print directamente el objeto del cliente, que haga print al nombre
	@Override
	public String toString() {
		return this.clientName;
	}
}
