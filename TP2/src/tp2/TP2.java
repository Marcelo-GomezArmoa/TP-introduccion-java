package tp2;

import java.util.Scanner;

public class TP2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opt;
        do {
            System.out.println("\n--- MENU TP2: Ejercicios ---");
            System.out.println("1  - Año bisiesto");
            System.out.println("2  - Mayor de tres números");
            System.out.println("3  - Clasificación de edad");
            System.out.println("4  - Calculadora de descuento por categoría");
            System.out.println("5  - Suma de números pares (while)");
            System.out.println("6  - Contador positivos/negativos/ceros (for)");
            System.out.println("7  - Validación de nota (do-while)");
            System.out.println("8  - Cálculo precio final (impuesto y descuento)");
            System.out.println("9  - Costo envío y total compra (composición)");
            System.out.println("10 - Actualizar stock");
            System.out.println("11 - Descuento especial (variable global)");
            System.out.println("12 - Array de precios: modificar y mostrar");
            System.out.println("13 - Impresión recursiva de array antes y después");
            System.out.println("0  - Salir");
            System.out.print("Elegí una opción: ");
            while (!sc.hasNextInt()) {
                System.out.print("Ingrese una opción válida: ");
                sc.next();
            }
            opt = sc.nextInt();
            switch (opt) {
                case 1 -> Ejercicio1Bisiesto.ejecutar(sc);
                case 2 -> Ejercicio2MayorTres.ejecutar(sc);
                case 3 -> Ejercicio3ClasificacionEdad.ejecutar(sc);
                case 4 -> Ejercicio4DescuentoCategoria.ejecutar(sc);
                case 5 -> Ejercicio5SumaPares.ejecutar(sc);
                case 6 -> Ejercicio6ContadorPosNegCeros.ejecutar(sc);
                case 7 -> Ejercicio7ValidacionNota.ejecutar(sc);
                case 8 -> Ejercicio8PrecioFinal.ejecutar(sc);
                case 9 -> Ejercicio9EnvioTotal.ejecutar(sc);
                case 10 -> Ejercicio10ActualizarStock.ejecutar(sc);
                case 11 -> Ejercicio11DescuentoEspecial.ejecutar(sc);
                case 12 -> Ejercicio12ArrayPrecios.ejecutar();
                case 13 -> Ejercicio13RecursivoPrecios.ejecutar();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opt != 0);
        sc.close();
    }
}