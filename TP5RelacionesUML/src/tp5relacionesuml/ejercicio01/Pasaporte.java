package tp5relacionesuml.ejercicio01;

/**
 * Clase Pasaporte - Ejemplo de COMPOSICIÓN y ASOCIACIÓN BIDIRECCIONAL
 * - COMPOSICIÓN con Foto: la foto es creada y destruida con el pasaporte
 * - ASOCIACIÓN BIDIRECCIONAL con Titular: ambos se conocen mutuamente
 */
public class Pasaporte {
    private String numero;
    private String fechaEmision;
    private Titular titular;  // Asociación bidireccional
    private Foto foto;        // Composición
    
    // Constructor que crea la foto internamente (COMPOSICIÓN)
    public Pasaporte(String numero, String fechaEmision, String imagenFoto, String formatoFoto) {
        this.numero = numero;
        this.fechaEmision = fechaEmision;
        // COMPOSICIÓN: el pasaporte crea y controla la foto
        this.foto = new Foto(imagenFoto, formatoFoto);
    }
    
    // Getters y Setters
    public String getNumero() {
        return numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public String getFechaEmision() {
        return fechaEmision;
    }
    
    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
    
    public Titular getTitular() {
        return titular;
    }
    
    // Método para establecer la relación bidireccional
    public void setTitular(Titular titular) {
        // Evitar bucle infinito: solo proceder si hay cambio real
        if (this.titular == titular) {
            return; // No hay cambio, evitar bucle
        }
        
        // Eliminar relación anterior si existe
        if (this.titular != null) {
            Titular anteriorTitular = this.titular;
            this.titular = null; // Cortar referencia primero
            anteriorTitular.setPasaporte(null); // Luego notificar
        }
        
        this.titular = titular;
        
        // Establecer la relación bidireccional
        if (titular != null && titular.getPasaporte() != this) {
            titular.setPasaporte(this);
        }
    }
    
    public Foto getFoto() {
        return foto;
    }
    
    // NO se permite cambiar la foto externamente (COMPOSICIÓN)
    // La foto solo puede ser cambiada internamente
    public void cambiarFoto(String nuevaImagen, String nuevoFormato) {
        this.foto = new Foto(nuevaImagen, nuevoFormato);
    }
    
    @Override
    public String toString() {
        return "Pasaporte{" +
                "numero='" + numero + '\'' +
                ", fechaEmision='" + fechaEmision + '\'' +
                ", titular=" + (titular != null ? titular.getNombre() : "Sin titular") +
                ", foto=" + foto +
                '}';
    }
}