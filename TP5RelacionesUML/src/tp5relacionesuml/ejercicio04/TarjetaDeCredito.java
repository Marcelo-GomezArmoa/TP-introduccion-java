package tp5relacionesuml.ejercicio04;

/**
 * Clase TarjetaDeCredito - Ejemplo de ASOCIACIÓN BIDIRECCIONAL y AGREGACIÓN
 * - ASOCIACIÓN BIDIRECCIONAL con Cliente: ambos se conocen mutuamente
 * - AGREGACIÓN con Banco: el banco puede existir independientemente
 */
public class TarjetaDeCredito {
    private String numero;
    private String fechaVencimiento;
    private Cliente cliente;  // Asociación bidireccional
    private Banco banco;      // Agregación

    // Constructor
    public TarjetaDeCredito(String numero, String fechaVencimiento) {
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
    }

    // Constructor con banco
    public TarjetaDeCredito(String numero, String fechaVencimiento, Banco banco) {
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.banco = banco;
    }

    // Getters y Setters
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    // Método para establecer la relación bidireccional
    public void setCliente(Cliente cliente) {
        // Evitar bucle infinito - verificar si es el mismo valor
        if (this.cliente == cliente) {
            return;
        }

        // Guardar referencia anterior para limpiarla después
        Cliente clienteAnterior = this.cliente;

        // Asignar nuevo cliente primero
        this.cliente = cliente;

        // Limpiar relación anterior si existe
        if (clienteAnterior != null && clienteAnterior.getTarjetaDeCredito() == this) {
            clienteAnterior.setTarjetaDeCredito(null);
        }

        // Establecer la relación bidireccional
        if (cliente != null && cliente.getTarjetaDeCredito() != this) {
            cliente.setTarjetaDeCredito(this);
        }
    }

    public Banco getBanco() {
        return banco;
    }

    // AGREGACIÓN: se permite cambiar el banco emisor
    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    // Método para obtener información completa de la tarjeta
    public String getInformacionCompleta() {
        StringBuilder info = new StringBuilder();
        info.append("Tarjeta ****").append(numero.substring(numero.length() - 4));

        if (banco != null) {
            info.append(" del ").append(banco.getNombre());
        }

        if (cliente != null) {
            info.append(" de ").append(cliente.getNombre());
        }

        info.append(" (Vence: ").append(fechaVencimiento).append(")");

        return info.toString();
    }

    @Override
    public String toString() {
        return "TarjetaDeCredito{" +
                "numero='****" + numero.substring(numero.length() - 4) + '\'' +
                ", fechaVencimiento='" + fechaVencimiento + '\'' +
                ", cliente=" + (cliente != null ? cliente.getNombre() : "Sin cliente") +
                ", banco=" + (banco != null ? banco.getNombre() : "Sin banco") +
                '}';
    }
}
