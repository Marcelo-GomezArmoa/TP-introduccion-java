package tp5relacionesuml.ejercicio09;

/**
 * Clase Profesional - Parte de ASOCIACIÓN UNIDIRECCIONAL
 * El profesional puede existir independientemente de las citas médicas
 * No mantiene referencias a sus citas (unidireccional desde CitaMedica)
 */
public class Profesional {
    private String nombre;
    private String especialidad;
    
    // Constructor
    public Profesional(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getEspecialidad() {
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    @Override
    public String toString() {
        return "Profesional{" +
                "nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}