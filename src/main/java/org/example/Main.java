package org.example;

import Helper.ConnectionHelper;
import Entity.Estudiante;
import Repository.*;
import abstractFactory.RepositoryFactory;
import abstractFactory.RepositoryFactoryImpl;

public class Main {
    public static void main(String[] args) {
        ConnectionHelper.startConnection();
        //crear repos
        RepositoryFactory repo = new RepositoryFactoryImpl();
        EstudianteRepository er = repo.getEstudianteRepository();
        InscripcionRepository ir = repo.getInscripcionRepository();
        CarreraRepository cr =repo.getCarreraRepository();
        Estudiante e = new Estudiante(20205637, "a", "b", 27, 'f', "Azul", 15);
        //Estudiantes repo
        er.getEstudiantes();
        er.agregarEstudiante(e);
        er.getEstudiantePorNumeroLegajo(15);
        er.getEstudiantesAscendente();
        er.getEstudiantesPorGenero('f');
        er.borrarEstudiantePorNumeroLegajo(15);

    }
}