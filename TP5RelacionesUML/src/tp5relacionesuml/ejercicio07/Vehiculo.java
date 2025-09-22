package tp5relacionesuml.ejercicio07;

/**
 * Clase Vehiculo - Ejemplo de AGREGACIÓN y ASOCIACIÓN BIDIRECCIONAL
 * - AGREGACIÓN con Motor: el motor puede existir independientemente
 * - ASOCIACIÓN BIDIRECCIONAL con Conductor: ambos se conocen mutuamente
 */
public class Vehiculo {
    private String patente;
    private String modelo;
    private Conductor conductor; // Asociación bidireccional
    private Motor motor;         // Agregación
    
    // Constructor
    public Vehiculo(String patente, String modelo) {
        this.patente = patente;
        this.modelo = modelo;
    }
    
    // Constructor con motor
    public Vehiculo(String patente, String modelo, Motor motor) {
        this.patente = patente;
        this.modelo = modelo;
        this.motor = motor;
    }
    
    // Getters y Setters
    public String getPatente() {
        return patente;
    }
    
    public void setPatente(String patente) {
        this.patente = patente;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public Conductor getConductor() {
        return conductor;
    }
    
    // Método para establecer la relación bidireccional
    public void setConductor(Conductor conductor) {
        // Evitar recursión infinita si ya es el mismo conductor
        if (this.conductor == conductor) {
            return;
        }
        
        // Guardar referencia del conductor anterior
        Conductor conductorAnterior = this.conductor;
        
        // Asignar el nuevo conductor
        this.conductor = conductor;
        
        // Remover relación anterior si existía
        if (conductorAnterior != null) {
            conductorAnterior.setVehiculo(null);
        }
        
        // Establecer la relación bidireccional
        if (conductor != null && conductor.getVehiculo() != this) {
            conductor.setVehiculo(this);
        }
    }
    
    public Motor getMotor() {
        return motor;
    }
    
    // AGREGACIÓN: se permite cambiar el motor externamente
    public void setMotor(Motor motor) {
        this.motor = motor;
    }
    
    // Método para cambiar motor (típico en talleres mecánicos)
    public void cambiarMotor(Motor nuevoMotor) {
        this.motor = nuevoMotor;
    }
    
    // Método para obtener información completa del vehículo
    public String getInformacionCompleta() {
        StringBuilder info = new StringBuilder();
        info.append("Vehículo ").append(modelo).append(" (").append(patente).append(")");
        
        if (motor != null) {
            info.append(" - Motor: ").append(motor.getTipo());
            info.append(" (S/N: ").append(motor.getNumeroSerie()).append(")");
        } else {
            info.append(" - Sin motor");
        }
        
        if (conductor != null) {
            info.append(" - Conductor: ").append(conductor.getNombre());
            info.append(" (Lic: ").append(conductor.getLicencia()).append(")");
        } else {
            info.append(" - Sin conductor");
        }
        
        return info.toString();
    }
    
    @Override
    public String toString() {
        return "Vehiculo{" +
                "patente='" + patente + '\'' +
                ", modelo='" + modelo + '\'' +
                ", conductor=" + (conductor != null ? conductor.getNombre() : "Sin conductor") +
                ", motor=" + (motor != null ? motor.getTipo() : "Sin motor") +
                '}';
    }
}