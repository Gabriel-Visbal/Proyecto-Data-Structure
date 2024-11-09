package dataProject;

import java.util.ArrayList;
public class MenuSelections {
	
	public static void stadiumAvailability() {
		
		System.out.println("\n" + "========================================");
		System.out.println("       DISPONIBILIDAD DEL ESTADIO");
		System.out.println("========================================" + "\n");

		System.out.println("1. Field (Costo: $300)");
		System.out.println("2. Main (Costo: $120)");
		System.out.println("3. Grandstand (Costo: $45)" + "\n");
		
		TextBasedGUI.isInputValid = false;
		
		//Verificación de Selección de Nivel de Asiento
	    while (!TextBasedGUI.isInputValid) {
			System.out.println("Selecciona una opcion (1-3) o 'Enter' para volver al menu principal: ");
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
            	   System.out.println("Seleccion no valida!");
            	   TextBasedGUI.isInputValid = false;
                   break;
           }
	    }
	}
	
	public static void seatAvailability(ArrayList<Seats> arrSeats, String seatLevel) {
		System.out.println("\n" + "========================================");
		
		switch (seatLevel) {
			case "Field":
				System.out.println("         ASIENTOS FIELD ($300)");
				break;
			case "Main":
				System.out.println("         ASIENTOS MAIN ($120)");
				break;
			case "Grandstand":
				System.out.println("        ASIENTOS GRANDSTAND ($45)");
				break;
			default:
				break;
		}
		
		System.out.println("========================================" + "\n");
		
		for (int i = 0; i < arrSeats.size(); i++) {
			System.out.println((i + 1) + ". " + (arrSeats.get(i)));
		}
		
		TextBasedGUI.isLevelInputValid = false;
		
		//Verificación de Selección de Asientos Field
	    while (!TextBasedGUI.isLevelInputValid) {
	       System.out.println("Selecciona una opcion (1-" + arrSeats.size() + ") o 'Enter' para volver al menu principal: ");
	       TextBasedGUI.menuSelection = TextBasedGUI.inputScanner.nextLine();
	       
	       if (TextBasedGUI.menuSelection.equals("")) {
	            TextBasedGUI.mainMenuScreen();
	            return;
	       } else {
	    	   
	            try {
	                int menuSelectionInt = Integer.parseInt(TextBasedGUI.menuSelection);
	                
	                if (menuSelectionInt >= 1 && menuSelectionInt <= arrSeats.size()) {
	                    Seats currentSeat = arrSeats.get(menuSelectionInt - 1);
	                    
	                    currentSeat.setIsSeatInUse(true);
	                    
	                    TextBasedGUI.currentClient.reservedSeats.add(currentSeat);

						Stadium.clientSeatReserved.put(currentSeat, TextBasedGUI.currentClient);

	                    TextBasedGUI.currentClient.setClientPay(TextBasedGUI.currentClient.getClientPay() + currentSeat.getSeatPrice());

						System.out.println("\n" + "========================================");
						System.out.println("      ASIENTO RESERVADO CON EXITO!");
						System.out.println("========================================" + "\n");

						System.out.println("Asiento reservado: #" + currentSeat.getSeatNumber());
						System.out.println("Seccion del asiento: " + currentSeat.getSeatLevel());
						System.out.println("Precio del asiento: $" + currentSeat.getSeatPrice());
						System.out.println("Pago total actual: $" + TextBasedGUI.currentClient.getClientPay());

						System.out.println("\n" + "Presione cualquier tecla para volver al menu principal...");
		
						TextBasedGUI.inputScanner.nextLine();

	                    TextBasedGUI.isLevelInputValid = true;
	                    
	                } else {
	                	System.out.println("Seleccion no valida!");
	                  }        
	            } catch (NumberFormatException error) {
	            	System.out.println("Seleccion no valida!");
	              }
	        }
	    }
	    
	    TextBasedGUI.isLevelInputValid = false;
	    
	    TextBasedGUI.mainMenuScreen();
	}
	public static void viewReservationsAndPay() {
		
		System.out.println("\n" + "========================================");
		System.out.println("       RESERVACIONES DEL CLIENTE");
		System.out.println("========================================" + "\n");
		
		if (TextBasedGUI.currentClient.reservedSeats.isEmpty()) {
			System.out.println("No hay reservaciones actuales.");
		} else {
			System.out.println("Reservaciones actuales: " + "\n");

	        for (Seats seat : TextBasedGUI.currentClient.reservedSeats) {
	            System.out.println("- " + seat.getSeatLevel() + ", Fila: #" + seat.getSeatRow() + ", Asiento: #" + seat.getSeatNumber() + ", Precio: $" + seat.getSeatPrice());
	        }

	        System.out.println("\n" + "Total a pagar: $" + TextBasedGUI.currentClient.getClientPay());

			TextBasedGUI.isInputValid = false;

			while (!TextBasedGUI.isInputValid) {
				System.out.println("\n" + "Desea realizar el pago? (Si/No): ");
				TextBasedGUI.menuSelection = TextBasedGUI.inputScanner.nextLine();
				
				switch (TextBasedGUI.menuSelection.toLowerCase()) {
					case ("si"):
						System.out.println("\n" + "Procesando pago...");
						System.out.println("Pago realizado con exito. Gracias por su compra!");

						//TODO Procesar pago

						TextBasedGUI.isInputValid = true;
						break;
					case "s":
						System.out.println("\n" + "Procesando pago...");
						System.out.println("Pago realizado con exito. Gracias por su compra!");

						//TODO Procesar pago

						TextBasedGUI.isInputValid = true;
						break;
					case "no":
						System.out.println("\n" + "No se ha realizado el pago.");
						TextBasedGUI.isInputValid = true;
						break;
					case "n":
						System.out.println("\n" + "No se ha realizado el pago.");
						TextBasedGUI.isInputValid = true;
						break;
					default:
						break;
				}

				if (!TextBasedGUI.isInputValid) {
					System.out.println("Seleccion no valida!");
				}
			}

	    }
		
		TextBasedGUI.mainMenuScreen();
	}
	public static void clientData() {
		System.out.println("\n" + "========================================");
		System.out.println("           DATOS DEL CLIENTE");
		System.out.println("========================================" + "\n");
		
		TextBasedGUI.currentClient.printClientData();
		
	    System.out.println("\n" + "Presione cualquier tecla para volver al menu principal...");
	    
	    TextBasedGUI.inputScanner.nextLine();
	    
		TextBasedGUI.mainMenuScreen();
	}
	
	public static void exitProgram() {
		System.out.println("\n" + "========================================");
		System.out.println("      GRACIAS POR USAR EL PROGRAMA!");
		System.out.println("========================================" + "\n");
		
		Stadium.programRunning = false;
	}
}
