# Implementation-KMP-algorithm (2016-II)
Proyecto realizado en el curso de Algoritmos del programa de Ingeniería de Sistemas de la UFPS. 

## Algoritmo KMP (Knuth-Morris-Pratt)
El algoritmo KMP es un algoritmo de búsqueda de subcadenas simple y por lo tanto su objetivo es 
buscar la existencia de una subcadena dentro de una cadena. Para ello utiliza información basada 
en los fallos previos, aprovechando la información que la propia palabra a buscar contiene de sí 
(sobre ella se precalcula una tabla de valores), para determinar donde podría darse la siguiente 
existencia, sin necesidad de analizar más de 1 vez los caracteres de la cadena donde se busca.

### Problema
En este [enlace](https://github.com/willtorber/Implementation-KMP-algorithm/blob/master/src/documentation/info/problem.pdf) podrá encontrar el enunciado del problema.

### Casos de prueba
En este [enlace](https://github.com/willtorber/Implementation-KMP-algorithm/blob/master/src/documentation/info/test_file.txt)  podrá encontrar el archivo _.txt_ con los casos de prueba enunciados en el problema.

### Desarrollo
La documentación relacionada al proyecto podrá encontrarla en el siguiente [enlace](https://github.com/willtorber/Implementation-KMP-algorithm/blob/master/src/documentation/implementation-kmp.pdf). Se explica paso a paso la funcionalidad y el costo computacional de cada método implementado (y de la solución en general).
