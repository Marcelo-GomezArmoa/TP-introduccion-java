package tp5relacionesuml.ejercicio07;

/**
 * Clase Conductor - Ejemplo de ASOCIACIÓN BIDIRECCIONAL
 * El conductor puede existir independientemente del vehículo
 * Mantiene una referencia a su vehículo actual (si lo tiene)
 */
public class Conductor {
    private String nombre;
    private String licencia;
    private Vehiculo vehiculo; // Referencia bidireccional
    
    // Constructor
    public Conductor(String nombre, String licencia) {
        this.nombre = nombre;
        this.licencia = licencia;
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getLicencia() {
        return licencia;
    }
    
    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }
    
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    
    // Método para establecer la relación bidireccional
    public void setVehiculo(Vehiculo vehiculo) {
        // Evitar recursión infinita si ya es el mismo vehículo
        if (this.vehiculo == vehiculo) {
            return;
        }
        
        // Guardar referencia del vehículo anterior
        Vehiculo vehiculoAnterior = this.vehiculo;
        
        // Asignar el nuevo vehículo
        this.vehiculo = vehiculo;
        
        // Remover relación anterior si existía
        if (vehiculoAnterior != null) {
            vehiculoAnterior.setConductor(null);
        }
        
        // Establecer la relación bidireccional
        if (vehiculo != null && vehiculo.getConductor() != this) {
            vehiculo.setConductor(this);
        }
    }
    
    @Override
    public String toString() {
        return "Conductor{" +
                "nombre='" + nombre + '\'' +
                ", licencia='" + licencia + '\'' +
                ", tieneVehiculo=" + (vehiculo != null) +
                '}';
    }
}