package tp2;

import java.util.Scanner;

public class Ejercicio11DescuentoEspecial {
    // "variable global" de la clase
    private static final double DESCUENTO_GLOBAL = 0.10; // 10%

    public static void ejecutar(Scanner sc) {
        System.out.print("Ingrese el precio del producto: ");
        double precio = readDouble(sc);
        double descuentoAplicado = calcularDescuentoEspecial(precio);
        double finalPrice = precio - descuentoAplicado;
        System.out.println("El descuento especial aplicado es: " + descuentoAplicado);
        System.out.println("El precio final con descuento es: " + finalPrice);
    }

    public static double calcularDescuentoEspecial(double precio) {
        double descuentoAplicado = precio * DESCUENTO_GLOBAL;
        return descuentoAplicado;
    }

    private static double readDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("Ingrese un número válido: ");
            sc.next();
        }
        return sc.nextDouble();
    }
}