package tp5relacionesuml.ejercicio11;

/**
 * Clase Artista - Parte de ASOCIACIÓN UNIDIRECCIONAL
 * El artista puede existir independientemente de las canciones
 * No mantiene referencias a sus canciones (unidireccional desde Cancion)
 */
public class Artista {
    private String nombre;
    private String genero;
    
    // Constructor
    public Artista(String nombre, String genero) {
        this.nombre = nombre;
        this.genero = genero;
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    @Override
    public String toString() {
        return "Artista{" +
                "nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}