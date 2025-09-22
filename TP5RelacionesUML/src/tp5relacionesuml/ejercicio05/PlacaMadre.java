package tp5relacionesuml.ejercicio05;

/**
 * Clase PlacaMadre - Ejemplo de COMPOSICIÓN
 * La placa madre NO puede existir sin la computadora que la contiene
 * Su ciclo de vida depende completamente de la computadora
 */
public class PlacaMadre {
    private String modelo;
    private String chipset;
    
    // Constructor
    public PlacaMadre(String modelo, String chipset) {
        this.modelo = modelo;
        this.chipset = chipset;
    }
    
    // Getters y Setters
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String getChipset() {
        return chipset;
    }
    
    public void setChipset(String chipset) {
        this.chipset = chipset;
    }
    
    @Override
    public String toString() {
        return "PlacaMadre{" +
                "modelo='" + modelo + '\'' +
                ", chipset='" + chipset + '\'' +
                '}';
    }
}