package tp2;

import java.util.Scanner;

public class Ejercicio3ClasificacionEdad {
    public static void ejecutar(Scanner sc) {
        System.out.print("Ingrese su edad: ");
        int edad = readInt(sc);
        if (edad < 12) {
            System.out.println("Eres un Niño.");
        } else if (edad <= 17) {
            System.out.println("Eres un Adolescente.");
        } else if (edad <= 59) {
            System.out.println("Eres un Adulto.");
        } else {
            System.out.println("Eres un Adulto mayor.");
        }
    }

    private static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Ingrese una edad válida: ");
            sc.next();
        }
        return sc.nextInt();
    }
}