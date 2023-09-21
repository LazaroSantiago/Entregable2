package Entity;



import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Inscripcion {
    @ManyToOne( cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinColumn(name = "legajo_estudiante")
    Estudiante estudiante;

    @ManyToOne( cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinColumn(name = "id_carrera")
    Carrera carrera;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_inscripcion;

    @Column(name = "fecha_de_inicio")
    private LocalDate fechaInicio;
    @Column(name = "es_graduado")
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

    public long getId_inscripcion() {
        return id_inscripcion;
    }

    public void setId_inscripcion(long id_inscripcion) {
        this.id_inscripcion = id_inscripcion;
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
