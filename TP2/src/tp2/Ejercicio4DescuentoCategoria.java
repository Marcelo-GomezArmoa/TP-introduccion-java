package tp2;

import java.util.Scanner;

public class Ejercicio4DescuentoCategoria {
    public static void ejecutar(Scanner sc) {
        System.out.print("Ingrese el precio del producto: ");
        double precio = readDouble(sc);
        System.out.print("Ingrese la categoría del producto (A, B o C): ");
        String categoria = sc.next().toUpperCase();
        double descuento = 0;
        switch (categoria) {
            case "A" -> descuento = 0.10;
            case "B" -> descuento = 0.15;
            case "C" -> descuento = 0.20;
            default -> {
                System.out.println("Categoría inválida.");
                return;
            }
        }
        double precioFinal = precio - (precio * descuento);
        System.out.println("Descuento aplicado: " + (int)(descuento * 100) + "%");
        System.out.println("Precio final: " + precioFinal);
    }

    private static double readDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("Ingrese un valor válido: ");
            sc.next();
        }
        return sc.nextDouble();
    }
}