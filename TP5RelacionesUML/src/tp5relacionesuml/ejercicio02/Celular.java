package tp5relacionesuml.ejercicio02;

/**
 * Clase Celular - Ejemplo de AGREGACIÓN y ASOCIACIÓN BIDIRECCIONAL
 * - AGREGACIÓN con Batería: la batería puede existir independientemente
 * - ASOCIACIÓN BIDIRECCIONAL con Usuario: ambos se conocen mutuamente
 */
public class Celular {
    private String imei;
    private String marca;
    private String modelo;
    private Usuario usuario;   // Asociación bidireccional
    private Bateria bateria;   // Agregación

    // Constructor
    public Celular(String imei, String marca, String modelo) {
        this.imei = imei;
        this.marca = marca;
        this.modelo = modelo;
    }

    // Constructor con batería
    public Celular(String imei, String marca, String modelo, Bateria bateria) {
        this.imei = imei;
        this.marca = marca;
        this.modelo = modelo;
        this.bateria = bateria;
    }

    // Getters y Setters
    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    // Método para establecer la relación bidireccional
    public void setUsuario(Usuario usuario) {
        // Si el usuario ya es el mismo, no hacer nada (evita bucle infinito)
        if (this.usuario == usuario) {
            return;
        }

        // Eliminar relación anterior si existe
        if (this.usuario != null) {
            Usuario oldUsuario = this.usuario;
            this.usuario = null;
            oldUsuario.setCelular(null);
        }

        this.usuario = usuario;

        // Establecer la relación bidireccional
        if (usuario != null && usuario.getCelular() != this) {
            usuario.setCelular(this);
        }
    }

    public Bateria getBateria() {
        return bateria;
    }

    // AGREGACIÓN: se permite cambiar la batería externamente
    public void setBateria(Bateria bateria) {
        this.bateria = bateria;
    }

    // Método para cambiar batería (típico en reparaciones)
    public void cambiarBateria(Bateria nuevaBateria) {
        this.bateria = nuevaBateria;
    }

    @Override
    public String toString() {
        return "Celular{" +
                "imei='" + imei + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", usuario=" + (usuario != null ? usuario.getNombre() : "Sin usuario") +
                ", bateria=" + bateria +
                '}';
    }
}
