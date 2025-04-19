package pe.edu.upeu.msestudiante.Servicio;

import pe.edu.upeu.msestudiante.entidad.Apoderado;


import java.util.List;
import java.util.Optional;

public interface ApoderadoServicio {
    List<Apoderado> Listar();
    Optional<Apoderado> Buscar(Long id);
    Apoderado Guardar(Apoderado apoderado);
    Apoderado Modificar(Long id, Apoderado apoderado);
    void Eliminar(Long id);
}
