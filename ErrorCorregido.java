import java.util.Scanner;

public class ErrorCorregido {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa tu nombre: ");
        //String nombre = scanner.nextInt(); ERROR 
        String nombre = scanner.nextLine(); // Correccion
        System.out.println("Hola, " + nombre);
        scanner.close();
    }
}
// el error se da porque es un tipo de dato String y retorna un Int
// no se puede asignar un int a una variable String.