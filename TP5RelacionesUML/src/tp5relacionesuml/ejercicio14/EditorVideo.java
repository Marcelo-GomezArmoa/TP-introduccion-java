package tp5relacionesuml.ejercicio14;

/**
 * Clase que representa un editor de video profesional.
 * En este ejercicio demuestra:
 * - DEPENDENCIA DE CREACIÓN: EditorVideo.renderizar() crea objetos Render
 * - Tiene la capacidad de renderizar sin mantener referencias permanentes a los renders
 */
public class EditorVideo {
    private String nombre;
    private String version;
    private String desarrollador;
    private String[] formatosEntrada;
    private String[] formatosSalida;
    private boolean licenciaValida;
    private String tipoLicencia;
    private int rendersCreados; // Contador para estadísticas
    
    public EditorVideo(String nombre, String version, String desarrollador) {
        this.nombre = nombre;
        this.version = version;
        this.desarrollador = desarrollador;
        this.licenciaValida = true;
        this.tipoLicencia = "PROFESIONAL";
        this.rendersCreados = 0;
        
        // Configurar formatos soportados por defecto
        this.formatosEntrada = new String[]{
            "mp4", "avi", "mov", "mkv", "wmv", "flv", "webm", "m4v"
        };
        
        this.formatosSalida = new String[]{
            "mp4", "avi", "mov", "mkv", "webm", "m4v"
        };
    }
    
    public EditorVideo(String nombre, String version) {
        this(nombre, version, "Desarrollador Desconocido");
    }
    
