package tp2;

import java.util.Scanner;

public class Ejercicio10ActualizarStock {
    public static void ejecutar(Scanner sc) {
        System.out.print("Ingrese el stock actual del producto: ");
        int stock = readInt(sc);
        System.out.print("Ingrese la cantidad vendida: ");
        int vendida = readInt(sc);
        System.out.print("Ingrese la cantidad recibida: ");
        int recibida = readInt(sc);
        int nuevo = actualizarStock(stock, vendida, recibida);
        System.out.println("El nuevo stock del producto es: " + nuevo);
    }

    public static int actualizarStock(int stockActual, int cantidadVendida, int cantidadRecibida) {
        return stockActual - cantidadVendida + cantidadRecibida;
    }

    private static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Ingrese un número válido: ");
            sc.next();
        }
        return sc.nextInt();
    }
}