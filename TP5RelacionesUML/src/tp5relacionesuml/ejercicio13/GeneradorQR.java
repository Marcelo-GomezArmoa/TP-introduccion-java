package tp5relacionesuml.ejercicio13;

/**
 * Clase GeneradorQR - Ejemplo de DEPENDENCIA DE CREACIÓN
 * - DEPENDENCIA DE CREACIÓN: crea objetos CodigoQR en tiempo de ejecución
 * No mantiene referencias permanentes a los códigos QR creados
 * Crea los objetos dentro del método y los retorna o entrega
 */
public class GeneradorQR {
    private String version;
    private String algoritmo;
    private int codigosGenerados;
    
    // Constructor
    public GeneradorQR(String version, String algoritmo) {
        this.version = version;
        this.algoritmo = algoritmo;
        this.codigosGenerados = 0;
    }
    
    // Getters
    public String getVersion() {
        return version;
    }
    
    public String getAlgoritmo() {
        return algoritmo;
    }
    
    public int getCodigosGenerados() {
        return codigosGenerados;
    }
    
    // DEPENDENCIA DE CREACIÓN: método que crea CodigoQR en tiempo de ejecución
    public CodigoQR generar(String valor, Usuario usuario) {
        if (valor == null || valor.trim().isEmpty()) {
            System.out.println("[GeneradorQR] Error: El valor no puede estar vacío");
            return null;
        }
        
        if (usuario == null) {
            System.out.println("[GeneradorQR] Error: Debe especificar un usuario");
            return null;
        }
        
        System.out.println("[GeneradorQR] 🔄 Generando código QR...");
        System.out.println("Versión: " + version + " | Algoritmo: " + algoritmo);
        System.out.println("Usuario: " + usuario.getNombre());
        System.out.println("Contenido: " + valor);
        
        // CREAR NUEVO OBJETO en tiempo de ejecución (DEPENDENCIA DE CREACIÓN)
        CodigoQR nuevoCodigoQR = new CodigoQR(valor, usuario);
        
        // Simular procesamiento
        procesarGeneracion(valor);
        
        codigosGenerados++;
        
        System.out.println("✅ Código QR generado exitosamente");
        System.out.println("Tipo detectado: " + nuevoCodigoQR.getTipoContenido());
        
        return nuevoCodigoQR; // Se devuelve el objeto creado, pero no se mantiene referencia
    }
    
    // DEPENDENCIA DE CREACIÓN: método que crea múltiples CodigoQR
    public CodigoQR[] generarLote(String[] valores, Usuario usuario) {
        if (valores == null || valores.length == 0) {
            System.out.println("[GeneradorQR] Error: Lista de valores vacía");
            return new CodigoQR[0];
        }
        
        if (usuario == null) {
            System.out.println("[GeneradorQR] Error: Debe especificar un usuario");
            return new CodigoQR[0];
        }
        
        System.out.println("[GeneradorQR] 📦 Generando lote de " + valores.length + " códigos QR...");
        System.out.println("Usuario: " + usuario.getNombre());
        
        CodigoQR[] codigosGenerados = new CodigoQR[valores.length];
        int exitosos = 0;
        
        for (int i = 0; i < valores.length; i++) {
            if (valores[i] != null && !valores[i].trim().isEmpty()) {
                System.out.println("  Generando " + (i+1) + "/" + valores.length + ": " + valores[i]);
                
                // CREAR NUEVO OBJETO para cada elemento (DEPENDENCIA DE CREACIÓN)
                codigosGenerados[i] = new CodigoQR(valores[i], usuario);
                procesarGeneracion(valores[i]);
                this.codigosGenerados++;
                exitosos++;
            } else {
                System.out.println("  Saltando " + (i+1) + "/" + valores.length + ": valor inválido");
                codigosGenerados[i] = null;
            }
        }
        
        System.out.println("📊 Lote completado: " + exitosos + "/" + valores.length + " códigos generados");
        
        return codigosGenerados; // Se devuelve el array, pero no se mantiene referencia
    }
    
    // DEPENDENCIA DE CREACIÓN: método que crea CodigoQR para tipos específicos
    public CodigoQR generarParaURL(String url, Usuario usuario) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }
        
        System.out.println("[GeneradorQR] 🌐 Generando código QR para URL...");
        
        // CREAR NUEVO OBJETO específico para URL (DEPENDENCIA DE CREACIÓN)
        CodigoQR codigoURL = new CodigoQR(url, usuario);
        
        procesarGeneracion(url);
        codigosGenerados++;
        
        System.out.println("✅ Código QR para URL generado");
        
        return codigoURL;
    }
    
    // DEPENDENCIA DE CREACIÓN: método que crea CodigoQR para WiFi
    public CodigoQR generarParaWiFi(String nombreRed, String password, Usuario usuario) {
        String valorWiFi = "wifi:T:WPA;S:" + nombreRed + ";P:" + password + ";;";
        
        System.out.println("[GeneradorQR] 📶 Generando código QR para WiFi...");
        System.out.println("Red: " + nombreRed);
        
        // CREAR NUEVO OBJETO específico para WiFi (DEPENDENCIA DE CREACIÓN)
        CodigoQR codigoWiFi = new CodigoQR(valorWiFi, usuario);
        
        procesarGeneracion(valorWiFi);
        codigosGenerados++;
        
        System.out.println("✅ Código QR para WiFi generado");
        
        return codigoWiFi;
    }
    
    // Método privado para simular el procesamiento
    private void procesarGeneracion(String valor) {
        // Simular tiempo de procesamiento basado en la longitud del contenido
        try {
            Thread.sleep(valor.length() * 2); // 2ms por carácter
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    // Método para obtener estadísticas del generador
    public String getEstadisticas() {
        return "Generador QR v" + version + " (" + algoritmo + ") - " + 
               codigosGenerados + " códigos generados";
    }
    
    @Override
    public String toString() {
        return "GeneradorQR{" +
                "version='" + version + '\'' +
                ", algoritmo='" + algoritmo + '\'' +
                ", codigosGenerados=" + codigosGenerados +
                '}';
    }
}