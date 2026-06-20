# TPO Programación 2 - UADE

**Alternativa C: Centro Logístico de Distribución Avanzada**

Este repositorio contiene el código fuente correspondiente al Trabajo Práctico Obligatorio de la materia Programación 2. El objetivo del sistema es gestionar eficientemente el almacenamiento, stock y rutas de despacho de una cadena de suministros utilizando Tipos Abstractos de Datos (TDAs) implementados desde cero.

---

## 👥 Integrantes del Grupo: Nombre original de grupo

| Nombre y Apellido | Legajo |
| :--- | :--- |
| Francisco Gonzalez Miel | 1218997 |
| Tomas Bautista Casal    | 1210292 |
| Martin Federico Asprea  | 1207196 |

---

## Estructuras de Datos Utilizadas

Para cumplir con los Requisitos Funcionales (RF) de eficiencia y tiempo de ejecución sin utilizar las librerías nativas de `java.util`, se desarrollaron las siguientes estructuras base:

* **Pila Dinámica (Stack):** Utilizada para el **RF-05 (Trazabilidad)**. Permite apilar los registros de movimientos de mercadería y deshacer la última acción en caso de error de los operarios (LIFO).
* **Cola FIFO (Queue):** Implementada para el **RF-04 (Línea de expedición)**. Garantiza que los pedidos listos se despachen en el orden exacto en el que fueron preparados.
* **Cola de Prioridad:** Diseñada para el **RF-03 (Inventario Crítico)**. Mantiene los productos ordenados según su nivel de stock mediante desplazamiento, asegurando que el producto con menor existencia siempre esté listo para ser extraído y repuesto.
* **Diccionario (arreglo de Producto indexado por código):** Aplicado para el **RF-01 (Localización de Stock)**. Permite agregar, buscar, eliminar y actualizar productos a partir de su código único, evitando duplicados.
* **Grafo no dirigido (lista de adyacencia por nodo):** Utilizado para el **RF-02 (Optimización de Recolección)**. Modela la interconexión física de los pasillos del depósito mediante nodos (`Pasillo`) y conexiones con peso (`Arista`). Sobre esta estructura se implementó el **algoritmo de Dijkstra** para calcular la ruta más corta entre dos pasillos.

---

## Estado del Proyecto

* [x] **Etapa 1:** Propuesta, diseño y diagramas (UML / Flujo).
* [x] **Etapa 2:** Avance funcional y desarrollo de estructuras base.
* [x] **Etapa 3:** Presentación final del código completo y casos de prueba.

---

## Funcionalidades implementadas en la segunda etapa

* **RF-01 - Localización de Stock:** Mediante un diccionario de productos indexado por código, se puede agregar, buscar, eliminar y actualizar el stock de cualquier producto sin recorrer toda la colección. Contempla el caso de códigos duplicados y búsquedas de productos inexistentes.
* **RF-02 - Optimización de Recolección:** Mediante un grafo no dirigido que modela los pasillos del depósito y sus conexiones, se calcula la ruta más corta entre dos puntos utilizando el algoritmo de Dijkstra. Contempla el caso de pasillos sin conexión entre sí y de pasillos inexistentes.
* **RF-03 - Inventario Crítico:** Mediante una cola de prioridad, los productos se ordenan automáticamente según su nivel de stock, permitiendo identificar de forma inmediata cuál necesita reposición más urgente.
* **RF-04 - Línea de Expedición:** Mediante una cola FIFO, los pedidos que ya están listos para despachar se procesan en el mismo orden en el que fueron preparados.
* **RF-05 - Trazabilidad de Lotes:** Mediante una pila dinámica, se registran todos los movimientos de stock y se puede deshacer el último movimiento en caso de error de carga de un operario.

La demostración de las 5 funcionalidades se encuentra en `src/Main.java`.

---
## Cómo compilar y ejecutar

### Desde IntelliJ IDEA
1. Abrir el proyecto (File → Open → seleccionar la carpeta del repo)
2. Ejecutar la clase `Main.java` (botón ▶ o Shift+F10)

### Desde consola
```bash
cd src
javac Clases/*.java EstructurasBase/*.java Main.java
java Main
```

La salida por consola muestra la ejecución y prueba de las 5 funcionalidades implementadas.

---
## Link al repositorio

https://github.com/catomsal/Proyecto-progra-2.git