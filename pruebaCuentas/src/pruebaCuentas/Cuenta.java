package pruebaCuentas;

/**
 * La clase Cuenta representa una cuenta bancaria con un número de cuenta y un saldo.
 * La clase proporciona métodos para recibir abonos en la cuenta, pagar recibos desde la cuenta
 * y validar el número de cuenta bancaria.
 * @author Charl
 * @since 2023-02-25
 * @version 1.0
 */
public class Cuenta {
    private String numCuenta;
    private double saldo;
    
    
    /**
     * Constructor de la clase Cuenta.
     * 
     * @param numCuenta El número de cuenta de la cuenta bancaria.
     * @param saldo El saldo de la cuenta bancaria.
     */
    public Cuenta(String numCuenta, double saldo) {
       if(validarCuenta(numCuenta)) {
    	   this.numCuenta = numCuenta;
    	   this.saldo = saldo;
       }else {
    	   System.err.println("Numero de la cuenta no es valido.");
       }
        
    }
    
    
    /**
     * Constructor de la Clase Cuenta que solo recibe el numero de la cuenta.
     * @param numCuenta O numero de la cuenta del banco.
     */
    public Cuenta(String numCuenta) {
        if(validarCuenta(numCuenta)) {
     	   this.numCuenta = numCuenta;
        }else {
     	   System.err.println("Numero de la cuenta no es valido.");
        }
         
     }
  
    
    /**
     * Método para obtener el número de cuenta de la cuenta bancaria.
     * 
     * @return El número de cuenta de la cuenta bancaria.
     */
    public String getNumCuenta() {
        return numCuenta;
    }
    
    
    /**
     * Método para obtener el saldo de la cuenta bancaria.
     * 
     * @return El saldo de la cuenta bancaria.
     */
    public double getSaldo() {
        return saldo;
    }
    
    
    /**
     * Método para recibir un abono en la cuenta bancaria.
     * 
     * @param cantidad La cantidad que se desea abonar en la cuenta bancaria.
     */
    public void recibirAbono(double cantidad) {
    	if(cantidad > 0) {
    		saldo += cantidad;
    		System.out.println("Operacion realizado con suceso");
    	}else {
    		System.out.println("Esta opcion no puede recebir valores negativos, para pagar algo seleccione la opcion '5'");
    	}
        
    }
    
    
    /**
     * Método para pagar un recibo desde la cuenta bancaria.
     * 
     * @param cantidad La cantidad que se desea pagar desde la cuenta bancaria.
     */
    public void pagarRecibo(double cantidad) {
        saldo -= cantidad;
        System.out.println("Pago realizado con suceso");
    }
    
    
    /**
     * Método para validar el numero de la cuenta bancaria
     * 
     * @param numero de la cuenta bancaria.
     * @return true o false
     */
    public boolean validarCuenta(String numCuenta) {
    	boolean sw = false;
    	if(numCuenta.length() <= 20) {
	    	if((numCuenta).matches("[A-Z]{2}\\d{18}")) 
	    		sw = true;
    	}
		return sw;
    }

	
}

	
