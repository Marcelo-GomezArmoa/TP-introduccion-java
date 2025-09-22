package tp5relacionesuml.ejercicio10;

/*    // Método para establecer la relación bidireccional
    public void setTitular(Titular titular) {
        // Evitar recursión infinita si ya es el mismo titular
        if (this.titular == titular) {
            return;
        }
        
        // Guardar referencia del titular anterior
        Titular titularAnterior = this.titular;
        
        // Asignar el nuevo titular
        this.titular = titular;
        
        // Remover relación anterior si existía
        if (titularAnterior != null) {
            titularAnterior.setCuentaBancaria(null);
        }
        
        // Establecer la relación bidireccional
        if (titular != null && titular.getCuentaBancaria() != this) {
            titular.setCuentaBancaria(this);
        }
    }entaBancaria - Ejemplo de COMPOSICIÓN y ASOCIACIÓN BIDIRECCIONAL
 * - COMPOSICIÓN con ClaveSeguridad: la clave es creada y destruida con la cuenta
 * - ASOCIACIÓN BIDIRECCIONAL con Titular: ambos se conocen mutuamente
 */
public class CuentaBancaria {
    private String cbu;
    private double saldo;
    private Titular titular;            // Asociación bidireccional
    private ClaveSeguridad claveSeguridad; // Composición
    
    // Constructor que crea la clave de seguridad internamente (COMPOSICIÓN)
    public CuentaBancaria(String cbu, double saldoInicial, String claveInicial) {
        this.cbu = cbu;
        this.saldo = saldoInicial;
        // COMPOSICIÓN: la cuenta crea y controla la clave de seguridad
        this.claveSeguridad = new ClaveSeguridad(claveInicial, 
            java.time.LocalDateTime.now().toString());
    }
    
    // Getters y Setters
    public String getCbu() {
        return cbu;
    }
    
    public void setCbu(String cbu) {
        this.cbu = cbu;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public Titular getTitular() {
        return titular;
    }
    
    // Método para establecer la relación bidireccional
    public void setTitular(Titular titular) {
        // Eliminar relación anterior si existe
        if (this.titular != null) {
            this.titular.setCuentaBancaria(null);
        }
        
        this.titular = titular;
        
        // Establecer la relación bidireccional
        if (titular != null && titular.getCuentaBancaria() != this) {
            titular.setCuentaBancaria(this);
        }
    }
    
    public ClaveSeguridad getClaveSeguridad() {
        return claveSeguridad;
    }
    
    // NO se permite cambiar la clave externamente de forma directa (COMPOSICIÓN)
    // Solo se permite mediante métodos controlados de la cuenta
    public boolean cambiarClave(String claveActual, String claveNueva) {
        if (claveSeguridad != null && claveSeguridad.getCodigo().equals(claveActual)) {
            // Crear nueva clave de seguridad (COMPOSICIÓN)
            this.claveSeguridad = new ClaveSeguridad(claveNueva, 
                java.time.LocalDateTime.now().toString());
            return true;
        }
        return false;
    }
    
    // Método para validar la clave
    public boolean validarClave(String clave) {
        return claveSeguridad != null && claveSeguridad.getCodigo().equals(clave);
    }
    
    // Métodos bancarios básicos
    public boolean depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            return true;
        }
        return false;
    }
    
    public boolean retirar(double monto, String clave) {
        if (validarClave(clave) && monto > 0 && monto <= saldo) {
            this.saldo -= monto;
            return true;
        }
        return false;
    }
    
    // Método para obtener información completa de la cuenta
    public String getInformacionCompleta() {
        StringBuilder info = new StringBuilder();
        info.append("Cuenta CBU: ").append(cbu);
        info.append(" - Saldo: $").append(String.format("%.2f", saldo));
        
        if (titular != null) {
            info.append(" - Titular: ").append(titular.getNombre());
            info.append(" (DNI: ").append(titular.getDni()).append(")");
        } else {
            info.append(" - Sin titular");
        }
        
        if (claveSeguridad != null) {
            info.append(" - Clave: ").append(claveSeguridad.getCodigoEnmascarado());
            info.append(" (Modificada: ").append(claveSeguridad.getUltimaModificacion()).append(")");
        }
        
        return info.toString();
    }
    
    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "cbu='" + cbu + '\'' +
                ", saldo=" + String.format("%.2f", saldo) +
                ", titular=" + (titular != null ? titular.getNombre() : "Sin titular") +
                ", claveSeguridad=" + (claveSeguridad != null ? claveSeguridad.getCodigoEnmascarado() : "Sin clave") +
                '}';
    }
}