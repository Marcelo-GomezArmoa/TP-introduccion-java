package tp5relacionesuml.ejercicio04;

/**
 * Clase Cliente - Ejemplo de ASOCIACIÓN BIDIRECCIONAL
 * El cliente puede existir independientemente de la tarjeta de crédito
 * Mantiene una referencia a su tarjeta de crédito (si la tiene)
 */
public class Cliente {
    private String nombre;
    private String dni;
    private TarjetaDeCredito tarjetaDeCredito; // Referencia bidireccional

    // Constructor
    public Cliente(String nombre, String dni) {
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

    public TarjetaDeCredito getTarjetaDeCredito() {
        return tarjetaDeCredito;
    }

    // Método para establecer la relación bidireccional
    public void setTarjetaDeCredito(TarjetaDeCredito tarjetaDeCredito) {
        // Evitar bucle infinito - verificar si es el mismo valor
        if (this.tarjetaDeCredito == tarjetaDeCredito) {
            return;
        }

        // Guardar referencia anterior para limpiarla después
        TarjetaDeCredito tarjetaAnterior = this.tarjetaDeCredito;

        // Asignar nueva tarjeta primero
        this.tarjetaDeCredito = tarjetaDeCredito;

        // Limpiar relación anterior si existe
        if (tarjetaAnterior != null && tarjetaAnterior.getCliente() == this) {
            tarjetaAnterior.setCliente(null);
        }

        // Establecer la relación bidireccional
        if (tarjetaDeCredito != null && tarjetaDeCredito.getCliente() != this) {
            tarjetaDeCredito.setCliente(this);
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", tieneTarjeta=" + (tarjetaDeCredito != null) +
                '}';
    }
}
