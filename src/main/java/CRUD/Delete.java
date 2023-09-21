package CRUD;

import Entity.Estudiante;
import Controller.JPAController;

public class Delete {
    private JPAController emfh = JPAController.startConnection();

    public void borrarEstudiante(Estudiante e){
        emfh.delete(e);
    }
}
