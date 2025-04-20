package pe.edu.upeu.msinsidencia.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.msinsidencia.Entidad.Insidencia;

public interface InsidenciaRepositorio extends JpaRepository<Insidencia, Long> {
}
