package tp5relacionesuml.ejercicio14;

/**
 * Clase que representa un proyecto de edición de video.
 * En este ejercicio demuestra:
 * - ASOCIACIÓN UNIDIRECCIONAL con EditorVideo (Proyecto → EditorVideo)
 */
public class Proyecto {
    private String nombre;
    private String descripcion;
    private String rutaArchivos;
    private EditorVideo editorVideo; // ASOCIACIÓN UNIDIRECCIONAL
    private long fechaCreacion;
    private long fechaModificacion;
    private boolean activo;
    private String estado;
    
    public Proyecto(String nombre, String descripcion, String rutaArchivos, EditorVideo editorVideo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutaArchivos = rutaArchivos;
        this.editorVideo = editorVideo; // ASOCIACIÓN UNIDIRECCIONAL
        this.fechaCreacion = System.currentTimeMillis();
        this.fechaModificacion = this.fechaCreacion;
        this.activo = true;
        this.estado = "CREADO";
    }
    
    // Constructor adicional sin editor (será asignado después)
    public Proyecto(String nombre, String descripcion, String rutaArchivos) {
        this(nombre, descripcion, rutaArchivos, null);
    }
    
    // Getters y setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
        actualizarFechaModificacion();
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        actualizarFechaModificacion();
    }
    
    public String getRutaArchivos() {
        return rutaArchivos;
    }
    
    public void setRutaArchivos(String rutaArchivos) {
        this.rutaArchivos = rutaArchivos;
        actualizarFechaModificacion();
    }
    
    public EditorVideo getEditorVideo() {
        return editorVideo; // ASOCIACIÓN UNIDIRECCIONAL
    }
    
    public void setEditorVideo(EditorVideo editorVideo) {
        this.editorVideo = editorVideo; // ASOCIACIÓN UNIDIRECCIONAL
        actualizarFechaModificacion();
    }
    
    public long getFechaCreacion() {
        return fechaCreacion;
    }
    
    public long getFechaModificacion() {
        return fechaModificacion;
    }
    
    public boolean isActivo() {
        return activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
        this.estado = activo ? "ACTIVO" : "PAUSADO";
        actualizarFechaModificacion();
    }
    
    public String getEstado() {
        return estado;
    }
    
    // Métodos de gestión del proyecto
    public void iniciarEdicion() {
        if (editorVideo != null) {
            this.estado = "EN_EDICION";
            this.activo = true;
            actualizarFechaModificacion();
            System.out.println("Proyecto '" + nombre + "' iniciado en " + editorVideo.getNombre());
        } else {
            System.out.println("Error: No hay editor asignado al proyecto");
        }
    }
    
    public void pausarEdicion() {
        this.estado = "PAUSADO";
        this.activo = false;
        actualizarFechaModificacion();
        System.out.println("Proyecto '" + nombre + "' pausado");
    }
    
    public void finalizarEdicion() {
        this.estado = "FINALIZADO";
        this.activo = false;
        actualizarFechaModificacion();
        System.out.println("Proyecto '" + nombre + "' finalizado");
    }
    
    public void guardarProyecto() {
        actualizarFechaModificacion();
        System.out.println("Proyecto '" + nombre + "' guardado en: " + rutaArchivos);
    }
    
    public boolean puedeEditarse() {
        return activo && editorVideo != null && "EN_EDICION".equals(estado);
    }
    
    public String getInformacionCompleta() {
        StringBuilder info = new StringBuilder();
        info.append("PROYECTO DE VIDEO:\n");
        info.append("  Nombre: ").append(nombre).append("\n");
        info.append("  Descripción: ").append(descripcion).append("\n");
        info.append("  Ruta: ").append(rutaArchivos).append("\n");
        info.append("  Estado: ").append(estado).append("\n");
        info.append("  Activo: ").append(activo ? "Sí" : "No").append("\n");
        info.append("  Creado: ").append(new java.util.Date(fechaCreacion)).append("\n");
        info.append("  Modificado: ").append(new java.util.Date(fechaModificacion)).append("\n");
        
        if (editorVideo != null) {
            info.append("  Editor asignado: ").append(editorVideo.getNombre()).append("\n");
            info.append("  Versión del editor: ").append(editorVideo.getVersion()).append("\n");
        } else {
            info.append("  Editor: No asignado\n");
        }
        
        return info.toString();
    }
    
    public String[] getFormatosSoportados() {
        if (editorVideo != null) {
            return editorVideo.getFormatosSoportados();
        } else {
            return new String[]{"Ninguno (sin editor)"};
        }
    }
    
    private void actualizarFechaModificacion() {
        this.fechaModificacion = System.currentTimeMillis();
    }
    
    @Override
    public String toString() {
        String editorInfo = (editorVideo != null) ? editorVideo.getNombre() : "Sin editor";
        return "Proyecto{nombre='" + nombre + "', estado=" + estado + 
               ", editor=" + editorInfo + ", activo=" + activo + "}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Proyecto proyecto = (Proyecto) obj;
        return nombre.equals(proyecto.nombre) && 
               rutaArchivos.equals(proyecto.rutaArchivos);
    }
    
    @Override
    public int hashCode() {
        return nombre.hashCode() + rutaArchivos.hashCode();
    }
}