package pe.edu.upeu.msestudiante.Repositorio;  // Paquete donde se encuentra la clase

// Importación de las librerías necesarias
import org.springframework.data.jpa.repository.JpaRepository;  // Interfaz de Spring Data JPA para realizar operaciones CRUD
import pe.edu.upeu.msestudiante.entidad.Estudiante;  // Importa la entidad 'Estudiante' que va a ser manejada por este repositorio

// Interface que extiende JpaRepository para acceder a la entidad 'Estudiante' y realizar operaciones CRUD sobre ella
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long> {
    // Al igual que el repositorio de 'Apoderado', este extiende JpaRepository, lo que proporciona métodos CRUD básicos automáticamente:
    // - save() para guardar un estudiante
    // - findById() para buscar un estudiante por su id
    // - findAll() para obtener todos los estudiantes
    // - deleteById() para eliminar un estudiante por su id
    // No es necesario definir métodos adicionales a menos que sea necesario realizar consultas personalizadas.
}
