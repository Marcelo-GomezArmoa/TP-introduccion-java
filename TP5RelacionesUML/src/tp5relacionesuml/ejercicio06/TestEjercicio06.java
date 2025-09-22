package tp5relacionesuml.ejercicio06;

/**
 * Clase de prueba para demostrar las relaciones del Ejercicio 6
 * - ASOCIACIÓN UNIDIRECCIONAL: Reserva → Cliente
 * - AGREGACIÓN: Reserva → Mesa
 */
public class TestEjercicio06 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 6: Reserva - Cliente - Mesa ===\n");
        
        // 1. Crear clientes independientes
        Cliente cliente1 = new Cliente("María Rodríguez", "11-2345-6789");
        Cliente cliente2 = new Cliente("Carlos Méndez", "11-8765-4321");
        Cliente cliente3 = new Cliente("Ana Jiménez", "11-5555-7777");
        Cliente cliente4 = new Cliente("Luis Castro", "11-9999-1111");
        
        System.out.println("1. Clientes creados:");
        System.out.println("   " + cliente1);
        System.out.println("   " + cliente2);
        System.out.println("   " + cliente3);
        System.out.println("   " + cliente4);
        
        // 2. Crear mesas independientes (AGREGACIÓN)
        Mesa mesa1 = new Mesa(1, 2);
        Mesa mesa2 = new Mesa(2, 4);
        Mesa mesa3 = new Mesa(3, 6);
        Mesa mesa4 = new Mesa(4, 8);
        Mesa mesa5 = new Mesa(5, 4);
        
        System.out.println("\n2. Mesas del restaurante:");
        System.out.println("   " + mesa1);
        System.out.println("   " + mesa2);
        System.out.println("   " + mesa3);
        System.out.println("   " + mesa4);
        System.out.println("   " + mesa5);
        
        // 3. Crear reservas básicas
        Reserva reserva1 = new Reserva("2024-03-15", "20:00");
        Reserva reserva2 = new Reserva("2024-03-15", "20:30");
        Reserva reserva3 = new Reserva("2024-03-16", "19:00");
        
        System.out.println("\n3. Reservas creadas (sin asignaciones):");
        System.out.println("   " + reserva1);
        System.out.println("   " + reserva2);
        System.out.println("   " + reserva3);
        
        // 4. Asignar clientes y mesas a las reservas
        reserva1.setCliente(cliente1);
        reserva1.setMesa(mesa1);
        
        reserva2.setCliente(cliente2);
        reserva2.setMesa(mesa2);
        
        System.out.println("\n4. Después de asignar clientes y mesas:");
        System.out.println("   " + reserva1);
        System.out.println("   " + reserva2);
        System.out.println("   " + reserva3);
        
        // 5. Demostrar ASOCIACIÓN UNIDIRECCIONAL
        System.out.println("\n5. Demostrando ASOCIACIÓN UNIDIRECCIONAL:");
        System.out.println("   La reserva1 conoce al cliente: " + 
                          (reserva1.getCliente() != null ? reserva1.getCliente().getNombre() : "No"));
        System.out.println("   ¿El cliente1 conoce sus reservas? NO (unidireccional)");
        System.out.println("   Los clientes no mantienen referencias a sus reservas");
        
        // 6. Demostrar AGREGACIÓN: reutilizar mesa
        System.out.println("\n6. Demostrando AGREGACIÓN - reutilizar mesa:");
        System.out.println("   Mesa2 original en reserva2: " + reserva2.getMesa().getNumero());
        
        // Crear nueva reserva para el mismo día con la misma mesa
        Reserva reserva4 = new Reserva("2024-03-15", "22:00", cliente3, mesa2);
        System.out.println("   Nueva reserva4 con la misma mesa: " + reserva4);
        System.out.println("   Mesa2 puede ser reutilizada (agregación): " + mesa2);
        
        // 7. Cambiar mesa de una reserva
        System.out.println("\n7. Cambiando mesa de reserva3:");
        System.out.println("   Reserva3 antes: " + reserva3);
        reserva3.setCliente(cliente4);
        reserva3.setMesa(mesa3);
        System.out.println("   Reserva3 después: " + reserva3);
        
        // 8. Verificar reservas completas
        System.out.println("\n8. Estado de las reservas:");
        Reserva[] reservas = {reserva1, reserva2, reserva3, reserva4};
        for (int i = 0; i < reservas.length; i++) {
            System.out.println("   Reserva" + (i+1) + " completa: " + reservas[i].estaCompleta());
        }
        
        // 9. Mostrar información completa de todas las reservas
        System.out.println("\n9. Información completa de todas las reservas:");
        for (int i = 0; i < reservas.length; i++) {
            System.out.println("   " + (i+1) + ". " + reservas[i].getInformacionCompleta());
        }
        
        // 10. Simular cambio de mesa por disponibilidad
        System.out.println("\n10. Simulando cambio de mesa por disponibilidad:");
        System.out.println("    Reserva1 mesa original: " + reserva1.getMesa().getNumero());
        reserva1.setMesa(mesa5);
        System.out.println("    Reserva1 nueva mesa: " + reserva1.getMesa().getNumero());
        System.out.println("    Mesa1 sigue disponible: " + mesa1);
        
        // 11. Crear reserva completa desde el constructor
        Reserva reserva5 = new Reserva("2024-03-17", "21:00", cliente1, mesa4);
        System.out.println("\n11. Reserva completa desde constructor:");
        System.out.println("    " + reserva5.getInformacionCompleta());
        
        System.out.println("\n=== FIN DEL EJERCICIO 6 ===");
    }
}