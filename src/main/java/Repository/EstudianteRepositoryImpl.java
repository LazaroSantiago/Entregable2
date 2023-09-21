package Repository;

import Helper.ConnectionHelper;
import DTO.EstudianteDTO;
import Entity.Estudiante;

import javax.persistence.EntityManager;
import java.util.List;

public class EstudianteRepositoryImpl implements EstudianteRepository {
    private EntityManager entityManager;

    public EstudianteRepositoryImpl() {
        super();
        this.entityManager = ConnectionHelper.refresh();
    }

    @Override
    public EstudianteDTO getEstudiantePorNumeroLegajo(int numeroLegajo) {
        Estudiante e = this.entityManager.find(Estudiante.class, numeroLegajo);
        if (e == null)
            return null;

        EstudianteDTO result = new EstudianteDTO(
                e.getNombre(),
                e.getApellido(),
                e.getCiudad(),
                e.getGenero(),
                e.getNumeroLegajo());
        return result;
    }

    @Override
    public List<EstudianteDTO> getEstudiantes() {
        @SuppressWarnings("unchecked")
        List<EstudianteDTO> result = entityManager.createQuery(
                      "SELECT new DTO.EstudianteDTO(e.nombre, e.apellido, e.ciudad, e.genero, e.numeroLegajo) " +
                        "FROM Estudiante e " +
                        "ORDER BY e.numeroLegajo DESC").getResultList();
        return result;
    }

    @Override
    public List<EstudianteDTO> getEstudiantesAscendente() {
        @SuppressWarnings("unchecked")
        List<EstudianteDTO> result = entityManager.createQuery(
                      "SELECT new DTO.EstudianteDTO(e.nombre, e.apellido, e.ciudad, e.genero, e.numeroLegajo) " +
                        "FROM Estudiante e " +
                        "ORDER BY e.numeroLegajo ASC")
                        .getResultList();
        return result;
    }

    @Override
    public List<EstudianteDTO> getEstudiantesPorGenero(char genero) {
        List<EstudianteDTO> result = entityManager.createQuery(
                          "SELECT new DTO.EstudianteDTO(e.nombre, e.apellido, e.ciudad, e.genero, e.numeroLegajo) " +
                            "FROM Estudiante e " +
                            "WHERE e.genero LIKE :VarGenero"
                            ).setParameter("VarGenero", genero)
                            .getResultList();
        return result;
    }

    @Override
    public void borrarEstudiantePorNumeroLegajo(int numeroLegajo) {
        Estudiante e = this.entityManager.find(Estudiante.class, numeroLegajo);
        this.entityManager.remove(e);
    }

    @Override
    public void agregarEstudiante(Estudiante e) {
        entityManager.getTransaction().begin();
        entityManager.persist(e);
        entityManager.getTransaction().commit();
    }
}