    // Getters y setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getVersion() {
        return version;
    }
    
    public void setVersion(String version) {
        this.version = version;
    }
    
    public String getDesarrollador() {
        return desarrollador;
    }
    
    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }
    
    public String[] getFormatosEntrada() {
        return formatosEntrada.clone(); // Devolver copia para seguridad
    }
    
    public void setFormatosEntrada(String[] formatosEntrada) {
        this.formatosEntrada = formatosEntrada.clone();
    }
    
    public String[] getFormatosSoportados() {
        return getFormatosSalida(); // Alias para compatibilidad
    }
    
    public String[] getFormatosSalida() {
        return formatosSalida.clone(); // Devolver copia para seguridad
    }
    
    public void setFormatosSalida(String[] formatosSalida) {
        this.formatosSalida = formatosSalida.clone();
    }
    
    public boolean isLicenciaValida() {
        return licenciaValida;
    }
    
    public void setLicenciaValida(boolean licenciaValida) {
        this.licenciaValida = licenciaValida;
    }
    
    public String getTipoLicencia() {
        return tipoLicencia;
    }
    
    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }
    
    public int getRendersCreados() {
        return rendersCreados;
    }
    
    // ========== MÉTODOS DE DEPENDENCIA DE CREACIÓN ==========
    
    /**
     * DEPENDENCIA DE CREACIÓN: Crea un objeto Render básico
     * El editor crea el render pero no mantiene referencia permanente
     */
    public Render renderizar(String nombreRender, String formatoSalida, String rutaSalida) {
        if (!licenciaValida) {
            System.out.println("Error: Licencia no válida para renderizar");
            return null;
        }
        
        if (!soportaFormatoSalida(formatoSalida)) {
            System.out.println("Error: Formato '" + formatoSalida + "' no soportado");
            return null;
        }
        
        if (nombreRender == null || nombreRender.trim().isEmpty()) {
            System.out.println("Error: Nombre de render no puede estar vacío");
            return null;
        }
        
        if (rutaSalida == null || rutaSalida.trim().isEmpty()) {
            System.out.println("Error: Ruta de salida no puede estar vacía");
            return null;
        }
        
        // CREAR OBJETO RENDER (DEPENDENCIA DE CREACIÓN)
        Render nuevoRender = new Render(nombreRender, formatoSalida, rutaSalida);
        rendersCreados++;
        
        System.out.println("Editor '" + nombre + "' ha creado un nuevo render: " + nombreRender);
        return nuevoRender;
    }
    
    /**
     * DEPENDENCIA DE CREACIÓN: Crea un objeto Render con configuración avanzada
     */
    public Render renderizarAvanzado(String nombreRender, String formatoSalida, 
                                   String resolucion, int calidad, String rutaSalida) {
        if (!licenciaValida) {
            System.out.println("Error: Licencia no válida para renderizar");
            return null;
        }
        
        if (!soportaFormatoSalida(formatoSalida)) {
            System.out.println("Error: Formato '" + formatoSalida + "' no soportado");
            return null;
        }
        
        // CREAR OBJETO RENDER CON CONFIGURACIÓN AVANZADA
        Render nuevoRender = new Render(nombreRender, formatoSalida, resolucion, calidad, rutaSalida);
        rendersCreados++;
        
        System.out.println("Editor '" + nombre + "' ha creado render avanzado: " + nombreRender + 
                          " (" + resolucion + ", calidad: " + calidad + "%)");
        return nuevoRender;
    }
    
    /**
     * DEPENDENCIA DE CREACIÓN: Crea múltiples renders en lote
     */
    public Render[] renderizarLote(String[] nombresRender, String formatoSalida, 
                                 String rutaBase) {
        if (!licenciaValida) {
            System.out.println("Error: Licencia no válida para renderizar lote");
            return new Render[0];
        }
        
        if (nombresRender == null || nombresRender.length == 0) {
            System.out.println("Error: Lista de nombres vacía");
            return new Render[0];
        }
        
        Render[] rendersCreados = new Render[nombresRender.length];
        
        for (int i = 0; i < nombresRender.length; i++) {
            if (nombresRender[i] != null && !nombresRender[i].trim().isEmpty()) {
                String rutaCompleta = rutaBase + "/" + nombresRender[i] + "." + formatoSalida;
                rendersCreados[i] = renderizar(nombresRender[i], formatoSalida, rutaCompleta);
            }
        }
        
        System.out.println("Editor '" + nombre + "' ha creado lote de " + 
                          nombresRender.length + " renders");
        return rendersCreados;
    }
    
    /**
     * DEPENDENCIA DE CREACIÓN: Crea render para resolución específica
     */
    public Render renderizarParaResolucion(String nombreRender, String resolucion, String rutaSalida) {
        // Seleccionar formato óptimo según resolución
        String formatoOptimo;
        switch (resolucion) {
            case "3840x2160": formatoOptimo = "mov"; break; // 4K
            case "2560x1440": formatoOptimo = "mp4"; break; // 2K
            case "1920x1080": formatoOptimo = "mp4"; break; // Full HD
            case "1280x720":  formatoOptimo = "mp4"; break; // HD
            default: formatoOptimo = "mp4"; break;
        }
        
        int calidadOptima = obtenerCalidadOptima(resolucion);
        
        return renderizarAvanzado(nombreRender, formatoOptimo, resolucion, calidadOptima, rutaSalida);
    }
    
    /**
     * DEPENDENCIA DE CREACIÓN: Crea render optimizado para plataforma
     */
    public Render renderizarParaPlataforma(String nombreRender, String plataforma, String rutaSalida) {
        String resolucion;
        String formato;
        int calidad;
        
        switch (plataforma.toLowerCase()) {
            case "youtube":
                resolucion = "1920x1080";
                formato = "mp4";
                calidad = 85;
                break;
            case "instagram":
                resolucion = "1080x1080";
                formato = "mp4";
                calidad = 80;
                break;
            case "tiktok":
                resolucion = "1080x1920";
                formato = "mp4";
                calidad = 75;
                break;
            case "facebook":
                resolucion = "1280x720";
                formato = "mp4";
                calidad = 80;
                break;
            case "twitter":
                resolucion = "1280x720";
                formato = "mp4";
                calidad = 75;
                break;
            default:
                resolucion = "1920x1080";
                formato = "mp4";
                calidad = 80;
                break;
        }
        
        System.out.println("Configurando render para " + plataforma + 
                          " (optimizado: " + resolucion + ", " + calidad + "% calidad)");
        
        return renderizarAvanzado(nombreRender, formato, resolucion, calidad, rutaSalida);
    }
    
    // Métodos auxiliares
    private boolean soportaFormatoSalida(String formato) {
        for (String formatoSoportado : formatosSalida) {
            if (formatoSoportado.equalsIgnoreCase(formato)) {
                return true;
            }
        }
        return false;
    }
    
    private int obtenerCalidadOptima(String resolucion) {
        switch (resolucion) {
            case "3840x2160": return 95; // 4K necesita alta calidad
            case "2560x1440": return 90; // 2K alta calidad
            case "1920x1080": return 85; // Full HD buena calidad
            case "1280x720":  return 80; // HD calidad estándar
            default: return 75;
        }
    }
    
    public boolean puedeRenderizar() {
        return licenciaValida;
    }
    
    public String getInformacionCompleta() {
        StringBuilder info = new StringBuilder();
        info.append("EDITOR DE VIDEO:\n");
        info.append("  Nombre: ").append(nombre).append("\n");
        info.append("  Versión: ").append(version).append("\n");
        info.append("  Desarrollador: ").append(desarrollador).append("\n");
        info.append("  Licencia: ").append(tipoLicencia).append(" (").append(licenciaValida ? "Válida" : "Inválida").append(")\n");
        info.append("  Renders creados: ").append(rendersCreados).append("\n");
        
        info.append("  Formatos de entrada: ");
        for (int i = 0; i < formatosEntrada.length; i++) {
            info.append(formatosEntrada[i]);
            if (i < formatosEntrada.length - 1) info.append(", ");
        }
        info.append("\n");
        
        info.append("  Formatos de salida: ");
        for (int i = 0; i < formatosSalida.length; i++) {
            info.append(formatosSalida[i]);
            if (i < formatosSalida.length - 1) info.append(", ");
        }
        info.append("\n");
        
        return info.toString();
    }
    
    public String getEstadisticas() {
        return "Editor '" + nombre + "' v" + version + " - Renders creados: " + 
               rendersCreados + " | Licencia: " + (licenciaValida ? "Válida" : "Inválida");
    }
    
    @Override
    public String toString() {
        return "EditorVideo{nombre='" + nombre + "', version='" + version + 
               "', licencia=" + (licenciaValida ? "Válida" : "Inválida") + 
               ", renders=" + rendersCreados + "}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        EditorVideo editor = (EditorVideo) obj;
        return nombre.equals(editor.nombre) && version.equals(editor.version);
    }
    
    @Override
    public int hashCode() {
        return nombre.hashCode() + version.hashCode();
    }
}