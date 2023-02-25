package pruebaCuentas;
/**
 * Clase que contiene el programa principal para la gestión de cuentas bancarias de personas.
 * @author Charl
 * @version 1.0
 * @since 2023-02-25
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PruebaCuentas {
	
	/**
	 * Método principal del programa.
	 * 
	 * @param args Argumentos de línea de comandos, no utilizados en este programa.
	 * @throws IOException si ocurre algún error de entrada/salida.
	 */
	public static void main(String[] args) throws IOException {
		// Instancia para la lectura de entrada de usuario
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// Array de personas que almacena hasta 10 personas
		Persona personas[] = new Persona[10];
		// Contador para el número actual de personas almacenadas en el Array personas
		int numPersonas = 0;
		
		// Variable para almacenar la opción seleccionada por el usuario
		String opcion;

		// Variable para almacenar el DNI de la persona
		String dni;
		
		// Variable para almacenar la persona encontrada
		Persona personaEncontrada;
		
		//Variable para almacenar el numero de la cuenta
		String num;
		
		//Variable para almacenar la cuenta encontrada
		Cuenta cuentaEncontrada;

		do {
			// Menú de opciones para el usuario
			System.out.println("-------------------------------MENU-----------------------------------\r\n"
					+ "1. Instanciar objetos de tipo Persona \r\n"
					+ "2. Instanciar objetos de tipo Cuenta y asociarlo a una persona.\r\n"
					+ "3. Mostrar datos de una persona (por su dni).\r\n"
					+ "4. Recibir la nómina mensual de una persona (por dni y núm de cuenta).\r\n"
					+ "5. Recibir un pago (por dni y núm de cuenta).\r\n"
					+ "6. Realizar transferencia entre cuentas.\r\n" + "7. Imprimir las personas morosas.");
			System.out.print("Opcion: ");
			// Lectura de la opción seleccionada por el usuario
			opcion = in.readLine();
			System.out.println("----------------------------------------------------------------------");
			
			// Selección de la opción elegida por el usuario
			switch (opcion) {
			case "1":
				/**
		         * Crea una nueva persona y la agrega al arreglo de personas existente
		         */
				System.out.print("Introduzca el DNI de la persona: ");
				dni = in.readLine();
				Persona persona = new Persona(dni);
				// Almacenamiento de la persona en el arreglo de personas
				personas[numPersonas] = persona;
				numPersonas++;
				break;

			case "2":
				  /**
		         * Asocia una cuenta a una persona existente
		         */
				System.out.print("Introduzca el DNI de la persona: ");
				dni = in.readLine();
				// Búsqueda de la persona por su DNI
				personaEncontrada = buscarPersona(dni, personas);
				if (personaEncontrada != null) {
					System.out.print("Introduce el número de cuenta: ");
					String numCuenta = in.readLine();
					System.out.print("Introduzca el saldo inicial: ");
					double saldo = Double.parseDouble(in.readLine());
					// Instanciación de una nueva cuenta y asociación a la persona encontrada
					Cuenta cuenta = new Cuenta(numCuenta, saldo);
					// Añade una cuenta a una persona
					personaEncontrada.anadirCuenta(cuenta);
				} else {
					System.out.println("No se ha encontrado ninguna persona con ese DNI");
				}
				break;
			case "3":
				 /**
		         * Muestra información de una persona por su DNI
		         */
				System.out.print("Introduzca el DNI de la persona: ");
				dni = in.readLine();
				// Búsqueda de la persona por su DNI
				// Búsqueda de la persona por su DNI
				personaEncontrada = buscarPersona(dni, personas);
				if (personaEncontrada != null) {
					System.out.println("DNI: " + personaEncontrada.getDni());
					Cuenta[] cuentas = personaEncontrada.getCuentas();
					for (int i = 0; i < personaEncontrada.getCuentas().length; i++) {
						if (cuentas[i] != null) {
							System.out.println("Cuenta " + (i + 1) + ": " + cuentas[i].getNumCuenta() + ", saldo: "
									+ cuentas[i].getSaldo());
						}
					}
				} else {
					System.out.println("No se ha encontrado ninguna persona con ese DNI");
				}
				break;
			case "4":
				/**
		         * Realiza una transferencia de la cuenta de una persona a otra cuenta de una persona.
		         */
				System.out.print("Introduzca el DNI de la persona: ");
				dni = in.readLine();
				personaEncontrada = buscarPersona(dni, personas);
				if (personaEncontrada != null) {
					System.out.print("Introduzca el numero de cuenta de la persona: ");
					num = in.readLine();
					cuentaEncontrada = buscarCuenta(personaEncontrada, num);
					if(cuentaEncontrada != null){
						System.out.print("Introduzca el valor de la nomina mensual: ");
						double saldo = Double.parseDouble(in.readLine());
						cuentaEncontrada.recibirAbono(saldo);
					}else {
						System.out.println("No se ha encontrado ninguna Cuenta con ese DNI");
					}
				} else {
					System.out.println("No se ha encontrado ninguna persona con ese DNI");
				}
				break;
			case "5":
				 /**
		         * Realiza el pago de un recibo a una cuenta específica de una persona.
		         */
				System.out.print("Introduzca el DNI de la persona: ");
				dni = in.readLine();
				personaEncontrada = buscarPersona(dni, personas);
				if (personaEncontrada != null) {
					System.out.print("Introduzca el numero de cuenta de la persona: ");
					num = in.readLine();
					cuentaEncontrada = buscarCuenta(personaEncontrada, num);
					if(cuentaEncontrada != null){
						System.out.print("Introduzca el valor del pago: ");
						double saldo = Double.parseDouble(in.readLine());
						cuentaEncontrada.pagarRecibo(saldo);
					}else {
						System.out.println("No se ha encontrado ninguna Cuenta con ese DNI");
					}
				} else {
					System.out.println("No se ha encontrado ninguna persona con ese DNI");
				}
				break;
			case "6":
				/**
				 * Realiza una tranferencia de dos cuentas de una misma persona
				 * 
				 * personaEncontrada llama al metodo @see #buscarPersona(String, Persona)
				 * 
				 * @see #tranferirEntreCuentas(Persona, BufferedReader) para hacer la transferencia
				 */
				 System.out.print("Ingrese el DNI de la persona que realiza la transferencia: ");
				    dni = in.readLine();
				    personaEncontrada = buscarPersona(dni, personas);
				    transferirEntreCuentas(personaEncontrada, in);
				break;
			case "7":
				/**
				 * Llamma a un metodo para imprimer el dni de las personas morosas.
				 * 
				 * @see #imprimirPersonaMorosa(Persona)
				 */
				imprimirPersonaMorosa(personas);
				break;
			case "0":
				/**
				 * Imprime una mensaje y termina el programa
				 */
				System.out.println("Saliendo...");
				break;
			default:
				/**
				 * Imprime una mensaje de error, cuando el usuario seleciona una opcion no valida.
				 */
				System.err.println("Opción no valida");
			}
		} while (opcion != "0");
	}
	
	
	/**
	 * Este método imprime en la consola el DNI de todas las personas que tengan cuentas morosas.
	 * @param personas Un array de objetos Persona.
	 * Si el array es nulo, se imprime un mensaje de error indicando que no hay personas registradas
	 */
	public static void imprimirPersonaMorosa(Persona[] personas) {
		if(personas != null) {
			for(int i = 0; i < personas.length; i++) {
				if(personas[i] != null && personas[i].getCuentas() != null && personas[i].esMorosa()) {
					System.out.println("Esta persona es morosa: " + "\nDNI: " + personas[i].getDni());
					System.out.println("========================\n");
				}
			}
		}else {
			System.err.println("No hay personas registradas.");
		}
	}
	
	
	/**
	 * Este método permite transferir dinero entre dos cuentas bancarias de una persona.
	 * @param persona Un objeto de la clase Persona que representa al titular de las cuentas.
	 * @param in Un objeto BufferedReader utilizado para obtener datos del usuario por consola.
	 * @throws IOException Si ocurre un error al leer los datos ingresados por el usuario.
	 */
	public static void transferirEntreCuentas(Persona persona, BufferedReader in) throws IOException {
	    if (persona != null) {
	        // Obtener las cuentas bancarias de la persona
	        Cuenta[] cuentas = persona.getCuentas();
	        
	        // Solicitar números de cuenta de origen y destino
	        System.out.print("Ingrese el número de cuenta de origen:");
	        String numCuentaOrigen = in.readLine();
	        System.out.print("Ingrese el número de cuenta de destino:");
	        String numCuentaDestino = in.readLine();
	        
	        // Buscar las cuentas bancarias correspondientes
	        Cuenta cuentaOrigen = null;
	        Cuenta cuentaDestino = null;
	        for (Cuenta cuenta : cuentas) {
	        	if (cuenta != null && cuenta.getNumCuenta().equals(numCuentaOrigen)) {
	        	    cuentaOrigen = cuenta;
	        	}
	        	if (cuenta != null && cuenta.getNumCuenta().equals(numCuentaDestino)) {
	        	    cuentaDestino = cuenta;
	        	}
	        }
	        
	        if (cuentaOrigen != null && cuentaDestino != null) {
	            // Solicitar monto de la transferencia
	            System.out.println("Ingrese el monto a transferir:");
	            double monto = Double.parseDouble(in.readLine());
	            
	            // Verificar que la cuenta de origen tenga saldo suficiente
	            if (cuentaOrigen.getSaldo() >= monto) {
	                // Realizar la transferencia
	                cuentaOrigen.pagarRecibo(monto);
	                cuentaDestino.recibirAbono(monto);
	                System.out.println("La transferencia se ha realizado con éxito.");
	            } else {
	                System.out.println("La cuenta de origen no tiene saldo suficiente para realizar la transferencia.");
	            }
	        } else {
	            System.out.println("No se encontraron las cuentas bancarias indicadas.");
	        }
	    } else {
	        System.out.println("No se encontró la persona indicada.");
	    }
	}

	
	/**
	 * Busca una persona por su DNI en la lista de personas.
	 * @param dni el DNI de la persona que se busca
	 * @return la persona encontrada o null si no se encuentra
	 */
	public static Persona buscarPersona(String dni, Persona[] personas) {
		Persona personaEncontrada = null;
	    int i = 0;
	    while (personaEncontrada == null && i < personas.length) {
	        if (personas[i] != null && personas[i].getDni().equals(dni)) {
	            personaEncontrada = personas[i];
	        }
	        i++;
	    }
	    return personaEncontrada;
	}
	
	
	/**
	 * Busca una cuenta por su número en la lista de cuentas de una persona.
	 * @param persona la persona a la que pertenecen las cuentas
	 * @param numCuenta el número de cuenta que se busca
	 * @return la cuenta encontrada o null si no se encuentra
	 */
	public static Cuenta buscarCuenta(Persona persona, String numCuenta) {
		Cuenta[] cuentas = persona.getCuentas();
		Cuenta cuentaEncontrada = null;
		for (int i = 0; i < cuentas.length && cuentaEncontrada == null; i++) {
			if (cuentas[i] != null && cuentas[i].getNumCuenta().equals(numCuenta)) {
				cuentaEncontrada = cuentas[i];
			}
		}
		return cuentaEncontrada;
	}

}
