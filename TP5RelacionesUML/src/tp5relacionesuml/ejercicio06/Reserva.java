package tp5relacionesuml.ejercicio06;

/**
 * Clase Reserva - Ejemplo de ASOCIACIÓN UNIDIRECCIONAL y AGREGACIÓN
 * - ASOCIACIÓN UNIDIRECCIONAL con Cliente: la reserva conoce al cliente
 * - AGREGACIÓN con Mesa: la mesa puede existir independientemente
 */
public class Reserva {
    private String fecha;
    private String hora;
    private Cliente cliente; // Asociación unidireccional
    private Mesa mesa;       // Agregación
    
    // Constructor
    public Reserva(String fecha, String hora) {
        this.fecha = fecha;
        this.hora = hora;
    }
    
    // Constructor completo
    public Reserva(String fecha, String hora, Cliente cliente, Mesa mesa) {
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.mesa = mesa;
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
    
    public Cliente getCliente() {
        return cliente;
    }
    
    // ASOCIACIÓN UNIDIRECCIONAL: solo la reserva mantiene la referencia
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Mesa getMesa() {
        return mesa;
    }
    
    // AGREGACIÓN: se permite cambiar la mesa
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    
    // Método para verificar si la reserva está completa
    public boolean estaCompleta() {
        return cliente != null && mesa != null;
    }
    
    // Método para obtener información completa de la reserva
    public String getInformacionCompleta() {
        StringBuilder info = new StringBuilder();
        info.append("Reserva para el ").append(fecha).append(" a las ").append(hora);
        
        if (cliente != null) {
            info.append(" - Cliente: ").append(cliente.getNombre());
            info.append(" (").append(cliente.getTelefono()).append(")");
        } else {
            info.append(" - Sin cliente asignado");
        }
        
        if (mesa != null) {
            info.append(" - Mesa: ").append(mesa.getNumero());
            info.append(" (").append(mesa.getCapacidad()).append(" personas)");
        } else {
            info.append(" - Sin mesa asignada");
        }
        
        return info.toString();
    }
    
    @Override
    public String toString() {
        return "Reserva{" +
                "fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", cliente=" + (cliente != null ? cliente.getNombre() : "Sin cliente") +
                ", mesa=" + (mesa != null ? "Mesa " + mesa.getNumero() : "Sin mesa") +
                '}';
    }
}