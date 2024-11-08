package dataProject;

public class Clients {
	public String clientName;
	public String clientEmail;
	public String clientPhoneNumber;
	
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
	
	@Override
	public String toString() {
		return this.clientName;
	}
}
