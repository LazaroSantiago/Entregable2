package abstractFactory;

import Repository.CarreraRepository;
import Repository.EstudianteRepository;
import Repository.InscripcionRepository;

public interface RepositoryFactory {
    public abstract EstudianteRepository getEstudianteRepository();

    public abstract CarreraRepository getCarreraRepository();

    public abstract InscripcionRepository getInscripcionRepository();

}