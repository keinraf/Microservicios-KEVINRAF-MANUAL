package com.kps.kpsestudianteservicio.Repositorio;

import com.kps.kpsestudianteservicio.Entidad.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long> {
}
