package dataProject;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.Set;

public class Seats {
	public String seatLevel;
	public int seatRow;
	public int seatNumber;
	boolean isSeatInUse;
	
	public static Set<Seats> seatsSet = new HashSet<Seats>();
	public static ArrayList<Seats> fieldSeats = new ArrayList<Seats>();
	public static ArrayList<Seats> mainSeats = new ArrayList<Seats>();
	public static ArrayList<Seats> grandstandSeats = new ArrayList<Seats>();
	
	Seats(String seatLevel, int seatRow, int seatNumber, boolean isSeatInUse) {
		this.seatLevel = seatLevel;
		this.seatRow = seatRow;
		this.seatNumber = seatNumber;
		this.isSeatInUse = isSeatInUse;
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
	
	public boolean isSeatInUse() {
		return this.isSeatInUse;
	}
	
	public void setIsSeatInUse(boolean newIsSeatInUse) {
		this.isSeatInUse = newIsSeatInUse;
	}
	
	@Override
	public String toString() {
		if (this.isSeatInUse()) {
			return "Sección: " + this.getSeatLevel() + ", Fila: #" + this.getSeatRow() + ", Asiento: #" + this.getSeatNumber()+ ", En Uso? Si";
		} else {
			return "Sección: " + this.getSeatLevel() + ", Fila: #" + this.getSeatRow() + ", Asiento: #" + this.getSeatNumber()+ ", En Uso? No";
		}
	}

	public static void initializeFieldSeats() {
        int totalRows = 4;
        int seatsPerRow = 5;

        for (int row = 1; row <= totalRows; row++) {
            for (int seat = 1; seat <= seatsPerRow; seat++) {
            	Seats newSeat = new Seats("Field", row, seat, false);
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
            	Seats newSeat = new Seats("Main", row, seat, false);
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
            	Seats newSeat = new Seats("Grandstand", row, seat, false);
            	seatsSet.add(newSeat);
            	grandstandSeats.add(newSeat);
            }
        }
	}
	
}
