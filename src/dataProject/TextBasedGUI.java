package dataProject;

import java.util.Scanner;
public class TextBasedGUI {
	
	public static Scanner inputScanner = new Scanner(System.in);

	public static boolean isInputValid = false;
	public static boolean isLevelInputValid = false;
	
	public static Clients currentClient;
	
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
            	System.out.println("Nombre invalido. Asegurese de que contenga solo numeros.");
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
		
		System.out.println("\n" + "========================================");
		System.out.println("BIENVENIDO, " + currentClient.getClientName());
		System.out.println("========================================");
		
        mainMenuScreen();
	}
	
	public static void mainMenuScreen() {
		
		System.out.println("\n" + "========================================");
		System.out.println("	     MENU PRINCIPAL");
		System.out.println("========================================" + "\n");
		
		System.out.println("1. Ver Disponibilidad del Estadio");
		System.out.println("2. Ver Reservaciones y Realizar Pago");
	//	System.out.println("3. Realizar Pago");
		System.out.println("3. Cancelar Reservaciones");
		System.out.println("4. Ver Lista de Espera");
		System.out.println("5. Ver Datos del Cliente");
		System.out.println("6. Cerrar Sesion");
		System.out.println("7. Salir del Sistema" + "\n");
		
		isInputValid = false;
		
		//Verificación de Selección de Menu Principal
	    while (!isInputValid) {
			System.out.println("Selecciona una opcion (1-7): ");
			menuSelection = inputScanner.nextLine();
			
			isInputValid = true;
			switch (menuSelection) {
				case "1":
					MenuSelections.stadiumAvailability();;
					break;
				case "2":
					MenuSelections.viewReservationsAndPay();
					return;
				case "3":
					System.out.println("3!");
					break;
				case "4":
					System.out.println("4!");
					break;
				case "5":
					MenuSelections.clientData();
					return;
				case "6":
					loginScreen();
					return;
				case "7":
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
