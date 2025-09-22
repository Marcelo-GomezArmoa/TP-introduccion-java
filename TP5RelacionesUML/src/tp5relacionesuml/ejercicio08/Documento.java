package tp5relacionesuml.ejercicio08;

/**
 * Clase Documento - Ejemplo de COMPOSICIÓN con FirmaDigital
 * - COMPOSICIÓN con FirmaDigital: la firma es creada y destruida con el documento
 * - La firma digital no puede existir independientemente del documento
 */
public class Documento {
    private String titulo;
    private String contenido;
    private FirmaDigital firmaDigital; // Composición
    
    // Constructor sin firma
    public Documento(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }
    
    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getContenido() {
        return contenido;
    }
    
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    public FirmaDigital getFirmaDigital() {
        return firmaDigital;
    }
    
    // COMPOSICIÓN: el documento crea y controla la firma digital
    public void firmarDocumento(Usuario usuario, String fecha) {
        // Generar hash basado en el contenido del documento
        String hash = generarHash(this.contenido);
        // Crear la firma digital internamente (COMPOSICIÓN)
        this.firmaDigital = new FirmaDigital(hash, fecha, usuario);
    }
    
    // Método para eliminar la firma (destrucción - COMPOSICIÓN)
    public void eliminarFirma() {
        this.firmaDigital = null;
    }
    
    // Método privado para generar hash (simulado)
    private String generarHash(String contenido) {
        // Simulación simple de hash - en la realidad sería más complejo
        return "HASH_" + Math.abs(contenido.hashCode());
    }
    
    // Método para verificar si el documento está firmado
    public boolean estaFirmado() {
        return firmaDigital != null && firmaDigital.esValida();
    }
    
    // Método para obtener información completa del documento
    public String getInformacionCompleta() {
        StringBuilder info = new StringBuilder();
        info.append("Documento: \"").append(titulo).append("\"");
        info.append(" (").append(contenido.length()).append(" caracteres)");
        
        if (estaFirmado()) {
            info.append(" - FIRMADO por ").append(firmaDigital.getUsuario().getNombre());
            info.append(" el ").append(firmaDigital.getFecha());
            info.append(" (Hash: ").append(firmaDigital.getCodigoHash()).append(")");
        } else {
            info.append(" - SIN FIRMAR");
        }
        
        return info.toString();
    }
    
    @Override
    public String toString() {
        return "Documento{" +
                "titulo='" + titulo + '\'' +
                ", contenido='" + (contenido.length() > 50 ? 
                    contenido.substring(0, 50) + "..." : contenido) + '\'' +
                ", firmado=" + estaFirmado() +
                '}';
    }
}