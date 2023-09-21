package Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carrera")
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Inscripcion> inscripciones;

    private String nombre;

    public Carrera(){
        super();
    }

    public Carrera(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.inscripciones = new HashSet<>();
    }

    public Carrera(int id, Set<Inscripcion> inscripciones, String nombre) {
        this(id, nombre);
        this.inscripciones = new HashSet<>(inscripciones);
    }

}
