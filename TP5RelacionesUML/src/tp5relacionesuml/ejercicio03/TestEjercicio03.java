package tp5relacionesuml.ejercicio03;

/**
 * Clase de prueba para demostrar las relaciones del Ejercicio 3
 * - ASOCIACIÓN UNIDIRECCIONAL: Libro → Autor
 * - AGREGACIÓN: Libro → Editorial
 */
public class TestEjercicio03 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 3: Libro - Autor - Editorial ===\n");
        
        // 1. Crear autores independientes
        Autor autor1 = new Autor("Gabriel García Márquez", "Colombiana");
        Autor autor2 = new Autor("Mario Vargas Llosa", "Peruana");
        Autor autor3 = new Autor("Isabel Allende", "Chilena");
        
        System.out.println("1. Autores creados:");
        System.out.println("   " + autor1);
        System.out.println("   " + autor2);
        System.out.println("   " + autor3);
        
        // 2. Crear editoriales independientes (AGREGACIÓN)
        Editorial editorial1 = new Editorial("Penguin Random House", "New York, USA");
        Editorial editorial2 = new Editorial("Planeta", "Barcelona, España");
        Editorial editorial3 = new Editorial("Alfaguara", "Madrid, España");
        
        System.out.println("\n2. Editoriales creadas:");
        System.out.println("   " + editorial1);
        System.out.println("   " + editorial2);
        System.out.println("   " + editorial3);
        
        // 3. Crear libros con asociaciones
        Libro libro1 = new Libro("Cien años de soledad", "978-0-06-088328-7", 
                                 autor1, editorial1);
        Libro libro2 = new Libro("La ciudad y los perros", "978-84-204-2825-1", 
                                 autor2, editorial2);
        Libro libro3 = new Libro("La casa de los espíritus", "978-84-204-2826-8");
        
        System.out.println("\n3. Libros creados:");
        System.out.println("   " + libro1);
        System.out.println("   " + libro2);
        System.out.println("   " + libro3);
        
        // 4. Demostrar ASOCIACIÓN UNIDIRECCIONAL
        System.out.println("\n4. Demostrando ASOCIACIÓN UNIDIRECCIONAL:");
        System.out.println("   El libro1 conoce a su autor: " + 
                          (libro1.getAutor() != null ? libro1.getAutor().getNombre() : "No"));
        System.out.println("   ¿El autor1 conoce sus libros? NO (unidireccional)");
        
        // 5. Establecer autor y editorial al libro3
        libro3.setAutor(autor3);
        libro3.setEditorial(editorial3);
        System.out.println("\n5. Después de asignar autor y editorial al libro3:");
        System.out.println("   " + libro3);
        System.out.println("   Información completa: " + libro3.getInformacionCompleta());
        
        // 6. Demostrar AGREGACIÓN: cambiar editorial
        System.out.println("\n6. Demostrando AGREGACIÓN - cambiar editorial:");
        System.out.println("   Libro2 editorial original: " + libro2.getEditorial().getNombre());
        libro2.setEditorial(editorial3);
        System.out.println("   Libro2 nueva editorial: " + libro2.getEditorial().getNombre());
        System.out.println("   Editorial2 sigue existiendo: " + editorial2.getNombre());
        
        // 7. Reutilizar autor en múltiples libros
        Libro libro4 = new Libro("El otoño del patriarca", "978-0-06-088329-4", 
                                 autor1, editorial1);
        System.out.println("\n7. Reutilizando autor1 en otro libro:");
        System.out.println("   " + libro4);
        System.out.println("   Mismo autor en libro1 y libro4: " + 
                          (libro1.getAutor() == libro4.getAutor()));
        
        // 8. Crear libro sin autor ni editorial
        Libro libro5 = new Libro("Libro anónimo", "978-0-00-000000-0");
        System.out.println("\n8. Libro sin autor ni editorial:");
        System.out.println("   " + libro5);
        System.out.println("   Información completa: " + libro5.getInformacionCompleta());
        
        // 9. Mostrar todos los libros con información completa
        System.out.println("\n9. Catálogo completo de libros:");
        Libro[] catalogo = {libro1, libro2, libro3, libro4, libro5};
        for (int i = 0; i < catalogo.length; i++) {
            System.out.println("   " + (i+1) + ". " + catalogo[i].getInformacionCompleta());
        }
        
        System.out.println("\n=== FIN DEL EJERCICIO 3 ===");
    }
}