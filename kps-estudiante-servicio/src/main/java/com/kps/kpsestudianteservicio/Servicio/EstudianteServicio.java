package com.kps.kpsestudianteservicio.Servicio;

import com.kps.kpsestudianteservicio.Entidad.Estudiante;

import java.util.List;

public interface EstudianteServicio {
    List<Estudiante> Listar();
    Estudiante Buscar(Long id);
    Estudiante Guardar(Estudiante estudiante);
    Estudiante Actualizar(Estudiante estudiante);
    Estudiante Eliminar(Estudiante estudiante);
}
