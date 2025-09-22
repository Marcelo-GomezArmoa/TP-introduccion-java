package tp5relacionesuml.ejercicio10;

/**
 * Clase ClaveSeguridad - Ejemplo de COMPOSICIÓN
 * La clave de seguridad NO puede existir sin la cuenta bancaria que la contiene
 * Su ciclo de vida depende completamente de la cuenta bancaria
 */
public class ClaveSeguridad {
    private String codigo;
    private String ultimaModificacion;
    
    // Constructor (solo puede ser creado por una CuentaBancaria - COMPOSICIÓN)
    public ClaveSeguridad(String codigo, String ultimaModificacion) {
        this.codigo = codigo;
        this.ultimaModificacion = ultimaModificacion;
    }
    
    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getUltimaModificacion() {
        return ultimaModificacion;
    }
    
    public void setUltimaModificacion(String ultimaModificacion) {
        this.ultimaModificacion = ultimaModificacion;
    }
    
    // Método para verificar la validez de la clave
    public boolean esValida() {
        return codigo != null && codigo.length() >= 4 && ultimaModificacion != null;
    }
    
    // Método para enmascarar la clave por seguridad
    public String getCodigoEnmascarado() {
        if (codigo == null || codigo.length() < 4) {
            return "****";
        }
        return "****" + codigo.substring(codigo.length() - 2);
    }
    
    @Override
    public String toString() {
        return "ClaveSeguridad{" +
                "codigo='" + getCodigoEnmascarado() + '\'' +
                ", ultimaModificacion='" + ultimaModificacion + '\'' +
                '}';
    }
}