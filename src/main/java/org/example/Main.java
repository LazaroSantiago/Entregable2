package org.example;

import Helper.ConnectionHelper;
import Entity.Estudiante;
import Repository.CarreraRepositoryImpl;
import Repository.EstudianteRepositoryImpl;
import Repository.InscripcionRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        ConnectionHelper.startConnection();
        //crear repos
        EstudianteRepositoryImpl er = new EstudianteRepositoryImpl();
        InscripcionRepositoryImpl ir = new InscripcionRepositoryImpl();
        CarreraRepositoryImpl cr = new CarreraRepositoryImpl();
        Estudiante e = new Estudiante(20205637, "a", "b", 27, 'f', "Azul", 15);
//        //Estudiantes repo
        er.getEstudiantes();
        er.agregarEstudiante(e);
        er.getEstudiantePorNumeroLegajo(15);
        er.getEstudiantesAscendente();
        er.getEstudiantesPorGenero('f');
        er.borrarEstudiantePorNumeroLegajo(15);

    }
}