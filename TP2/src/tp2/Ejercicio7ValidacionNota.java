package tp2;

import java.util.Scanner;

public class Ejercicio7ValidacionNota {
    public static void ejecutar(Scanner sc) {
        int nota;
        do {
            System.out.print("Ingrese una nota (0-10): ");
            while (!sc.hasNextInt()) {
                System.out.print("Error: Nota inválida. Ingrese una nota entre 0 y 10: ");
                sc.next();
            }
            nota = sc.nextInt();
            if (nota < 0 || nota > 10) {
                System.out.println("Error: Nota inválida. Ingrese una nota entre 0 y 10.");
            }
        } while (nota < 0 || nota > 10);
        System.out.println("Nota guardada correctamente: " + nota);
    }
}