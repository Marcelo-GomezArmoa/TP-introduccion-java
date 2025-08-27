package tp2;

public class Ejercicio13RecursivoPrecios {
    public static void ejecutar() {
        double[] precios = {199.99, 299.5, 149.75, 399.0, 89.99};
        System.out.println("Precios originales:");
        imprimirRec(precios, 0);
        precios[2] = 129.99; // modificar tercer elemento
        System.out.println("Precios modificados:");
        imprimirRec(precios, 0);
    }

    private static void imprimirRec(double[] arr, int idx) {
        if (idx >= arr.length) return;
        System.out.println("Precio: $" + arr[idx]);
        imprimirRec(arr, idx + 1);
    }
}