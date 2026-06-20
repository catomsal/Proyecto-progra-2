# Documento de Casos de Prueba

**TPO Programación 2 — UADE**
**Alternativa C: Centro Logístico de Distribución Avanzada**
**Etapa 3 — Presentación Final**

---

## Introducción

Este documento detalla los casos de prueba ejecutados sobre el sistema, organizados por requerimiento funcional (RF). Cada caso fue verificado de forma manual ejecutando la clase `Main.java` del repositorio, contrastando la salida obtenida por consola contra el resultado esperado según la lógica implementada en cada estructura de datos.

---

## RF-01 — Localización de Stock

**Estructura utilizada:** Diccionario (arreglo de `Producto` indexado por código)

| N° | Acción / Caso | Entrada | Resultado Esperado | Resultado |
|----|---------------|---------|---------------------|-----------|
| 1 | Agregar producto nuevo | TOR-001, Tornillos 5mm, stock 50 | Se agrega correctamente al inventario | ✅ OK |
| 2 | Agregar producto con código duplicado | TOR-001 (ya existente) | Rechaza el alta e informa el error sin romper el programa | ✅ OK |
| 3 | Buscar producto existente | TUE-003 | Devuelve el objeto Producto completo con su ubicación | ✅ OK |
| 4 | Buscar producto inexistente | XYZ-999 | Devuelve `null` sin romper el programa | ✅ OK |
| 5 | Actualizar stock de un producto | CLA-002, delta -3 | El stock se actualiza correctamente y queda reflejado en el listado | ✅ OK |

---

## RF-02 — Optimización de Recolección

**Estructura utilizada:** Grafo no dirigido (`Pasillo` + `Arista`) con algoritmo de Dijkstra

| N° | Acción / Caso | Entrada | Resultado Esperado | Resultado |
|----|---------------|---------|---------------------|-----------|
| 1 | Calcular ruta más corta entre dos pasillos conectados | Origen A, Destino D | Devuelve la secuencia de pasillos y la distancia total mínima | ✅ OK |
| 2 | Calcular ruta a un pasillo sin conexiones | Origen A, Destino E (aislado) | Informa que no existe camino, sin romper el programa | ✅ OK |
| 3 | Calcular ruta a un pasillo inexistente | Origen A, Destino Z | Informa que el pasillo de destino no existe | ✅ OK |

---

## RF-03 — Inventario Crítico

**Estructura utilizada:** Cola de Prioridad (`ColaConPrioridad`)

| N° | Acción / Caso | Entrada | Resultado Esperado | Resultado |
|----|---------------|---------|---------------------|-----------|
| 1 | Construir la cola a partir del inventario actual | 3 productos con distinto stock | La cola se arma ordenada por nivel de stock | ✅ OK |
| 2 | Consultar el producto más crítico | Cola con productos cargados | Devuelve el producto con menor stock sin sacarlo de la cola | ✅ OK |
| 3 | Mostrar todos los productos ordenados por prioridad | Cola con productos cargados | Lista todos de menor a mayor stock | ✅ OK |
| 4 | Consultar el más crítico con la cola vacía | Cola sin construir / vacía | Informa que no hay productos sin romper el programa | ✅ OK |

---

## RF-04 — Línea de Expedición

**Estructura utilizada:** Cola FIFO (`Cola<Pedido>`)

| N° | Acción / Caso | Entrada | Resultado Esperado | Resultado |
|----|---------------|---------|---------------------|-----------|
| 1 | Encolar 3 pedidos | PED-001, PED-002, PED-003 | Los 3 quedan en fila en orden de llegada | ✅ OK |
| 2 | Despachar pedidos | 2 despachos consecutivos | Se despachan PED-001 y PED-002 en ese orden (FIFO) | ✅ OK |
| 3 | Verificar estado de la fila tras despachar | Fila con 1 pedido restante | Muestra únicamente PED-003 como pendiente | ✅ OK |
| 4 | Despachar con la fila vacía | Fila sin pedidos | Informa que no hay pedidos para despachar, sin romper el programa | ✅ OK |

---

## RF-05 — Trazabilidad de Lotes

**Estructura utilizada:** Pila dinámica (`Pila<Movimiento>`)

| N° | Acción / Caso | Entrada | Resultado Esperado | Resultado |
|----|---------------|---------|---------------------|-----------|
| 1 | Registrar movimientos de stock | 4 movimientos: ENTRADA, ENTRADA, SALIDA, REPOSICION | Los 4 movimientos quedan apilados correctamente | ✅ OK |
| 2 | Consultar el último movimiento registrado | Pila con movimientos cargados | Muestra el último sin desapilarlo | ✅ OK |
| 3 | Deshacer el último movimiento | Pila con movimientos cargados | Se revierte el stock al valor anterior y se desapila | ✅ OK |
| 4 | Registrar movimiento con tipo inválido | Tipo "TRANSFERENCIA" | Rechaza el registro e informa el error | ✅ OK |
| 5 | Registrar movimiento con ID de producto vacío | idProducto = "" | Rechaza el registro e informa el error | ✅ OK |
| 6 | Registrar movimiento con cantidad negativa | cantidadAnterior = -5 | Rechaza el registro e informa el error | ✅ OK |
| 7 | Deshacer con la pila vacía | Pila sin movimientos | Informa que no hay movimientos para deshacer, sin romper el programa | ✅ OK |

---

## Conclusión

Las 5 funcionalidades requeridas para la Alternativa C fueron implementadas y probadas exitosamente. Todos los casos límite contemplados (datos duplicados, búsquedas sin resultado, estructuras vacías y entradas inválidas) fueron manejados sin generar errores de ejecución, cumpliendo con el requisito de robustez solicitado en la consigna.