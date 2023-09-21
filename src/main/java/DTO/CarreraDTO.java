package DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarreraDTO implements Serializable {
    private String nombre;
    private List<EstudianteDTO> estudiantes;

    public CarreraDTO(){super();}
    public CarreraDTO(String nombre){
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<EstudianteDTO> getEstudiantes() {
        return new ArrayList<EstudianteDTO>(estudiantes);
    }

    public void addEstudiante(EstudianteDTO e) {
        this.estudiantes.add(e);
    }

    public void addEstudiantes(int dni, String nombre, String apellido, int edad, char genero, String ciudad, int numeroLegajo) {
        this.estudiantes.add(new EstudianteDTO(dni, nombre, apellido, edad, genero, ciudad, numeroLegajo, false, LocalDate.now(), this.nombre));
    }
}