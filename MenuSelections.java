package dataProject;

public class MenuSelections {
	
	public static void verDisponibilidadEstadio() {
		
		System.out.println("\n" + "━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("      DISPONIBILIDAD DEL ESTADIO");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━" + "\n");

		System.out.println("1. Field");
		System.out.println("2. Main");
		System.out.println("3. Grandstand" + "\n");
		
		TextBasedGUI.isInputValid = false;
		
		//Verificación de Selección de Nivel de Asiento
	    while (!TextBasedGUI.isInputValid) {
			System.out.println("Selecciona una opción (1-3): ");
			TextBasedGUI.menuSelection = TextBasedGUI.inputScanner.nextLine();
			
			TextBasedGUI.isInputValid = true;
	           switch (TextBasedGUI.menuSelection) {
               case "1":
                   break;
               case "2":
                   break;
               case "3":
                   break;
               default:
            	   System.out.println("Selección no válida!");
            	   TextBasedGUI.isInputValid = false;
                   break;
           }
	    }
	}
}
