package tp5relacionesuml.ejercicio08;

/**
 * Clase FirmaDigital - Ejemplo de COMPOSICIÓN y AGREGACIÓN
 * - COMPOSICIÓN: parte del Documento (no puede existir sin él)
 * - AGREGACIÓN con Usuario: el usuario puede existir independientemente
 */
public class FirmaDigital {
    private String codigoHash;
    private String fecha;
    private Usuario usuario; // Agregación
    
    // Constructor (solo puede ser creado por un Documento - COMPOSICIÓN)
    public FirmaDigital(String codigoHash, String fecha, Usuario usuario) {
        this.codigoHash = codigoHash;
        this.fecha = fecha;
        this.usuario = usuario;
    }
    
    // Getters y Setters
    public String getCodigoHash() {
        return codigoHash;
    }
    
    public void setCodigoHash(String codigoHash) {
        this.codigoHash = codigoHash;
    }
    
    public String getFecha() {
        return fecha;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    // AGREGACIÓN: se permite cambiar el usuario firmante
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    // Método para verificar validez de la firma
    public boolean esValida() {
        return codigoHash != null && !codigoHash.isEmpty() && 
               fecha != null && !fecha.isEmpty() && usuario != null;
    }
    
    @Override
    public String toString() {
        return "FirmaDigital{" +
                "codigoHash='" + codigoHash + '\'' +
                ", fecha='" + fecha + '\'' +
                ", usuario=" + (usuario != null ? usuario.getNombre() : "Sin usuario") +
                '}';
    }
}