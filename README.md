# TPO Programación 2 - UADE 

**Alternativa C: Centro Logístico de Distribución Avanzada**

Este repositorio contiene el código fuente correspondiente al Trabajo Práctico Obligatorio de la materia Programación 2. El objetivo del sistema es gestionar eficientemente el almacenamiento, stock y rutas de despacho de una cadena de suministros utilizando Tipos Abstractos de Datos (TDAs) implementados desde cero.

---

## 👥 Integrantes del Grupo: Nombre original de grupo

| Nombre y Apellido | Legajo |
| :--- | :--- |
| Francisco Gonzalez Miel | 1218997 |
| Tomas Bautista Casal    | 1210292 |
| [Nombre Integrante 3] | [Legajo 3] |

---

## Estructuras de Datos Utilizadas

Para cumplir con los Requisitos Funcionales (RF) de eficiencia y tiempo de ejecución sin utilizar las librerías nativas de `java.util`, se desarrollaron las siguientes estructuras base:

* **Pila Dinámica (Stack):** Utilizada para el **RF-05 (Trazabilidad)**. Permite apilar los registros de movimientos de mercadería y deshacer la última acción en caso de error de los operarios (LIFO).
* **Cola FIFO (Queue):** Implementada para el **RF-04 (Línea de expedición)**. Garantiza que los pedidos listos se despachen en el orden exacto en el que fueron preparados.
* **Cola de Prioridad:** Diseñada para el **RF-03 (Inventario Crítico)**. Mantiene los productos ordenados según su nivel de stock mediante desplazamiento, asegurando que el producto con menor existencia siempre esté listo para ser extraído y repuesto.
* **Diccionario (Dato[]):** Aplicado para el **RF-01 (Localización de Stock)**. Estructura basada en pares de Clave (Código del producto) y Valor (Objeto Producto).
* **Grafo no dirigido (Matriz de Adyacencia):** Utilizado para el **RF-02 (Optimización de Recolección)**. Modela la interconexión física de los pasillos y sectores del depósito logístico.

---

## Estado del Proyecto

* [x] **Etapa 1:** Propuesta, diseño y diagramas (UML / Flujo).
* [x] **Etapa 2:** Avance funcional y desarrollo de estructuras base.
* [ ] **Etapa 3:** Presentación final del código completo, algoritmo de Dijkstra para el ruteo y casos de prueba.

