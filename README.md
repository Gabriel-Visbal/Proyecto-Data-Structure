# Proyecto-Data-Structure

## Integrantes: 

- Gabriel Visbal Rodriguez (802-23-4640)

- Bruno Vergara Collado (802-23-6348)

- Jan Morales Vazquez (802-23-7639)

## Resumen del Proyecto:

- El objetivo del proyecto fue simular una página de reserva de asientos para un juego de "baseball". Se crearon diferentes filas de asientos con sus diferentes capacidades y diferentes precios. Además, se tuvo que crear una lista de espera en caso de que los asientos estén llenos.

## Funcionalidad del Proyecto: 

- Nuestro proyecto consta de seis files donde se dividen las tareas para la ejecucion de este proyecto

### File ClientActions

- El file ClientActions contiene la clase que gestiona las acciones realizadas por los clientes, como reservas o cancelaciones de asientos. Las acciones se almacenan en un Stack para mantener el historial y permitir deshacer acciones si es necesario.

  ### Clase ClientActions

    #### Atributos:

    - client: Cliente que realiza la acción.
    - seat: Asiento asociado a la acción (reserva o cancelación).
    - actionType: Tipo de acción realizada (puede ser "Reserve" o "Cancel").

    #### Métodos:
    
    -	getClient(): Devuelve el cliente que realizó la acción.
    -	setClient(Clients newClient): Actualiza el cliente que realizó la acción.
    -	getSeat(): Devuelve el asiento relacionado con la acción.
    -	setSeat(Seats newSeat): Actualiza el asiento de la acción.
    -	getActionType(): Devuelve el tipo de acción realizada.
    -	setActionType(String newActionType): Actualiza el tipo de acción.
 
### File Clients

- El file Clients contiene la clase que gestiona la información de los clientes, como nombre, correo electrónico, número de teléfono y su historial de reservas. Esta clase permite crear, actualizar y consultar los datos de los clientes.

  ### Clase Clients

    #### Atributos:
  
    -	clientName: Nombre del cliente.
    -	clientEmail: Correo electrónico del cliente.
    -	clientPhoneNumber: Número de teléfono del cliente.
    -	reservationHistory: Historial de reservas del cliente.
    -	reservedSeats: Asientos reservados actualmente por el cliente.

    #### Constructor:
  
    -	Clients(String clientName, String clientEmail, String clientPhoneNumber):
    Inicializa un nuevo cliente con el nombre, correo electrónico y número de teléfono              especificados.

    #### Métodos:

    -	getClientName(), getClientEmail(), getClientPhoneNumber(): Devuelven la información del       cliente.
    -	setClientName(), setClientEmail(), setClientPhoneNumber(): Permiten actualizar los datos      del cliente.
    -	printClientData(): Imprime todos los datos del cliente.
    -	isSameClient(Clients otherClient): Verifica si dos clientes son iguales comparando su         nombre, email y teléfono.
    -	toString(): Override al método de java para que el nombre del objeto Clients sea el nombre del cliente.

### File MenuSelections

- El file menuSelections contiene la clase que gestiona todos los casos posibles que el usuario puede seleccionar. Se ejecuta las acciones que el usuario ha elegido, como reservar un asiento, cancelar un asiento, ver la lista de espera, entre otras.

  ### Clase MenuSelections

    #### Métodos:

  - stadiumAvailability(), seatAvailability(): Le pregunta al cliente que sección de asientos desea escoger, de acuerdo a la sección que el cliente escogió, le muestra todos los asientos de esa seccion y le permite realizar el pago.
  - viewReservations(): Le muestra al cliente todas sus reservaciones actuales.
  - cancelReservations(): Le permite al cliente cancelar reservaciones actuales.
  - viewWaitingList(), queuePositions(): Le muestran al cliente en que posiciones de la lista de espera de cada seccion se encuentran.
  - clientData(): Imprime la información del cliente.
  - undoLastAction(): Le permite al cliente cancelar su ultima acción, ya sea una reserva o una cancelación.
  - viewReservationHistory(): Le muestra al cliente todo el historial de lo que ha realizado en el programa.
  - administratorView(): Vista de administrador para ver todos los asientos y quien tiene la reserva de cada uno. Usuario y contraseña son "admin".
  - exitProgram(): Cierra el programa completamente.

