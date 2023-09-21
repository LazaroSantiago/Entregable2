package Repository;

import Helper.ConnectionHelper;
import Entity.Carrera;
import Entity.Estudiante;
import Entity.Inscripcion;

import javax.persistence.EntityManager;

public class InscripcionRepositoryImpl implements InscripcionRepository{
    private EntityManager entityManager;

    public InscripcionRepositoryImpl(){
        super();
        this.entityManager = ConnectionHelper.refresh();
    }

    @Override
    public void inscribirEstudiante(Estudiante e, Carrera c) {
        Inscripcion i = new Inscripcion(e,c);
        entityManager.merge(i);
        entityManager.getTransaction().commit();
    }

}
