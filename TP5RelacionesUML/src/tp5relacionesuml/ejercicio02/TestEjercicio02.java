package tp5relacionesuml.ejercicio02;

/**
 * Clase de prueba para demostrar las relaciones del Ejercicio 2
 * - AGREGACIÓN: Celular → Batería
 * - ASOCIACIÓN BIDIRECCIONAL: Celular ↔ Usuario
 */
public class TestEjercicio02 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 2: Celular - Batería - Usuario ===\n");
        
        // 1. Crear baterías independientes (AGREGACIÓN)
        Bateria bateria1 = new Bateria("Li-Ion 3000", 3000);
        Bateria bateria2 = new Bateria("Li-Po 4000", 4000);
        System.out.println("1. Baterías creadas independientemente:");
        System.out.println("   " + bateria1);
        System.out.println("   " + bateria2);
        
        // 2. Crear usuarios
        Usuario usuario1 = new Usuario("Ana López", "11111111");
        Usuario usuario2 = new Usuario("Carlos Ruiz", "22222222");
        System.out.println("\n2. Usuarios creados:");
        System.out.println("   " + usuario1);
        System.out.println("   " + usuario2);
        
        // 3. Crear celular con batería (AGREGACIÓN)
        Celular celular1 = new Celular("123456789012345", "Samsung", "Galaxy S21", bateria1);
        System.out.println("\n3. Celular creado con batería:");
        System.out.println("   " + celular1);
        
        // 4. Establecer relación bidireccional celular-usuario
        celular1.setUsuario(usuario1);
        System.out.println("\n4. Después de asignar usuario al celular:");
        System.out.println("   Celular: " + celular1);
        System.out.println("   Usuario: " + usuario1);
        
        // 5. Verificar relación bidireccional
        System.out.println("\n5. Verificación de relación bidireccional:");
        System.out.println("   ¿El usuario tiene celular? " + 
                          (usuario1.getCelular() != null));
        System.out.println("   ¿El celular tiene usuario? " + 
                          (celular1.getUsuario() != null));
        
        // 6. Demostrar AGREGACIÓN: cambiar batería
        System.out.println("\n6. Demostrando AGREGACIÓN - cambiar batería:");
        System.out.println("   Batería original: " + celular1.getBateria());
        celular1.cambiarBateria(bateria2);
        System.out.println("   Batería nueva: " + celular1.getBateria());
        System.out.println("   Batería original sigue existiendo: " + bateria1);
        
        // 7. Crear otro celular sin batería
        Celular celular2 = new Celular("987654321098765", "iPhone", "13 Pro");
        System.out.println("\n7. Celular sin batería:");
        System.out.println("   " + celular2);
        
        // 8. Reutilizar la batería 1 en el celular 2 (AGREGACIÓN)
        celular2.setBateria(bateria1);
        System.out.println("\n8. Reutilizando batería1 en celular2:");
        System.out.println("   " + celular2);
        
        // 9. Cambiar el celular del usuario
        System.out.println("\n9. Cambiando celular del usuario:");
        System.out.println("   Antes - Usuario1: " + usuario1);
        usuario1.setCelular(celular2);
        System.out.println("   Después - Usuario1: " + usuario1);
        System.out.println("   Celular1 (sin usuario): " + celular1);
        System.out.println("   Celular2 (con usuario): " + celular2);
        
        System.out.println("\n=== FIN DEL EJERCICIO 2 ===");
    }
}