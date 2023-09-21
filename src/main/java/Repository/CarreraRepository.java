package Repository;

import DTO.CarreraDTO;
import Entity.Carrera;

import java.util.List;

public interface CarreraRepository {
    List<CarreraDTO> getCarreras();
    void agregarCarrera(Carrera c);
}
