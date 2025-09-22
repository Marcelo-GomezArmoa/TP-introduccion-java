package tp5relacionesuml.ejercicio11;

/**
 * Clase Cancion - Ejemplo de ASOCIACIÓN UNIDIRECCIONAL
 * - ASOCIACIÓN UNIDIRECCIONAL con Artista: la canción conoce al artista
 * El artista no conoce sus canciones (unidireccional)
 */
public class Cancion {
    private String titulo;
    private Artista artista; // Asociación unidireccional
    
    // Constructor
    public Cancion(String titulo) {
        this.titulo = titulo;
    }
    
    // Constructor completo
    public Cancion(String titulo, Artista artista) {
        this.titulo = titulo;
        this.artista = artista;
    }
    
    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public Artista getArtista() {
        return artista;
    }
    
    // ASOCIACIÓN UNIDIRECCIONAL: solo la canción mantiene la referencia
    public void setArtista(Artista artista) {
        this.artista = artista;
    }
    
    // Método para obtener información completa de la canción
    public String getInformacionCompleta() {
        StringBuilder info = new StringBuilder();
        info.append("\"").append(titulo).append("\"");
        
        if (artista != null) {
            info.append(" por ").append(artista.getNombre());
            info.append(" (").append(artista.getGenero()).append(")");
        } else {
            info.append(" - Artista desconocido");
        }
        
        return info.toString();
    }
    
    @Override
    public String toString() {
        return "Cancion{" +
                "titulo='" + titulo + '\'' +
                ", artista=" + (artista != null ? artista.getNombre() : "Desconocido") +
                '}';
    }
}