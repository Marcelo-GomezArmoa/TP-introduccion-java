# TP5 - Relaciones UML 1 a 1

## 📋 Descripción General

Este trabajo práctico implementa **14 ejercicios** que demuestran diferentes tipos de **relaciones UML 1 a 1** en Java, cubriendo:

- **ASOCIACIÓN** (Bidireccional y Unidireccional)
- **AGREGACIÓN**
- **COMPOSICIÓN**
- **DEPENDENCIA DE USO**
- **DEPENDENCIA DE CREACIÓN**

Cada ejercicio contiene un escenario del mundo real que ilustra claramente los conceptos de relaciones entre clases.

---

## 🗂️ Estructura del Proyecto

```
TP5RelacionesUML/
├── src/
│   └── tp5relacionesuml/
│       ├── ejercicio01/          # Pasaporte - Foto - Titular
│       ├── ejercicio02/          # Celular - Batería - Usuario  
│       ├── ejercicio03/          # Libro - Autor - Editorial
│       ├── ejercicio04/          # Vehiculo - Motor - Propietario
│       ├── ejercicio05/          # CuentaBancaria - Cliente - Banco
│       ├── ejercicio06/          # Empleado - Departamento - Empresa
│       ├── ejercicio07/          # Estudiante - Profesor - Materia
│       ├── ejercicio08/          # Casa - Habitacion - Propietario
│       ├── ejercicio09/          # Computadora - Procesador - Usuario
│       ├── ejercicio10/          # Pedido - Cliente - Producto
│       ├── ejercicio11/          # Curso - Instructor - Plataforma
│       ├── ejercicio12/          # Ticket - Cliente - Sistema
│       ├── ejercicio13/          # GeneradorQR - Usuario - CodigoQR
│       └── ejercicio14/          # EditorVideo - Proyecto - Render
└── README.md
```

---

## 📚 Tipos de Relaciones UML Implementadas

### 🔗 1. ASOCIACIÓN BIDIRECCIONAL
**Definición**: Ambas clases se conocen mutuamente y mantienen referencias entre sí.

**Ejemplos en el proyecto**:
- **Ejercicio 1**: Pasaporte ↔ Titular (ambos se conocen)
- **Ejercicio 2**: Celular ↔ Usuario (relación bidireccional)
- **Ejercicio 3**: Libro ↔ Autor (ambos mantienen referencias)

**Características**:
- Navegación en ambas direcciones
- Ambas clases tienen métodos get/set para la otra
- Sincronización necesaria al cambiar referencias

---

### ➡️ 2. ASOCIACIÓN UNIDIRECCIONAL
**Definición**: Solo una clase conoce y tiene referencia a la otra.

**Ejemplos en el proyecto**:
- **Ejercicio 4**: Vehiculo → Propietario (vehículo conoce propietario)
- **Ejercicio 6**: Empleado → Departamento (empleado conoce departamento)
- **Ejercicio 13**: CodigoQR → Usuario (código conoce usuario)
- **Ejercicio 14**: Proyecto → EditorVideo (proyecto conoce editor)

**Características**:
- Navegación en una sola dirección
- Solo una clase tiene referencia a la otra
- Más simple de mantener que bidireccional

---

### 📦 3. AGREGACIÓN
**Definición**: Relación "tiene-un" donde las partes pueden existir independientemente del todo.

**Ejemplos en el proyecto**:
- **Ejercicio 2**: Celular tiene Batería (batería puede existir sin celular)
- **Ejercicio 5**: CuentaBancaria tiene Cliente (cliente existe independientemente)
- **Ejercicio 6**: Departamento tiene Empleados (empleados pueden cambiar de departamento)

**Características**:
- Relación más débil que composición
- Las partes pueden existir sin el todo
- "Rombo vacío" en UML

---

### 🏗️ 4. COMPOSICIÓN
**Definición**: Relación "parte-de" donde las partes no pueden existir sin el todo.

**Ejemplos en el proyecto**:
- **Ejercicio 1**: Pasaporte crea Foto internamente
- **Ejercicio 4**: Vehiculo crea Motor internamente
- **Ejercicio 8**: Casa crea Habitaciones internamente
- **Ejercicio 9**: Computadora crea Procesador internamente

**Características**:
- Relación fuerte de dependencia existencial
- El todo controla el ciclo de vida de las partes
- "Rombo lleno" en UML

