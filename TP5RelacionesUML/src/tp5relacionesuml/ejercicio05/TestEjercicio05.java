package tp5relacionesuml.ejercicio05;

/**
 * Clase de prueba para demostrar las relaciones del Ejercicio 5
 * - COMPOSICIÓN: Computadora → PlacaMadre
 * - ASOCIACIÓN BIDIRECCIONAL: Computadora ↔ Propietario
 */
public class TestEjercicio05 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 5: Computadora - PlacaMadre - Propietario ===\n");
        
        // 1. Crear propietarios
        Propietario propietario1 = new Propietario("Diego Fernández", "30123456");
        Propietario propietario2 = new Propietario("Sofía Ramírez", "28987654");
        Propietario propietario3 = new Propietario("Mateo Torres", "35555666");
        
        System.out.println("1. Propietarios creados:");
        System.out.println("   " + propietario1);
        System.out.println("   " + propietario2);
        System.out.println("   " + propietario3);
        
        // 2. Crear computadoras (que internamente crean sus placas madre - COMPOSICIÓN)
        Computadora comp1 = new Computadora("Dell", "DL001234", "ASUS Prime B450M", "AMD B450");
        Computadora comp2 = new Computadora("HP", "HP987654", "MSI B550M Pro", "AMD B550");
        Computadora comp3 = new Computadora("Lenovo", "LN555777", "Gigabyte Z590", "Intel Z590");
        
        System.out.println("\n2. Computadoras creadas con placas madre (COMPOSICIÓN):");
        System.out.println("   " + comp1);
        System.out.println("   " + comp2);
        System.out.println("   " + comp3);
        
        // 3. Establecer relaciones bidireccionales computadora-propietario
        comp1.setPropietario(propietario1);
        comp2.setPropietario(propietario2);
        
        System.out.println("\n3. Después de asignar propietarios:");
        System.out.println("   Computadora1: " + comp1);
        System.out.println("   Computadora2: " + comp2);
        System.out.println("   Propietario1: " + propietario1);
        System.out.println("   Propietario2: " + propietario2);
        
        // 4. Verificar relaciones bidireccionales
        System.out.println("\n4. Verificación de relaciones bidireccionales:");
        System.out.println("   ¿Propietario1 tiene computadora? " + 
                          (propietario1.getComputadora() != null));
        System.out.println("   ¿Computadora1 tiene propietario? " + 
                          (comp1.getPropietario() != null));
        System.out.println("   ¿Son la misma relación? " + 
                          (propietario1.getComputadora() == comp1));
        
        // 5. Demostrar COMPOSICIÓN: reemplazar placa madre
        System.out.println("\n5. Demostrando COMPOSICIÓN - reemplazar placa madre:");
        System.out.println("   Placa original comp1: " + comp1.getPlacaMadre());
        comp1.reemplazarPlacaMadre("ASUS ROG Strix B550-F", "AMD B550");
        System.out.println("   Placa nueva comp1: " + comp1.getPlacaMadre());
        System.out.println("   (La placa anterior fue destruida - COMPOSICIÓN)");
        
        // 6. Mostrar especificaciones completas
        System.out.println("\n6. Especificaciones completas:");
        System.out.println("   " + comp1.getEspecificaciones());
        System.out.println("   " + comp2.getEspecificaciones());
        
        // 7. Asignar computadora3 al propietario3
        propietario3.setComputadora(comp3);
        System.out.println("\n7. Asignando comp3 al propietario3:");
        System.out.println("   " + comp3.getEspecificaciones());
        
        // 8. Cambiar computadora entre propietarios
        System.out.println("\n8. Cambiando comp1 del propietario1 al propietario3:");
        System.out.println("   Antes - Propietario1: " + propietario1);
        System.out.println("   Antes - Propietario3: " + propietario3);
        
        propietario3.setComputadora(comp1);
        
        System.out.println("   Después del cambio:");
        System.out.println("   Propietario1: " + propietario1);
        System.out.println("   Propietario3: " + propietario3);
        System.out.println("   Comp1: " + comp1);
        
        // 9. Crear nueva computadora para propietario sin computadora
        Computadora comp4 = new Computadora("Apple", "MAC123456", "Apple M2", "Apple Silicon M2");
        propietario1.setComputadora(comp4);
        
        System.out.println("\n9. Nueva computadora para propietario1:");
        System.out.println("   " + comp4.getEspecificaciones());
        
        // 10. Mostrar todas las computadoras y sus relaciones
        System.out.println("\n10. Inventario completo:");
        Computadora[] inventario = {comp1, comp2, comp3, comp4};
        for (int i = 0; i < inventario.length; i++) {
            System.out.println("    " + (i+1) + ". " + inventario[i].getEspecificaciones());
        }
        
        // 11. Demostrar que las placas madre no pueden existir independientemente
        System.out.println("\n11. Demostrando COMPOSICIÓN:");
        System.out.println("    Las placas madre NO pueden crearse independientemente");
        System.out.println("    Solo existen como parte de una computadora");
        System.out.println("    Si la computadora se destruye, la placa madre también");
        
        System.out.println("\n=== FIN DEL EJERCICIO 5 ===");
    }
}