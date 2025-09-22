package tp5relacionesuml.ejercicio01;

/**
 * Clase Titular - Ejemplo de ASOCIACIÓN BIDIRECCIONAL
 * El titular puede existir independientemente del pasaporte
 * Mantiene una referencia al pasaporte (si lo tiene)
 */
public class Titular {
    private String nombre;
    private String dni;
    private Pasaporte pasaporte; // Referencia bidireccional
    
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
    
    public Pasaporte getPasaporte() {
        return pasaporte;
    }
    
    // Método para establecer la relación bidireccional
    public void setPasaporte(Pasaporte pasaporte) {
        // Evitar bucle infinito: solo proceder si hay cambio real
        if (this.pasaporte == pasaporte) {
            return; // No hay cambio, evitar bucle
        }
        
        // Eliminar relación anterior si existe
        if (this.pasaporte != null) {
            Pasaporte anteriorPasaporte = this.pasaporte;
            this.pasaporte = null; // Cortar referencia primero
            anteriorPasaporte.setTitular(null); // Luego notificar
        }
        
        this.pasaporte = pasaporte;
        
        // Establecer la relación bidireccional
        if (pasaporte != null && pasaporte.getTitular() != this) {
            pasaporte.setTitular(this);
        }
    }
    
    @Override
    public String toString() {
        return "Titular{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", tienePasaporte=" + (pasaporte != null) +
                '}';
    }
}