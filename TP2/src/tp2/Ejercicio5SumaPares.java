package tp2;

import java.util.Scanner;

public class Ejercicio5SumaPares {
    public static void ejecutar(Scanner sc) {
        int suma = 0;
        int num;
        do {
            System.out.print("Ingrese un número (0 para terminar): ");
            num = readInt(sc);
            if (num % 2 == 0 && num != 0) {
                suma += num;
            }
        } while (num != 0);
        System.out.println("La suma de los números pares es: " + suma);
    }

    private static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Ingrese un número válido: ");
            sc.next();
        }
        return sc.nextInt();
    }
}