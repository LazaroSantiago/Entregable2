package org.example;

import Controller.JPAController;

public class Main {
    public static void main(String[] args) {
        JPAController.startConnection();

//        TODO:Hay problemas de delegacion que resolver... el JPA Controller esta bien? Quien se encarga de las queries?
//        Al parecer hay que hacer repositories en vez de tener la carpeta CRUD. Un repositorio por objeto y ahi se encajan las queries
//        Primero hay que hacer lo de abajo, eso es el 4. Despues se pueden hacer repositorios, DTOs, factory, hacer fetch lazy las relaciones etc.
//        TODO:Hacer el diagramita de clases (DER). Si, esta en las cosas que evaluan. No hago las reglas xd
//        TODO:e) recuperar todos los estudiantes, en base a su género.
//        TODO:g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia
//        TODO: Generar un reporte de las carreras, que para cada carrera incluya información de los
//              inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
//              los años de manera cronológica
    }
}