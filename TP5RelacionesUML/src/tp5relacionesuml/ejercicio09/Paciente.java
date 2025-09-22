package tp5relacionesuml.ejercicio09;

/**
 * Clase Paciente - Parte de ASOCIACIÓN UNIDIRECCIONAL
 * El paciente puede existir independientemente de las citas médicas
 * No mantiene referencias a sus citas (unidireccional desde CitaMedica)
 */
public class Paciente {
    private String nombre;
    private String obraSocial;
    
    // Constructor
    public Paciente(String nombre, String obraSocial) {
        this.nombre = nombre;
        this.obraSocial = obraSocial;
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getObraSocial() {
        return obraSocial;
    }
    
    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }
    
    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", obraSocial='" + obraSocial + '\'' +
                '}';
    }
}