package pe.edu.upeu.msinsidencia.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.msinsidencia.Entidad.Insidencia;

// ============================================
// REPOSITORIO DE DATOS PARA LA ENTIDAD INSIDENCIA
// ============================================

// Esta interfaz extiende JpaRepository, lo que le otorga automáticamente
// todos los métodos CRUD y operaciones de paginación, ordenamiento, etc.
public interface InsidenciaRepositorio extends JpaRepository<Insidencia, Long> {
    // JpaRepository<Entidad, TipoDeDatoDelId>
    // Ya incluye métodos como:
    // - findAll()
    // - findById(Long id)
    // - save(Insidencia entidad)
    // - deleteById(Long id)
    // - existsById(Long id)
    // - count()
    // y muchos más, sin necesidad de escribir código adicional.
}
