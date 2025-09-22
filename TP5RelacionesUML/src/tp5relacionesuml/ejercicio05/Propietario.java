package tp5relacionesuml.ejercicio05;

/**
 * Clase Propietario - Ejemplo de ASOCIACIÓN BIDIRECCIONAL
 * El propietario puede existir independientemente de la computadora
 * Mantiene una referencia a su computadora (si la tiene)
 */
public class Propietario {
    private String nombre;
    private String dni;
    private Computadora computadora; // Referencia bidireccional

    // Constructor
    public Propietario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Computadora getComputadora() {
        return computadora;
    }

    // Método para establecer la relación bidireccional
    public void setComputadora(Computadora computadora) {
        // Evitar bucle infinito - verificar si es el mismo valor
        if (this.computadora == computadora) {
            return;
        }

        // Guardar referencia anterior para limpiarla después
        Computadora computadoraAnterior = this.computadora;

        // Asignar nueva computadora primero
        this.computadora = computadora;

        // Limpiar relación anterior si existe
        if (computadoraAnterior != null && computadoraAnterior.getPropietario() == this) {
            computadoraAnterior.setPropietario(null);
        }

        // Establecer la relación bidireccional
        if (computadora != null && computadora.getPropietario() != this) {
            computadora.setPropietario(this);
        }
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", tieneComputadora=" + (computadora != null) +
                '}';
    }
}
