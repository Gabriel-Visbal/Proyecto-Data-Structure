# Proyecto-Data-Structure

## Integrantes: 

- Gabriel Visbal Rodriguez (802-23-4640)

- Bruno Vergara Collado (802-23-6348)

- Jan Morales Vazquez (802-23-7639)

## Resumen del Proyecto:

- El objetivo del proyecto fue simular una página de reserva de asientos para un juego de "baseball". Se crearon diferentes filas de asientos con sus diferentes capacidades y diferentes precios. Además, se tuvo que crear una lista de espera en caso de que los asientos estén llenos.

## Funcionalidad del Proyecto: 

- Nuestro proyecto consta de seis folders donde se dividen las tareas para la ejecucion de este proyecto

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
    -	toString(): Devuelve el nombre del cliente.

### File MenuSelections

- El file menuSelections contiene la clase que gestiona todos los casos posibles que el usuario puede seleccionar. Se ejecuta las acciones que el usuario ha elegido, como reservar un asiento, cancelar un asiento, ver la lista de espera, entre otras.

  ### Clase MenuSelections

    #### Atributos:

    #### Métodos:


### File Seats

- El file seats contiene la clase que gestiona las operaciones relacionadas con los asientos, como asignar asientos a los clientes, manejar las listas de espera y mantener un registro de los asientos reservados de cada sección.

  ### Clase Seats

    #### Atributos:

    #### Métodos:


### File Stadium

- El file Stadium contiene la clase que gestiona las secciones de los asientos, como asignar la capacidad de cada sección y confirmar la disponibilidad de los mismos.

  ### Clase Stadium

    #### Atributos:

    #### Métodos:

### File TextBasedGUI

- El file TextBasedGUI contiene la clase que gestiona los prints para el usuario, como solicitar su informacion, mostrar los diferentes casos.

  ### Clase TextBasedGUI

  #### Atributos:

  #### Métodos:



    

  


