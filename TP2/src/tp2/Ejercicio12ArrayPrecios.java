package tp2;

public class Ejercicio12ArrayPrecios {
    public static void ejecutar() {
        double[] precios = {199.99, 299.5, 149.75, 399.0, 89.99};
        System.out.println("Precios originales:");
        for (double p : precios) System.out.println("Precio: $" + p);
        // modificar índice 2 (tercer producto) a 129.99
        precios[2] = 129.99;
        System.out.println("Precios modificados:");
        for (double p : precios) System.out.println("Precio: $" + p);
    }
}