package tp5relacionesuml.ejercicio09;

/**
 * Clase CitaMedica - Ejemplo de ASOCIACIONES UNIDIRECCIONALES
 * - ASOCIACIÓN UNIDIRECCIONAL con Paciente: la cita conoce al paciente
 * - ASOCIACIÓN UNIDIRECCIONAL con Profesional: la cita conoce al profesional
 * Ni el paciente ni el profesional conocen sus citas (unidireccional)
 */
public class CitaMedica {
    private String fecha;
    private String hora;
    private Paciente paciente;       // Asociación unidireccional
    private Profesional profesional; // Asociación unidireccional
    
    // Constructor básico
    public CitaMedica(String fecha, String hora) {
        this.fecha = fecha;
        this.hora = hora;
    }
    
    // Constructor completo
    public CitaMedica(String fecha, String hora, Paciente paciente, Profesional profesional) {
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.profesional = profesional;
    }
    
    // Getters y Setters
    public String getFecha() {
        return fecha;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public String getHora() {
        return hora;
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public Paciente getPaciente() {
        return paciente;
    }
    
    // ASOCIACIÓN UNIDIRECCIONAL: solo la cita mantiene la referencia al paciente
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public Profesional getProfesional() {
        return profesional;
    }
    
    // ASOCIACIÓN UNIDIRECCIONAL: solo la cita mantiene la referencia al profesional
    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }
    
    // Método para verificar si la cita está completa
    public boolean estaCompleta() {
        return paciente != null && profesional != null;
    }
    
    // Método para obtener información completa de la cita
    public String getInformacionCompleta() {
        StringBuilder info = new StringBuilder();
        info.append("Cita médica el ").append(fecha).append(" a las ").append(hora);
        
        if (paciente != null) {
            info.append("\n  Paciente: ").append(paciente.getNombre());
            info.append(" (").append(paciente.getObraSocial()).append(")");
        } else {
            info.append("\n  Paciente: No asignado");
        }
        
        if (profesional != null) {
            info.append("\n  Profesional: ").append(profesional.getNombre());
            info.append(" (").append(profesional.getEspecialidad()).append(")");
        } else {
            info.append("\n  Profesional: No asignado");
        }
        
        return info.toString();
    }
    
    // Método para verificar compatibilidad de especialidad (ejemplo de lógica de negocio)
    public boolean esEspecialidadCompatible() {
        if (profesional == null) return false;
        
        // Lógica simple de compatibilidad - en la realidad sería más compleja
        String especialidad = profesional.getEspecialidad().toLowerCase();
        return especialidad.contains("medicina") || especialidad.contains("cardiología") || 
               especialidad.contains("neurología") || especialidad.contains("pediatría") ||
               especialidad.contains("ginecología") || especialidad.contains("traumatología");
    }
    
    @Override
    public String toString() {
        return "CitaMedica{" +
                "fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", paciente=" + (paciente != null ? paciente.getNombre() : "Sin paciente") +
                ", profesional=" + (profesional != null ? profesional.getNombre() : "Sin profesional") +
                '}';
    }
}