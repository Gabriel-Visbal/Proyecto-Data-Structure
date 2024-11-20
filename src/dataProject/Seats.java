package dataProject;

import java.util.ArrayList;

import java.util.LinkedList;

import java.util.Set;
import java.util.HashSet;

import java.util.Queue;

public class Seats {
	public String seatLevel;
	public int seatRow;
	public int seatNumber;
	public int seatPrice;
	
	//Guarda todos los asientos de cada seccion
	public static Set<Seats> seatsSet = new HashSet<Seats>();
	
	//Guarda todos los asientos de la seccion field
	public static ArrayList<Seats> fieldSeats = new ArrayList<Seats>();

	//Guarda todos los asientos de la seccion main
	public static ArrayList<Seats> mainSeats = new ArrayList<Seats>();

	//Guarda todos los asientos de la seccion grandstand
	public static ArrayList<Seats> grandstandSeats = new ArrayList<Seats>();

	//Guarda los clientes que estan en fila de espera de la seccion field
	public static Queue<Clients> fieldWaitingList = new LinkedList<Clients>();

	//Guarda los clientes que estan en fila de espera de la seccion main
	public static Queue<Clients> mainWaitingList = new LinkedList<Clients>();

	//Guarda los clientes que estan en fila de espera de la seccion grandstand
	public static Queue<Clients> grandstandWaitingList = new LinkedList<Clients>();

	Seats(String seatLevel, int seatRow, int seatNumber) {
		this.seatLevel = seatLevel;
		this.seatRow = seatRow;
		this.seatNumber = seatNumber;
		
		//De acuerdo a que seccion de asiento estamos construyendo, asigna el precio especifico para esa seccion
		switch (this.seatLevel) {
			case "Field":
				this.seatPrice = 300;
				break;
			case "Main":
				this.seatPrice = 120;
				break;
			case "Grandstand":
				this.seatPrice = 45;
				break;
			default:
				break;
		}
		
	}
	
	//Devuelve la seccion a la que pertenece el asiento
	public String getSeatLevel() {
		return this.seatLevel;
	}

	//Settea una seccion de asiento a un asiento ya existente
	public void setSeatLevel(String newSeatLevel) {
		this.seatLevel = newSeatLevel;
	}

	//Devuelve el numero de fila del asiento
	public int getSeatRow() {
		return this.seatRow;
	}
	
	//Settea un numero de fila para una siento ya existente
	public void setSeatRow(int newSeatRow) {
		this.seatRow = newSeatRow;
	}
	
	//Devuelve el numero de asiento
	public int getSeatNumber() {
		return this.seatNumber;
	}
	
	//Settea un numero de asiento para una siento ya existente
	public void setSeatNumber(int newSeatNumber) {
		this.seatNumber = newSeatNumber;
	}
	
	//Devuelve el precio del asiento
	public int getSeatPrice() {
		return this.seatPrice;
	}
	
	//Settea un precio para un asiento ya existente
	public void setSeatPrice(int newSeatPrice) {
		this.seatPrice = newSeatPrice;
	}
	
	//Por si queremos print directamente el objeto del asiento, que haga print a los datos del asiento
	@Override
	public String toString() {
		//Si este asiento esta en uso, printea tambien quien lo tiene reservado, de lo contrario printea que no esta reservado
		if (Stadium.clientSeatReserved.containsKey(this)) {
			return "Seccion: " + this.getSeatLevel() + ", Fila: #" + this.getSeatRow() + ", Asiento: #" + this.getSeatNumber()+ ", Reservado";
		} else {
			return "Seccion: " + this.getSeatLevel() + ", Fila: #" + this.getSeatRow() + ", Asiento: #" + this.getSeatNumber()+ ", No Reservado.";
		}
	}
	
	//Inicializa todos los asientos field por numero de fila y numero de asiento
	public static void initializeFieldSeats() {
		//En la seccion field originalmente eran 4 rows y 5 seats por fila

        int totalRows = 2; //Numero de filas que va a tener esta seccion
        int seatsPerRow = 1; //Numero de asientos por fila

        for (int row = 1; row <= totalRows; row++) {
            for (int seat = 1; seat <= seatsPerRow; seat++) {
            	Seats newSeat = new Seats("Field", row, seat);
            	seatsSet.add(newSeat);
            	fieldSeats.add(newSeat);
            }
        }
	}
	
	//Inicializa todos los asientos main por numero de fila y numero de asiento
	public static void initializeMainSeats() {
        int totalRows = 4; //Numero de filas que va a tener esta seccion
        int seatsPerRow = 10; //Numero de asientos por fila

        for (int row = 1; row <= totalRows; row++) {
            for (int seat = 1; seat <= seatsPerRow; seat++) {
            	Seats newSeat = new Seats("Main", row, seat);
            	seatsSet.add(newSeat);
            	mainSeats.add(newSeat);
            }
        }
	}

	//Inicializa todos los asientos grandstand por numero de fila y numero de asiento
	public static void initializeGrandstandSeats() {
        int totalRows = 4; //Numero de filas que va a tener esta seccion
        int seatsPerRow = 20; //Numero de asientos por fila

        for (int row = 1; row <= totalRows; row++) {
            for (int seat = 1; seat <= seatsPerRow; seat++) {
            	Seats newSeat = new Seats("Grandstand", row, seat);
            	seatsSet.add(newSeat);
            	grandstandSeats.add(newSeat);
            }
        }
	}

	//Funcion que devuelve si todos los asientos de una sección estan reservados
	public static boolean areAllSeatsReserved(ArrayList<Seats> arrSeats) {
		for (Seats seat : arrSeats) {
			if (!Stadium.clientSeatReserved.containsKey(seat)) {
				return false;
			}
		}
		return true;
	}

}
