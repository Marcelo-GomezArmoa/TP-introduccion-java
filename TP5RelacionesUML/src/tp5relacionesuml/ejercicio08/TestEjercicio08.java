package tp5relacionesuml.ejercicio08;

/**
 * Clase de prueba para demostrar las relaciones del Ejercicio 8
 * - COMPOSICIÓN: Documento → FirmaDigital
 * - AGREGACIÓN: FirmaDigital → Usuario
 */
public class TestEjercicio08 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 8: Documento - FirmaDigital - Usuario ===\n");
        
        // 1. Crear usuarios independientes (AGREGACIÓN)
        Usuario usuario1 = new Usuario("Dr. Elena Sánchez", "elena.sanchez@empresa.com");
        Usuario usuario2 = new Usuario("Ing. Roberto Díaz", "roberto.diaz@empresa.com");
        Usuario usuario3 = new Usuario("Lic. Patricia Morales", "patricia.morales@empresa.com");
        
        System.out.println("1. Usuarios creados:");
        System.out.println("   " + usuario1);
        System.out.println("   " + usuario2);
        System.out.println("   " + usuario3);
        
        // 2. Crear documentos sin firmar
        Documento doc1 = new Documento("Contrato de Servicios", 
            "Este contrato establece los términos y condiciones para la prestación de servicios de consultoría...");
        Documento doc2 = new Documento("Propuesta Técnica", 
            "La presente propuesta describe las actividades técnicas necesarias para el desarrollo del proyecto...");
        Documento doc3 = new Documento("Informe de Avance", 
            "Se presenta el siguiente informe de avance correspondiente al mes de marzo...");
        
        System.out.println("\n2. Documentos creados (sin firmar):");
        System.out.println("   " + doc1);
        System.out.println("   " + doc2);
        System.out.println("   " + doc3);
        
        // 3. Verificar estado inicial
        System.out.println("\n3. Estado inicial de los documentos:");
        System.out.println("   Doc1 firmado: " + doc1.estaFirmado());
        System.out.println("   Doc2 firmado: " + doc2.estaFirmado());
        System.out.println("   Doc3 firmado: " + doc3.estaFirmado());
        
        // 4. Firmar documentos (COMPOSICIÓN - crear firma digital)
        doc1.firmarDocumento(usuario1, "2024-03-15 10:30");
        doc2.firmarDocumento(usuario2, "2024-03-16 14:45");
        
        System.out.println("\n4. Después de firmar documentos:");
        System.out.println("   " + doc1);
        System.out.println("   " + doc2);
        System.out.println("   " + doc3);
        
        // 5. Demostrar COMPOSICIÓN - acceder a firma digital
        System.out.println("\n5. Demostrando COMPOSICIÓN - firmas creadas internamente:");
        System.out.println("   Firma del doc1: " + doc1.getFirmaDigital());
        System.out.println("   Firma del doc2: " + doc2.getFirmaDigital());
        System.out.println("   Firma del doc3: " + doc3.getFirmaDigital());
        
        // 6. Verificar validez de las firmas
        System.out.println("\n6. Validez de las firmas:");
        if (doc1.getFirmaDigital() != null) {
            System.out.println("   Firma doc1 válida: " + doc1.getFirmaDigital().esValida());
        }
        if (doc2.getFirmaDigital() != null) {
            System.out.println("   Firma doc2 válida: " + doc2.getFirmaDigital().esValida());
        }
        
        // 7. Demostrar AGREGACIÓN - reutilizar usuario en otro documento
        doc3.firmarDocumento(usuario1, "2024-03-17 09:15");
        System.out.println("\n7. Reutilizando usuario1 para firmar doc3:");
        System.out.println("   " + doc3);
        System.out.println("   Usuario1 ha firmado múltiples documentos (agregación)");
        
        // 8. Mostrar información completa de todos los documentos
        System.out.println("\n8. Información completa de todos los documentos:");
        Documento[] documentos = {doc1, doc2, doc3};
        for (int i = 0; i < documentos.length; i++) {
            System.out.println("   " + (i+1) + ". " + documentos[i].getInformacionCompleta());
        }
        
        // 9. Demostrar COMPOSICIÓN - eliminar firma
        System.out.println("\n9. Demostrando COMPOSICIÓN - eliminar firma del doc2:");
        System.out.println("   Antes: " + doc2.getInformacionCompleta());
        doc2.eliminarFirma();
        System.out.println("   Después: " + doc2.getInformacionCompleta());
        System.out.println("   La firma digital fue destruida (composición)");
        
        // 10. Crear nuevo documento y firmarlo con usuario existente
        Documento doc4 = new Documento("Acuerdo de Confidencialidad", 
            "Las partes acuerdan mantener confidencial toda la información compartida...");
        doc4.firmarDocumento(usuario3, "2024-03-18 16:20");
        
        System.out.println("\n10. Nuevo documento firmado por usuario3:");
        System.out.println("    " + doc4.getInformacionCompleta());
        
        // 11. Demostrar que las firmas no pueden existir sin documento
        System.out.println("\n11. Demostrando COMPOSICIÓN:");
        System.out.println("    Las firmas digitales NO pueden crearse independientemente");
        System.out.println("    Solo existen como parte de un documento específico");
        System.out.println("    Si el documento se elimina, su firma también se destruye");
        
        // 12. Cambiar usuario de una firma existente (AGREGACIÓN)
        if (doc1.getFirmaDigital() != null) {
            System.out.println("\n12. Cambiando usuario de firma existente (agregación):");
            System.out.println("    Firma original: " + doc1.getFirmaDigital());
            doc1.getFirmaDigital().setUsuario(usuario2);
            System.out.println("    Firma modificada: " + doc1.getFirmaDigital());
            System.out.println("    Usuario1 sigue existiendo independientemente");
        }
        
        System.out.println("\n=== FIN DEL EJERCICIO 8 ===");
    }
}