package dataProject;

import java.util.HashMap;
public class Stadium {
	
	public static HashMap<Seats, Clients> clientSeatReserved = new HashMap<Seats, Clients>();

	public static boolean programRunning = true;
	
	public static void main(String[] args) {
		
		while (programRunning) {
			Seats.initializeFieldSeats();
			Seats.initializeMainSeats();
			Seats.initializeGrandstandSeats();
			
			TextBasedGUI.loginScreen();
			
		}

	}
}
