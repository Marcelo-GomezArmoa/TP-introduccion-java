package tp5relacionesuml.ejercicio13;

/**
 * Clase CodigoQR - Ejemplo de ASOCIACIÓN UNIDIRECCIONAL
 * - ASOCIACIÓN UNIDIRECCIONAL con Usuario: el código QR conoce al usuario que lo generó
 * El usuario no conoce sus códigos QR (unidireccional)
 * Esta clase es creada por DEPENDENCIA DE CREACIÓN desde GeneradorQR
 */
public class CodigoQR {
    private String valor;
    private Usuario usuario; // Asociación unidireccional
    private String fechaCreacion;
    private String tipoContenido;
    
    // Constructor (solo puede ser creado por GeneradorQR - DEPENDENCIA DE CREACIÓN)
    public CodigoQR(String valor, Usuario usuario) {
        this.valor = valor;
        this.usuario = usuario;
        this.fechaCreacion = java.time.LocalDateTime.now().toString();
        this.tipoContenido = determinarTipoContenido(valor);
    }
    
    // Getters y Setters
    public String getValor() {
        return valor;
    }
    
    public void setValor(String valor) {
        this.valor = valor;
        this.tipoContenido = determinarTipoContenido(valor);
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    // ASOCIACIÓN UNIDIRECCIONAL: solo el código QR mantiene la referencia
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String getFechaCreacion() {
        return fechaCreacion;
    }
    
    public String getTipoContenido() {
        return tipoContenido;
    }
    
    // Método privado para determinar el tipo de contenido
    private String determinarTipoContenido(String valor) {
        if (valor == null || valor.isEmpty()) {
            return "Vacío";
        } else if (valor.startsWith("http://") || valor.startsWith("https://")) {
            return "URL";
        } else if (valor.contains("@") && valor.contains(".")) {
            return "Email";
        } else if (valor.matches("\\+?\\d[\\d\\s\\-\\(\\)]{7,}")) {
            return "Teléfono";
        } else if (valor.startsWith("wifi:")) {
            return "WiFi";
        } else {
            return "Texto";
        }
    }
    
    // Método para obtener información completa del código QR
    public String getInformacionCompleta() {
        StringBuilder info = new StringBuilder();
        info.append("Código QR (").append(tipoContenido).append(")");
        info.append(" - Valor: \"").append(valor).append("\"");
        
        if (usuario != null) {
            info.append(" - Generado por: ").append(usuario.getNombre());
            info.append(" (").append(usuario.getEmail()).append(")");
        } else {
            info.append(" - Sin usuario asociado");
        }
        
        info.append(" - Fecha: ").append(fechaCreacion.substring(0, 19));
        
        return info.toString();
    }
    
    // Método para generar representación visual simple del QR
    public String getRepresentacionVisual() {
        return "████████████████████\n" +
               "██   ██   ██   ██   ██\n" +
               "██ ██ ██ ██ ██ ██ ██ ██\n" +
               "██   ██   ██   ██   ██\n" +
               "████████████████████\n" +
               "Contenido: " + (valor.length() > 20 ? valor.substring(0, 20) + "..." : valor);
    }
    
    @Override
    public String toString() {
        return "CodigoQR{" +
                "valor='" + (valor.length() > 30 ? valor.substring(0, 30) + "..." : valor) + '\'' +
                ", tipoContenido='" + tipoContenido + '\'' +
                ", usuario=" + (usuario != null ? usuario.getNombre() : "Sin usuario") +
                '}';
    }
}