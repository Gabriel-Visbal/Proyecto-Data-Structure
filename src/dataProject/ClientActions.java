package dataProject;

import java.util.Stack;

public class ClientActions {
    public Clients client;
    public Seats seat;    
    public String actionType;

	//Stack que guarda todas las acciones que se hacen durante el programa, las reservaciones, las cancelaciones
    public static Stack<ClientActions> actionHistory = new Stack<ClientActions>();

    ClientActions(Clients client, Seats seat, String actionType) {
        this.client = client;
        this.seat = seat;
        this.actionType = actionType;
    }

	//Devuelve el cliente que hizo dicha accion
	public Clients getClient() {
		return this.client;
	}

	//Settea un nuevo cliente que hizo la accion
	public void setClient(Clients newClient) {
		this.client = newClient;
	}

	//Devuelve a que asiento se le hizo dicha accion
    public Seats getSeat() {
		return this.seat;
	}
	
	//Settea un nuevo asiento para esta accion
	public void setSeat(Seats newSeat) {
		this.seat = newSeat;
	}

	//Devuelve que accion fue realizada, puede ser Reserve o Cancel
    public String getActionType() {
		return this.actionType;
	}

	//Settea una nueva accion para esta accion
	public void setActionType(String newActionType) {
		this.actionType = newActionType;
	}

}
