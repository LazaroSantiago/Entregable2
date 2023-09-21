package Repository;

import DTO.EstudianteDTO;
import Entity.Estudiante;

import java.util.List;

public interface EstudianteRepository {
    EstudianteDTO getEstudiantePorNumeroLegajo(int numeroLegajo);
    List<EstudianteDTO> getEstudiantes();
    List<EstudianteDTO> getEstudiantesAscendente();
    List<EstudianteDTO> getEstudiantesPorGenero(char genero);
    void borrarEstudiantePorNumeroLegajo(int numeroLegajo);
    void agregarEstudiante(Estudiante e);
}
