package dataProject;

import java.util.HashMap;

public class Stadium {
	
	//Hashmap donde se parean los asientos y que cliente los tiene reservados
	public static HashMap<Seats, Clients> clientSeatReserved = new HashMap<Seats, Clients>();

	//Se encarga del loop principal del programa
	public static boolean programRunning = true; 

	public static void main(String[] args) {
		
		while (programRunning) {

			//Inicializa todos los asientos
			Seats.initializeFieldSeats();
			Seats.initializeMainSeats();
			Seats.initializeGrandstandSeats();
			
			//Justo al abrir al programa, te envia a la pantalla de login - inicio de sesion
			TextBasedGUI.loginScreen();
		}
	}
}
