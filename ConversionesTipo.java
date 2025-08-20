import java.util.Scanner;

public class ConversionesTipo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Div con enteros
        System.out.println("=== DIVISIÓN CON ENTEROS ===");
        System.out.print("Ingresa el primer número entero: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Ingresa el segundo número entero: ");
        int num2 = scanner.nextInt();
        
        if (num2 != 0) {
            int divisionEntera = num1 / num2;
            System.out.println("División entera: " + num1 + " / " + num2 + " = " + divisionEntera);
        }
        
        // Div con decimales
        System.out.println("\n=== DIVISIÓN CON DECIMALES ===");
        System.out.print("Ingresa el primer número decimal: ");
        double numDouble1 = scanner.nextDouble();
        
        System.out.print("Ingresa el segundo número decimal: ");
        double numDouble2 = scanner.nextDouble();
        
        if (numDouble2 != 0) {
            double divisionDecimal = numDouble1 / numDouble2;
            System.out.println("División decimal: " + numDouble1 + " / " + numDouble2 + " = " + divisionDecimal);
        }
        
        // Conversion
        if (num2 != 0) {
            double conversionExplicita = (double) num1 / num2;
            System.out.println("\n=== CONVERSIÓN ===");
            System.out.println("Enteros convertidos a decimal: " + conversionExplicita);
        }
        
        scanner.close();
    }
}