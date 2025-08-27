package tp2;

import java.util.Scanner;

public class Ejercicio9EnvioTotal {
    public static void ejecutar(Scanner sc) {
        System.out.print("Ingrese el precio del producto: ");
        double precio = readDouble(sc);
        System.out.print("Ingrese el peso del paquete en kg: ");
        double peso = readDouble(sc);
        System.out.print("Ingrese la zona de envío (Nacional/Internacional): ");
        String zona = sc.next().trim();
        double costoEnvio = calcularCostoEnvio(peso, zona);
        double total = calcularTotalCompra(precio, costoEnvio);
        System.out.println("El costo de envío es: " + costoEnvio);
        System.out.println("El total a pagar es: " + total);
    }

    public static double calcularCostoEnvio(double peso, String zona) {
        if (zona.equalsIgnoreCase("Nacional")) return 5.0 * peso;
        else return 10.0 * peso;
    }

    public static double calcularTotalCompra(double precioProducto, double costoEnvio) {
        return precioProducto + costoEnvio;
    }

    private static double readDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("Ingrese un número válido: ");
            sc.next();
        }
        return sc.nextDouble();
    }
}