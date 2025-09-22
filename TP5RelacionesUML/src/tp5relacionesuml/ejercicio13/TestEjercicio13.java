package tp5relacionesuml.ejercicio13;

/**
 * Clase de prueba para demostrar las relaciones del Ejercicio 13
 * - ASOCIACIÓN UNIDIRECCIONAL: CódigoQR → Usuario
 * - DEPENDENCIA DE CREACIÓN: GeneradorQR.generar(String, Usuario)
 */
public class TestEjercicio13 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 13: GeneradorQR - Usuario - CódigoQR ===\n");
        
        // 1. Crear usuarios independientes
        Usuario usuario1 = new Usuario("Ana Martínez", "ana.martinez@empresa.com");
        Usuario usuario2 = new Usuario("Carlos Rodríguez", "carlos.rodriguez@startup.com");
        Usuario usuario3 = new Usuario("Lucía Fernández", "lucia.fernandez@freelance.com");
        
        System.out.println("1. Usuarios registrados:");
        System.out.println("   " + usuario1);
        System.out.println("   " + usuario2);
        System.out.println("   " + usuario3);
        
        // 2. Crear generadores QR
        GeneradorQR generador1 = new GeneradorQR("3.2.1", "Reed-Solomon");
        GeneradorQR generador2 = new GeneradorQR("2.8.5", "BCH");
        
        System.out.println("\n2. Generadores QR disponibles:");
        System.out.println("   " + generador1);
        System.out.println("   " + generador2);
        
        // 3. Demostrar DEPENDENCIA DE CREACIÓN - generar códigos QR individuales
        System.out.println("\n3. Demostrando DEPENDENCIA DE CREACIÓN - generar códigos:");
        System.out.println("=".repeat(60));
        
        CodigoQR qr1 = generador1.generar("https://www.ejemplo.com", usuario1);
        System.out.println("Código generado: " + qr1);
        
        System.out.println("\n" + "-".repeat(60));
        CodigoQR qr2 = generador1.generar("Bienvenido a nuestro evento especial 2024", usuario1);
        System.out.println("Código generado: " + qr2);
        
        // 4. Demostrar ASOCIACIÓN UNIDIRECCIONAL
        System.out.println("\n" + "=".repeat(60));
        System.out.println("4. Demostrando ASOCIACIÓN UNIDIRECCIONAL:");
        System.out.println("   QR1 conoce al usuario: " + 
                          (qr1.getUsuario() != null ? qr1.getUsuario().getNombre() : "No"));
        System.out.println("   QR2 conoce al usuario: " + 
                          (qr2.getUsuario() != null ? qr2.getUsuario().getNombre() : "No"));
        System.out.println("   ¿El usuario1 conoce sus códigos QR? NO (unidireccional)");
        System.out.println("   Los usuarios no mantienen referencias a sus códigos QR");
        
        // 5. Usar otro generador con diferente usuario
        System.out.println("\n" + "=".repeat(60));
        System.out.println("5. Usando otro generador con diferente usuario:");
        
        CodigoQR qr3 = generador2.generar("carlos.rodriguez@startup.com", usuario2);
        System.out.println("Código generado: " + qr3);
        
        // 6. Demostrar DEPENDENCIA DE CREACIÓN - generar para tipos específicos
        System.out.println("\n" + "=".repeat(60));
        System.out.println("6. Generando códigos para tipos específicos:");
        
        CodigoQR qrURL = generador1.generarParaURL("www.mitienda.com", usuario2);
        System.out.println("QR URL: " + qrURL);
        
        System.out.println("\n" + "-".repeat(60));
        CodigoQR qrWiFi = generador2.generarParaWiFi("OficinaWiFi", "password123", usuario3);
        System.out.println("QR WiFi: " + qrWiFi);
        
        // 7. Demostrar DEPENDENCIA DE CREACIÓN - generar lote
        System.out.println("\n" + "=".repeat(60));
        System.out.println("7. Demostrando DEPENDENCIA DE CREACIÓN - lote de códigos:");
        
        String[] valoresLote = {
            "https://docs.google.com/forms/12345",
            "+54 11 1234-5678",
            "Código de descuento: DESC2024",
            "mailto:contacto@empresa.com"
        };
        
        CodigoQR[] loteCodigos = generador1.generarLote(valoresLote, usuario3);
        
        System.out.println("\nCódigos del lote generados:");
        for (int i = 0; i < loteCodigos.length; i++) {
            if (loteCodigos[i] != null) {
                System.out.println("   " + (i+1) + ". " + loteCodigos[i]);
            }
        }
        
        // 8. Mostrar información completa de códigos creados
        System.out.println("\n" + "=".repeat(60));
        System.out.println("8. Información completa de códigos QR creados:");
        
        CodigoQR[] todosLosCodigos = {qr1, qr2, qr3, qrURL, qrWiFi};
        for (int i = 0; i < todosLosCodigos.length; i++) {
            if (todosLosCodigos[i] != null) {
                System.out.println("\n   Código " + (i+1) + ":");
                System.out.println("   " + todosLosCodigos[i].getInformacionCompleta());
            }
        }
        
        // 9. Mostrar representación visual de algunos códigos
        System.out.println("\n" + "=".repeat(60));
        System.out.println("9. Representación visual de códigos QR:");
        
        System.out.println("\nQR1 (URL):");
        System.out.println(qr1.getRepresentacionVisual());
        
        System.out.println("\nQR WiFi:");
        System.out.println(qrWiFi.getRepresentacionVisual());
        
        // 10. Reutilizar usuarios en diferentes generadores
        System.out.println("\n" + "=".repeat(60));
        System.out.println("10. Reutilizando usuarios en diferentes generadores:");
        
        CodigoQR qr4 = generador1.generar("Evento Anual 2024", usuario2);
        CodigoQR qr5 = generador2.generar("Evento Anual 2024", usuario2);
        
        System.out.println("Mismo usuario, diferentes generadores:");
        System.out.println("   Generador1: " + qr4);
        System.out.println("   Generador2: " + qr5);
        
        // 11. Mostrar estadísticas de los generadores
        System.out.println("\n" + "=".repeat(60));
        System.out.println("11. Estadísticas de los generadores:");
        System.out.println("   " + generador1.getEstadisticas());
        System.out.println("   " + generador2.getEstadisticas());
        
        // 12. Demostrar que los códigos QR son independientes después de la creación
        System.out.println("\n12. Confirmando DEPENDENCIA DE CREACIÓN:");
        System.out.println("    Los generadores NO mantienen referencias a los códigos QR creados");
        System.out.println("    Crean objetos CodigoQR en tiempo de ejecución y los devuelven");
        System.out.println("    Los códigos QR son independientes después de ser creados");
        System.out.println("    Los generadores pueden crear múltiples códigos para el mismo usuario");
        
        // 13. Crear código QR con contenido inválido para mostrar manejo de errores
        System.out.println("\n" + "=".repeat(60));
        System.out.println("13. Manejo de errores en la creación:");
        
        CodigoQR qrError1 = generador1.generar("", usuario1);
        CodigoQR qrError2 = generador1.generar("Contenido válido", null);
        
        System.out.println("QR con contenido vacío: " + qrError1);
        System.out.println("QR sin usuario: " + qrError2);
        
        System.out.println("\n=== FIN DEL EJERCICIO 13 ===");
    }
}