### File Seats

- El file seats contiene la clase que gestiona las operaciones relacionadas con los asientos, como asignar asientos a los clientes, manejar las listas de espera y mantener un registro de los asientos reservados de cada sección.

  ### Clase Seats

    #### Atributos:
  
    -	seatLevel: Sección del asiento.
    -	seatRow: Número de fila del asiento.
    -	seatNumber: Número del asiento.
    -	seatPrice: Precio del asiento.
    -	seatPrice: Guarda todos los asientos del estadio.
    -	fieldSeats: Guarda los asientos de la seccion Field.
    -	mainSeats: Guarda los asientos de la seccion Main.
    -	grandstandSeats: Guarda los asientos de la seccion Grandstand.
    -	fieldWaitingList: Guarda los clientes en la lista de espera de la seccion Field.
    -	mainWaitingList: Guarda los clientes en la lista de espera de la seccion Main.
    - grandstandWaitingList: Guarda los clientes en la lista de espera de la seccion Grandstand.
 
    #### Constructor:
  
    -	Seats(String seatLevel, int seatRow, int seatNumber):
    Inicializa un nuevo asiento con la sección, número de fila y número de asiento              especificados. Además, le asigna un precio específico de acuerdo a la sección, 
      
    #### Métodos:
  
    -	getSeatLevel(), getSeatRow(), getSeatNumber(), getSeatPrice(): Devuelven la información del       asiento.
    -	setSeatLevel(), setSeatRow(), setSeatNumber(), setSeatPrice(): Permiten actualizar los datos      del asiento.
    -	printClientData(): Imprime todos los datos del cliente.
    -	toString(): Override al método de java para que el nombre del objeto Seats sean los datos del asiento.
    -	initializeFieldSeats(), initializeMainSeats(), initializeGrandstandSeats(): Crea todos los objetos Seats que se van a usar en el programa de acuerdo a la seccion y capacidad. Además, añade estos asientos y sus respectivas listas.
    -	areAllSeatsReserved(): Dado un ArrayList de Seats, verifica si todos los asientos de ese ArrayList estan reservados.
      
### File Stadium

- El file Stadium contiene la clase que gestiona las secciones de los asientos, como asignar la capacidad de cada sección y confirmar la disponibilidad de los mismos.

  ### Clase Stadium

    #### Atributos:

    - clientSeatReserved: Hashmap que tiene como key un objeto Seats y como value un objeto Clients, este hashmap es utilizado para parear a los asientos con el respectivo cliente que lo tiene reservado.
 
    - programRunning: Boolean que se encarga del loop principal del programa.

    #### Métodos:

    - main(): Método main del programa, aqui se llaman los metodos de inicialización de asientos y luego la pantalla de inicio de sesión para empezar el programa.

 ### File TextBasedGUI

- El file TextBasedGUI contiene la clase que gestiona los prints para el cliente, como solicitar su informacion, mostrar los diferentes casos.

  ### Clase TextBasedGUI:

   #### Atributos:

    -	inputScanner: Scanner que se utiliza durante el programa para el input del cliente
    -	isInputValid, isLevelInputValid, isLevelInputValid: Booleans utilizados en los loops donde el cliente debe de escribir un input.
    -	currentClient: Objeto cliente que está utilizando el programa actualmente.
    -	currentAction: Objeto que guarda la ultima acción realizada en el programa.
    -	allClientsList: Guarda todos los clientes que han utilizado el programa.
    -	menuSelection: Guarda el input del cliente.

   #### Métodos:

    - loginScreen(): Le pregunta al cliente su nombre, email y número de telefono para luego almacenarlo en un objeto cliente. Si este cliente ya existe, utiliza el objeto Clients que ya estaba anteriormente en la lista de clientes.
    - mainMenuScreen(): Menú principal del programa, aqui se encuentran todos lo que el cliente puede realizar en el programa, de acuerdo a lo que seleccione el cliente, llama al respectivo método asociado con esa selección.
