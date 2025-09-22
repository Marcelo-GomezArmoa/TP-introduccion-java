package tp5relacionesuml.ejercicio08;

/**
 * Clase Usuario - Ejemplo de AGREGACIÓN
 * El usuario puede existir independientemente de las firmas digitales
 * Puede firmar múltiples documentos a lo largo del tiempo
 */
public class Usuario {
    private String nombre;
    private String email;
    
    // Constructor
    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}