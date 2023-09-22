package abstractFactory;

import Repository.*;

public class RepositoryFactoryImpl implements RepositoryFactory{
    private EstudianteRepository estudiante;
    private CarreraRepository carrera;
    private InscripcionRepository inscripcion;

    @Override
    public EstudianteRepository getEstudianteRepository() {
        if (this.estudiante == null)
            this.estudiante = new EstudianteRepositoryImpl();

        return this.estudiante;
    }

    @Override
    public CarreraRepository getCarreraRepository() {
        if (this.carrera == null)
            this.carrera = new CarreraRepositoryImpl();
        return this.carrera;
    }

    @Override
    public InscripcionRepository getInscripcionRepository() {
        if (this.inscripcion == null)
            this.inscripcion = new InscripcionRepositoryImpl();
        return this.inscripcion;
    }
}
