package dataProject;

import java.util.ArrayList;

public class MenuSelections {
	
	public static void stadiumAvailability() {
		
		System.out.println("\n" + "━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("      DISPONIBILIDAD DEL ESTADIO");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━" + "\n");

		System.out.println("1. Field (Costo: $300)");
		System.out.println("2. Main (Costo: $120)");
		System.out.println("3. Grandstand (Costo: $45)" + "\n");
		
		TextBasedGUI.isInputValid = false;
		
		//Verificación de Selección de Nivel de Asiento
	    while (!TextBasedGUI.isInputValid) {
			System.out.println("Selecciona una opción (1-3) o 'Enter' para volver al menú principal: ");
			TextBasedGUI.menuSelection = TextBasedGUI.inputScanner.nextLine();
			
			TextBasedGUI.isInputValid = true;
	           switch (TextBasedGUI.menuSelection) {
               case "1":
            	   seatAvailability(Seats.fieldSeats, "Field");
                   break;
               case "2":
            	   seatAvailability(Seats.mainSeats, "Main");
                   break;
               case "3":
            	   seatAvailability(Seats.grandstandSeats, "Grandstand");
                   break;
               case "":
            	   TextBasedGUI.mainMenuScreen();
                   break;
               default:
            	   System.out.println("Selección no válida!");
            	   TextBasedGUI.isInputValid = false;
                   break;
           }
	    }
	}
	
	public static void seatAvailability(ArrayList<Seats> arrSeats, String seatLevel) {
		System.out.println("\n" + "━━━━━━━━━━━━━━━━━━━━━━━━━");
		
		if (seatLevel.equals("Field")) {
			System.out.println("      ASIENTOS FIELD ($300)");
		} else if (seatLevel.equals("Main")) {
			System.out.println("      ASIENTOS MAIN ($120)");
		} else if (seatLevel.equals("Grandstand")) {
			System.out.println("      ASIENTOS GRANDSTAND ($45)");
		}
		
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━" + "\n");
		
		for (int i = 0; i < arrSeats.size(); i++) {
			System.out.println((i + 1) + ". " + (arrSeats.get(i)));
		}
		
		TextBasedGUI.isLevelInputValid = false;
		
		//Verificación de Selección de Asientos Field
	    while (!TextBasedGUI.isLevelInputValid) {
	       System.out.println("Selecciona una opción (1-" + arrSeats.size() + ") o 'Enter' para volver al menú principal: ");
	       //TODO agregar lo de que si presiona Enter le de para atras (Enter = ""),
	       //a lo mejor convirtiendo el input primero de un string a un int con un try catch
	       if (TextBasedGUI.inputScanner.hasNextInt()) {
	            TextBasedGUI.menuSelectionInt = TextBasedGUI.inputScanner.nextInt();

	            if (TextBasedGUI.menuSelectionInt >= 1 && TextBasedGUI.menuSelectionInt <= arrSeats.size()) {
	            	Seats currentSeat = arrSeats.get(TextBasedGUI.menuSelectionInt - 1);
	            	currentSeat.setIsSeatInUse(true);
	                TextBasedGUI.currentClient.reservedSeats.add(currentSeat);
	                
	                TextBasedGUI.currentClient.setClientPay(TextBasedGUI.currentClient.getClientPay() + currentSeat.getSeatPrice());
	                
	                TextBasedGUI.isLevelInputValid = true;
	            }
	            
	        }
	        
	        if (!TextBasedGUI.isLevelInputValid) {
	        	System.out.println("Selección no válida!");
	        }
	        
            TextBasedGUI.inputScanner.nextLine();
	    }
	    TextBasedGUI.isLevelInputValid = false;
	    
	    TextBasedGUI.mainMenuScreen();
	}
	public static void viewReservations() {
		
		System.out.println("\n" + "━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("      RESERVACIONES DEL CLIENTE");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━" + "\n");
		
		if (TextBasedGUI.currentClient.reservedSeats.isEmpty()) {
			System.out.println("No hay reservaciones actuales.");
		} else {
			System.out.println("Reservaciones actuales: " + "\n");

	        for (Seats seat : TextBasedGUI.currentClient.reservedSeats) {
	            System.out.println("• " + seat.getSeatLevel() + ", Fila: #" + seat.getSeatRow() + ", Asiento: #" + seat.getSeatNumber() + ", Precio: $" + seat.getSeatPrice());
	        }

	        System.out.println("\n" + "Total a pagar: $" + TextBasedGUI.currentClient.getClientPay());
	    }
		
		System.out.println("\n" + "Presione cualquier tecla para volver al menú principal...");
		
		TextBasedGUI.inputScanner.nextLine();
		
		TextBasedGUI.mainMenuScreen();
	}
	public static void clientData() {
		System.out.println("\n" + "━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("      DATOS DEL CLIENTE");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━" + "\n");
		
		TextBasedGUI.currentClient.printClientData();
		
	    System.out.println("\n" + "Presione cualquier tecla para volver al menú principal...");
	    
	    TextBasedGUI.inputScanner.nextLine();
	    
		TextBasedGUI.mainMenuScreen();
	}
	
	public static void exitProgram() {
		System.out.println("\n" + "━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("      GRACIAS POR USAR EL PROGRAMA!");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━" + "\n");
		
		Stadium.programRunning = false;
	}
}