---

### ⚡ 5. DEPENDENCIA DE USO
**Definición**: Una clase usa servicios de otra clase sin mantener referencias permanentes.

**Ejemplos en el proyecto**:
- **Ejercicio 10**: Pedido.calcularTotal(Producto) usa Producto temporalmente
- **Ejercicio 11**: Curso.crearCertificado(Estudiante) usa Estudiante temporalmente
- **Ejercicio 12**: Sistema.validarTicket(Ticket) usa Ticket temporalmente

**Características**:
- No hay referencias permanentes
- Interacción temporal a través de métodos
- Bajo acoplamiento

---

### 🎯 6. DEPENDENCIA DE CREACIÓN
**Definición**: Una clase crea objetos de otra clase pero no mantiene referencias permanentes.

**Ejemplos en el proyecto**:
- **Ejercicio 11**: Plataforma.crearCurso() crea objetos Curso
- **Ejercicio 12**: Sistema.generarTicket() crea objetos Ticket
- **Ejercicio 13**: GeneradorQR.generar() crea objetos CodigoQR
- **Ejercicio 14**: EditorVideo.renderizar() crea objetos Render

**Características**:
- Creación en tiempo de ejecución
- No mantiene referencias después de la creación
- Factory pattern común

---

## 🎯 Ejercicios Detallados

### 📄 Ejercicio 1: Pasaporte - Foto - Titular
**Relaciones**: 
- COMPOSICIÓN: Pasaporte crea Foto
- ASOCIACIÓN BIDIRECCIONAL: Pasaporte ↔ Titular

**Escenario**: Un pasaporte tiene una foto (composición) y está asociado a un titular.

### 📱 Ejercicio 2: Celular - Batería - Usuario
**Relaciones**:
- AGREGACIÓN: Celular tiene Batería 
- ASOCIACIÓN BIDIRECCIONAL: Celular ↔ Usuario

**Escenario**: Un celular tiene una batería (agregación) y pertenece a un usuario.

### 📖 Ejercicio 3: Libro - Autor - Editorial
**Relaciones**:
- ASOCIACIÓN BIDIRECCIONAL: Libro ↔ Autor
- ASOCIACIÓN UNIDIRECCIONAL: Libro → Editorial

**Escenario**: Un libro está escrito por un autor y publicado por una editorial.

### 🚗 Ejercicio 4: Vehículo - Motor - Propietario
**Relaciones**:
- COMPOSICIÓN: Vehiculo crea Motor
- ASOCIACIÓN UNIDIRECCIONAL: Vehiculo → Propietario

**Escenario**: Un vehículo tiene un motor (composición) y pertenece a un propietario.

### 💳 Ejercicio 5: CuentaBancaria - Cliente - Banco
**Relaciones**:
- AGREGACIÓN: CuentaBancaria tiene Cliente
- ASOCIACIÓN UNIDIRECCIONAL: CuentaBancaria → Banco

**Escenario**: Una cuenta bancaria pertenece a un cliente y está en un banco.

### 🏢 Ejercicio 6: Empleado - Departamento - Empresa
**Relaciones**:
- ASOCIACIÓN UNIDIRECCIONAL: Empleado → Departamento
- AGREGACIÓN: Departamento tiene Empleados
- ASOCIACIÓN UNIDIRECCIONAL: Departamento → Empresa

**Escenario**: Empleados trabajan en departamentos de una empresa.

### 🎓 Ejercicio 7: Estudiante - Profesor - Materia
**Relaciones**:
- ASOCIACIÓN BIDIRECCIONAL: Estudiante ↔ Profesor
- ASOCIACIÓN UNIDIRECCIONAL: Profesor → Materia

**Escenario**: Estudiantes tienen profesores que enseñan materias.

### 🏠 Ejercicio 8: Casa - Habitación - Propietario
**Relaciones**:
- COMPOSICIÓN: Casa crea Habitaciones
- ASOCIACIÓN UNIDIRECCIONAL: Casa → Propietario

**Escenario**: Una casa tiene habitaciones (composición) y un propietario.

### 💻 Ejercicio 9: Computadora - Procesador - Usuario
**Relaciones**:
- COMPOSICIÓN: Computadora crea Procesador
- ASOCIACIÓN BIDIRECCIONAL: Computadora ↔ Usuario

