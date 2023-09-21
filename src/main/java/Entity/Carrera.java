package Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Table(name = "carrera")
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_carrera;

    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Inscripcion> inscripciones;

    @Column
    private String nombre;

    public Carrera(){
        super();
    }

    public Carrera(String nombre) {
        this.nombre = nombre;
        this.inscripciones = new HashSet<>();
    }

    public Carrera(Set<Inscripcion> inscripciones, String nombre) {
        this(nombre);
        this.inscripciones = new HashSet<>(inscripciones);
    }
}