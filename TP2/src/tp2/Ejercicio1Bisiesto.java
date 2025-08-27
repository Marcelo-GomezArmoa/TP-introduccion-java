package tp2;

import java.util.Scanner;

public class Ejercicio1Bisiesto {
    public static void ejecutar(Scanner sc) {
        System.out.print("Ingrese un año: ");
        while (!sc.hasNextInt()) {
            System.out.print("Ingrese un año válido: ");
            sc.next();
        }
        int year = sc.nextInt();
        if (esBisiesto(year)) {
            System.out.println("El año " + year + " es bisiesto.");
        } else {
            System.out.println("El año " + year + " no es bisiesto.");
        }
    }

    public static boolean esBisiesto(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }
}