package tp5relacionesuml.ejercicio06;

/**
 * Clase Mesa - Ejemplo de AGREGACIÓN
 * La mesa puede existir independientemente de las reservas
 * Puede ser utilizada en múltiples reservas a lo largo del tiempo
 */
public class Mesa {
    private int numero;
    private int capacidad;
    
    // Constructor
    public Mesa(int numero, int capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
    }
    
    // Getters y Setters
    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public int getCapacidad() {
        return capacidad;
    }
    
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    @Override
    public String toString() {
        return "Mesa{" +
                "numero=" + numero +
                ", capacidad=" + capacidad + " personas" +
                '}';
    }
}