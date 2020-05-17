# Implementation-KMP-algorithm
Proyecto realizado en el curso de Algoritmos del programa de Ingeniería de Sistemas de la UFPS. 

### Algoritmo KMP (Knuth-Morris-Pratt)
El algoritmo KMP es un algoritmo de búsqueda de subcadenas simple y por lo tanto su objetivo es buscar la existencia de una subcadena dentro de una cadena. Para ello utiliza información basada en los fallos previos, aprovechando la información que la propia palabra a buscar contiene de sí (sobre ella se precalcula una tabla de valores), para determinar donde podría darse la siguiente existencia, sin necesidad de analizar más de 1 vez los caracteres de la cadena donde se busca.
