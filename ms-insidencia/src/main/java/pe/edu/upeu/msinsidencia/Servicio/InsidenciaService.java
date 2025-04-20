package pe.edu.upeu.msinsidencia.Servicio;

import pe.edu.upeu.msinsidencia.Entidad.Insidencia;

import java.util.List;

public interface InsidenciaService {

    List<Insidencia> Listar();
    Insidencia Buscar(Long id);
    Insidencia Guardar(Insidencia insidencia);
    Insidencia Actualizar(Insidencia insidencia);
    Insidencia Eliminar(Insidencia insidencia);

}
