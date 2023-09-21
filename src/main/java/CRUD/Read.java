package CRUD;

import Entity.Carrera;
import Entity.Estudiante;
import Controller.JPAController;

import javax.persistence.EntityManager;
import java.util.List;

public class Read {
    private JPAController emfh = JPAController.startConnection();

    public Estudiante getEstudiantePorNumeroLegajo(int numeroLegajo) {
        Class<Estudiante> estudianteClass = Estudiante.class;
        Estudiante estudiante = emfh.select(estudianteClass, numeroLegajo);
        return estudiante;
    }

    public List<Estudiante> getEstudiantes() {
        EntityManager em = JPAController.getEntityManager();
        @SuppressWarnings("unchecked")
        List<Estudiante> result = em.createQuery("SELECT e FROM estudiante e ORDER BY DESC").getResultList();
        return result;
    }

    public List<Estudiante> getEstudiantesAscendente() {
        EntityManager em = JPAController.getEntityManager();
        @SuppressWarnings("unchecked")
        List<Estudiante> result = em.createQuery("SELECT e FROM estudiante e ORDER BY ASC").getResultList();
        return result;
    }

    public List<Carrera> getCarreras() {
        EntityManager em = JPAController.getEntityManager();
        @SuppressWarnings("unchecked")
        List<Carrera> result = em.createQuery(  "SELECT nombre AS carrera, sum(id_estudiante) AS inscriptos " +
                                                "FROM inscripcion NATURAL JOIN carrera" +
                                                "GROUP BY nombre " +
                                                "HAVING inscriptos > 0" +
                                                "ORDER BY inscriptos DESC").getResultList();
        return result;
    }

    public List<Estudiante> getEstudiantesPorGenero(char genero) {
        EntityManager em = JPAController.getEntityManager();
        @SuppressWarnings("unchecked")
        List<Estudiante> result = em.createQuery("SELECT e FROM estudiante e WHERE e.genero LIKE :VarGenero")
                .setParameter("VarGenero", genero)
                .getResultList();
        return result;
    }

    public List<Estudiante> getEstudiantesPorCarreraYCiudad(String ciudad, String nombreCarrera) {
        EntityManager em = JPAController.getEntityManager();
        @SuppressWarnings("unchecked")
        List<Estudiante> result = em.createQuery("SELECT e " +
                                                    "FROM estudiante e JOIN carrera c" +
                                                    "WHERE e.ciudad LIKE :VarCiudad AND c.nombre LIKE :VarNombre")
                .setParameter("VarCiudad", ciudad)
                .setParameter("VarNombre", nombreCarrera)
                .getResultList();
        return result;
    }

    public List<Estudiante> getReporteCarreras(char genero) {
        EntityManager em = JPAController.getEntityManager();
        @SuppressWarnings("unchecked")
        List<Estudiante> result = em.createQuery("SELECT c.nombre AS carrera, i.fechaInicio, i, esGraduado, e " +
                                                    "FROM estudiante e NATURAL JOIN inscripcion i NATURAL JOIN  carrera c" +
                                                    "ORDER BY c.nombre AND i.fechaInicio")
                .setParameter("VarGenero", genero)
                .getResultList();
        return result;
    }

}
