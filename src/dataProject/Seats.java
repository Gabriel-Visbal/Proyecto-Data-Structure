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
	
	public static Set<Seats> seatsSet = new HashSet<Seats>();
	
	public static ArrayList<Seats> fieldSeats = new ArrayList<Seats>();
	public static ArrayList<Seats> mainSeats = new ArrayList<Seats>();
	public static ArrayList<Seats> grandstandSeats = new ArrayList<Seats>();

	public static Queue<Clients> fieldWaitingList = new LinkedList<Clients>();
	public static Queue<Clients> mainWaitingList = new LinkedList<Clients>();
	public static Queue<Clients> grandstandWaitingList = new LinkedList<Clients>();

	Seats(String seatLevel, int seatRow, int seatNumber) {
		this.seatLevel = seatLevel;
		this.seatRow = seatRow;
		this.seatNumber = seatNumber;
		
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
	
	public String getSeatLevel() {
		return this.seatLevel;
	}
	
	public void setSeatLevel(String newSeatLevel) {
		this.seatLevel = newSeatLevel;
	}
	
	public int getSeatRow() {
		return this.seatRow;
	}
	
	public void setSeatRow(int newSeatRow) {
		this.seatRow = newSeatRow;
	}
	
	public int getSeatNumber() {
		return this.seatNumber;
	}
	
	public void setSeatNumber(int newSeatNumber) {
		this.seatNumber = newSeatNumber;
	}
	
	public int getSeatPrice() {
		return this.seatPrice;
	}
	
	public void setSeatPrice(int newSeatPrice) {
		this.seatPrice = newSeatPrice;
	}
	
	@Override
	public String toString() {
		if (Stadium.clientSeatReserved.containsKey(this)) {
			return "Seccion: " + this.getSeatLevel() + ", Fila: #" + this.getSeatRow() + ", Asiento: #" + this.getSeatNumber()+ ", Reservado por: " + Stadium.clientSeatReserved.get(this) + ".";
		} else {
			return "Seccion: " + this.getSeatLevel() + ", Fila: #" + this.getSeatRow() + ", Asiento: #" + this.getSeatNumber()+ ", No Reservado.";
		}
	}
	
	public static void initializeFieldSeats() {
        int totalRows = 2; //Esto es para testear
        int seatsPerRow = 1; // Originalmente era 4 rows y 5 seats por fila

        for (int row = 1; row <= totalRows; row++) {
            for (int seat = 1; seat <= seatsPerRow; seat++) {
            	Seats newSeat = new Seats("Field", row, seat);
            	seatsSet.add(newSeat);
            	fieldSeats.add(newSeat);
            }
        }
	}
	
	public static void initializeMainSeats() {
        int totalRows = 4;
        int seatsPerRow = 10;

        for (int row = 1; row <= totalRows; row++) {
            for (int seat = 1; seat <= seatsPerRow; seat++) {
            	Seats newSeat = new Seats("Main", row, seat);
            	seatsSet.add(newSeat);
            	mainSeats.add(newSeat);
            }
        }
	}
	
	public static void initializeGrandstandSeats() {
        int totalRows = 4;
        int seatsPerRow = 20;

        for (int row = 1; row <= totalRows; row++) {
            for (int seat = 1; seat <= seatsPerRow; seat++) {
            	Seats newSeat = new Seats("Grandstand", row, seat);
            	seatsSet.add(newSeat);
            	grandstandSeats.add(newSeat);
            }
        }
	}

	public static boolean areAllSeatsReserved(ArrayList<Seats> arrSeats) {
		for (Seats seat : arrSeats) {
			if (!Stadium.clientSeatReserved.containsKey(seat)) {
				return false;
			}
		}
		return true;
	}

}
