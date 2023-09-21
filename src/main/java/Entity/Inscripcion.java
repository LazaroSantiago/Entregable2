package Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "inscripcion")
public class Inscripcion {
    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_carrera")
    Carrera carrera;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalDate fechaInicio;
    private boolean esGraduado = false;

    private Inscripcion() {
        super();
        this.fechaInicio = LocalDate.now();
    }

    public Inscripcion(Estudiante estudiante, Carrera carrera) {
        this();
        this.estudiante = estudiante;
        this.carrera = carrera;
    }

    public int getAniosAntiguedad() {
        Period p = Period.between(this.fechaInicio, LocalDate.now());
        return p.getYears();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public boolean isEsGraduado() {
        return esGraduado;
    }

    public void setEsGraduado(boolean esGraduado) {
        this.esGraduado = esGraduado;
    }
}
