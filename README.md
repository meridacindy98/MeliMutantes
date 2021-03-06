# Ejercicio Mutantes - Mercadolibre :boom:

## Objetivo

Detectar si un ADN es mutante o no usando como input una secuencia de 6 cadenas de ADN. Esto se da cuando se encuentra mas de una secuencia de 4 caracteres iguales, ya sea de manera horizontal asi como vertical o diagonalmente.

Los caracteres validos son A, T, G y C, los cuales representan cada base nitrogenada del ADN.

## Implementacion y tecnologias usadas

- Java 8
- H2
- MySQL 
- Maven
- Spring Boot 
- Junit

## Host API :computer:
* https://melimutantes.herokuapp.com

## Servicios
* [Servicio mutant](doc/serviceMutant.md) : `POST/mutant/`
* [Servicio stat](doc/serviceStats.md) : `GET/stats/`

## Cobertura

Ejecutando los test localmente con la herramienta Jacoco.

![coverage](./doc/codeCoverage.png)
