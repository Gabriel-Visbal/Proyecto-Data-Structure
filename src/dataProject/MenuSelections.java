package dataProject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
public class MenuSelections {
	
	public static void stadiumAvailability() {
		
		System.out.println("\n" + "========================================");
		System.out.println("       DISPONIBILIDAD DEL ESTADIO");
		System.out.println("========================================" + "\n");

		System.out.println("1. Field (Costo: $300)");
		System.out.println("2. Main (Costo: $120)");
		System.out.println("3. Grandstand (Costo: $45)" + "\n");
		
		TextBasedGUI.isInputValid = false;
		
		//Verifica que el cliente seleccione una opcion que sea valida del 1 al 3, field, main o grandstand, sigue preguntando hasta que eso se cumpla
	    while (!TextBasedGUI.isInputValid) {
			System.out.println("Selecciona una opcion (1-3) o 'Enter' para volver al menu principal: ");
			TextBasedGUI.menuSelection = TextBasedGUI.inputScanner.nextLine().trim();
			
			TextBasedGUI.isInputValid = true;
	           switch (TextBasedGUI.menuSelection) {
               case "1":
            	   seatAvailability(Seats.fieldSeats, "Field"); //Llama a la funcion de ver los asientos por seccion con el array de asientos field y el string "Field"
                   break;
               case "2":
            	   seatAvailability(Seats.mainSeats, "Main"); //Llama a la funcion de ver los asientos por seccion con el array de asientos main y el string "Main"
                   break;
               case "3":
            	   seatAvailability(Seats.grandstandSeats, "Grandstand"); //Llama a la funcion de ver los asientos por seccion con el array de asientos grandstand y el string "Grandstand"
                   break;
               case "":
            	   TextBasedGUI.mainMenuScreen(); //Si el cliente le da al enter, vuelve al menu principal
                   break;
               default:
            	   System.out.println("\n" + "Seleccion no valida!"); //El input de cliente no es valido
            	   TextBasedGUI.isInputValid = false;
                   break;
           }
	    }
	}
	
