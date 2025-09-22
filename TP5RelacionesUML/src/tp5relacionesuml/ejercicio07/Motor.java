package tp5relacionesuml.ejercicio07;

/**
 * Clase Motor - Ejemplo de AGREGACIÓN
 * El motor puede existir independientemente del vehículo
 * Puede ser reutilizado en diferentes vehículos o vendido por separado
 */
public class Motor {
    private String tipo;
    private String numeroSerie;
    
    // Constructor
    public Motor(String tipo, String numeroSerie) {
        this.tipo = tipo;
        this.numeroSerie = numeroSerie;
    }
    
    // Getters y Setters
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getNumeroSerie() {
        return numeroSerie;
    }
    
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    
    @Override
    public String toString() {
        return "Motor{" +
                "tipo='" + tipo + '\'' +
                ", numeroSerie='" + numeroSerie + '\'' +
                '}';
    }
}