package tp5relacionesuml.ejercicio10;

/**
 * Clase de prueba para demostrar las relaciones del Ejercicio 10
 * - COMPOSICIÓN: CuentaBancaria → ClaveSeguridad
 * - ASOCIACIÓN BIDIRECCIONAL: CuentaBancaria ↔ Titular
 */
public class TestEjercicio10 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 10: CuentaBancaria - ClaveSeguridad - Titular ===\n");
        
        // 1. Crear titulares
        Titular titular1 = new Titular("José Martínez", "20345678");
        Titular titular2 = new Titular("Laura Fernández", "27987654");
        Titular titular3 = new Titular("Diego Castro", "33555777");
        
        System.out.println("1. Titulares creados:");
        System.out.println("   " + titular1);
        System.out.println("   " + titular2);
        System.out.println("   " + titular3);
        
        // 2. Crear cuentas bancarias (que internamente crean sus claves - COMPOSICIÓN)
        CuentaBancaria cuenta1 = new CuentaBancaria("0000003100012345678901", 15000.50, "1234");
        CuentaBancaria cuenta2 = new CuentaBancaria("0000003100087654321098", 8750.00, "5678");
        CuentaBancaria cuenta3 = new CuentaBancaria("0000003100055577799911", 25000.75, "9999");
        
        System.out.println("\n2. Cuentas bancarias creadas con claves de seguridad (COMPOSICIÓN):");
        System.out.println("   " + cuenta1);
        System.out.println("   " + cuenta2);
        System.out.println("   " + cuenta3);
        
        // 3. Establecer relaciones bidireccionales cuenta-titular
        cuenta1.setTitular(titular1);
        cuenta2.setTitular(titular2);
        
        System.out.println("\n3. Después de asignar titulares:");
        System.out.println("   Cuenta1: " + cuenta1);
        System.out.println("   Cuenta2: " + cuenta2);
        System.out.println("   Titular1: " + titular1);
        System.out.println("   Titular2: " + titular2);
        
        // 4. Verificar relaciones bidireccionales
        System.out.println("\n4. Verificación de relaciones bidireccionales:");
        System.out.println("   ¿Titular1 tiene cuenta? " + 
                          (titular1.getCuentaBancaria() != null));
        System.out.println("   ¿Cuenta1 tiene titular? " + 
                          (cuenta1.getTitular() != null));
        System.out.println("   ¿Son la misma relación? " + 
                          (titular1.getCuentaBancaria() == cuenta1));
        
        // 5. Demostrar COMPOSICIÓN - acceder a claves de seguridad
        System.out.println("\n5. Demostrando COMPOSICIÓN - claves creadas internamente:");
        System.out.println("   Clave cuenta1: " + cuenta1.getClaveSeguridad());
        System.out.println("   Clave cuenta2: " + cuenta2.getClaveSeguridad());
        System.out.println("   Clave cuenta3: " + cuenta3.getClaveSeguridad());
        
        // 6. Realizar operaciones bancarias con validación de clave
        System.out.println("\n6. Operaciones bancarias:");
        System.out.println("   Saldo inicial cuenta1: $" + cuenta1.getSaldo());
        
        // Depósito (no requiere clave)
        boolean depositoExitoso = cuenta1.depositar(500.00);
        System.out.println("   Depósito de $500: " + (depositoExitoso ? "EXITOSO" : "FALLIDO"));
        System.out.println("   Saldo después del depósito: $" + cuenta1.getSaldo());
        
        // Retiro con clave correcta
        boolean retiroExitoso = cuenta1.retirar(1000.00, "1234");
        System.out.println("   Retiro de $1000 con clave correcta: " + (retiroExitoso ? "EXITOSO" : "FALLIDO"));
        System.out.println("   Saldo después del retiro: $" + cuenta1.getSaldo());
        
        // Retiro con clave incorrecta
        boolean retiroFallido = cuenta1.retirar(500.00, "0000");
        System.out.println("   Retiro de $500 con clave incorrecta: " + (retiroFallido ? "EXITOSO" : "FALLIDO"));
        
        // 7. Cambiar clave de seguridad (COMPOSICIÓN)
        System.out.println("\n7. Demostrando COMPOSICIÓN - cambiar clave:");
        System.out.println("   Clave original cuenta2: " + cuenta2.getClaveSeguridad());
        boolean cambioExitoso = cuenta2.cambiarClave("5678", "8765");
        System.out.println("   Cambio de clave: " + (cambioExitoso ? "EXITOSO" : "FALLIDO"));
        System.out.println("   Nueva clave cuenta2: " + cuenta2.getClaveSeguridad());
        System.out.println("   (La clave anterior fue destruida - COMPOSICIÓN)");
        
        // 8. Asignar cuenta3 al titular3
        titular3.setCuentaBancaria(cuenta3);
        System.out.println("\n8. Asignando cuenta3 al titular3:");
        System.out.println("   " + cuenta3);
        
        // 9. Cambiar titular de una cuenta
        System.out.println("\n9. Cambiando cuenta1 del titular1 al titular3:");
        System.out.println("   Antes - Titular1: " + titular1);
        System.out.println("   Antes - Titular3: " + titular3);
        
        titular3.setCuentaBancaria(cuenta1);
        
        System.out.println("   Después del cambio:");
        System.out.println("   Titular1: " + titular1);
        System.out.println("   Titular3: " + titular3);
        System.out.println("   Cuenta1: " + cuenta1);
        
        // 10. Mostrar información completa de todas las cuentas
        System.out.println("\n10. Estado completo de las cuentas bancarias:");
        CuentaBancaria[] cuentas = {cuenta1, cuenta2, cuenta3};
        for (int i = 0; i < cuentas.length; i++) {
            System.out.println("    " + (i+1) + ". " + cuentas[i].getInformacionCompleta());
        }
        
        // 11. Crear nueva cuenta para titular sin cuenta
        CuentaBancaria cuenta4 = new CuentaBancaria("0000003100099988877766", 5000.00, "4321");
        titular1.setCuentaBancaria(cuenta4);
        
        System.out.println("\n11. Nueva cuenta para titular1:");
        System.out.println("    " + cuenta4.getInformacionCompleta());
        
        // 12. Demostrar que las claves no pueden existir independientemente
        System.out.println("\n12. Demostrando COMPOSICIÓN:");
        System.out.println("    Las claves de seguridad NO pueden crearse independientemente");
        System.out.println("    Solo existen como parte de una cuenta bancaria específica");
        System.out.println("    Si la cuenta se elimina, su clave también se destruye");
        
        // 13. Validaciones de seguridad
        System.out.println("\n13. Validaciones de seguridad:");
        System.out.println("    Validar clave cuenta1 con '1234': " + cuenta1.validarClave("1234"));
        System.out.println("    Validar clave cuenta2 con '8765': " + cuenta2.validarClave("8765"));
        System.out.println("    Validar clave cuenta4 con '0000': " + cuenta4.validarClave("0000"));
        
        System.out.println("\n=== FIN DEL EJERCICIO 10 ===");
    }
}