package tp5relacionesuml.ejercicio12;

/**
 * Clase Impuesto - Ejemplo de ASOCIACIÓN UNIDIRECCIONAL
 * - ASOCIACIÓN UNIDIRECCIONAL con Contribuyente: el impuesto conoce al contribuyente
 * El contribuyente no conoce sus impuestos (unidireccional)
 */
public class Impuesto {
    private double monto;
    private Contribuyente contribuyente; // Asociación unidireccional
    private String tipo;
    private String periodo;
    
    // Constructor básico
    public Impuesto(double monto) {
        this.monto = monto;
    }
    
    // Constructor completo
    public Impuesto(double monto, Contribuyente contribuyente, String tipo, String periodo) {
        this.monto = monto;
        this.contribuyente = contribuyente;
        this.tipo = tipo;
        this.periodo = periodo;
    }
    
    // Getters y Setters
    public double getMonto() {
        return monto;
    }
    
    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    public Contribuyente getContribuyente() {
        return contribuyente;
    }
    
    // ASOCIACIÓN UNIDIRECCIONAL: solo el impuesto mantiene la referencia
    public void setContribuyente(Contribuyente contribuyente) {
        this.contribuyente = contribuyente;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getPeriodo() {
        return periodo;
    }
    
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
    // Método para obtener información completa del impuesto
    public String getInformacionCompleta() {
        StringBuilder info = new StringBuilder();
        info.append("Impuesto");
        
        if (tipo != null && !tipo.isEmpty()) {
            info.append(" ").append(tipo);
        }
        
        info.append(" - Monto: $").append(String.format("%.2f", monto));
        
        if (periodo != null && !periodo.isEmpty()) {
            info.append(" (").append(periodo).append(")");
        }
        
        if (contribuyente != null) {
            info.append(" - Contribuyente: ").append(contribuyente.getNombre());
            info.append(" (CUIL: ").append(contribuyente.getCuil()).append(")");
        } else {
            info.append(" - Sin contribuyente asignado");
        }
        
        return info.toString();
    }
    
    @Override
    public String toString() {
        return "Impuesto{" +
                "monto=" + String.format("%.2f", monto) +
                ", tipo='" + (tipo != null ? tipo : "Sin especificar") + '\'' +
                ", contribuyente=" + (contribuyente != null ? contribuyente.getNombre() : "Sin asignar") +
                '}';
    }
}