package tp5relacionesuml.ejercicio14;

/**
 * Clase que representa un render de video.
 * En este ejercicio demuestra:
 * - Es creado por EditorVideo mediante DEPENDENCIA DE CREACIÓN
 * - Mantiene información sobre el proceso de renderizado
 */
public class Render {
    private String nombre;
    private String formatoSalida;
    private String resolucion;
    private int calidad; // 1-100
    private String rutaSalida;
    private long fechaInicio;
    private long fechaFin;
    private String estado;
    private int progreso; // 0-100
    private long tamanioEstimado;
    private String tiempoEstimado;
    
    public Render(String nombre, String formatoSalida, String resolucion, 
                  int calidad, String rutaSalida) {
        this.nombre = nombre;
        this.formatoSalida = formatoSalida;
        this.resolucion = resolucion;
        this.calidad = Math.max(1, Math.min(100, calidad)); // Validar rango 1-100
        this.rutaSalida = rutaSalida;
        this.fechaInicio = System.currentTimeMillis();
        this.fechaFin = 0;
        this.estado = "INICIADO";
        this.progreso = 0;
        this.tamanioEstimado = calcularTamanioEstimado();
        this.tiempoEstimado = calcularTiempoEstimado();
    }
    
    // Constructor simplificado
    public Render(String nombre, String formatoSalida, String rutaSalida) {
        this(nombre, formatoSalida, "1920x1080", 80, rutaSalida);
    }
    
