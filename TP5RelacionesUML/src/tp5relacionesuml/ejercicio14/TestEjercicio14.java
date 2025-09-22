package tp5relacionesuml.ejercicio14;

/**
 * Clase de prueba para demostrar las relaciones del Ejercicio 14
 * - ASOCIACIÓN UNIDIRECCIONAL: Proyecto → EditorVideo
 * - DEPENDENCIA DE CREACIÓN: EditorVideo.renderizar() crea objetos Render
 */
public class TestEjercicio14 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 14: EditorVideo - Proyecto - Render ===\n");
        
        // 1. Crear editores de video independientes
        EditorVideo premierePro = new EditorVideo("Adobe Premiere Pro", "2024.1", "Adobe Systems");
        EditorVideo finalCut = new EditorVideo("Final Cut Pro", "10.7", "Apple Inc.");
        EditorVideo davinci = new EditorVideo("DaVinci Resolve", "18.6", "Blackmagic Design");
        
        System.out.println("1. Editores de video disponibles:");
        System.out.println("   " + premierePro);
        System.out.println("   " + finalCut);
        System.out.println("   " + davinci);
        
        // 2. Crear proyectos con ASOCIACIÓN UNIDIRECCIONAL
        System.out.println("\n2. Creando proyectos con ASOCIACIÓN UNIDIRECCIONAL:");
        System.out.println("=".repeat(60));
        
        Proyecto proyecto1 = new Proyecto(
            "Comercial Verano 2024",
            "Video promocional para campaña de verano",
            "/proyectos/comercial_verano/",
            premierePro // ASOCIACIÓN UNIDIRECCIONAL
        );
        
        Proyecto proyecto2 = new Proyecto(
            "Documental Naturaleza",
            "Documental sobre vida silvestre en los Andes",
            "/proyectos/documental_naturaleza/",
            finalCut // ASOCIACIÓN UNIDIRECCIONAL
        );
        
        Proyecto proyecto3 = new Proyecto(
            "Videoclip Musical",
            "Video musical para artista independiente",
            "/proyectos/videoclip_musical/"
            // Sin editor asignado inicialmente
        );
        
        System.out.println("Proyecto1: " + proyecto1);
        System.out.println("Proyecto2: " + proyecto2);
        System.out.println("Proyecto3: " + proyecto3);
        
        // 3. Asignar editor al proyecto3 (ASOCIACIÓN UNIDIRECCIONAL)
        System.out.println("\n3. Asignando editor al proyecto3:");
        proyecto3.setEditorVideo(davinci); // ASOCIACIÓN UNIDIRECCIONAL
        System.out.println("Editor asignado: " + proyecto3.getEditorVideo().getNombre());
        
        // 4. Demostrar DEPENDENCIA DE CREACIÓN - renders básicos
        System.out.println("\n4. Demostrando DEPENDENCIA DE CREACIÓN - renders básicos:");
        System.out.println("=".repeat(60));
        
        // El editor CREA objetos Render sin mantener referencias permanentes
        Render render1 = premierePro.renderizar("Comercial_Final", "mp4", 
                                               "/salida/comercial_final.mp4");
        System.out.println("Render creado: " + render1);
        
        System.out.println("\n" + "-".repeat(60));
        Render render2 = finalCut.renderizar("Documental_Trailer", "mov", 
                                           "/salida/documental_trailer.mov");
        System.out.println("Render creado: " + render2);
        
        // 5. Demostrar DEPENDENCIA DE CREACIÓN - renders avanzados
        System.out.println("\n" + "=".repeat(60));
        System.out.println("5. Demostrando DEPENDENCIA DE CREACIÓN - renders avanzados:");
        
        Render render3 = davinci.renderizarAvanzado("Videoclip_4K", "mov", 
                                                   "3840x2160", 95, 
                                                   "/salida/videoclip_4k.mov");
        System.out.println("Render 4K creado: " + render3);
        
        System.out.println("\n" + "-".repeat(60));
        Render render4 = premierePro.renderizarAvanzado("Comercial_HD", "mp4", 
                                                       "1920x1080", 85, 
                                                       "/salida/comercial_hd.mp4");
        System.out.println("Render HD creado: " + render4);
        
        // 6. Simular proceso de renderizado
        System.out.println("\n" + "=".repeat(60));
        System.out.println("6. Simulando proceso de renderizado:");
        
        render1.iniciarRender();
        render1.actualizarProgreso(25);
        render1.actualizarProgreso(50);
        render1.actualizarProgreso(75);
        render1.actualizarProgreso(100);
        
        System.out.println("\n" + "-".repeat(30));
        render3.iniciarRender();
        render3.actualizarProgreso(30);
        render3.pausarRender();
        render3.reanudarRender();
        render3.actualizarProgreso(100);
        
        // 7. Demostrar DEPENDENCIA DE CREACIÓN - renders para plataformas
        System.out.println("\n" + "=".repeat(60));
        System.out.println("7. Creando renders optimizados para plataformas:");
        
        Render renderYoutube = finalCut.renderizarParaPlataforma("Documental_YouTube", 
                                                               "youtube", 
                                                               "/salida/documental_youtube.mp4");
        System.out.println("Render YouTube: " + renderYoutube);
        
        System.out.println("\n" + "-".repeat(60));
        Render renderInstagram = davinci.renderizarParaPlataforma("Videoclip_Instagram", 
                                                                 "instagram", 
                                                                 "/salida/videoclip_instagram.mp4");
        System.out.println("Render Instagram: " + renderInstagram);
        
        // 8. Demostrar DEPENDENCIA DE CREACIÓN - lote de renders
        System.out.println("\n" + "=".repeat(60));
        System.out.println("8. Creando lote de renders:");
        
        String[] nombresLote = {
            "Teaser_1", "Teaser_2", "Trailer_Corto", "Trailer_Largo", "Version_Final"
        };
        
        Render[] loteRenders = premierePro.renderizarLote(nombresLote, "mp4", 
                                                         "/salida/comercial/");
        
        System.out.println("\nRenders del lote creados:");
        for (int i = 0; i < loteRenders.length; i++) {
            if (loteRenders[i] != null) {
                System.out.println("   " + (i+1) + ". " + loteRenders[i]);
            }
        }
        
        // 9. Demostrar que los proyectos conocen a sus editores (ASOCIACIÓN UNIDIRECCIONAL)
        System.out.println("\n" + "=".repeat(60));
        System.out.println("9. Demostrando ASOCIACIÓN UNIDIRECCIONAL (Proyecto → Editor):");
        
        System.out.println("Proyecto1 conoce su editor: " + 
                          proyecto1.getEditorVideo().getNombre());
        System.out.println("Proyecto2 conoce su editor: " + 
                          proyecto2.getEditorVideo().getNombre());
        System.out.println("Proyecto3 conoce su editor: " + 
                          proyecto3.getEditorVideo().getNombre());
        
        System.out.println("\n¿Los editores conocen sus proyectos? NO (unidireccional)");
        System.out.println("Los editores no mantienen referencias a los proyectos que los usan");
        
        // 10. Gestionar proyectos con sus editores
        System.out.println("\n" + "=".repeat(60));
        System.out.println("10. Gestionando proyectos:");
        
        proyecto1.iniciarEdicion();
        proyecto2.iniciarEdicion();
        proyecto3.iniciarEdicion();
        
        System.out.println("\nFormatos soportados por cada proyecto:");
        System.out.println("   Proyecto1: " + String.join(", ", proyecto1.getFormatosSoportados()));
        System.out.println("   Proyecto2: " + String.join(", ", proyecto2.getFormatosSoportados()));
        System.out.println("   Proyecto3: " + String.join(", ", proyecto3.getFormatosSoportados()));
        
        // 11. Crear renders desde los proyectos usando sus editores
        System.out.println("\n" + "=".repeat(60));
        System.out.println("11. Creando renders desde proyectos (usando asociación):");
        
        if (proyecto1.getEditorVideo() != null) {
            Render renderDesdeProyecto1 = proyecto1.getEditorVideo().renderizarParaResolucion(
                "Final_" + proyecto1.getNombre().replace(" ", "_"), 
                "1920x1080", 
                "/salida/" + proyecto1.getNombre().toLowerCase().replace(" ", "_") + ".mp4"
            );
            System.out.println("Render desde proyecto1: " + renderDesdeProyecto1);
        }
        
        // 12. Mostrar información completa
        System.out.println("\n" + "=".repeat(60));
        System.out.println("12. Información completa de componentes:");
        
        System.out.println("\n--- INFORMACIÓN DE EDITORES ---");
        System.out.println(premierePro.getInformacionCompleta());
        
        System.out.println("\n--- INFORMACIÓN DE PROYECTOS ---");
        System.out.println(proyecto1.getInformacionCompleta());
        
        System.out.println("\n--- INFORMACIÓN DE RENDERS ---");
        System.out.println(render3.getInformacionCompleta());
        
        // 13. Mostrar estadísticas de editores
        System.out.println("\n" + "=".repeat(60));
        System.out.println("13. Estadísticas de editores:");
        System.out.println("   " + premierePro.getEstadisticas());
        System.out.println("   " + finalCut.getEstadisticas());
        System.out.println("   " + davinci.getEstadisticas());
        
        // 14. Finalizar proyectos
        System.out.println("\n" + "=".repeat(60));
        System.out.println("14. Finalizando proyectos:");
        
        proyecto1.finalizarEdicion();
        proyecto2.pausarEdicion();
        proyecto3.finalizarEdicion();
        
        System.out.println("\nEstados finales:");
        System.out.println("   " + proyecto1);
        System.out.println("   " + proyecto2);
        System.out.println("   " + proyecto3);
        
        // 15. Demonstrar DEPENDENCIA DE CREACIÓN - los editores no mantienen referencias
        System.out.println("\n15. Confirmando DEPENDENCIA DE CREACIÓN:");
        System.out.println("    Los editores NO mantienen referencias a los renders creados");
        System.out.println("    Crean objetos Render en tiempo de ejecución y los devuelven");
        System.out.println("    Los renders son independientes después de ser creados");
        System.out.println("    Los editores pueden crear múltiples renders para diferentes proyectos");
        System.out.println("    Los proyectos mantienen asociación unidireccional con sus editores");
        
        System.out.println("\n=== FIN DEL EJERCICIO 14 ===");
    }
}