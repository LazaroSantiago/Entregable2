package Repository;

import Entity.Carrera;
import Entity.Estudiante;

public interface InscripcionRepository {
    public void inscribirEstudiante(Estudiante e, Carrera c);
}
