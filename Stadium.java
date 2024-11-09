package dataProject;

public class Stadium {
	
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
