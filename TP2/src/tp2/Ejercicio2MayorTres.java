package tp2;

import java.util.Scanner;

public class Ejercicio2MayorTres {
    public static void ejecutar(Scanner sc) {
        System.out.print("Ingrese el primer número: ");
        int a = readInt(sc);
        System.out.print("Ingrese el segundo número: ");
        int b = readInt(sc);
        System.out.print("Ingrese el tercer número: ");
        int c = readInt(sc);
        int mayor = a;
        if (b > mayor) mayor = b;
        if (c > mayor) mayor = c;
        System.out.println("El mayor es: " + mayor);
    }

    private static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Ingrese un número válido: ");
            sc.next();
        }
        return sc.nextInt();
    }
}