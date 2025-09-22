package tp5relacionesuml.ejercicio02;

/**
 * Clase Batería - Ejemplo de AGREGACIÓN
 * La batería puede existir independientemente del celular
 * Puede ser reutilizada en diferentes celulares
 */
public class Bateria {
    private String modelo;
    private int capacidad; // en mAh
    
    // Constructor
    public Bateria(String modelo, int capacidad) {
        this.modelo = modelo;
        this.capacidad = capacidad;
    }
    
    // Getters y Setters
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public int getCapacidad() {
        return capacidad;
    }
    
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    @Override
    public String toString() {
        return "Bateria{" +
                "modelo='" + modelo + '\'' +
                ", capacidad=" + capacidad + "mAh" +
                '}';
    }
}