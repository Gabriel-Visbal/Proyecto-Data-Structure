package dataProject;

import java.util.ArrayList;
import java.util.Scanner;

public class TextBasedGUI {
	
	public static Scanner inputScanner = new Scanner(System.in);

	public static boolean isInputValid = false;
	public static boolean isLevelInputValid = false;
	public static boolean isReserveInputValid = false;
	
	public static Clients currentClient; //Cliente actual que está usando el programa
	public static ClientActions currentAction;
	
	//Lista que contiene todos los clientes que han usado el programa
	public static ArrayList<Clients> allClientsList = new ArrayList<>();

	public static String menuSelection = "";
	
	public static void loginScreen() {
		
		String clientName = "";
		String clientEmail = "";
		String clientPhoneNumber = "";
		
		System.out.println("\n" + "========================================");
		System.out.println("            INICIO DE SESION");
		System.out.println("========================================" + "\n");
		
		isInputValid = false;
		
        //Verifica que el nombre tenga solo letras o espacios, sigue preguntando hasta que eso se cumpla
        while (!isInputValid) {
            System.out.print("Nombre del Cliente: ");
            clientName = inputScanner.nextLine();

            isInputValid = true;
            for (int i = 0; i < clientName.length(); i++) {
                if (!Character.isLetter(clientName.charAt(i)) && clientName.charAt(i) != ' ') { //Aqui verifica si no es o una letra y no 
                	isInputValid = false;														//es un espacio entonces sabemos que tenemos que preguntar de nuevo
                    break;
                }
            }

            if (!isInputValid) {
            	System.out.println("\u001B[31m" + "Nombre invalido. Asegurese de que contenga solo letras o espacios." + "\u001B[0m" + "\n");
            }
        }
        
        isInputValid = false;
        
        //Verifica que el email tenga por lo menos un @ en alguna parte, sigue preguntando hasta que eso se cumpla
        while (!isInputValid) {
            System.out.print("Email del Cliente: ");
            clientEmail = inputScanner.nextLine();

            isInputValid = false;
            for (int i = 0; i < clientEmail.length(); i++) {
                if (clientEmail.charAt(i) == '@') { //Si encontró el @ entonces esta bien
                	isInputValid = true;
                    break;
                }
            }

            if (!isInputValid) {
            	System.out.println("\u001B[31m" + "Correo electronico invalido. Asegurese de que contenga un '@'." + "\u001B[0m" + "\n");
            }
        }
        
        isInputValid = false;
        
        //Verifica que el numero de telefono tenga solo numeros, sigue preguntando hasta que eso se cumpla
        while (!isInputValid) {
            System.out.print("Numero de Telefono del Cliente: ");
            clientPhoneNumber = inputScanner.nextLine();
            
            if (clientPhoneNumber.contains("-")) { //Si el numero de telefono tiene guiones, los reemplaza por un espacio vacio, osea los elimina
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
            	System.out.println("\u001B[31m" + "Numero de telefono invalido. Asegurese de que contenga solo numeros o guiones." + "\u001B[0m" + "\n");
            }
        }
        
        isInputValid = false;

		//Hace un nuevo objeto cliente con los datos anteriormente recogidos
        currentClient = new Clients(clientName, clientEmail, clientPhoneNumber);

        boolean clientExists = false;

		//Recorre la lista de todos los clientes que han usado el programa
        for (Clients client : allClientsList) {
            if (currentClient.isSameClient(client)) { //Si encuentra que este cliente ya habia usado el programa, se queda con el cliente que ya habia anteriormente
                currentClient = client; 			  //esto para que si entras con el mismo cliente, tenga todas las reservas y el historial de ese cliente 
                clientExists = true;
                break;
            }
        }

		//Si es un cliente nuevo, añadelo a la lista de clientes
        if (!clientExists) {
            allClientsList.add(currentClient);
        }

		System.out.println("\n" + "========================================");
		System.out.println("       BIENVENIDO, " + "\u001B[32m" + currentClient.getClientName().toUpperCase() + "\u001B[0m");
		System.out.println("========================================");
		
		//Pasa a la pantalla principal para que el cliente seleccione que quiere hacer
        mainMenuScreen();
	}
	
	public static void mainMenuScreen() {
		
		System.out.println("\n" + "========================================");
		System.out.println("	     MENU PRINCIPAL");
		System.out.println("========================================" + "\n");
		
		System.out.println("\u001B[34m" + "1. Ver Disponibilidad del Estadio" + "\u001B[0m");
		System.out.println("\u001B[34m" + "2. Ver Reservaciones" + "\u001B[0m");
		System.out.println("\u001B[34m" + "3. Cancelar Reservaciones" + "\u001B[0m");
		System.out.println("\u001B[34m" + "4. Ver Lista de Espera" + "\u001B[0m");
		System.out.println("\u001B[34m" + "5. Ver Datos del Cliente" + "\u001B[0m");
		System.out.println("\u001B[34m" + "6. Deshacer Ultima Accion" + "\u001B[0m");
		System.out.println("\u001B[34m" + "7. Ver Historial de Reservaciones" + "\u001B[0m");
		System.out.println("\u001B[34m" + "8. Vista de Administrador" + "\u001B[0m");
		System.out.println("\u001B[34m" + "9. Cerrar Sesion" + "\u001B[0m");
		System.out.println("\u001B[34m" + "10. Salir del Sistema" + "\u001B[0m" +"\n");
		
		isInputValid = false;
		
		//Verifica que lo que elegio el cliente es una opcion valida, sigue preguntando hasta que eso se cumpla
	    while (!isInputValid) {
			System.out.println("Selecciona una opcion (" + "\u001B[34m" + "1-10" + "\u001B[0m" + "): ");
			menuSelection = inputScanner.nextLine().trim();
			
			isInputValid = true;
			switch (menuSelection) {
				case "1":
					MenuSelections.stadiumAvailability(); //Envia al cliente al apartado de ver y comprar asientos
					return;
				case "2":
					MenuSelections.viewReservations(); //Envia al cliente al apartado de ver las reservaciones que tiene actualmente
					return;
				case "3":
					MenuSelections.cancelReservations(); //Envia al cliente al apartado de cancelar reservaciones que tenga actualmente
					return;
				case "4":
					MenuSelections.viewWaitingList(); //Envia al cliente al apartado de ver en que posicion de las listas de espera se encuentra actualmente
					return;
				case "5":
					MenuSelections.clientData(); //Envia al cliente al apartado de ver todos sus datos, nombre, email, numero de telefono
					return;
				case "6":
					MenuSelections.undoLastAction(); //Envia al cliente al apartado de deshacer su ultima accion
					return;
				case "7":
					MenuSelections.viewReservationHistory(); //Envia al cliente al apartado de ver todo su historial de reservas, cancelaciones, cosas que deshizo
					return;
				case "8":
					MenuSelections.administratorView(); //Vista de administrador
					return;
				case "9":
					loginScreen(); //Vuelve a la pantalla de login - inicio de sesion para entrar con otro usuario
					return;
				case "10":
					MenuSelections.exitProgram(); //Llama la funcion de cerrar el programa
					return;
				default:
					System.out.println("\n" + "\u001B[31m" + "Seleccion no valida!" + "\u001B[0m");
					isInputValid = false; //Si la seleccion no es valida, vuelve a preguntar de nuevo
					break;
			}
	    }
	}
	
}
