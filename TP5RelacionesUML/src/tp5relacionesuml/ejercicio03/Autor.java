package tp5relacionesuml.ejercicio03;

/**
 * Clase Autor - Parte de ASOCIACIÓN UNIDIRECCIONAL
 * El autor puede existir independientemente de los libros
 * No mantiene referencias a sus libros (unidireccional desde Libro)
 */
public class Autor {
    private String nombre;
    private String nacionalidad;
    
    // Constructor
    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNacionalidad() {
        return nacionalidad;
    }
    
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }
}