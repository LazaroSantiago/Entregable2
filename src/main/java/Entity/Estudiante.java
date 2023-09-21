package Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Estudiante {
    @Id
    private int numeroLegajo;

    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private int edad;
    @Column
    private char genero;
    @Column
    private String ciudad;
    @Column(unique = true)
    private int dni;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Inscripcion> inscripciones;

    public Estudiante() {
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getNumeroLegajo() {
        return numeroLegajo;
    }

    public void setNumeroLegajo(int numeroLegajo) {
        this.numeroLegajo = numeroLegajo;
    }

    public Set<Inscripcion> getInscripciones() {
        Set<Inscripcion> result = new HashSet<>(this.inscripciones);
        return result;
    }

    public void addInscripcion(Inscripcion inscripcion) {
        this.inscripciones.add(inscripcion);
    }

    @Override
    public String toString() {
        return this.getNombre() + " " + this.getApellido();
    }
}