**Escenario**: Una computadora tiene un procesador y pertenece a un usuario.

### 📦 Ejercicio 10: Pedido - Cliente - Producto
**Relaciones**:
- ASOCIACIÓN UNIDIRECCIONAL: Pedido → Cliente
- DEPENDENCIA DE USO: Pedido.calcularTotal(Producto)

**Escenario**: Pedidos de clientes que usan productos para calcular totales.

### 📚 Ejercicio 11: Curso - Instructor - Plataforma
**Relaciones**:
- ASOCIACIÓN BIDIRECCIONAL: Curso ↔ Instructor
- DEPENDENCIA DE CREACIÓN: Plataforma.crearCurso()

**Escenario**: Plataforma educativa que crea cursos con instructores.

### 🎫 Ejercicio 12: Ticket - Cliente - Sistema
**Relaciones**:
- ASOCIACIÓN UNIDIRECCIONAL: Ticket → Cliente
- DEPENDENCIA DE CREACIÓN: Sistema.generarTicket()
- DEPENDENCIA DE USO: Sistema.validarTicket(Ticket)

**Escenario**: Sistema que genera y valida tickets para clientes.

### 📱 Ejercicio 13: GeneradorQR - Usuario - CodigoQR
**Relaciones**:
- ASOCIACIÓN UNIDIRECCIONAL: CodigoQR → Usuario
- DEPENDENCIA DE CREACIÓN: GeneradorQR.generar()

**Escenario**: Generador que crea códigos QR para usuarios.

### 🎬 Ejercicio 14: EditorVideo - Proyecto - Render
**Relaciones**:
- ASOCIACIÓN UNIDIRECCIONAL: Proyecto → EditorVideo
- DEPENDENCIA DE CREACIÓN: EditorVideo.renderizar()

**Escenario**: Editor de video que renderiza proyectos.

---

## 🚀 Cómo Ejecutar

### 1. Compilar el proyecto:
```bash
javac -d out src/tp5relacionesuml/ejercicio*/*.java
```

### 2. Ejecutar un ejercicio específico:
```bash
# Ejemplo: Ejecutar ejercicio 1
java -cp out tp5relacionesuml.ejercicio01.TestEjercicio01

# Ejemplo: Ejecutar ejercicio 5
java -cp out tp5relacionesuml.ejercicio05.TestEjercicio05

# Ejemplo: Ejecutar ejercicio 14
java -cp out tp5relacionesuml.ejercicio14.TestEjercicio14
```

### 3. Ejecutar todos los ejercicios:
```bash
for i in {01..14}; do
    echo "=== EJECUTANDO EJERCICIO $i ==="
    java -cp out tp5relacionesuml.ejercicio$i.TestEjercicio$i
    echo ""
done
```

---

## 📊 Diagramas UML

### Asociación Bidireccional
```
┌─────────────┐    1     1    ┌─────────────┐
│   Clase A   │◄─────────────►│   Clase B   │
│             │               │             │
│ - claseB: B │               │ - claseA: A │
└─────────────┘               └─────────────┘
```

### Asociación Unidireccional
```
┌─────────────┐    1     1     ┌─────────────┐
│   Clase A   │───────────────►│   Clase B   │
│             │                │             │
│ - claseB: B │                │             │
└─────────────┘                └─────────────┘
```

### Agregación
```
┌─────────────┐    1     1     ┌─────────────┐
│     Todo    │◇─────────────►│    Parte    │
│             │                │             │
│ - parte: P  │                │             │
└─────────────┘                └─────────────┘
```

### Composición
```
┌─────────────┐    1     1    ┌─────────────┐
│     Todo    │♦─────────────►│    Parte    │
│             │               │             │
│             │               │             │
└─────────────┘               └─────────────┘
```

### Dependencia de Uso
```
┌─────────────┐               ┌─────────────┐
│   Cliente   │┈┈┈┈┈┈┈┈┈┈┈┈┈┈►│  Proveedor  │
│             │    «use»      │             │
│             │               │             │
└─────────────┘               └─────────────┘
```

### Dependencia de Creación
```
┌─────────────┐               ┌─────────────┐
│   Creador   │┈┈┈┈┈┈┈┈┈┈┈┈┈┈►│   Producto  │
│             │  «create»     │             │
│             │               │             │
└─────────────┘               └─────────────┘
```

---
