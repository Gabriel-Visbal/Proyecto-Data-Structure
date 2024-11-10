package dataProject;

import java.util.Scanner;

import java.util.HashSet;
import java.util.Set;
public class TextBasedGUI {
	
	public static Scanner inputScanner = new Scanner(System.in);

	public static boolean isInputValid = false;
	public static boolean isLevelInputValid = false;
	public static boolean isReserveInputValid = false;
	
	public static Clients currentClient;
	public static ClientActions currentAction;
	
	public static Set<Clients> allClientsSet = new HashSet<Clients>();

	public static String menuSelection = "";
	
	public static void loginScreen() {
		
		String clientName = "";
		String clientEmail = "";
		String clientPhoneNumber = "";
		
		System.out.println("\n" + "========================================");
		System.out.println("            INICIO DE SESION");
		System.out.println("========================================" + "\n");
		
		isInputValid = false;
		
        //Verificación de Nombre
        while (!isInputValid) {
            System.out.print("Nombre del Cliente: ");
            clientName = inputScanner.nextLine();

            isInputValid = true;
            for (int i = 0; i < clientName.length(); i++) {
                if (!Character.isLetter(clientName.charAt(i)) && clientName.charAt(i) != ' ') {
                	isInputValid = false;
                    break;
                }
            }

            if (!isInputValid) {
            	System.out.println("Nombre invalido. Asegurese de que contenga solo letras.");
            }
        }
        
        isInputValid = false;
        
        //Verificación de Email
        while (!isInputValid) {
            System.out.print("Email del Cliente: ");
            clientEmail = inputScanner.nextLine();

            isInputValid = false;
            for (int i = 0; i < clientEmail.length(); i++) {
                if (clientEmail.charAt(i) == '@') {
                	isInputValid = true;
                    break;
                }
            }

            if (!isInputValid) {
            	System.out.println("Correo electronico invalido. Asegurese de que contenga un '@'.");
            }
        }
        
        isInputValid = false;
        
        //Verificación de Número de Teléfono
        while (!isInputValid) {
            System.out.print("Numero de Telefono del Cliente: ");
            clientPhoneNumber = inputScanner.nextLine();
            
            if (clientPhoneNumber.contains("-")) {
                clientPhoneNumber = clientPhoneNumber.replace("-", "");
            }
            
            isInputValid = true;
            for (int i = 0; i < clientPhoneNumber.length(); i++) {
                if (!Character.isDigit(clientPhoneNumber.charAt(i))) {
                    isInputValid = false;
                    break;
                }
            }

            if (!isInputValid) {
            	System.out.println("Numero de telefono invalido. Asegurese de que contenga solo numeros o guiones.");
            }
        }
        
        isInputValid = false;

        currentClient = new Clients(clientName, clientEmail, clientPhoneNumber);
		
		if (allClientsSet.contains(currentClient)) {
			for (Clients client : allClientsSet) {
				if (currentClient.equals(client)) {
					currentClient = client;
					break;
				}
			}
		} else {
			allClientsSet.add(currentClient);
		}

		System.out.println("\n" + "========================================");
		System.out.println("       BIENVENIDO, " + currentClient.getClientName().toUpperCase());
		System.out.println("========================================");
		
        mainMenuScreen();
	}
	
	public static void mainMenuScreen() {
		
		System.out.println("\n" + "========================================");
		System.out.println("	     MENU PRINCIPAL");
		System.out.println("========================================" + "\n");
		
		System.out.println("1. Ver Disponibilidad del Estadio");
		System.out.println("2. Ver Reservaciones");
		System.out.println("3. Cancelar Reservaciones");
		System.out.println("4. Ver Lista de Espera");
		System.out.println("5. Ver Datos del Cliente");
		System.out.println("6. Deshacer Ultima Accion");
		System.out.println("7. Cerrar Sesion");
		System.out.println("8. Salir del Sistema" + "\n");
		
		isInputValid = false;
		
		//Verificación de Selección de Menu Principal
	    while (!isInputValid) {
			System.out.println("Selecciona una opcion (1-8): ");
			menuSelection = inputScanner.nextLine();
			
			isInputValid = true;
			switch (menuSelection) {
				case "1":
					MenuSelections.stadiumAvailability();;
					break;
				case "2":
					MenuSelections.viewReservations();
					return;
				case "3":
					MenuSelections.cancelReservations();
					return;
				case "4":
					MenuSelections.viewWaitingList(); //TODO
					break;
				case "5":
					MenuSelections.clientData();
					return;
				case "6":
					MenuSelections.undoLastAction();
					return;
				case "7":
					loginScreen();
					return;
				case "8":
					MenuSelections.exitProgram();
					return;
				default:
					System.out.println("Seleccion no valida!");
					isInputValid = false;
					break;
			}
	    }
	}
	
}
