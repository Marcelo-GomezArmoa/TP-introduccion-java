package tp5relacionesuml.ejercicio10;

/**
 * Clase Titular - Ejemplo de ASOCIACIÓN BIDIRECCIONAL
 * El titular puede existir independientemente de la cuenta bancaria
 * Mantiene una referencia a su cuenta bancaria (si la tiene)
 */
public class Titular {
    private String nombre;
    private String dni;
    private CuentaBancaria cuentaBancaria; // Referencia bidireccional
    
    // Constructor
    public Titular(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDni() {
        return dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }
    
    // Método para establecer la relación bidireccional
    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        // Evitar recursión infinita si ya es la misma cuenta
        if (this.cuentaBancaria == cuentaBancaria) {
            return;
        }
        
        // Guardar referencia de la cuenta anterior
        CuentaBancaria cuentaAnterior = this.cuentaBancaria;
        
        // Asignar la nueva cuenta
        this.cuentaBancaria = cuentaBancaria;
        
        // Remover relación anterior si existía
        if (cuentaAnterior != null) {
            cuentaAnterior.setTitular(null);
        }
        
        // Establecer la relación bidireccional
        if (cuentaBancaria != null && cuentaBancaria.getTitular() != this) {
            cuentaBancaria.setTitular(this);
        }
    }
    
    @Override
    public String toString() {
        return "Titular{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", tieneCuenta=" + (cuentaBancaria != null) +
                '}';
    }
}