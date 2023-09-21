package DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class EstudianteDTO implements Serializable {
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private char genero;
    private String ciudad;
    private int numeroLegajo;

    // me parecio importante
    private boolean esGraduado;
    private LocalDate fechaInicio;
    private String nombreCarrera;


    public EstudianteDTO(){super();}
    public EstudianteDTO(int dni, String nombre, String apellido, int edad, char genero, String ciudad, int numeroLegajo){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudad = ciudad;
        this.numeroLegajo = numeroLegajo;
    }


    // me parecio importante
    public EstudianteDTO(int dni, String nombre, String apellido, int edad, char genero, String ciudad, int numeroLegajo, boolean esGraduado, LocalDate fechaInicio,String nombreCarrera){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudad = ciudad;
        this.numeroLegajo = numeroLegajo;
        this.esGraduado = esGraduado;
        this.fechaInicio = fechaInicio;
        this.nombreCarrera = nombreCarrera;
    }

    public int getAniosAntiguedad() {
        if(this.fechaInicio != null) {
            Period p = Period.between(this.fechaInicio, LocalDate.now());
            return p.getYears();
        }
        return -1;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        if(this.nombreCarrera != null)
            this.fechaInicio = fechaInicio;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public boolean isEsGraduado() {
        return esGraduado;
    }

    public void setEsGraduado(boolean esGraduado) {
        if(this.nombreCarrera != null)
            this.esGraduado = esGraduado;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumeroLegajo() {
        return numeroLegajo;
    }

    public void setNumeroLegajo(int numeroLegajo) {
        this.numeroLegajo = numeroLegajo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
}