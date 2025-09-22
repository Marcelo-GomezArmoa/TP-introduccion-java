package tp5relacionesuml.ejercicio05;

/**
 * Clase Computadora - Ejemplo de COMPOSICIÓN y ASOCIACIÓN BIDIRECCIONAL
 * - COMPOSICIÓN con PlacaMadre: la placa madre es creada y destruida con la computadora
 * - ASOCIACIÓN BIDIRECCIONAL con Propietario: ambos se conocen mutuamente
 */
public class Computadora {
    private String marca;
    private String numeroSerie;
    private Propietario propietario; // Asociación bidireccional
    private PlacaMadre placaMadre;   // Composición

    // Constructor que crea la placa madre internamente (COMPOSICIÓN)
    public Computadora(String marca, String numeroSerie, String modeloPlaca, String chipset) {
        this.marca = marca;
        this.numeroSerie = numeroSerie;
        // COMPOSICIÓN: la computadora crea y controla la placa madre
        this.placaMadre = new PlacaMadre(modeloPlaca, chipset);
    }

    // Getters y Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    // Método para establecer la relación bidireccional
    public void setPropietario(Propietario propietario) {
        // Evitar bucle infinito - verificar si es el mismo valor
        if (this.propietario == propietario) {
            return;
        }

        // Guardar referencia anterior para limpiarla después
        Propietario propietarioAnterior = this.propietario;

        // Asignar nuevo propietario primero
        this.propietario = propietario;

        // Limpiar relación anterior si existe
        if (propietarioAnterior != null && propietarioAnterior.getComputadora() == this) {
            propietarioAnterior.setComputadora(null);
        }

        // Establecer la relación bidireccional
        if (propietario != null && propietario.getComputadora() != this) {
            propietario.setComputadora(this);
        }
    }

    public PlacaMadre getPlacaMadre() {
        return placaMadre;
    }

    // NO se permite cambiar la placa madre externamente (COMPOSICIÓN)
    // La placa madre solo puede ser reemplazada internamente (como en una reparación)
    public void reemplazarPlacaMadre(String nuevoModelo, String nuevoChipset) {
        // Simula una reparación/upgrade donde se reemplaza la placa madre
        this.placaMadre = new PlacaMadre(nuevoModelo, nuevoChipset);
    }

    // Método para obtener especificaciones completas
    public String getEspecificaciones() {
        StringBuilder specs = new StringBuilder();
        specs.append("Computadora ").append(marca);
        specs.append(" (S/N: ").append(numeroSerie).append(")");

        if (placaMadre != null) {
            specs.append(" - Placa: ").append(placaMadre.getModelo());
            specs.append(" (").append(placaMadre.getChipset()).append(")");
        }

        if (propietario != null) {
            specs.append(" - Propietario: ").append(propietario.getNombre());
        }

        return specs.toString();
    }

    @Override
    public String toString() {
        return "Computadora{" +
                "marca='" + marca + '\'' +
                ", numeroSerie='" + numeroSerie + '\'' +
                ", propietario=" + (propietario != null ? propietario.getNombre() : "Sin propietario") +
                ", placaMadre=" + placaMadre +
                '}';
    }
}
