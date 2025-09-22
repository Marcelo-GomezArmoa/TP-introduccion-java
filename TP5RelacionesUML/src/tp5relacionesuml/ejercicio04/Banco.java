package tp5relacionesuml.ejercicio04;

/**
 * Clase Banco - Ejemplo de AGREGACIÓN
 * El banco puede existir independientemente de las tarjetas de crédito
 * Puede emitir múltiples tarjetas para diferentes clientes
 */
public class Banco {
    private String nombre;
    private String cuit;
    
    // Constructor
    public Banco(String nombre, String cuit) {
        this.nombre = nombre;
        this.cuit = cuit;
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCuit() {
        return cuit;
    }
    
    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
    
    @Override
    public String toString() {
        return "Banco{" +
                "nombre='" + nombre + '\'' +
                ", cuit='" + cuit + '\'' +
                '}';
    }
}