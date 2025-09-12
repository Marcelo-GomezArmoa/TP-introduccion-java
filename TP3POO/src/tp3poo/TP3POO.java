package tp3poo;

public class TP3POO {
    public static void main(String[] args) {
        // Ejercicio 1 Estudiante
        Estudiante estudiante1 = new Estudiante("Ana", "Pérez", "3A", 7.5);
        estudiante1.mostrarInfo();
        estudiante1.subirCalificacion(1.0);
        estudiante1.bajarCalificacion(0.5);
        System.out.println("Después de modificar la calificación:");
        estudiante1.mostrarInfo();

        // Ejercicio 2 Mascota
        Mascota mascota1 = new Mascota("Firulais", "Perro", 3);
        mascota1.mostrarInfo();
        mascota1.cumplirAnios();
        System.out.println("Después de un año:");
        mascota1.mostrarInfo();
        
        // Ejercicio 3 Libro
        Libro libro1 = new Libro("El Principito", "Antoine de Saint-Exupéry", 1943);
        libro1.mostrarInfo();
        libro1.setAñoPublicacion(-200); // Intento inválido
        libro1.setAñoPublicacion(2010); // Intento válido
        System.out.println("Información final del libro:");
        libro1.mostrarInfo();
        
        // Ejercicio 4: Gallinas
        Gallina gallina1 = new Gallina(1, 2);
        Gallina gallina2 = new Gallina(2, 1);

        gallina1.envejecer();
        gallina1.ponerHuevo();
        gallina1.ponerHuevo();

        gallina2.ponerHuevo();

        System.out.println("Estado de la gallina 1:");
        gallina1.mostrarEstado();

        System.out.println("Estado de la gallina 2:");
        gallina2.mostrarEstado();
        
        // Ejercicio 5: Nave Espacial
        NaveEspacial nave1 = new NaveEspacial("Apolo", 50);
        nave1.avanzar(30); // Intento de avanzar sin suficiente combustible
        nave1.recargarCombustible(40); // Recarga válida
        nave1.avanzar(30); // Ahora sí puede avanzar
        nave1.mostrarEstado();
    }
}