package DTO;

import java.io.Serializable;

public class CarreraDTO implements Serializable {
    private String nombre;
    private int cantEstudiantes;

    public CarreraDTO() {
        super();
    }

    public CarreraDTO(String nombre, int cantEstudiantes) {
        this.nombre = nombre;
        this.cantEstudiantes = cantEstudiantes;
    }

    public CarreraDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantEstudiantes() {
        return cantEstudiantes;
    }

    public void setCantEstudiantes(int cantEstudiantes) {
        this.cantEstudiantes = cantEstudiantes;
    }
}