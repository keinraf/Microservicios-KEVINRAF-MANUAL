package pe.edu.upeu.msestudiante.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.msestudiante.entidad.Estudiante;

public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long> {
}
