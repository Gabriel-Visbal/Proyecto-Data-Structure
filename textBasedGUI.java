package dataProject;
import java.util.Scanner;
public class textBasedGUI {
	
	public static Scanner inputScanner = new Scanner(System.in);
	
	public static String personName = "";
	public static String personEmail = "";
	public static String personPhoneNumber = "";
	
	public static void loginScreen() {
		
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("      LOGIN SCREEN");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━" + "\n");
		

		boolean isInputValid = false;
		
       //Name Verification
        while (!isInputValid) {
            System.out.print("Enter your Name: ");
            personName = inputScanner.nextLine();

            isInputValid = true;
            for (int i = 0; i < personName.length(); i++) {
                if (!Character.isLetter(personName.charAt(i)) && personName.charAt(i) != ' ') {
                	isInputValid = false;
                    break;
                }
            }

            if (!isInputValid) {
            	System.out.println("Invalid name. Please use letters only.");
            }
        }
        
        isInputValid = false;
        
        //Email Verification
        while (!isInputValid) {
            System.out.print("Enter your Email: ");
            personEmail = inputScanner.nextLine();

            isInputValid = false;
            for (int i = 0; i < personEmail.length(); i++) {
                if (personEmail.charAt(i) == '@') {
                	isInputValid = true;
                    break;
                }
            }

            if (!isInputValid) {
            	System.out.println("Invalid email. Please ensure it contains an @.");
            }
        }
        
        isInputValid = false;
        
        //Phone Verification
        while (!isInputValid) {
            System.out.print("Enter your Phone Number: ");
            personPhoneNumber = inputScanner.nextLine();
            
            if (personPhoneNumber.contains("-")) {
                personPhoneNumber = personPhoneNumber.replace("-", "");
            }
            
            isInputValid = true;
            for (int i = 0; i < personPhoneNumber.length(); i++) {
                if (!Character.isDigit(personPhoneNumber.charAt(i))) {
                    isInputValid = false;
                    break;
                }
            }

            if (!isInputValid) {
            	System.out.println("Invalid number. Please ensure it only contains numbers or hyphens.");
            }
        }
        
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("WELCOME, " + personName);
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━" + "\n");
		
	}
	
}