    // Getters y setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getFormatoSalida() {
        return formatoSalida;
    }
    
    public void setFormatoSalida(String formatoSalida) {
        this.formatoSalida = formatoSalida;
        this.tamanioEstimado = calcularTamanioEstimado();
    }
    
    public String getResolucion() {
        return resolucion;
    }
    
    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
        this.tamanioEstimado = calcularTamanioEstimado();
        this.tiempoEstimado = calcularTiempoEstimado();
    }
    
    public int getCalidad() {
        return calidad;
    }
    
    public void setCalidad(int calidad) {
        this.calidad = Math.max(1, Math.min(100, calidad));
        this.tamanioEstimado = calcularTamanioEstimado();
    }
    
    public String getRutaSalida() {
        return rutaSalida;
    }
    
    public void setRutaSalida(String rutaSalida) {
        this.rutaSalida = rutaSalida;
    }
    
    public long getFechaInicio() {
        return fechaInicio;
    }
    
    public long getFechaFin() {
        return fechaFin;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public int getProgreso() {
        return progreso;
    }
    
    public long getTamanioEstimado() {
        return tamanioEstimado;
    }
    
    public String getTiempoEstimado() {
        return tiempoEstimado;
    }
    
    // Métodos para simular el proceso de renderizado
    public void iniciarRender() {
        this.estado = "RENDERIZANDO";
        this.progreso = 0;
        this.fechaInicio = System.currentTimeMillis();
        System.out.println("Iniciando render: " + nombre);
        System.out.println("Formato: " + formatoSalida + " | Resolución: " + resolucion + 
                          " | Calidad: " + calidad + "%");
    }
    
    public void actualizarProgreso(int nuevoProgreso) {
        this.progreso = Math.max(0, Math.min(100, nuevoProgreso));
        
        if (progreso == 100) {
            completarRender();
        } else {
            System.out.println("Render '" + nombre + "': " + progreso + "% completado");
        }
    }
    
    public void pausarRender() {
        if ("RENDERIZANDO".equals(estado)) {
            this.estado = "PAUSADO";
            System.out.println("Render '" + nombre + "' pausado en " + progreso + "%");
        }
    }
    
    public void reanudarRender() {
        if ("PAUSADO".equals(estado)) {
            this.estado = "RENDERIZANDO";
            System.out.println("Render '" + nombre + "' reanudado desde " + progreso + "%");
        }
    }
    
    public void cancelarRender() {
        this.estado = "CANCELADO";
        this.fechaFin = System.currentTimeMillis();
        System.out.println("Render '" + nombre + "' cancelado");
    }
    
    private void completarRender() {
        this.estado = "COMPLETADO";
        this.progreso = 100;
        this.fechaFin = System.currentTimeMillis();
        System.out.println("Render '" + nombre + "' completado exitosamente");
        System.out.println("Archivo guardado en: " + rutaSalida);
    }
    
    public boolean estaCompletado() {
        return "COMPLETADO".equals(estado);
    }
    
    public boolean estaEnProceso() {
        return "RENDERIZANDO".equals(estado);
    }
    
    public long getTiempoTranscurrido() {
        if (fechaFin > 0) {
            return fechaFin - fechaInicio;
        } else {
            return System.currentTimeMillis() - fechaInicio;
        }
    }
    
    public String getInformacionCompleta() {
        StringBuilder info = new StringBuilder();
        info.append("RENDER DE VIDEO:\n");
        info.append("  Nombre: ").append(nombre).append("\n");
        info.append("  Formato: ").append(formatoSalida).append("\n");
        info.append("  Resolución: ").append(resolucion).append("\n");
        info.append("  Calidad: ").append(calidad).append("%\n");
        info.append("  Ruta de salida: ").append(rutaSalida).append("\n");
        info.append("  Estado: ").append(estado).append("\n");
        info.append("  Progreso: ").append(progreso).append("%\n");
        info.append("  Tamaño estimado: ").append(formatearTamano(tamanioEstimado)).append("\n");
        info.append("  Tiempo estimado: ").append(tiempoEstimado).append("\n");
        info.append("  Iniciado: ").append(new java.util.Date(fechaInicio)).append("\n");
        
        if (fechaFin > 0) {
            info.append("  Finalizado: ").append(new java.util.Date(fechaFin)).append("\n");
            info.append("  Duración total: ").append(formatearTiempo(getTiempoTranscurrido())).append("\n");
        } else {
            info.append("  Tiempo transcurrido: ").append(formatearTiempo(getTiempoTranscurrido())).append("\n");
        }
        
        return info.toString();
    }
    
    private long calcularTamanioEstimado() {
        // Estimación basada en resolución, formato y calidad
        long baseSize = 0;
        
        // Tamaño base según resolución
        switch (resolucion) {
            case "3840x2160": baseSize = 8000000000L; break; // 8GB para 4K
            case "2560x1440": baseSize = 4000000000L; break; // 4GB para 2K
            case "1920x1080": baseSize = 2000000000L; break; // 2GB para Full HD
            case "1280x720":  baseSize = 1000000000L; break; // 1GB para HD
            default: baseSize = 500000000L; break; // 500MB por defecto
        }
        
        // Ajuste por formato
        switch (formatoSalida.toLowerCase()) {
            case "mp4": 
            case "avi": baseSize = (long)(baseSize * 1.0); break;
            case "mov": baseSize = (long)(baseSize * 1.2); break;
            case "mkv": baseSize = (long)(baseSize * 0.9); break;
            case "webm": baseSize = (long)(baseSize * 0.7); break;
        }
        
        // Ajuste por calidad
        return (long)(baseSize * (calidad / 100.0));
    }
    
    private String calcularTiempoEstimado() {
        // Estimación basada en resolución y calidad
        int minutosBase = 0;
        
        switch (resolucion) {
            case "3840x2160": minutosBase = 120; break; // 2 horas para 4K
            case "2560x1440": minutosBase = 60; break;  // 1 hora para 2K
            case "1920x1080": minutosBase = 30; break;  // 30 min para Full HD
            case "1280x720":  minutosBase = 15; break;  // 15 min para HD
            default: minutosBase = 10; break;
        }
        
        // Ajuste por calidad (mayor calidad = más tiempo)
        int minutosAjustados = (int)(minutosBase * (calidad / 80.0));
        
        if (minutosAjustados < 60) {
            return minutosAjustados + " minutos";
        } else {
            int horas = minutosAjustados / 60;
            int minutos = minutosAjustados % 60;
            return horas + "h " + minutos + "m";
        }
    }
    
    private String formatearTamano(long bytes) {
        if (bytes < 1024) return bytes + " B";
        if (bytes < 1024 * 1024) return (bytes / 1024) + " KB";
        if (bytes < 1024 * 1024 * 1024) return (bytes / (1024 * 1024)) + " MB";
        return (bytes / (1024 * 1024 * 1024)) + " GB";
    }
    
    private String formatearTiempo(long milisegundos) {
        long segundos = milisegundos / 1000;
        long minutos = segundos / 60;
        segundos = segundos % 60;
        
        if (minutos < 60) {
            return minutos + "m " + segundos + "s";
        } else {
            long horas = minutos / 60;
            minutos = minutos % 60;
            return horas + "h " + minutos + "m " + segundos + "s";
        }
    }
    
    @Override
    public String toString() {
        return "Render{nombre='" + nombre + "', formato=" + formatoSalida + 
               ", resolución=" + resolucion + ", estado=" + estado + 
               ", progreso=" + progreso + "%}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Render render = (Render) obj;
        return nombre.equals(render.nombre) && 
               rutaSalida.equals(render.rutaSalida);
    }
    
    @Override
    public int hashCode() {
        return nombre.hashCode() + rutaSalida.hashCode();
    }
}