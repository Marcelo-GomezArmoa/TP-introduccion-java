package tp5relacionesuml.ejercicio01;

/**
 * Clase de prueba para demostrar las relaciones del Ejercicio 1
 * - COMPOSICIÓN: Pasaporte → Foto
 * - ASOCIACIÓN BIDIRECCIONAL: Pasaporte ↔ Titular
 */
public class TestEjercicio01 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 1: Pasaporte - Foto - Titular ===\n");
        
        // 1. Crear un titular
        Titular titular1 = new Titular("Juan Pérez", "12345678");
        System.out.println("1. Titular creado: " + titular1);
        
        // 2. Crear un pasaporte (que internamente crea la foto - COMPOSICIÓN)
        Pasaporte pasaporte1 = new Pasaporte("ARG123456", "2024-01-15", 
                                           "foto_juan.jpg", "JPEG");
        System.out.println("2. Pasaporte creado: " + pasaporte1);
        
        // 3. Establecer relación bidireccional entre pasaporte y titular
        pasaporte1.setTitular(titular1);
        System.out.println("\n3. Después de establecer la relación:");
        System.out.println("   Pasaporte: " + pasaporte1);
        System.out.println("   Titular: " + titular1);
        
        // 4. Verificar que la relación es bidireccional
        System.out.println("\n4. Verificación de relación bidireccional:");
        System.out.println("   ¿El titular tiene pasaporte? " + 
                          (titular1.getPasaporte() != null));
        System.out.println("   ¿El pasaporte tiene titular? " + 
                          (pasaporte1.getTitular() != null));
        
        // 5. Demostrar COMPOSICIÓN: cambiar la foto del pasaporte
        System.out.println("\n5. Demostrando COMPOSICIÓN - cambiar foto:");
        System.out.println("   Foto original: " + pasaporte1.getFoto());
        pasaporte1.cambiarFoto("foto_juan_nueva.png", "PNG");
        System.out.println("   Foto nueva: " + pasaporte1.getFoto());
        
        // 6. Crear otro titular y pasaporte
        Titular titular2 = new Titular("María García", "87654321");
        Pasaporte pasaporte2 = new Pasaporte("ARG789012", "2024-02-20", 
                                           "foto_maria.jpg", "JPEG");
        
        // 7. Demostrar cambio de relación
        System.out.println("\n6. Demostrando cambio de relación:");
        System.out.println("   Antes - Titular1: " + titular1);
        System.out.println("   Antes - Titular2: " + titular2);
        
        // Cambiar el pasaporte del titular1 al titular2
        pasaporte1.setTitular(titular2);
        
        System.out.println("   Después del cambio:");
        System.out.println("   Titular1: " + titular1);
        System.out.println("   Titular2: " + titular2);
        System.out.println("   Pasaporte1: " + pasaporte1);
        
        System.out.println("\n=== FIN DEL EJERCICIO 1 ===");
    }
}