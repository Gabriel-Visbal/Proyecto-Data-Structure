package dataProject;

import java.util.ArrayList;
import java.util.Iterator;
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
			TextBasedGUI.menuSelection = TextBasedGUI.inputScanner.nextLine().trim();
			
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
            	   System.out.println("\n" + "Seleccion no valida!");
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
		
		if (Seats.areAllSeatsReserved(arrSeats)) {

			System.out.println("\n" + "Todos los asientos en esta seccion estan reservados.");
			System.out.println("\n" + "Agregando a " + TextBasedGUI.currentClient.getClientName() + " a la lista de espera de Asientos " + seatLevel + "...");
			
			switch (seatLevel) {
				case "Field":
					Seats.fieldWaitingList.add(TextBasedGUI.currentClient);
					break;
				case "Main":
					Seats.mainWaitingList.add(TextBasedGUI.currentClient);
					break;
				case "Grandstand":
					Seats.grandstandWaitingList.add(TextBasedGUI.currentClient);
					break;
				default:
					break;
			}
			System.out.println("\n" + "Agregado exitosamente!");

			System.out.println("\n" + "Presione cualquier tecla para volver al menu principal...");
	
			TextBasedGUI.inputScanner.nextLine();
	
			TextBasedGUI.mainMenuScreen();
		}


		TextBasedGUI.isLevelInputValid = false;
		
		//Verificación de Seleccion de Asientos
	    while (!TextBasedGUI.isLevelInputValid) {
	       System.out.println("\n" + "Selecciona una opcion (1-" + arrSeats.size() + ") o 'Enter' para volver al menu principal: ");
	       TextBasedGUI.menuSelection = TextBasedGUI.inputScanner.nextLine().trim();
	       
	       if (TextBasedGUI.menuSelection.equals("")) {
	            TextBasedGUI.mainMenuScreen();
	            return;
	       } else {
	    	   
	            try {
	                int menuSelectionInt = Integer.parseInt(TextBasedGUI.menuSelection);
	                
	                if (menuSelectionInt >= 1 && menuSelectionInt <= arrSeats.size()) {
	                    Seats currentSeat = arrSeats.get(menuSelectionInt - 1);

						if (Stadium.clientSeatReserved.containsKey(currentSeat)) {
							System.out.println("\n" + "Asiento ya reservado por: " + Stadium.clientSeatReserved.get(currentSeat).getClientName() + "!");

							System.out.println("\n" + "Presione cualquier tecla para volver al menu principal...");
	
							TextBasedGUI.inputScanner.nextLine();
					
							TextBasedGUI.mainMenuScreen();
						}
	                    
						System.out.println("\n" + "========================================");
						System.out.println("      RESERVA DE ASIENTOS");
						System.out.println("========================================" + "\n");

						System.out.println("Asiento: #" + currentSeat.getSeatNumber() + ", Fila: #" + currentSeat.getSeatRow());
						System.out.println("Seccion del asiento: " + currentSeat.getSeatLevel());
						System.out.println("Precio del asiento: $" + currentSeat.getSeatPrice());

						TextBasedGUI.isReserveInputValid = false;

						while (!TextBasedGUI.isReserveInputValid) {
							System.out.println("\n" + "Desea confirmar la reserva? (Si/No): ");
				
							TextBasedGUI.menuSelection = TextBasedGUI.inputScanner.nextLine().trim();

							if (TextBasedGUI.menuSelection.toLowerCase().equals("si") || TextBasedGUI.menuSelection.toLowerCase().equals("s")) {
								System.out.println("\n" + "Reserva confirmada exitosamente!");

								TextBasedGUI.currentClient.reservedSeats.add(currentSeat);
								Stadium.clientSeatReserved.put(currentSeat, TextBasedGUI.currentClient);

								TextBasedGUI.currentClient.reservationHistory.add(TextBasedGUI.currentClient.getClientName() + " reservo el asiento #" + currentSeat.getSeatNumber() + ", de la Fila #" + currentSeat.getSeatRow() + ", de la Seccion: " + currentSeat.getSeatLevel());

								TextBasedGUI.currentAction = new ClientActions(TextBasedGUI.currentClient, currentSeat, "Reserve");

								ClientActions.actionHistory.push(TextBasedGUI.currentAction);

								TextBasedGUI.isReserveInputValid = true;
						
								System.out.println("\n" + "Presione cualquier tecla para volver al menu principal...");
	
								TextBasedGUI.inputScanner.nextLine();
						
								TextBasedGUI.mainMenuScreen();
							} else if (TextBasedGUI.menuSelection.toLowerCase().equals("no") || TextBasedGUI.menuSelection.toLowerCase().equals("o")) {
								System.out.println("\n" + "Reserva no confirmada!");

								TextBasedGUI.isReserveInputValid = true;
								System.out.println("\n" + "Presione cualquier tecla para volver al menu principal...");
	
								TextBasedGUI.inputScanner.nextLine();
						
								TextBasedGUI.mainMenuScreen();
							} else {
								System.out.println("\n" + "Seleccion no valida!");
							}

						}

	                    TextBasedGUI.isLevelInputValid = false;
	                    
	                } else {
	                	System.out.println("\n" + "Seleccion no valida!");
	                  }        
	            } catch (NumberFormatException error) {
	            	System.out.println("\n" + "Seleccion no valida!");
	              }
	        }
	    }
	    
	    TextBasedGUI.isLevelInputValid = false;
	    
	    TextBasedGUI.mainMenuScreen();
	}
	public static void viewReservations() {
		
		System.out.println("\n" + "========================================");
		System.out.println("       RESERVACIONES DEL CLIENTE");
		System.out.println("========================================" + "\n");
		
		if (TextBasedGUI.currentClient.reservedSeats.isEmpty()) {
			System.out.println("No hay reservaciones actuales.");

		} else {
			System.out.println("Reservaciones actuales: " + "\n");

	        for (Seats seat : TextBasedGUI.currentClient.reservedSeats) {
				System.out.println("- " + seat.getSeatLevel() + ", Fila: #" + seat.getSeatRow() + ", Asiento: #" + seat.getSeatNumber());
			}

			TextBasedGUI.isInputValid = false;

	    }
		
		System.out.println("\n" + "Presione cualquier tecla para volver al menu principal...");
	    
	    TextBasedGUI.inputScanner.nextLine();

		TextBasedGUI.mainMenuScreen();
	}

	public static void cancelReservations() {

		System.out.println("\n" + "========================================");
		System.out.println("       CANCELAR RESERVACIONES");
		System.out.println("========================================" + "\n");

		if (TextBasedGUI.currentClient.reservedSeats.isEmpty()) {
			System.out.println("No hay reservaciones actuales.");

		} else {
			System.out.println("Reservaciones actuales: " + "\n");

			for (int i = 0; i < TextBasedGUI.currentClient.reservedSeats.size(); i++) {
				System.out.println((i + 1) + ". " + (TextBasedGUI.currentClient.reservedSeats.get(i)));
			}
			TextBasedGUI.isLevelInputValid = false;
		
			//Verificación de Cancelacion de Asientos
			while (!TextBasedGUI.isLevelInputValid) {
			   System.out.println("\n" + "Selecciona una opcion (1-" + TextBasedGUI.currentClient.reservedSeats.size() + ") para cancelar o 'Enter' para volver al menu principal: ");
			   TextBasedGUI.menuSelection = TextBasedGUI.inputScanner.nextLine().trim();
			   
			   if (TextBasedGUI.menuSelection.equals("")) {
					TextBasedGUI.mainMenuScreen();
					return;
			   } else {
				   
					try {
						int menuSelectionInt = Integer.parseInt(TextBasedGUI.menuSelection);
						
						if (menuSelectionInt >= 1 && menuSelectionInt <= TextBasedGUI.currentClient.reservedSeats.size()) {
							Seats currentSeat = TextBasedGUI.currentClient.reservedSeats.get(menuSelectionInt - 1);

							TextBasedGUI.isReserveInputValid = false;
	
							while (!TextBasedGUI.isReserveInputValid) {
								System.out.println("\n" + "Desea cancelar la reserva? (Si/No): ");
					
								TextBasedGUI.menuSelection = TextBasedGUI.inputScanner.nextLine().trim();

								if (TextBasedGUI.menuSelection.toLowerCase().equals("si") || TextBasedGUI.menuSelection.toLowerCase().equals("s")) {
									System.out.println("\n" + "Reserva cancelada exitosamente!");
	
									TextBasedGUI.currentAction = new ClientActions(TextBasedGUI.currentClient, currentSeat, "Cancel");

									TextBasedGUI.currentClient.reservationHistory.add(TextBasedGUI.currentClient.getClientName() + " cancelo su reserva del asiento #" + currentSeat.getSeatNumber() + ", de la Fila #" + currentSeat.getSeatRow() + ", de la Seccion: " + currentSeat.getSeatLevel());

									ClientActions.actionHistory.push(TextBasedGUI.currentAction);

									TextBasedGUI.currentClient.reservedSeats.remove(currentSeat);
									Stadium.clientSeatReserved.remove(currentSeat);

									switch (currentSeat.getSeatLevel()) {
										case "Field":
											if (!Seats.fieldWaitingList.isEmpty()) {
												Clients nextClient = Seats.fieldWaitingList.poll();
												nextClient.reservedSeats.add(currentSeat);
												Stadium.clientSeatReserved.put(currentSeat, nextClient);
											}
											break;
										case "Main":
											if (!Seats.mainWaitingList.isEmpty()) {
												Clients nextClient = Seats.mainWaitingList.poll();
												nextClient.reservedSeats.add(currentSeat);
												Stadium.clientSeatReserved.put(currentSeat, nextClient);
											}
											break;
										case "Grandstand":
											if (!Seats.grandstandWaitingList.isEmpty()) {
												Clients nextClient = Seats.grandstandWaitingList.poll();
												nextClient.reservedSeats.add(currentSeat);
												Stadium.clientSeatReserved.put(currentSeat, nextClient);
											}
											break;
										default:
											break;
									}

									TextBasedGUI.isReserveInputValid = true;
									
									System.out.println("\n" + "Presione cualquier tecla para volver al menu principal...");
		
									TextBasedGUI.inputScanner.nextLine();
							
									TextBasedGUI.mainMenuScreen();
								} else if (TextBasedGUI.menuSelection.toLowerCase().equals("no") || TextBasedGUI.menuSelection.toLowerCase().equals("n")) {
									System.out.println("\n" + "Cancelacion de reserva no confirmada!");
	
									TextBasedGUI.isReserveInputValid = true;
									System.out.println("\n" + "Presione cualquier tecla para volver al menu principal...");
		
									TextBasedGUI.inputScanner.nextLine();
							
									TextBasedGUI.mainMenuScreen();
								} else {
									System.out.println("\n" + "Seleccion no valida!");
								}

							}
	
							TextBasedGUI.isLevelInputValid = false;
							
						} else {
							System.out.println("\n" + "Seleccion no valida!");
						  }        
					} catch (NumberFormatException error) {
						System.out.println("\n" + "Seleccion no valida!");
					  }
				}
			}
		}
		System.out.println("\n" + "Presione cualquier tecla para volver al menu principal...");
	    
	    TextBasedGUI.inputScanner.nextLine();

		TextBasedGUI.mainMenuScreen();
	}

	public static void viewWaitingList() {
		System.out.println("\n" + "========================================");
		System.out.println("      LISTA DE ESPERA");
		System.out.println("========================================" + "\n");
		
		Iterator<Clients> fieldIterator = Seats.fieldWaitingList.iterator();

		Iterator<Clients> mainIterator = Seats.mainWaitingList.iterator();

		Iterator<Clients> grandstandIterator = Seats.grandstandWaitingList.iterator();

		queuePositions(fieldIterator, "Field");
		queuePositions(mainIterator, "Main");
		queuePositions(grandstandIterator, "Grandstand");

		System.out.println("Presione cualquier tecla para volver al menu principal...");
	    
	    TextBasedGUI.inputScanner.nextLine();

		TextBasedGUI.mainMenuScreen();
	}

	public static void queuePositions(Iterator<Clients> iterator, String seatlevel) {

		int queuePosition = 1;
		ArrayList<Integer> queuePositionList = new ArrayList<Integer>();

		while (iterator.hasNext()) {
			Clients client = iterator.next();
			if (client.equals(TextBasedGUI.currentClient)) {
				queuePositionList.add(queuePosition);
			}

			queuePosition++;
		}
	
		if (queuePositionList.isEmpty()) {
			System.out.println(TextBasedGUI.currentClient.getClientName() + " no se encuentra en la lista de espera de " + seatlevel + "!" + "\n");
		} else {
			System.out.println(TextBasedGUI.currentClient.getClientName() + " se encuentra en las posiciones " + queuePositionList + " de la lista de espera de " + seatlevel + "\n");
		}
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

	public static void undoLastAction() {
		System.out.println("\n" + "========================================");
		System.out.println("           DESHACER ULTIMA ACCION");
		System.out.println("========================================" + "\n");

		if (ClientActions.actionHistory.isEmpty()) {
			System.out.println("No hay acciones para deshacer.");
		} else {		
			
			ClientActions lastAction = ClientActions.actionHistory.pop();
        
			switch (lastAction.getActionType()) {
				case "Reserve":
					lastAction.getClient().reservedSeats.remove(lastAction.getSeat());
					Stadium.clientSeatReserved.remove(lastAction.getSeat());
					TextBasedGUI.currentClient.reservationHistory.add(TextBasedGUI.currentClient.getClientName() + " deshizo su ultima accion: Reserva del asiento #" + lastAction.getSeat().getSeatNumber() + ", de la Fila #" + lastAction.getSeat().getSeatRow() + ", de la Seccion: " + lastAction.getSeat().getSeatLevel());
					
					System.out.println("Se ha deshecho la ultima accion!");

					switch (lastAction.getSeat().getSeatLevel()) {
						case "Field":
							if (!Seats.fieldWaitingList.isEmpty()) {
								Clients nextClient = Seats.fieldWaitingList.poll();
								nextClient.reservedSeats.add(lastAction.getSeat());
								Stadium.clientSeatReserved.put(lastAction.getSeat(), nextClient);
							}
							break;
						case "Main":
							if (!Seats.mainWaitingList.isEmpty()) {
								Clients nextClient = Seats.mainWaitingList.poll();
								nextClient.reservedSeats.add(lastAction.getSeat());
								Stadium.clientSeatReserved.put(lastAction.getSeat(), nextClient);
							}
							break;
						case "Grandstand":
							if (!Seats.grandstandWaitingList.isEmpty()) {
								Clients nextClient = Seats.grandstandWaitingList.poll();
								nextClient.reservedSeats.add(lastAction.getSeat());
								Stadium.clientSeatReserved.put(lastAction.getSeat(), nextClient);
							}
							break;
						default:
							break;
					}
					break;
					
				case "Cancel":
					if (Stadium.clientSeatReserved.containsKey(lastAction.getSeat())) {
						System.out.println("No se puede deshacer la cancelacion debido a que el asiento ya fue asignado al proximo cliente en la lista de espera!");
					} else {					
						lastAction.getClient().reservedSeats.add(lastAction.getSeat());
						Stadium.clientSeatReserved.put(lastAction.getSeat(), lastAction.getClient());
						TextBasedGUI.currentClient.reservationHistory.add(TextBasedGUI.currentClient.getClientName() + " deshizo su ultima accion: Cancelacion de la reserva del asiento #" + lastAction.getSeat().getSeatNumber() + ", de la Fila #" + lastAction.getSeat().getSeatRow() + ", de la Seccion: " + lastAction.getSeat().getSeatLevel());

						System.out.println("Se ha deshecho la ultima accion!");
					}
					break;
				default:
					break;
			}
		}

		System.out.println("\n" + "Presione cualquier tecla para volver al menu principal...");
	    
	    TextBasedGUI.inputScanner.nextLine();

		TextBasedGUI.mainMenuScreen();
	}

	public static void viewReservationHistory() {
		System.out.println("\n" + "========================================");
		System.out.println("      HISTORIAL DE RESERVAS");
		System.out.println("========================================" + "\n");

		if (TextBasedGUI.currentClient.reservationHistory.isEmpty()) {
			System.out.println("Ningun historial disponible!" + "\n");
		} else {	
			for (int i = TextBasedGUI.currentClient.reservationHistory.size() - 1; i >= 0; i--) {
				System.out.println("-" + TextBasedGUI.currentClient.reservationHistory.get(i) + "\n");
			}
		}
		System.out.println("Presione cualquier tecla para volver al menu principal...");
	    
	    TextBasedGUI.inputScanner.nextLine();

		TextBasedGUI.mainMenuScreen();
	}
	
	public static void exitProgram() {
		System.out.println("\n" + "========================================");
		System.out.println("      GRACIAS POR USAR EL PROGRAMA!");
		System.out.println("========================================" + "\n");

		Stadium.programRunning = false;

		TextBasedGUI.isInputValid = true;
		TextBasedGUI.isLevelInputValid = true;
		TextBasedGUI.isReserveInputValid = true;

		TextBasedGUI.inputScanner.close();

		System.exit(0);
	}
}
