package CRUD;

import Entity.Carrera;
import Entity.Estudiante;
import Entity.Inscripcion;
import Controller.JPAController;

public class Insert {
    private JPAController jpac = JPAController.startConnection();

    public Inscripcion inscribirEstudiante(Estudiante e, Carrera c){
        Inscripcion i = new Inscripcion(e,c);
        this.jpac.insert(i);
        return i;
    }
}
