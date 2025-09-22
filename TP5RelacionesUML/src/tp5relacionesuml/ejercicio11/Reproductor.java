package tp5relacionesuml.ejercicio11;

/**
 * Clase Reproductor - Ejemplo de DEPENDENCIA DE USO
 * - DEPENDENCIA DE USO: usa Cancion como parámetro en el método reproducir()
 * No mantiene una referencia permanente a las canciones
 * Solo las usa temporalmente durante la ejecución del método
 */
public class Reproductor {
    private String marca;
    private boolean reproduciendo;
    private Cancion cancionActual; // Referencia temporal (no es dependencia permanente)
    
    // Constructor
    public Reproductor(String marca) {
        this.marca = marca;
        this.reproduciendo = false;
        this.cancionActual = null;
    }
    
    // Getters
    public String getMarca() {
        return marca;
    }
    
    public boolean isReproduciendo() {
        return reproduciendo;
    }
    
    public Cancion getCancionActual() {
        return cancionActual;
    }
    
    // DEPENDENCIA DE USO: método que usa Cancion como parámetro
    public void reproducir(Cancion cancion) {
        if (cancion == null) {
            System.out.println("[" + marca + "] Error: No se puede reproducir una canción nula");
            return;
        }
        
        // Usar la canción temporalmente
        this.cancionActual = cancion;
        this.reproduciendo = true;
        
        System.out.println("[" + marca + "] ♪ Reproduciendo: " + cancion.getInformacionCompleta());
        
        // Simular información adicional usando la canción
        if (cancion.getArtista() != null) {
            System.out.println("[" + marca + "] Género: " + cancion.getArtista().getGenero());
        }
    }
    
    // Método para pausar la reproducción
    public void pausar() {
        if (reproduciendo) {
            this.reproduciendo = false;
            System.out.println("[" + marca + "] ⏸ Pausado: " + 
                             (cancionActual != null ? cancionActual.getTitulo() : "Ninguna canción"));
        } else {
            System.out.println("[" + marca + "] No hay reproducción en curso");
        }
    }
    
    // Método para detener la reproducción
    public void detener() {
        if (cancionActual != null || reproduciendo) {
            System.out.println("[" + marca + "] ⏹ Detenido: " + 
                             (cancionActual != null ? cancionActual.getTitulo() : "Ninguna canción"));
            this.reproduciendo = false;
            this.cancionActual = null; // Se libera la referencia temporal
        } else {
            System.out.println("[" + marca + "] No hay reproducción activa");
        }
    }
    
    // DEPENDENCIA DE USO: método que procesa múltiples canciones
    public void reproducirLista(Cancion[] playlist) {
        if (playlist == null || playlist.length == 0) {
            System.out.println("[" + marca + "] Error: Lista de reproducción vacía");
            return;
        }
        
        System.out.println("[" + marca + "] 📋 Iniciando lista de reproducción con " + 
                          playlist.length + " canciones:");
        
        for (int i = 0; i < playlist.length; i++) {
            if (playlist[i] != null) {
                System.out.println("    " + (i+1) + ". " + playlist[i].getInformacionCompleta());
            }
        }
        
        // Reproducir la primera canción
        if (playlist[0] != null) {
            reproducir(playlist[0]);
        }
    }
    
    // DEPENDENCIA DE USO: método que usa Cancion para análisis
    public void analizarCancion(Cancion cancion) {
        if (cancion == null) {
            System.out.println("[" + marca + "] Error: No se puede analizar una canción nula");
            return;
        }
        
        System.out.println("[" + marca + "] 🔍 Analizando canción:");
        System.out.println("    Título: " + cancion.getTitulo());
        System.out.println("    Longitud del título: " + cancion.getTitulo().length() + " caracteres");
        
        if (cancion.getArtista() != null) {
            System.out.println("    Artista: " + cancion.getArtista().getNombre());
            System.out.println("    Género: " + cancion.getArtista().getGenero());
        } else {
            System.out.println("    Artista: No disponible");
        }
        
        // El análisis termina aquí - no se guarda referencia permanente
    }
    
    @Override
    public String toString() {
        return "Reproductor{" +
                "marca='" + marca + '\'' +
                ", reproduciendo=" + reproduciendo +
                ", cancionActual=" + (cancionActual != null ? cancionActual.getTitulo() : "Ninguna") +
                '}';
    }
}