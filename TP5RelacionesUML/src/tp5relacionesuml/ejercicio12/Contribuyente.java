package tp5relacionesuml.ejercicio12;

/**
 * Clase Contribuyente - Parte de ASOCIACIÓN UNIDIRECCIONAL
 * El contribuyente puede existir independientemente de los impuestos
 * No mantiene referencias a sus impuestos (unidireccional desde Impuesto)
 */
public class Contribuyente {
    private String nombre;
    private String cuil;
    
    // Constructor
    public Contribuyente(String nombre, String cuil) {
        this.nombre = nombre;
        this.cuil = cuil;
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCuil() {
        return cuil;
    }
    
    public void setCuil(String cuil) {
        this.cuil = cuil;
    }
    
    @Override
    public String toString() {
        return "Contribuyente{" +
                "nombre='" + nombre + '\'' +
                ", cuil='" + cuil + '\'' +
                '}';
    }
}