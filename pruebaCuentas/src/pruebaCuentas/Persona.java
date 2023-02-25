package pruebaCuentas;

/**
 * Clase que representa a una persona que puede tener una o varias cuentas bancarias.
 * @author Charl
 * @since 2023-02-25
 * @version 1.0
 */
public class Persona {
	private String dni;
	private Cuenta[] cuentas = new Cuenta[3];
	private int numCuentas = 0;

	
	/**
	 * Constructor de la clase Persona que recibe como parámetro el DNI.
	 * 
	 * @param dni El DNI de la persona.
	 */
	public Persona(String dni) {
		if (validarDNI(dni)) {
			this.dni = dni;
			System.out.println("Persona introduzida con suceso");
		} else {
			System.err.println("El DNI introduzido no es valido.");
		}
	}

	
	/**
	 * Método para obtener las cuentas bancarias de la persona.
	 * 
	 * @return El arreglo de objetos Cuenta que contiene las cuentas bancarias de la
	 *         persona.
	 */
	public Cuenta[] getCuentas() {
		return cuentas;
	}

	
	/**
	 * Método para añadir una cuenta bancaria a la persona.
	 * 
	 * @param cuenta La cuenta bancaria que se desea añadir.
	 */
	public void anadirCuenta(Cuenta cuenta) {
		if (validarDNI(dni)) {
			if(cuenta.validarCuenta(cuenta.getNumCuenta())) {
				if (numCuentas < 3) {
					cuentas[numCuentas] = cuenta;
					numCuentas++;
					System.out.println("Cuenda añadida con suceso");
				} else {
					System.out.println("La persona ya tiene el número máximo de cuentas bancarias (3)");
				}
			}
		}
	}

	
	/**
	 * Método para obtener el DNI de la persona.
	 * 
	 * @return El DNI de la persona.
	 */
	public String getDni() {
		return dni;
	}

	
	/**
	 * Método para establecer el DNI de la persona.
	 * 
	 * @param dni El DNI que se desea establecer.
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	
	/**
	 * Método que retorna si la persona es morosa o no, es decir, si tiene alguna cuenta con saldo negativo.
	 * 
	 * @return true si la persona es morosa, false en caso contrario.
	 */
	public boolean esMorosa() {
		boolean sw = false;

		for (int i = 0; i < numCuentas; i++) {
			if ((cuentas[i]).getSaldo() < 0) {
				sw = true;
			} else {
				sw = false;
			}
		}
		return sw;
	}

	
	/**
	 * Método para validar DNI.
	 * 
	 * @param dni El DNI que se desea validar.
	 * @return true si el DNI es válido, false en caso contrario.
	 */
	private boolean validarDNI(String dni) {
		boolean sw = false;
		if (dni.matches("\\d{8}[A-Z]"))
			sw = true;
		else
			sw = false;
		return sw;

	}
	

}
