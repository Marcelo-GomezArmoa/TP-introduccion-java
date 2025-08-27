package tp2;

import java.util.Scanner;

public class Ejercicio8PrecioFinal {
    public static void ejecutar(Scanner sc) {
        System.out.print("Ingrese el precio base del producto: ");
        double base = readDouble(sc);
        System.out.print("Ingrese el impuesto en porcentaje (Ej: 10): ");
        double impuestoPct = readDouble(sc);
        System.out.print("Ingrese el descuento en porcentaje (Ej: 5): ");
        double descuentoPct = readDouble(sc);
        double finalPrice = calcularPrecioFinal(base, impuestoPct/100.0, descuentoPct/100.0);
        System.out.println("El precio final del producto es: " + finalPrice);
    }

    public static double calcularPrecioFinal(double precioBase, double impuesto, double descuento) {
        return precioBase + (precioBase * impuesto) - (precioBase * descuento);
    }

    private static double readDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("Ingrese un número válido: ");
            sc.next();
        }
        return sc.nextDouble();
    }
}