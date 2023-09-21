package Repository;

import Controller.JPAController;
import Entity.Carrera;
import Entity.Estudiante;
import Entity.Inscripcion;

import javax.persistence.EntityManager;

public class InscripcionRepositoryImpl implements InscripcionRepository{
    private EntityManager entityManager;

    public InscripcionRepositoryImpl(){
        super();
        this.entityManager = JPAController.getEntityManager();
    }

    @Override
    public void inscribirEstudiante(Estudiante e, Carrera c) {
        Inscripcion i = new Inscripcion(e,c);
        entityManager.persist(i);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
