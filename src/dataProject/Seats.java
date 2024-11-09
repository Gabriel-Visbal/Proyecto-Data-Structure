package dataProject;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.Set;

public class Seats {
	public String seatLevel;
	public int seatRow;
	public int seatNumber;
	public int seatPrice;
	
	public static Set<Seats> seatsSet = new HashSet<Seats>();
	
	public static ArrayList<Seats> fieldSeats = new ArrayList<Seats>();
	public static ArrayList<Seats> mainSeats = new ArrayList<Seats>();
	public static ArrayList<Seats> grandstandSeats = new ArrayList<Seats>();
	
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
        int totalRows = 4;
        int seatsPerRow = 5;

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
	
}
