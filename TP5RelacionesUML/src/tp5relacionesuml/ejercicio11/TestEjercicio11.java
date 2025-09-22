package tp5relacionesuml.ejercicio11;

/**
 * Clase de prueba para demostrar las relaciones del Ejercicio 11
 * - ASOCIACIÓN UNIDIRECCIONAL: Canción → Artista
 * - DEPENDENCIA DE USO: Reproductor.reproducir(Cancion)
 */
public class TestEjercicio11 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 11: Reproductor - Canción - Artista ===\n");
        
        // 1. Crear artistas independientes
        Artista artista1 = new Artista("The Beatles", "Rock");
        Artista artista2 = new Artista("Michael Jackson", "Pop");
        Artista artista3 = new Artista("Bob Marley", "Reggae");
        Artista artista4 = new Artista("Mozart", "Clásica");
        
        System.out.println("1. Artistas disponibles:");
        System.out.println("   " + artista1);
        System.out.println("   " + artista2);
        System.out.println("   " + artista3);
        System.out.println("   " + artista4);
        
        // 2. Crear canciones con asociaciones unidireccionales
        Cancion cancion1 = new Cancion("Hey Jude", artista1);
        Cancion cancion2 = new Cancion("Billie Jean", artista2);
        Cancion cancion3 = new Cancion("No Woman No Cry", artista3);
        Cancion cancion4 = new Cancion("Eine kleine Nachtmusik", artista4);
        Cancion cancion5 = new Cancion("Canción sin artista");
        
        System.out.println("\n2. Canciones creadas con asociaciones:");
        System.out.println("   " + cancion1);
        System.out.println("   " + cancion2);
        System.out.println("   " + cancion3);
        System.out.println("   " + cancion4);
        System.out.println("   " + cancion5);
        
        // 3. Demostrar ASOCIACIÓN UNIDIRECCIONAL
        System.out.println("\n3. Demostrando ASOCIACIÓN UNIDIRECCIONAL:");
        System.out.println("   Canción1 conoce al artista: " + 
                          (cancion1.getArtista() != null ? cancion1.getArtista().getNombre() : "No"));
        System.out.println("   ¿El artista1 conoce sus canciones? NO (unidireccional)");
        System.out.println("   Los artistas no mantienen referencias a sus canciones");
        
        // 4. Crear reproductor
        Reproductor reproductor1 = new Reproductor("Sony WalkMan");
        Reproductor reproductor2 = new Reproductor("iPod Classic");
        
        System.out.println("\n4. Reproductores creados:");
        System.out.println("   " + reproductor1);
        System.out.println("   " + reproductor2);
        
        // 5. Demostrar DEPENDENCIA DE USO - método reproducir()
        System.out.println("\n5. Demostrando DEPENDENCIA DE USO - reproducir canciones:");
        reproductor1.reproducir(cancion1);
        System.out.println("   Estado después de reproducir: " + reproductor1);
        
        reproductor1.pausar();
        reproductor1.reproducir(cancion2);
        
        // 6. Usar otro reproductor con diferentes canciones
        System.out.println("\n6. Usando otro reproductor:");
        reproductor2.reproducir(cancion3);
        reproductor2.pausar();
        reproductor2.reproducir(cancion4);
        
        // 7. Demostrar DEPENDENCIA DE USO - analizar canciones
        System.out.println("\n7. Demostrando DEPENDENCIA DE USO - analizar canciones:");
        reproductor1.detener();
        reproductor1.analizarCancion(cancion1);
        System.out.println();
        reproductor1.analizarCancion(cancion5);
        
        // 8. Demostrar DEPENDENCIA DE USO - lista de reproducción
        System.out.println("\n8. Demostrando DEPENDENCIA DE USO - lista de reproducción:");
        Cancion[] playlist = {cancion1, cancion2, cancion3, cancion4};
        reproductor2.detener();
        reproductor2.reproducirLista(playlist);
        
        // 9. Reutilizar canciones en diferentes reproductores
        System.out.println("\n9. Reutilizando canciones en diferentes reproductores:");
        System.out.println("   Canción2 en reproductor1:");
        reproductor1.reproducir(cancion2);
        System.out.println("   La misma canción2 en reproductor2:");
        reproductor2.detener();
        reproductor2.reproducir(cancion2);
        
        // 10. Mostrar información completa de las canciones
        System.out.println("\n10. Biblioteca musical completa:");
        Cancion[] biblioteca = {cancion1, cancion2, cancion3, cancion4, cancion5};
        for (int i = 0; i < biblioteca.length; i++) {
            System.out.println("    " + (i+1) + ". " + biblioteca[i].getInformacionCompleta());
        }
        
        // 11. Crear nueva canción para artista existente
        Cancion cancion6 = new Cancion("Let It Be", artista1);
        System.out.println("\n11. Nueva canción para artista existente:");
        System.out.println("    " + cancion6.getInformacionCompleta());
        reproductor1.detener();
        reproductor1.reproducir(cancion6);
        
        // 12. Demostrar que las dependencias son temporales
        System.out.println("\n12. Demostrando DEPENDENCIA DE USO temporal:");
        System.out.println("    El reproductor1 antes de detener: " + reproductor1);
        reproductor1.detener();
        System.out.println("    El reproductor1 después de detener: " + reproductor1);
        System.out.println("    La canción sigue existiendo independientemente: " + cancion6);
        
        // 13. Usar canción sin artista
        System.out.println("\n13. Reproduciendo canción sin artista:");
        reproductor2.detener();
        reproductor2.reproducir(cancion5);
        reproductor2.analizarCancion(cancion5);
        
        // 14. Confirmar que no hay dependencias permanentes
        System.out.println("\n14. Confirmando DEPENDENCIA DE USO:");
        System.out.println("    Los reproductores NO guardan referencias permanentes a las canciones");
        System.out.println("    Solo las usan temporalmente cuando se ejecutan los métodos");
        System.out.println("    Las canciones pueden ser procesadas por múltiples reproductores");
        System.out.println("    Los reproductores pueden funcionar sin canciones precargadas");
        
        System.out.println("\n=== FIN DEL EJERCICIO 11 ===");
    }
}