package Repository;

import Controller.JPAController;
import DTO.CarreraDTO;

import javax.persistence.EntityManager;
import java.util.List;

public class CarreraRepositoryImpl implements CarreraRepository {
    private EntityManager entityManager;

    public CarreraRepositoryImpl() {
        super();
        this.entityManager = JPAController.getEntityManager();
    }

    @Override
    public List<CarreraDTO> getCarreras() {
        @SuppressWarnings("unchecked")
        List<CarreraDTO> result = this.entityManager.createNativeQuery(
                                                  "SELECT nombre, sum(id_estudiante) AS cantEstudiantes " +
                                                    "FROM Inscripcion i " +
                                                    "INNER JOIN Carrera c ON i.id_carrera=c.id " +
                                                    "GROUP BY nombre " +
                                                    "HAVING cantEstudiantes > 0 " +
                                                    "ORDER BY cantEstudiantes DESC")
                                                    .getResultList();
        this.entityManager.close();
        return result;
    }
}
