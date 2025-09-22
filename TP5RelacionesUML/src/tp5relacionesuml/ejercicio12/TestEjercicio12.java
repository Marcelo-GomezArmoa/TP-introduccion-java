package tp5relacionesuml.ejercicio12;

/**
 * Clase de prueba para demostrar las relaciones del Ejercicio 12
 * - ASOCIACIÓN UNIDIRECCIONAL: Impuesto → Contribuyente
 * - DEPENDENCIA DE USO: Calculadora.calcular(Impuesto)
 */
public class TestEjercicio12 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 12: Impuesto - Contribuyente - Calculadora ===\n");
        
        // 1. Crear contribuyentes independientes
        Contribuyente contrib1 = new Contribuyente("Empresa ABC S.A.", "30-12345678-9");
        Contribuyente contrib2 = new Contribuyente("Juan Carlos Pérez", "20-98765432-1");
        Contribuyente contrib3 = new Contribuyente("Comercial XYZ Ltda.", "30-55555555-0");
        Contribuyente contrib4 = new Contribuyente("María Elena González", "27-11111111-3");
        
        System.out.println("1. Contribuyentes registrados:");
        System.out.println("   " + contrib1);
        System.out.println("   " + contrib2);
        System.out.println("   " + contrib3);
        System.out.println("   " + contrib4);
        
        // 2. Crear impuestos con asociaciones unidireccionales
        Impuesto impuesto1 = new Impuesto(15000.50, contrib1, "IVA", "Marzo 2024");
        Impuesto impuesto2 = new Impuesto(45000.00, contrib2, "Ganancias", "Año 2023");
        Impuesto impuesto3 = new Impuesto(8750.25, contrib3, "Ingresos Brutos", "Febrero 2024");
        Impuesto impuesto4 = new Impuesto(125000.00, contrib1, "Ganancias", "Año 2023");
        Impuesto impuesto5 = new Impuesto(2500.00); // Sin contribuyente ni tipo
        
        System.out.println("\n2. Impuestos creados con asociaciones:");
        System.out.println("   " + impuesto1);
        System.out.println("   " + impuesto2);
        System.out.println("   " + impuesto3);
        System.out.println("   " + impuesto4);
        System.out.println("   " + impuesto5);
        
        // 3. Demostrar ASOCIACIÓN UNIDIRECCIONAL
        System.out.println("\n3. Demostrando ASOCIACIÓN UNIDIRECCIONAL:");
        System.out.println("   Impuesto1 conoce al contribuyente: " + 
                          (impuesto1.getContribuyente() != null ? impuesto1.getContribuyente().getNombre() : "No"));
        System.out.println("   ¿El contribuyente1 conoce sus impuestos? NO (unidireccional)");
        System.out.println("   Los contribuyentes no mantienen referencias a sus impuestos");
        
        // 4. Crear calculadoras
        Calculadora calculadoraAFIP = new Calculadora("2024.1", "AFIP");
        Calculadora calculadoraRentas = new Calculadora("1.5.3", "Rentas Provinciales");
        
        System.out.println("\n4. Calculadoras fiscales:");
        System.out.println("   " + calculadoraAFIP);
        System.out.println("   " + calculadoraRentas);
        
        // 5. Demostrar DEPENDENCIA DE USO - calcular impuestos individuales
        System.out.println("\n5. Demostrando DEPENDENCIA DE USO - calcular impuestos:");
        calculadoraAFIP.calcular(impuesto1);
        
        System.out.println("\n" + "=".repeat(50));
        calculadoraAFIP.calcular(impuesto2);
        
        // 6. Usar otra calculadora con diferentes impuestos
        System.out.println("\n" + "=".repeat(50));
        calculadoraRentas.calcular(impuesto3);
        
        // 7. Demostrar DEPENDENCIA DE USO - generar reportes
        System.out.println("\n" + "=".repeat(50));
        System.out.println("7. Demostrando DEPENDENCIA DE USO - generar reportes:");
        calculadoraAFIP.generarReporte(impuesto4);
        
        // 8. Demostrar DEPENDENCIA DE USO - calcular lote de impuestos
        System.out.println("\n" + "=".repeat(50));
        System.out.println("8. Demostrando DEPENDENCIA DE USO - lote de impuestos:");
        Impuesto[] loteImpuestos = {impuesto1, impuesto2, impuesto3};
        calculadoraRentas.calcularLote(loteImpuestos);
        
        // 9. Reutilizar impuestos en diferentes calculadoras
        System.out.println("\n" + "=".repeat(50));
        System.out.println("9. Reutilizando impuestos en diferentes calculadoras:");
        System.out.println("   Impuesto1 en calculadora AFIP:");
        calculadoraAFIP.calcular(impuesto1);
        System.out.println("\n   El mismo impuesto1 en calculadora Rentas:");
        calculadoraRentas.calcular(impuesto1);
        
        // 10. Mostrar información completa de todos los impuestos
        System.out.println("\n" + "=".repeat(50));
        System.out.println("10. Base de datos fiscal completa:");
        Impuesto[] baseDatos = {impuesto1, impuesto2, impuesto3, impuesto4, impuesto5};
        for (int i = 0; i < baseDatos.length; i++) {
            System.out.println("    " + (i+1) + ". " + baseDatos[i].getInformacionCompleta());
        }
        
        // 11. Crear nuevo impuesto para contribuyente existente
        Impuesto impuesto6 = new Impuesto(7500.75, contrib4, "IVA", "Abril 2024");
        System.out.println("\n11. Nuevo impuesto para contribuyente existente:");
        System.out.println("    " + impuesto6.getInformacionCompleta());
        calculadoraAFIP.calcular(impuesto6);
        
        // 12. Asignar contribuyente al impuesto sin asignar
        System.out.println("\n" + "=".repeat(50));
        System.out.println("12. Asignando contribuyente a impuesto sin asignar:");
        System.out.println("    Antes: " + impuesto5);
        impuesto5.setContribuyente(contrib4);
        impuesto5.setTipo("Monotributo");
        impuesto5.setPeriodo("Marzo 2024");
        System.out.println("    Después: " + impuesto5);
        calculadoraRentas.generarReporte(impuesto5);
        
        // 13. Demostrar que las dependencias son temporales
        System.out.println("\n13. Confirmando DEPENDENCIA DE USO temporal:");
        System.out.println("    Las calculadoras NO guardan referencias permanentes a los impuestos");
        System.out.println("    Solo los usan temporalmente cuando se ejecutan los métodos");
        System.out.println("    Los impuestos pueden ser procesados por múltiples calculadoras");
        System.out.println("    Las calculadoras pueden funcionar sin impuestos precargados");
        
        // 14. Procesar lote completo
        System.out.println("\n" + "=".repeat(50));
        System.out.println("14. Procesamiento completo de todos los impuestos:");
        Impuesto[] todoLote = {impuesto1, impuesto2, impuesto3, impuesto4, impuesto5, impuesto6};
        calculadoraAFIP.calcularLote(todoLote);
        
        System.out.println("\n=== FIN DEL EJERCICIO 12 ===");
    }
}