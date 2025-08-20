import java.util.Scanner;

public class OperacionesAritmeticas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingresa un número entero: ");
        int numero1 = scanner.nextInt();
        
        System.out.print("Ingresa otro número entero: ");
        int numero2 = scanner.nextInt();
        
        int suma = numero1 + numero2;
        int resta = numero1 - numero2;
        int multiplicacion = numero1 * numero2;
        
        System.out.println("\n--- Resultados ---");
        System.out.println("Suma: " + numero1 + " + " + numero2 + " = " + suma);
        System.out.println("Resta: " + numero1 + " - " + numero2 + " = " + resta);
        System.out.println("Multiplicación: " + numero1 + " × " + numero2 + " = " + multiplicacion);
        
        if (numero2 != 0) {
            double division = (double) numero1 / numero2;
            System.out.println("División: " + numero1 + " ÷ " + numero2 + " = " + division);
        } else {
            System.out.println("División: No se puede dividir entre cero");
        }
        
        scanner.close();
    }
}