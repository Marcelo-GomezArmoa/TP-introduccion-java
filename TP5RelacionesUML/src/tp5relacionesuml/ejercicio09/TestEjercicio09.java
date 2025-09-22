package tp5relacionesuml.ejercicio09;

/**
 * Clase de prueba para demostrar las relaciones del Ejercicio 9
 * - ASOCIACIÓN UNIDIRECCIONAL: CitaMédica → Paciente
 * - ASOCIACIÓN UNIDIRECCIONAL: CitaMédica → Profesional
 */
public class TestEjercicio09 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 9: CitaMédica - Paciente - Profesional ===\n");
        
        // 1. Crear pacientes independientes
        Paciente paciente1 = new Paciente("María González", "OSDE");
        Paciente paciente2 = new Paciente("Juan Pérez", "Swiss Medical");
        Paciente paciente3 = new Paciente("Ana Rodríguez", "Galeno");
        Paciente paciente4 = new Paciente("Carlos Martín", "IOMA");
        
        System.out.println("1. Pacientes registrados:");
        System.out.println("   " + paciente1);
        System.out.println("   " + paciente2);
        System.out.println("   " + paciente3);
        System.out.println("   " + paciente4);
        
        // 2. Crear profesionales independientes
        Profesional prof1 = new Profesional("Dr. Alberto Fernández", "Cardiología");
        Profesional prof2 = new Profesional("Dra. Laura Sánchez", "Pediatría");
        Profesional prof3 = new Profesional("Dr. Miguel Torres", "Traumatología");
        Profesional prof4 = new Profesional("Dra. Carmen López", "Ginecología");
        
        System.out.println("\n2. Profesionales disponibles:");
        System.out.println("   " + prof1);
        System.out.println("   " + prof2);
        System.out.println("   " + prof3);
        System.out.println("   " + prof4);
        
        // 3. Crear citas médicas básicas
        CitaMedica cita1 = new CitaMedica("2024-04-15", "09:00");
        CitaMedica cita2 = new CitaMedica("2024-04-15", "10:30");
        CitaMedica cita3 = new CitaMedica("2024-04-16", "14:00");
        CitaMedica cita4 = new CitaMedica("2024-04-16", "16:15");
        
        System.out.println("\n3. Citas creadas (sin asignaciones):");
        System.out.println("   " + cita1);
        System.out.println("   " + cita2);
        System.out.println("   " + cita3);
        System.out.println("   " + cita4);
        
        // 4. Asignar pacientes y profesionales a las citas
        cita1.setPaciente(paciente1);
        cita1.setProfesional(prof1);
        
        cita2.setPaciente(paciente2);
        cita2.setProfesional(prof2);
        
        cita3.setPaciente(paciente3);
        cita3.setProfesional(prof3);
        
        System.out.println("\n4. Después de asignar pacientes y profesionales:");
        System.out.println("   " + cita1);
        System.out.println("   " + cita2);
        System.out.println("   " + cita3);
        System.out.println("   " + cita4);
        
        // 5. Demostrar ASOCIACIÓN UNIDIRECCIONAL
        System.out.println("\n5. Demostrando ASOCIACIÓN UNIDIRECCIONAL:");
        System.out.println("   Cita1 conoce al paciente: " + 
                          (cita1.getPaciente() != null ? cita1.getPaciente().getNombre() : "No"));
        System.out.println("   Cita1 conoce al profesional: " + 
                          (cita1.getProfesional() != null ? cita1.getProfesional().getNombre() : "No"));
        System.out.println("   ¿El paciente1 conoce sus citas? NO (unidireccional)");
        System.out.println("   ¿El profesional1 conoce sus citas? NO (unidireccional)");
        
        // 6. Verificar estado de las citas
        System.out.println("\n6. Estado de las citas:");
        CitaMedica[] citas = {cita1, cita2, cita3, cita4};
        for (int i = 0; i < citas.length; i++) {
            System.out.println("   Cita" + (i+1) + " completa: " + citas[i].estaCompleta());
        }
        
        // 7. Mostrar información completa de citas asignadas
        System.out.println("\n7. Información completa de citas:");
        for (int i = 0; i < 3; i++) { // Solo las primeras 3 que están asignadas
            System.out.println("   Cita " + (i+1) + ":");
            System.out.println("   " + citas[i].getInformacionCompleta());
            System.out.println();
        }
        
        // 8. Reutilizar profesional en otra cita
        cita4.setPaciente(paciente4);
        cita4.setProfesional(prof1); // Reutilizamos prof1
        
        System.out.println("8. Reutilizando profesional en múltiples citas:");
        System.out.println("   " + cita1);
        System.out.println("   " + cita4);
        System.out.println("   Dr. Fernández atiende múltiples pacientes (asociación)");
        
        // 9. Cambiar asignaciones de una cita
        System.out.println("\n9. Cambiando asignaciones de cita2:");
        System.out.println("   Antes: " + cita2);
        cita2.setPaciente(paciente4);
        cita2.setProfesional(prof4);
        System.out.println("   Después: " + cita2);
        
        // 10. Verificar compatibilidad de especialidades
        System.out.println("\n10. Verificación de especialidades:");
        for (int i = 0; i < citas.length; i++) {
            if (citas[i].estaCompleta()) {
                System.out.println("   Cita" + (i+1) + " especialidad compatible: " + 
                                  citas[i].esEspecialidadCompatible());
            }
        }
        
        // 11. Crear cita completa desde el constructor
        CitaMedica cita5 = new CitaMedica("2024-04-17", "11:00", paciente1, prof3);
        System.out.println("\n11. Cita completa desde constructor:");
        System.out.println("    " + cita5.getInformacionCompleta());
        
        // 12. Mostrar agenda completa
        System.out.println("\n12. Agenda médica completa:");
        CitaMedica[] agendaCompleta = {cita1, cita2, cita3, cita4, cita5};
        for (int i = 0; i < agendaCompleta.length; i++) {
            if (agendaCompleta[i].estaCompleta()) {
                System.out.println("   " + (i+1) + ". " + agendaCompleta[i]);
            }
        }
        
        // 13. Demostrar que pacientes y profesionales no conocen sus citas
        System.out.println("\n13. Confirmando asociaciones unidireccionales:");
        System.out.println("    Los pacientes NO mantienen listas de sus citas");
        System.out.println("    Los profesionales NO mantienen listas de sus citas");
        System.out.println("    Solo las citas conocen a sus participantes (unidireccional)");
        
        System.out.println("\n=== FIN DEL EJERCICIO 9 ===");
    }
}