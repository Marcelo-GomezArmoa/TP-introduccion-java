package tp5relacionesuml.ejercicio04;

/**
 * Clase de prueba para demostrar las relaciones del Ejercicio 4
 * - ASOCIACIÓN BIDIRECCIONAL: TarjetaDeCrédito ↔ Cliente
 * - AGREGACIÓN: TarjetaDeCrédito → Banco
 */
public class TestEjercicio04 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 4: TarjetaDeCrédito - Cliente - Banco ===\n");
        
        // 1. Crear bancos independientes (AGREGACIÓN)
        Banco banco1 = new Banco("Banco Santander", "30-12345678-9");
        Banco banco2 = new Banco("Banco Galicia", "30-87654321-0");
        Banco banco3 = new Banco("BBVA Argentina", "30-11223344-5");
        
        System.out.println("1. Bancos creados:");
        System.out.println("   " + banco1);
        System.out.println("   " + banco2);
        System.out.println("   " + banco3);
        
        // 2. Crear clientes
        Cliente cliente1 = new Cliente("Patricia Gómez", "25123456");
        Cliente cliente2 = new Cliente("Roberto Silva", "28987654");
        Cliente cliente3 = new Cliente("Lucía Martín", "32555666");
        
        System.out.println("\n2. Clientes creados:");
        System.out.println("   " + cliente1);
        System.out.println("   " + cliente2);
        System.out.println("   " + cliente3);
        
        // 3. Crear tarjetas de crédito con bancos (AGREGACIÓN)
        TarjetaDeCredito tarjeta1 = new TarjetaDeCredito("1234567890123456", "12/2027", banco1);
        TarjetaDeCredito tarjeta2 = new TarjetaDeCredito("9876543210987654", "06/2026", banco2);
        TarjetaDeCredito tarjeta3 = new TarjetaDeCredito("5555444433332222", "03/2028");
        
        System.out.println("\n3. Tarjetas de crédito creadas:");
        System.out.println("   " + tarjeta1);
        System.out.println("   " + tarjeta2);
        System.out.println("   " + tarjeta3);
        
        // 4. Establecer relaciones bidireccionales tarjeta-cliente
        tarjeta1.setCliente(cliente1);
        tarjeta2.setCliente(cliente2);
        
        System.out.println("\n4. Después de asignar clientes a tarjetas:");
        System.out.println("   Cliente1: " + cliente1);
        System.out.println("   Cliente2: " + cliente2);
        System.out.println("   Cliente3: " + cliente3);
        System.out.println("   Tarjeta1: " + tarjeta1);
        System.out.println("   Tarjeta2: " + tarjeta2);
        
        // 5. Verificar relaciones bidireccionales
        System.out.println("\n5. Verificación de relaciones bidireccionales:");
        System.out.println("   ¿Cliente1 tiene tarjeta? " + 
                          (cliente1.getTarjetaDeCredito() != null));
        System.out.println("   ¿Tarjeta1 tiene cliente? " + 
                          (tarjeta1.getCliente() != null));
        System.out.println("   ¿Son la misma relación? " + 
                          (cliente1.getTarjetaDeCredito() == tarjeta1));
        
        // 6. Demostrar AGREGACIÓN: cambiar banco de tarjeta
        System.out.println("\n6. Demostrando AGREGACIÓN - cambiar banco:");
        System.out.println("   Tarjeta3 banco original: " + tarjeta3.getBanco());
        tarjeta3.setBanco(banco3);
        System.out.println("   Tarjeta3 nuevo banco: " + tarjeta3.getBanco());
        System.out.println("   Banco3 sigue existiendo independientemente");
        
        // 7. Asignar tarjeta3 al cliente3
        cliente3.setTarjetaDeCredito(tarjeta3);
        System.out.println("\n7. Asignando tarjeta3 al cliente3:");
        System.out.println("   " + tarjeta3.getInformacionCompleta());
        
        // 8. Cambiar tarjeta de un cliente a otro
        System.out.println("\n8. Cambiando tarjeta1 del cliente1 al cliente3:");
        System.out.println("   Antes - Cliente1: " + cliente1);
        System.out.println("   Antes - Cliente3: " + cliente3);
        
        cliente3.setTarjetaDeCredito(tarjeta1);
        
        System.out.println("   Después del cambio:");
        System.out.println("   Cliente1: " + cliente1);
        System.out.println("   Cliente3: " + cliente3);
        System.out.println("   Tarjeta1: " + tarjeta1);
        
        // 9. Mostrar información completa de todas las tarjetas
        System.out.println("\n9. Información completa de todas las tarjetas:");
        TarjetaDeCredito[] tarjetas = {tarjeta1, tarjeta2, tarjeta3};
        for (int i = 0; i < tarjetas.length; i++) {
            System.out.println("   " + (i+1) + ". " + tarjetas[i].getInformacionCompleta());
        }
        
        // 10. Crear nueva tarjeta del mismo banco para otro cliente
        TarjetaDeCredito tarjeta4 = new TarjetaDeCredito("1111222233334444", "09/2029", banco1);
        cliente2.setTarjetaDeCredito(tarjeta4);
        
        System.out.println("\n10. Nueva tarjeta del mismo banco para cliente2:");
        System.out.println("    " + tarjeta4.getInformacionCompleta());
        System.out.println("    Banco1 tiene múltiples tarjetas (agregación)");
        
        System.out.println("\n=== FIN DEL EJERCICIO 4 ===");
    }
}