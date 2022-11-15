# Vehículo Explorador de la Agencia Espacial Europea (ESA)

## Descripción

Un vehículo explorador de la ESA va a ser transportado a un valle de Marte.

Esta localización, que es curiosamente rectangular, debe ser explorada por el vehículo de forma que sus cámaras puedan obtener una vista completa de los alrededores y que pueda enviar las imágenes de vuelta
a la tierra.

La posición del vehículo se representa por una combinación de coordenadas x,y y una letra representa los 4 puntos cardinales. El valle se divide en una cuadrícula para simplificar la navegación. Un ejemplo de la posición podría ser 0, 0, N lo que significaría que el vehículo está en el margen inferior izquierdo y con orientación Norte.

Para conseguir controlar el vehículo, la agencia espacial envía una sencilla cadena de caracteres. Las posibles letras son 'I','D','A','R' , 'I' y 'D' hacen girar al vehículo 90 grados a izquierda o derecha respectivamente, sin moverse de su posición actual.'A' hace moverse al vehículo hacia adelante teniendo en cuenta la orientación actual, y 'R' lo hace retroceder sin cambiar la orientación.

Los puntos cardinales se expresan como N, S,E, O.

Asumimos que la posición al norte de una posición x,y es x,y+1.

Cuando el rover acabe de ejecutar las instrucciones, transmite su posición final.

## Reglas

- TDD sin excusas. Ciclo Red, Green, Refactor y al final de cada ciclo, commit.
- Evitar el rojo mientras se refactoriza, usando cuando sea posible los refactors del IDE.
- El vehículo no debe salir de la cuadrícula.

## Input

La primera línea son las coordenadas del margen superior derecho (tamaño de la cuadrícula), la segunda línea nos indica la posición actual del vehículo y la tercera línea son las instrucciones de movimiento.

Ejemplo:

“5 5\n0 1 N\nAADADRIA\n”
