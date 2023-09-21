package org.example;

import Controller.JPAController;
import Entity.Carrera;
import Entity.Estudiante;
import Repository.EstudianteRepositoryImpl;
import Repository.InscripcionRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        JPAController.startConnection();
        EstudianteRepositoryImpl er = new EstudianteRepositoryImpl();
        InscripcionRepositoryImpl ir = new InscripcionRepositoryImpl();
        Carrera c = new Carrera("TUDAI");
        Estudiante e = new Estudiante(20205637, "asd", "asd", 23, 'x', "Tandil", 23);
        ir.inscribirEstudiante(e, c);
        er.getEstudiantes();
    }
}