package DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class EstudianteDTO implements Serializable {
    private String nombreCompleto;
    private String ciudad;
    private char genero;
    private int numeroLegajo;

    public EstudianteDTO() {
        super();
    }

    public EstudianteDTO(String nombre, String apellido, String ciudad, char genero, int numeroLegajo){
        this.setNombreCompleto(nombre, apellido);
        this.ciudad = ciudad;
        this.genero = genero;
        this.numeroLegajo = numeroLegajo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombre, String apellido) {
        this.nombreCompleto = apellido +", "+nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getNumeroLegajo() {
        return numeroLegajo;
    }

    public void setNumeroLegajo(int numeroLegajo) {
        this.numeroLegajo = numeroLegajo;
    }
}