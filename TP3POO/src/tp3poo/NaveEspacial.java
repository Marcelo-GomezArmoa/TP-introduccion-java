package tp3poo;

public class NaveEspacial {
    String nombre;
    int combustible;
    final int COMBUSTIBLE_MAXIMO = 100;

    public NaveEspacial(String nombre, int combustible) {
        this.nombre = nombre;
        this.combustible = combustible;
    }

    public void despegar() {
        if (combustible >= 10) {
            combustible -= 10;
            System.out.println(nombre + " ha despegado. Combustible restante: " + combustible);
        } else {
            System.out.println("No hay suficiente combustible para despegar.");
        }
    }

    public void avanzar(int distancia) {
        int consumo = distancia * 2;
        if (combustible >= consumo) {
            combustible -= consumo;
            System.out.println(nombre + " avanzó " + distancia + " unidades. Combustible restante: " + combustible);
        } else {
            System.out.println("No hay suficiente combustible para avanzar " + distancia + " unidades.");
        }
    }

    public void recargarCombustible(int cantidad) {
        if (combustible + cantidad > COMBUSTIBLE_MAXIMO) {
            System.out.println("No se puede recargar esa cantidad. Se superaría el máximo.");
        } else {
            combustible += cantidad;
            System.out.println("Combustible recargado. Nivel actual: " + combustible);
        }
    }

    public void mostrarEstado() {
        System.out.println("Nave: " + nombre);
        System.out.println("Combustible: " + combustible + "/" + COMBUSTIBLE_MAXIMO);
    }
}