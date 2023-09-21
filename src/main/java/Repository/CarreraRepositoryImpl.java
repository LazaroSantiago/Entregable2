package Repository;

import Helper.ConnectionHelper;
import DTO.CarreraDTO;
import Entity.Carrera;

import javax.persistence.EntityManager;
import java.util.List;

public class CarreraRepositoryImpl implements CarreraRepository {
    private EntityManager entityManager;

    public CarreraRepositoryImpl() {
        super();
        this.entityManager = ConnectionHelper.refresh();
    }

    @Override
    public List<CarreraDTO> getCarreras() {
        @SuppressWarnings("unchecked")
        List<CarreraDTO> result = this.entityManager.createNativeQuery(
                                                  "SELECT nombre, sum(legajo_estudiante) AS cantEstudiantes " +
                                                    "FROM Inscripcion i " +
                                                    "INNER JOIN Carrera c ON i.id_carrera=c.id_carrera " +
                                                    "GROUP BY nombre " +
                                                    "HAVING cantEstudiantes > 0 " +
                                                    "ORDER BY cantEstudiantes DESC")
                                                    .getResultList();
        return result;
    }

    @Override
    public void agregarCarrera(Carrera c) {
        entityManager.persist(c);
        entityManager.getTransaction().commit();
    }
}
