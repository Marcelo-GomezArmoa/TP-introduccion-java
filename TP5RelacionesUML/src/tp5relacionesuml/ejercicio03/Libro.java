package tp5relacionesuml.ejercicio03;

/**
 * Clase Libro - Ejemplo de ASOCIACIÓN UNIDIRECCIONAL y AGREGACIÓN
 * - ASOCIACIÓN UNIDIRECCIONAL con Autor: el libro conoce al autor
 * - AGREGACIÓN con Editorial: la editorial puede existir independientemente
 */
public class Libro {
    private String titulo;
    private String isbn;
    private Autor autor;        // Asociación unidireccional
    private Editorial editorial; // Agregación
    
    // Constructor
    public Libro(String titulo, String isbn) {
        this.titulo = titulo;
        this.isbn = isbn;
    }
    
    // Constructor completo
    public Libro(String titulo, String isbn, Autor autor, Editorial editorial) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.editorial = editorial;
    }
    
    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public Autor getAutor() {
        return autor;
    }
    
    // ASOCIACIÓN UNIDIRECCIONAL: solo el libro mantiene la referencia
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    public Editorial getEditorial() {
        return editorial;
    }
    
    // AGREGACIÓN: se permite cambiar la editorial
    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
    
    // Método para obtener información completa del libro
    public String getInformacionCompleta() {
        StringBuilder info = new StringBuilder();
        info.append("\"").append(titulo).append("\"");
        
        if (autor != null) {
            info.append(" por ").append(autor.getNombre());
            info.append(" (").append(autor.getNacionalidad()).append(")");
        }
        
        if (editorial != null) {
            info.append(", publicado por ").append(editorial.getNombre());
        }
        
        info.append(" [ISBN: ").append(isbn).append("]");
        
        return info.toString();
    }
    
    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autor=" + (autor != null ? autor.getNombre() : "Desconocido") +
                ", editorial=" + (editorial != null ? editorial.getNombre() : "Sin editorial") +
                '}';
    }
}