package dataProject;

import java.util.Stack;

public class ClientActions {
    public Clients client;
    public Seats seat;    
    public String actionType;

    public static Stack<ClientActions> actionHistory = new Stack<ClientActions>();

    ClientActions(Clients client, Seats seat, String actionType) {
        this.client = client;
        this.seat = seat;
        this.actionType = actionType;
    }

	public Clients getClient() {
		return this.client;
	}
	
	public void setClient(Clients newClient) {
		this.client = newClient;
	}

    public Seats getSeat() {
		return this.seat;
	}
	
	public void setSeat(Seats newSeat) {
		this.seat = newSeat;
	}

    public String getActionType() {
		return this.actionType;
	}
	
	public void setActionType(String newActionType) {
		this.actionType = newActionType;
	}

}
