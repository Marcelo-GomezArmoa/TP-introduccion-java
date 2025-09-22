package tp5relacionesuml.ejercicio03;

/**
 * Clase Editorial - Ejemplo de AGREGACIÓN
 * La editorial puede existir independientemente de los libros
 * Puede publicar múltiples libros de diferentes autores
 */
public class Editorial {
    private String nombre;
    private String direccion;
    
    // Constructor
    public Editorial(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    @Override
    public String toString() {
        return "Editorial{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}