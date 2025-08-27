package tp2;

import java.util.Scanner;

public class Ejercicio6ContadorPosNegCeros {
    public static void ejecutar(Scanner sc) {
        int positivos = 0, negativos = 0, ceros = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("Ingrese el número " + i + ": ");
            int v = readInt(sc);
            if (v > 0) positivos++;
            else if (v < 0) negativos++;
            else ceros++;
        }
        System.out.println("Resultados:");
        System.out.println("Positivos: " + positivos);
        System.out.println("Negativos: " + negativos);
        System.out.println("Ceros: " + ceros);
    }

    private static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Ingrese un número válido: ");
            sc.next();
        }
        return sc.nextInt();
    }
}