package tp4poo2;

public class TestEmpleado {
    public static void main(String[] args) {
        // Instanciar empleados usando ambos constructores
        Empleado emp1 = new Empleado(1, "Ana López", "Desarrolladora", 80000);
        Empleado emp2 = new Empleado("Juan Pérez", "Analista");
        Empleado emp3 = new Empleado("María Gómez", "Tester");

        // Aplica metodo
        emp1.actualizarSalario(10); // 10% de aumento
        emp2.actualizarSalario(5000); // Aumento fijo
        emp3.actualizarSalario(5); // 5% de aumento

        // Imprimir información de cada empleado
        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);

        // Mostrar total de empleados
        System.out.println("Total de empleados: " + Empleado.mostrarTotalEmpleados());
    }
}
