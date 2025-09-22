package tp5relacionesuml.ejercicio06;

/**
 * Clase Cliente - Parte de ASOCIACIÓN UNIDIRECCIONAL
 * El cliente puede existir independientemente de las reservas
 * No mantiene referencias a sus reservas (unidireccional desde Reserva)
 */
public class Cliente {
    private String nombre;
    private String telefono;
    
    // Constructor
    public Cliente(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}