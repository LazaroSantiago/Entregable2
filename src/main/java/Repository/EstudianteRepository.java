package Repository;

import DTO.EstudianteDTO;

import java.util.List;

public interface EstudianteRepository {
    EstudianteDTO getEstudiantePorNumeroLegajo(int numeroLegajo);
    List<EstudianteDTO> getEstudiantes();
    List<EstudianteDTO> getEstudiantesAscendente();
    List<EstudianteDTO> getEstudiantesPorGenero(char genero);
    void borrarEstudiante(int numeroLegajo);
}