	public static void seatAvailability(ArrayList<Seats> arrSeats, String seatLevel) {
		System.out.println("\n" + "========================================");
		
		//Prints de la seccion que esta buscando el cliente
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
		
		//Printea todos los asientos de esta seccion
		for (int i = 0; i < arrSeats.size(); i++) {
			System.out.println((i + 1) + ". " + (arrSeats.get(i)));
		}
		
		//Si todos los asientos de estan seccion estan reservados, preguntale al cliente si quiere entrar a la lista de espera
		if (Seats.areAllSeatsReserved(arrSeats)) {

			System.out.println("\n" + "Todos los asientos en esta seccion se encuentran reservados.");

			TextBasedGUI.isReserveInputValid = false;
			
			//Sigue preguntando si quiere entrar a lista de espera hasta que el cliente escriba (si/no)
			while (!TextBasedGUI.isReserveInputValid) {
				System.out.println("\n" + "Desea entrar a la lista de espera de Asientos " + seatLevel + "? (Si/No): ");
	
				TextBasedGUI.menuSelection = TextBasedGUI.inputScanner.nextLine().trim();

				//Si el cliente escribe que si, añadalo a la lista de espera de la seccion especifica
				if (TextBasedGUI.menuSelection.toLowerCase().equals("si") || TextBasedGUI.menuSelection.toLowerCase().equals("s")) {
					System.out.println("\n" + "Agregando a " + TextBasedGUI.currentClient.getClientName() + " a la lista de espera de Asientos " + seatLevel + "...");
			
					switch (seatLevel) {
						case "Field":
							Seats.fieldWaitingList.add(TextBasedGUI.currentClient); //Añade a la lista de espera de asientos field
							break;
						case "Main":
							Seats.mainWaitingList.add(TextBasedGUI.currentClient); //Añade a la lista de espera de asientos main
							break;
						case "Grandstand":
							Seats.grandstandWaitingList.add(TextBasedGUI.currentClient); //Añade a la lista de espera de asientos grandstand
							break;
						default:
							break;
					}

					TextBasedGUI.isReserveInputValid = true;

					System.out.println("\n" + "Agregado exitosamente!");

				  //Si el cliente escribe que no, termina el loop
				} else if (TextBasedGUI.menuSelection.toLowerCase().equals("no") || TextBasedGUI.menuSelection.toLowerCase().equals("n")) {
					System.out.println("\n" + "Ha decidido no unirse a la lista de espera para los Asientos " + seatLevel + ".");

					TextBasedGUI.isReserveInputValid = true;
				} else {
					System.out.println("\n" + "Seleccion no valida!");
				}
			}

			System.out.println("\n" + "Presione cualquier tecla para volver al menu principal...");
	
			TextBasedGUI.inputScanner.nextLine(); //Si el cliente le da al enter, envialo al menu principal
	
			TextBasedGUI.mainMenuScreen();
		}

		TextBasedGUI.isLevelInputValid = false;
		
		//Si no todos los asientos estan reservados, printea todos los asientos para que el clienta seleccione el que desee, sigue preguntando hasta que la seleccion sea valida
	    while (!TextBasedGUI.isLevelInputValid) {
	       System.out.println("\n" + "Selecciona una opcion (1-" + arrSeats.size() + ") o 'Enter' para volver al menu principal: ");
	       TextBasedGUI.menuSelection = TextBasedGUI.inputScanner.nextLine().trim();
	       
	       if (TextBasedGUI.menuSelection.equals("")) { //Si el cliente le da al enter, envialo al menu principal
	            TextBasedGUI.mainMenuScreen();
	            return;
	       } else {
	    	   
	            try {
	                int menuSelectionInt = Integer.parseInt(TextBasedGUI.menuSelection); //Convierte el input del cliente a un numero para poder buscar con el indice
	                
	                if (menuSelectionInt >= 1 && menuSelectionInt <= arrSeats.size()) { //Verifica que ese numero este dentro del rango de indices del array de los asientos
	                    Seats currentSeat = arrSeats.get(menuSelectionInt - 1); //Selecciona el asiento que el cliente selecciono

						if (Stadium.clientSeatReserved.containsKey(currentSeat)) { //Si el cliente selecciona un asiento que ya esta reservado, printea que no puede reservar ese asiento
							System.out.println("\n" + "Asiento ya reservado por: " + Stadium.clientSeatReserved.get(currentSeat).getClientName() + "!");

							System.out.println("\n" + "Presione cualquier tecla para volver al menu principal...");
	
							TextBasedGUI.inputScanner.nextLine();
					
							TextBasedGUI.mainMenuScreen();
						}
	                    
						System.out.println("\n" + "========================================");
						System.out.println("      RESERVA DE ASIENTOS");
						System.out.println("========================================" + "\n");

						//Cuando el cliente seleccione un asiento que pueda reservar, muestrale los datos de ese asiento como el numero, la seccion y el precio
						System.out.println("Asiento: #" + currentSeat.getSeatNumber() + ", Fila: #" + currentSeat.getSeatRow());
						System.out.println("Seccion del asiento: " + currentSeat.getSeatLevel());
						System.out.println("Precio del asiento: $" + currentSeat.getSeatPrice());

						TextBasedGUI.isReserveInputValid = false;

						//Le pregunta al cliente si quiere confirmar la reserva, que escriba (si/no), sigue preguntando hasta que la seleccion sea valida
						while (!TextBasedGUI.isReserveInputValid) {
							System.out.println("\n" + "Desea confirmar la reserva? (Si/No): ");
				
							TextBasedGUI.menuSelection = TextBasedGUI.inputScanner.nextLine().trim();

							//Si el cliente escribe que si, añade la reserva a su nombre
							if (TextBasedGUI.menuSelection.toLowerCase().equals("si") || TextBasedGUI.menuSelection.toLowerCase().equals("s")) {
								System.out.println("\n" + "Reserva confirmada exitosamente!");

								TextBasedGUI.currentClient.reservedSeats.add(currentSeat); //Le añade el asiento a la lista de asientos reservados por el cliente
								Stadium.clientSeatReserved.put(currentSeat, TextBasedGUI.currentClient); //Parea el asiento con el cliente en el hashmap de Asientos - Clientes

								//Añade un string diciendo que el cliente reservo el asiento para el historial de actividades
								TextBasedGUI.currentClient.reservationHistory.add(TextBasedGUI.currentClient.getClientName() + " reservo el asiento #" + currentSeat.getSeatNumber() + ", de la Fila #" + currentSeat.getSeatRow() + ", de la Seccion: " + currentSeat.getSeatLevel());

								//Hace una nueva acción en el programa diciendo que este cliente reservo este asiento
								TextBasedGUI.currentAction = new ClientActions(TextBasedGUI.currentClient, currentSeat, "Reserve");

								//Añade esta nueva accion creada al stack de acciones hechas
								ClientActions.actionHistory.push(TextBasedGUI.currentAction);

								TextBasedGUI.isReserveInputValid = true;
						
								System.out.println("\n" + "Presione cualquier tecla para volver al menu principal...");
	
								TextBasedGUI.inputScanner.nextLine();
						
								TextBasedGUI.mainMenuScreen();

							  //Si el cliente escribe que no, envialo al menu principal
							} else if (TextBasedGUI.menuSelection.toLowerCase().equals("no") || TextBasedGUI.menuSelection.toLowerCase().equals("n")) {
								System.out.println("\n" + "Reserva no confirmada!");

								TextBasedGUI.isReserveInputValid = true;
								System.out.println("\n" + "Presione cualquier tecla para volver al menu principal...");
	
								TextBasedGUI.inputScanner.nextLine();
						
								TextBasedGUI.mainMenuScreen();
							} else {
								System.out.println("\n" + "Seleccion no valida!"); //El input de cliente no es valido
							}

						}

	                    TextBasedGUI.isLevelInputValid = false;
	                    
	                } else {
	                	System.out.println("\n" + "Seleccion no valida!"); //El input de cliente no es valido
	                  }        
	            } catch (NumberFormatException error) {
	            	System.out.println("\n" + "Seleccion no valida!"); //El input de cliente no es valido
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
		
		//Si el cliente no tiene reservaciones, printea un mensaje diciendo que no tiene reservaciones
		if (TextBasedGUI.currentClient.reservedSeats.isEmpty()) {
			System.out.println("No hay reservaciones actuales.");

		} else {
			//Si tiene reservaciones, le printea todoas las reservaciones que tiene actualmente por secciones, numero y fila
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

		//Si el cliente no tiene reservas, printea que no tiene reservas actualmente
		if (TextBasedGUI.currentClient.reservedSeats.isEmpty()) {
			System.out.println("No hay reservaciones actuales.");

		} else {
			System.out.println("Reservaciones actuales: " + "\n");
			//Printea todos los asientos reservados que tiene el cliente
			for (int i = 0; i < TextBasedGUI.currentClient.reservedSeats.size(); i++) {
				System.out.println((i + 1) + ". " + (TextBasedGUI.currentClient.reservedSeats.get(i)));
			}
			TextBasedGUI.isLevelInputValid = false;
		
			//Le printea al cliente todos los asientos que tiene reservados para seleccione el que desea cancelar, sigue preguntando hasta que la seleccion sea valida
			while (!TextBasedGUI.isLevelInputValid) {
			   System.out.println("\n" + "Selecciona una opcion (1-" + TextBasedGUI.currentClient.reservedSeats.size() + ") para cancelar o 'Enter' para volver al menu principal: ");
			   TextBasedGUI.menuSelection = TextBasedGUI.inputScanner.nextLine().trim();
			   
			   if (TextBasedGUI.menuSelection.equals("")) { //Si el cliente pone un enter, vuelve al menu principal
					TextBasedGUI.mainMenuScreen();
					return;
			   } else {
				   
					try {
						int menuSelectionInt = Integer.parseInt(TextBasedGUI.menuSelection); //Convierte el input del cliente a un numero para poder buscar con el indice en el array de reservas del cliente
						
						if (menuSelectionInt >= 1 && menuSelectionInt <= TextBasedGUI.currentClient.reservedSeats.size()) { //Verifica que ese numero este dentro del rango de indices del array de los asientos del cliente
							Seats currentSeat = TextBasedGUI.currentClient.reservedSeats.get(menuSelectionInt - 1); //Selecciona el asiento que el cliente selecciono

							TextBasedGUI.isReserveInputValid = false;
							
							//Le pregunta al cliente si quiere cancelar la reserva, que escriba (si/no), sigue preguntando hasta que la seleccion sea valida
							while (!TextBasedGUI.isReserveInputValid) {
								System.out.println("\n" + "Desea cancelar la reserva? (Si/No): ");
					
								TextBasedGUI.menuSelection = TextBasedGUI.inputScanner.nextLine().trim();

							    //Si el cliente escribe que si, quita la reserva que esta a su nombre
								if (TextBasedGUI.menuSelection.toLowerCase().equals("si") || TextBasedGUI.menuSelection.toLowerCase().equals("s")) {
									System.out.println("\n" + "Reserva cancelada exitosamente!");
	
									//Hace una nueva acción en el programa diciendo que este cliente cancelo su reserva de este asiento
									TextBasedGUI.currentAction = new ClientActions(TextBasedGUI.currentClient, currentSeat, "Cancel");
								
									//Añade un string diciendo que el cliente cancelo el asiento para el historial de actividades
									TextBasedGUI.currentClient.reservationHistory.add(TextBasedGUI.currentClient.getClientName() + " cancelo su reserva del asiento #" + currentSeat.getSeatNumber() + ", de la Fila #" + currentSeat.getSeatRow() + ", de la Seccion: " + currentSeat.getSeatLevel());
									
									//Añade esta nueva accion creada al stack de acciones hechas
									ClientActions.actionHistory.push(TextBasedGUI.currentAction);

									TextBasedGUI.currentClient.reservedSeats.remove(currentSeat); //Quita el asiento de la lista de asientos reservados por el cliente
									Stadium.clientSeatReserved.remove(currentSeat); //Quita el asiento y el cliente en el hashmap de Asientos - Clientes

									//Si hay clientes en la lista de espera, le asigna el asiento que se acaba de cancelar a ese cliente
									switch (currentSeat.getSeatLevel()) {
										case "Field":
											if (!Seats.fieldWaitingList.isEmpty()) { //Si el asiento es de tipo field y hay clientes en la lista de espera, asigna el asiento
												Clients nextClient = Seats.fieldWaitingList.poll(); //Cliente al cual se le va a asignar el asiento
												nextClient.reservedSeats.add(currentSeat); //Se le añade el asiento a ese cliente
												Stadium.clientSeatReserved.put(currentSeat, nextClient); //Parea el asiento con el nuevo cliente en el hashmap de Asientos - Clientes
											}
											break;
										case "Main":
											if (!Seats.mainWaitingList.isEmpty()) { //Si el asiento es de tipo main y hay clientes en la lista de espera, asigna el asiento
												Clients nextClient = Seats.mainWaitingList.poll(); //Cliente al cual se le va a asignar el asiento
												nextClient.reservedSeats.add(currentSeat); //Se le añade el asiento a ese cliente
												Stadium.clientSeatReserved.put(currentSeat, nextClient); //Parea el asiento con el nuevo cliente en el hashmap de Asientos - Clientes
											}
											break;
										case "Grandstand":
											if (!Seats.grandstandWaitingList.isEmpty()) { //Si el asiento es de tipo grandstand y hay clientes en la lista de espera, asigna el asiento
												Clients nextClient = Seats.grandstandWaitingList.poll(); //Cliente al cual se le va a asignar el asiento
												nextClient.reservedSeats.add(currentSeat); //Se le añade el asiento a ese cliente
												Stadium.clientSeatReserved.put(currentSeat, nextClient); //Parea el asiento con el nuevo cliente en el hashmap de Asientos - Clientes
											}
											break;
										default:
											break;
									}

									TextBasedGUI.isReserveInputValid = true;
									
									System.out.println("\n" + "Presione cualquier tecla para volver al menu principal...");
		
									TextBasedGUI.inputScanner.nextLine();
							
									TextBasedGUI.mainMenuScreen();

								  //Si el cliente escribe que no, envialo al menu principal
								} else if (TextBasedGUI.menuSelection.toLowerCase().equals("no") || TextBasedGUI.menuSelection.toLowerCase().equals("n")) {
									System.out.println("\n" + "Cancelacion de reserva no confirmada!");
	
									TextBasedGUI.isReserveInputValid = true;
									System.out.println("\n" + "Presione cualquier tecla para volver al menu principal...");
		
									TextBasedGUI.inputScanner.nextLine();
							
									TextBasedGUI.mainMenuScreen();
								} else {
									System.out.println("\n" + "Seleccion no valida!"); //El input de cliente no es valido
								}

							}
	
							TextBasedGUI.isLevelInputValid = false;
							
						} else {
							System.out.println("\n" + "Seleccion no valida!"); //El input de cliente no es valido
						  }        
					} catch (NumberFormatException error) {
						System.out.println("\n" + "Seleccion no valida!"); //El input de cliente no es valido
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
		
		queuePositions(Seats.fieldWaitingList, "Field"); //Llama la funcion para ver si el cliente se encuentra en una lista de espera con el queue de asientos field
		queuePositions(Seats.mainWaitingList, "Main"); //Llama la funcion para ver si el cliente se encuentra en una lista de espera con el queue de asientos main
		queuePositions(Seats.grandstandWaitingList, "Grandstand"); //Llama la funcion para ver si el cliente se encuentra en una lista de espera con el queue de asientos grandstand

		System.out.println("Presione cualquier tecla para volver al menu principal...");
	    
	    TextBasedGUI.inputScanner.nextLine();

		TextBasedGUI.mainMenuScreen();
	}

	public static void queuePositions(Queue<Clients> waitingList, String seatlevel) {

		//Iterador para recorrer el queue de lista de espera sin tener que modificar el propio queue
		Iterator<Clients> waitingListIterator = waitingList.iterator();

		//Empezamos en la posicion 1
		int queuePosition = 1;
		ArrayList<Integer> queuePositionList = new ArrayList<Integer>(); //Por si el cliente aparece en mas de una posicion, guarda las posiciones en un array

		//Itera el queue de lista de espera
		while (waitingListIterator.hasNext()) {
			Clients client = waitingListIterator.next();
			if (client.equals(TextBasedGUI.currentClient)) { //Si se encuentra que el cliente actual esta en el queue, añade la posicion en la que se encuentra
				queuePositionList.add(queuePosition);
			}

			queuePosition++;
		}
	
		//Si no encontro el cliente, printea que no se encuentra en esa lista de espera
		if (queuePositionList.isEmpty()) {
			System.out.println(TextBasedGUI.currentClient.getClientName() + " no se encuentra en la lista de espera de " + seatlevel + "!" + "\n");
		} else { //Si se encontro el cliente, printea todas las posiciones en las que se encontro en esa lista de espera
			System.out.println(TextBasedGUI.currentClient.getClientName() + " se encuentra en las posiciones " + queuePositionList + " de la lista de espera de " + seatlevel + "!" + "\n");
		}
	}

	public static void clientData() {
		System.out.println("\n" + "========================================");
		System.out.println("           DATOS DEL CLIENTE");
		System.out.println("========================================" + "\n");
		
		//Llama el metodo de printear todos los datos del cliente que cada objeto cliente tiene
		TextBasedGUI.currentClient.printClientData();
		
	    System.out.println("\n" + "Presione cualquier tecla para volver al menu principal...");
	    
	    TextBasedGUI.inputScanner.nextLine();
	    
		TextBasedGUI.mainMenuScreen();
	}

	public static void undoLastAction() {
		System.out.println("\n" + "========================================");
		System.out.println("           DESHACER ULTIMA ACCION");
		System.out.println("========================================" + "\n");

		//Si no hay acciones para deshacer, printea que no hay acciones
		if (ClientActions.actionHistory.isEmpty()) {
			System.out.println("No hay acciones para deshacer.");
		} else {		
			//Coge la ultima accion que sucedio del stack de acciones
			ClientActions lastAction = ClientActions.actionHistory.pop();
        
			//Verifca que tipo de accion es, si fue una reserva o una cancelacion
			switch (lastAction.getActionType()) {
				case "Reserve":
					//Si la ultima accion fue una reserva, deshacer una reserva es cancelar asi que cancela esa reserva

					lastAction.getClient().reservedSeats.remove(lastAction.getSeat()); //Quita el asiento de la lista de asientos reservados por el cliente

					Stadium.clientSeatReserved.remove(lastAction.getSeat()); //Quita el asiento y el cliente en el hashmap de Asientos - Clientes

					//Añade el string de que el cliente deshizo su ultima accion a la lista de historial de actividades del cliente
					TextBasedGUI.currentClient.reservationHistory.add(TextBasedGUI.currentClient.getClientName() + " deshizo su ultima accion: Reserva del asiento #" + lastAction.getSeat().getSeatNumber() + ", de la Fila #" + lastAction.getSeat().getSeatRow() + ", de la Seccion: " + lastAction.getSeat().getSeatLevel());
					
					System.out.println("Se ha deshecho la ultima accion!");
					
					//Si hay clientes en la lista de espera, le asigna el asiento que se acaba de cancelar a ese cliente
					switch (lastAction.getSeat().getSeatLevel()) {
						case "Field":
							if (!Seats.fieldWaitingList.isEmpty()) { //Si el asiento es de tipo field y hay clientes en la lista de espera, asigna el asiento
								Clients nextClient = Seats.fieldWaitingList.poll(); //Cliente al cual se le va a asignar el asiento
								nextClient.reservedSeats.add(lastAction.getSeat()); //Se le añade el asiento a ese cliente
								Stadium.clientSeatReserved.put(lastAction.getSeat(), nextClient); //Parea el asiento con el nuevo cliente en el hashmap de Asientos - Clientes
							}
							break;
						case "Main":
							if (!Seats.mainWaitingList.isEmpty()) { //Si el asiento es de tipo main y hay clientes en la lista de espera, asigna el asiento
								Clients nextClient = Seats.mainWaitingList.poll(); //Cliente al cual se le va a asignar el asiento
								nextClient.reservedSeats.add(lastAction.getSeat()); //Se le añade el asiento a ese cliente
								Stadium.clientSeatReserved.put(lastAction.getSeat(), nextClient); //Parea el asiento con el nuevo cliente en el hashmap de Asientos - Clientes
							}
							break;
						case "Grandstand":
							if (!Seats.grandstandWaitingList.isEmpty()) { //Si el asiento es de tipo grandstand y hay clientes en la lista de espera, asigna el asiento
								Clients nextClient = Seats.grandstandWaitingList.poll(); //Cliente al cual se le va a asignar el asiento
								nextClient.reservedSeats.add(lastAction.getSeat()); //Se le añade el asiento a ese cliente
								Stadium.clientSeatReserved.put(lastAction.getSeat(), nextClient); //Parea el asiento con el nuevo cliente en el hashmap de Asientos - Clientes
							}
							break;
						default:
							break;
					}
					break;
					
				case "Cancel":
					//Si el cliente va a deshacer una cancelacion y ya alguien que estaba anteriormente en fila de espera tiene el asiento, printea que no puede reservar el asiento
					if (Stadium.clientSeatReserved.containsKey(lastAction.getSeat())) {
						System.out.println("No se puede deshacer la cancelacion debido a que el asiento ya fue asignado al proximo cliente en la lista de espera!");
					} else {	
						//Si no hay nadie, añade el asiento de nuevo a nombre del cliente				
						lastAction.getClient().reservedSeats.add(lastAction.getSeat()); //Le añade el asiento a la lista de asientos reservados por el cliente
						Stadium.clientSeatReserved.put(lastAction.getSeat(), lastAction.getClient()); //Parea el asiento con el cliente en el hashmap de Asientos - Clientes

						//Añade el string de que el cliente deshizo su ultima accion a la lista de historial de actividades del cliente
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

		//Si el cliente no tiene ningun historial de actividades, printea que no tiene ningun historial disponible
		if (TextBasedGUI.currentClient.reservationHistory.isEmpty()) {
			System.out.println("Ningun historial disponible!" + "\n");
		} else {	
			//Printea todo el historial al reves para que el que este mas arriba sea la actividad mas reciente
			for (int i = TextBasedGUI.currentClient.reservationHistory.size() - 1; i >= 0; i--) {
				System.out.println("-" + TextBasedGUI.currentClient.reservationHistory.get(i) + "\n");
			}
		}
		System.out.println("Presione cualquier tecla para volver al menu principal...");
	    
	    TextBasedGUI.inputScanner.nextLine();

		TextBasedGUI.mainMenuScreen();
	}
	
	public static void administratorView() {
		System.out.println("\n" + "========================================");
		System.out.println("      VISTA DE ADMINISTRADOR");
		System.out.println("========================================");

		String username = "admin"; //Usuario valido para entrar a la vista de admin

		String password = "admin"; //Password valido para entrar a la vista de admin

		String inputUsername = "";
		String inputPassword = "";

		TextBasedGUI.isInputValid = false;

		//Le printea al admin todos los asientos, sigue preguntando hasta que el usuario y el password sean validos
		while(!TextBasedGUI.isInputValid) {
			System.out.println("\n" + "Inserte Usuario o Enter para Volver al menu principal: ");
			inputUsername = TextBasedGUI.inputScanner.nextLine();

			if (inputUsername.equals("")) { //Si le da al enter, envialo al menu principal
				TextBasedGUI.mainMenuScreen();
			}

			System.out.println("Password o Enter para volver al menu principal: ");
			inputPassword = TextBasedGUI.inputScanner.nextLine();

			if (inputPassword.equals("")) {  //Si le da al enter, envialo al menu principal
				TextBasedGUI.mainMenuScreen();
			}

			//Si el usuario y el password son validos, printea todos los asientos
			if (inputUsername.trim().equals(username) && inputPassword.trim().equals(password)) {
				for (Seats seat : Seats.seatsSet) {
					if (Stadium.clientSeatReserved.containsKey(seat)) { //Si un cliente tiene ese asiento reservado, printea tambien su nombre
						Clients client = Stadium.clientSeatReserved.get(seat);
						System.out.println("-" + seat + " por: " + client);
					} else { //Si nadie tiene este asiento, solo printea los datos del asiento
					System.out.println("-" + seat);
				}
			}

			TextBasedGUI.isInputValid = true;
		} else {
			System.out.println("\n" + "Usuario o Password Invalido!"); //Print cuando el usuario o el password no son validos
		}
	}

	System.out.println("\n" + "Presione cualquier tecla para volver al menu principal...");
	    
	TextBasedGUI.inputScanner.nextLine();

	TextBasedGUI.mainMenuScreen();

}
	public static void exitProgram() {
		System.out.println("\n" + "========================================");
		System.out.println("      GRACIAS POR USAR EL PROGRAMA!");
		System.out.println("========================================" + "\n");

		//Pone el loop principal del programa como falso
		Stadium.programRunning = false;

		//Pone los booleans de verificacion de inputs como true (realmente no es necesario pero no esta mal)
		TextBasedGUI.isInputValid = true;
		TextBasedGUI.isLevelInputValid = true;
		TextBasedGUI.isReserveInputValid = true;

		//Cierra el scanner
		TextBasedGUI.inputScanner.close();

		//Cierra el programa completamente con estado cero como que está todo bien
		System.exit(0);
	}
}
