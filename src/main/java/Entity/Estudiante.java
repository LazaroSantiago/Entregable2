package Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "estudiante")
public class Estudiante {
    @Id
    private int dni;

    private String nombre;
    private String apellido;
    private int edad;
    private char genero;
    private String ciudad;
    private int numeroLegajo;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Inscripcion> inscripciones;

    public Estudiante(){
        super();
    }

    public Estudiante(int dni, String nombre, String apellido, int edad, char genero, String ciudad, int numeroLegajo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudad = ciudad;
        this.numeroLegajo = numeroLegajo;
        this.inscripciones = new HashSet<>();
    }

    public Estudiante(int dni, String nombre, String apellido, int edad, char genero, String ciudad, int numeroLegajo, Set<Inscripcion> inscripciones) {
        this(dni, nombre, apellido, edad, genero, ciudad, numeroLegajo);
        this.inscripciones = new HashSet<>(inscripciones);
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return this.getNombre() + " " + this.getApellido();
    }
}
