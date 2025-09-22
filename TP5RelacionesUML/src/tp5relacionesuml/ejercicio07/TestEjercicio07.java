package tp5relacionesuml.ejercicio07;

/**
 * Clase de prueba para demostrar las relaciones del Ejercicio 7
 * - AGREGACIÓN: Vehículo → Motor
 * - ASOCIACIÓN BIDIRECCIONAL: Vehículo ↔ Conductor
 */
public class TestEjercicio07 {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 7: Vehículo - Motor - Conductor ===\n");
        
        // 1. Crear motores independientes (AGREGACIÓN)
        Motor motor1 = new Motor("1.6L Turbo", "MOT001234");
        Motor motor2 = new Motor("2.0L Aspirado", "MOT987654");
        Motor motor3 = new Motor("1.4L Turbo", "MOT555777");
        Motor motor4 = new Motor("3.0L V6", "MOT333888");
        
        System.out.println("1. Motores creados independientemente:");
        System.out.println("   " + motor1);
        System.out.println("   " + motor2);
        System.out.println("   " + motor3);
        System.out.println("   " + motor4);
        
        // 2. Crear conductores
        Conductor conductor1 = new Conductor("Miguel Herrera", "B-12345678");
        Conductor conductor2 = new Conductor("Carmen López", "B-87654321");
        Conductor conductor3 = new Conductor("Andrés Vega", "A-55555555");
        
        System.out.println("\n2. Conductores creados:");
        System.out.println("   " + conductor1);
        System.out.println("   " + conductor2);
        System.out.println("   " + conductor3);
        
        // 3. Crear vehículos con motores (AGREGACIÓN)
        Vehiculo vehiculo1 = new Vehiculo("ABC123", "Toyota Corolla", motor1);
        Vehiculo vehiculo2 = new Vehiculo("XYZ789", "Honda Civic", motor2);
        Vehiculo vehiculo3 = new Vehiculo("DEF456", "Volkswagen Polo");
        
        System.out.println("\n3. Vehículos creados con motores:");
        System.out.println("   " + vehiculo1);
        System.out.println("   " + vehiculo2);
        System.out.println("   " + vehiculo3);
        
        // 4. Establecer relaciones bidireccionales vehículo-conductor
        vehiculo1.setConductor(conductor1);
        vehiculo2.setConductor(conductor2);
        
        System.out.println("\n4. Después de asignar conductores:");
        System.out.println("   Vehículo1: " + vehiculo1);
        System.out.println("   Vehículo2: " + vehiculo2);
        System.out.println("   Conductor1: " + conductor1);
        System.out.println("   Conductor2: " + conductor2);
        
        // 5. Verificar relaciones bidireccionales
        System.out.println("\n5. Verificación de relaciones bidireccionales:");
        System.out.println("   ¿Conductor1 tiene vehículo? " + 
                          (conductor1.getVehiculo() != null));
        System.out.println("   ¿Vehículo1 tiene conductor? " + 
                          (vehiculo1.getConductor() != null));
        System.out.println("   ¿Son la misma relación? " + 
                          (conductor1.getVehiculo() == vehiculo1));
        
        // 6. Demostrar AGREGACIÓN: cambiar motor
        System.out.println("\n6. Demostrando AGREGACIÓN - cambiar motor:");
        System.out.println("   Vehículo3 motor original: " + vehiculo3.getMotor());
        vehiculo3.cambiarMotor(motor3);
        System.out.println("   Vehículo3 nuevo motor: " + vehiculo3.getMotor());
        System.out.println("   Motor3 sigue existiendo independientemente: " + motor3);
        
        // 7. Reutilizar motor en otro vehículo
        System.out.println("\n7. Reutilizando motor2 en vehículo3:");
        System.out.println("   Motor2 antes: usado en " + vehiculo2.getModelo());
        vehiculo3.setMotor(motor2);
        System.out.println("   Motor2 ahora: reutilizado en " + vehiculo3.getModelo());
        System.out.println("   Vehículo2 sin motor: " + vehiculo2);
        
        // 8. Asignar motor4 al vehículo2
        vehiculo2.setMotor(motor4);
        System.out.println("\n8. Asignando motor4 al vehículo2:");
        System.out.println("   " + vehiculo2);
        
        // 9. Cambiar vehículo entre conductores
        System.out.println("\n9. Cambiando vehículo1 del conductor1 al conductor3:");
        System.out.println("   Antes - Conductor1: " + conductor1);
        System.out.println("   Antes - Conductor3: " + conductor3);
        
        conductor3.setVehiculo(vehiculo1);
        
        System.out.println("   Después del cambio:");
        System.out.println("   Conductor1: " + conductor1);
        System.out.println("   Conductor3: " + conductor3);
        System.out.println("   Vehículo1: " + vehiculo1);
        
        // 10. Asignar vehículo3 al conductor2 (cambio de vehículo)
        conductor2.setVehiculo(vehiculo3);
        System.out.println("\n10. Conductor2 cambia de vehículo:");
        System.out.println("    " + conductor2);
        System.out.println("    Vehículo2: " + vehiculo2);
        System.out.println("    Vehículo3: " + vehiculo3);
        
        // 11. Mostrar información completa de todos los vehículos
        System.out.println("\n11. Información completa del parque automotor:");
        Vehiculo[] parqueAutomotor = {vehiculo1, vehiculo2, vehiculo3};
        for (int i = 0; i < parqueAutomotor.length; i++) {
            System.out.println("    " + (i+1) + ". " + parqueAutomotor[i].getInformacionCompleta());
        }
        
        // 12. Crear nuevo vehículo sin motor para demostrar agregación
        Vehiculo vehiculo4 = new Vehiculo("GHI999", "Ford Focus");
        System.out.println("\n12. Vehículo sin motor (para reparación):");
        System.out.println("    " + vehiculo4.getInformacionCompleta());
        
        // Motor1 ahora está disponible para reutilizar
        vehiculo4.setMotor(motor1);
        System.out.println("    Después de instalar motor1:");
        System.out.println("    " + vehiculo4.getInformacionCompleta());
        
        System.out.println("\n=== FIN DEL EJERCICIO 7 ===");
    }
}