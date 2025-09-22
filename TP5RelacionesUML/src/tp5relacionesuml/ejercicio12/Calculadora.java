package tp5relacionesuml.ejercicio12;

/**
 * Clase Calculadora - Ejemplo de DEPENDENCIA DE USO
 * - DEPENDENCIA DE USO: usa Impuesto como parámetro en el método calcular()
 * No mantiene una referencia permanente a los impuestos
 * Solo los usa temporalmente durante la ejecución de los métodos
 */
public class Calculadora {
    private String version;
    private String entidadFiscal;
    
    // Constructor
    public Calculadora(String version, String entidadFiscal) {
        this.version = version;
        this.entidadFiscal = entidadFiscal;
    }
    
    // Getters
    public String getVersion() {
        return version;
    }
    
    public String getEntidadFiscal() {
        return entidadFiscal;
    }
    
    // DEPENDENCIA DE USO: método que usa Impuesto como parámetro
    public void calcular(Impuesto impuesto) {
        if (impuesto == null) {
            System.out.println("[" + entidadFiscal + "] Error: No se puede calcular un impuesto nulo");
            return;
        }
        
        System.out.println("[" + entidadFiscal + "] 🧮 Iniciando cálculo de impuesto...");
        System.out.println("Calculadora versión: " + version);
        
        // Usar el impuesto temporalmente para realizar cálculos
        double montoBase = impuesto.getMonto();
        String tipoImpuesto = impuesto.getTipo() != null ? impuesto.getTipo() : "General";
        
        System.out.println("Tipo de impuesto: " + tipoImpuesto);
        System.out.println("Monto base: $" + String.format("%.2f", montoBase));
        
        // Calcular diferentes componentes según el tipo
        double interes = calcularInteres(montoBase, tipoImpuesto);
        double recargo = calcularRecargo(montoBase, tipoImpuesto);
        double descuento = calcularDescuento(montoBase, tipoImpuesto);
        double total = montoBase + interes + recargo - descuento;
        
        System.out.println("Interés: $" + String.format("%.2f", interes));
        System.out.println("Recargo: $" + String.format("%.2f", recargo));
        System.out.println("Descuento: $" + String.format("%.2f", descuento));
        System.out.println("TOTAL A PAGAR: $" + String.format("%.2f", total));
        
        if (impuesto.getContribuyente() != null) {
            System.out.println("Contribuyente: " + impuesto.getContribuyente().getNombre());
        }
        
        System.out.println("✅ Cálculo completado");
        // El método termina aquí - no se guarda referencia permanente
    }
    
    // DEPENDENCIA DE USO: método que procesa múltiples impuestos
    public void calcularLote(Impuesto[] impuestos) {
        if (impuestos == null || impuestos.length == 0) {
            System.out.println("[" + entidadFiscal + "] Error: Lote de impuestos vacío");
            return;
        }
        
        System.out.println("[" + entidadFiscal + "] 📊 Procesando lote de " + impuestos.length + " impuestos:");
        
        double totalGeneral = 0;
        int procesados = 0;
        
        for (int i = 0; i < impuestos.length; i++) {
            if (impuestos[i] != null) {
                System.out.println("\n--- Impuesto " + (i+1) + " ---");
                calcular(impuestos[i]);
                totalGeneral += obtenerTotalCalculado(impuestos[i]);
                procesados++;
            }
        }
        
        System.out.println("\n📋 RESUMEN DEL LOTE:");
        System.out.println("Impuestos procesados: " + procesados);
        System.out.println("Total general estimado: $" + String.format("%.2f", totalGeneral));
    }
    
    // DEPENDENCIA DE USO: método que usa Impuesto para generar reporte
    public void generarReporte(Impuesto impuesto) {
        if (impuesto == null) {
            System.out.println("[" + entidadFiscal + "] Error: No se puede generar reporte de impuesto nulo");
            return;
        }
        
        System.out.println("[" + entidadFiscal + "] 📄 Generando reporte fiscal:");
        System.out.println("════════════════════════════════════");
        System.out.println("REPORTE FISCAL - " + entidadFiscal);
        System.out.println("Calculadora v" + version);
        System.out.println("════════════════════════════════════");
        System.out.println(impuesto.getInformacionCompleta());
        
        // Análisis adicional usando el impuesto
        if (impuesto.getMonto() > 50000) {
            System.out.println("⚠️  IMPUESTO DE ALTO MONTO");
        } else if (impuesto.getMonto() > 10000) {
            System.out.println("ℹ️  Impuesto de monto medio");
        } else {
            System.out.println("ℹ️  Impuesto de monto bajo");
        }
        
        System.out.println("════════════════════════════════════");
        // El reporte termina aquí - no se conserva referencia
    }
    
    // Métodos auxiliares privados para cálculos
    private double calcularInteres(double monto, String tipo) {
        double tasa = 0.05; // 5% por defecto
        if ("IVA".equals(tipo)) tasa = 0.03;
        else if ("Ganancias".equals(tipo)) tasa = 0.08;
        else if ("Ingresos Brutos".equals(tipo)) tasa = 0.04;
        
        return monto * tasa;
    }
    
    private double calcularRecargo(double monto, String tipo) {
        double porcentaje = 0.02; // 2% por defecto
        if ("Ganancias".equals(tipo)) porcentaje = 0.05;
        
        return monto * porcentaje;
    }
    
    private double calcularDescuento(double monto, String tipo) {
        double porcentaje = 0.01; // 1% por defecto
        if (monto > 100000) porcentaje = 0.03; // Descuento por monto alto
        
        return monto * porcentaje;
    }
    
    private double obtenerTotalCalculado(Impuesto impuesto) {
        if (impuesto == null) return 0;
        
        double monto = impuesto.getMonto();
        String tipo = impuesto.getTipo() != null ? impuesto.getTipo() : "General";
        
        return monto + calcularInteres(monto, tipo) + calcularRecargo(monto, tipo) - calcularDescuento(monto, tipo);
    }
    
    @Override
    public String toString() {
        return "Calculadora{" +
                "version='" + version + '\'' +
                ", entidadFiscal='" + entidadFiscal + '\'' +
                '}';
    }
}