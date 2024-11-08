package dataProject;
import java.util.Scanner;
public class TextBasedGUI {
	
	public static Scanner inputScanner = new Scanner(System.in);

	public static boolean isInputValid = false;
	
	public static Clients currentClient;
	
	public static String menuSelection = "";
	
	public static void loginScreen() {
		
		String clientName = "";
		String clientEmail = "";
		String clientPhoneNumber = "";
		
		System.out.println("\n" + "━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("      INICIO DE SESIÓN");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━" + "\n");
		
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
            	System.out.println("Nombre inválido. Asegúrese de que contenga solo números.");
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
            	System.out.println("Correo electrónico inválido. Asegúrese de que contenga un '@'.");
            }
        }
        
        isInputValid = false;
        
        //Verificación de Número de Teléfono
        while (!isInputValid) {
            System.out.print("Número de Teléfono del Cliente: ");
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
            	System.out.println("Número de teléfono inválido. Asegúrese de que contenga solo números o guiones.");
            }
        }
        
        isInputValid = false;
        
        currentClient = new Clients(clientName, clientEmail, clientPhoneNumber);
        
        mainMenuScreen();
	}
	
	public static void mainMenuScreen() {
		
		System.out.println("\n" + "━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("BIENVENIDO, " + currentClient.getClientName());
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━" + "\n");
		
		System.out.println("\n" + "━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("      MENÚ PRINCIPAL");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━" + "\n");
		
		System.out.println("1. Ver Disponibilidad del Estadio");
		System.out.println("2. Ver Reservación");
		System.out.println("3. Realizar Pago");
		System.out.println("4. Cancelar Reservación");
		System.out.println("5. Ver Lista de Espera");
		System.out.println("5. Ver Datos del Cliente");
		System.out.println("6. Cerrar Sesión");
		System.out.println("7. Salir del Sistema" + "\n");
		
		isInputValid = false;
		
		//Verificación de Selección de Menu Principal
	    while (!isInputValid) {
			System.out.println("Selecciona una opción: ");
			menuSelection = inputScanner.nextLine();
			
			isInputValid = true;
			switch (menuSelection) {
				case "1":
					System.out.println("1!");
					break;
				case "2":
					System.out.println("2!");
					break;
				case "3":
					System.out.println("3!");
					break;
				case "4":
					System.out.println("4!");
					break;
				case "5":
					System.out.println("5!");
					break;
				case "6":
					System.out.println("6!");
					loginScreen();
					break;
				case "7":
					System.out.println("7!");
					break;
				default:
					System.out.println("Selección no válida!");
					isInputValid = false;
					break;
			}
	    }
	}
	
	public static void verDisponibilidadEstadio() {
	}
	
	public static void main(String[] args) {
		loginScreen();
	}
	
}
