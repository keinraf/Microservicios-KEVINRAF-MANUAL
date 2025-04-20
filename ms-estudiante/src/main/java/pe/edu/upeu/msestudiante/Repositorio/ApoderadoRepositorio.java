package pe.edu.upeu.msestudiante.Repositorio;  // Paquete donde se encuentra la clase

// Importación de las librerías necesarias
import org.springframework.data.jpa.repository.JpaRepository;  // Interfaz de Spring Data JPA para realizar operaciones CRUD
import pe.edu.upeu.msestudiante.entidad.Apoderado;  // Importa la entidad 'Apoderado' que va a ser manejada por este repositorio

// Interface que extiende JpaRepository para acceder a la entidad 'Apoderado' y realizar operaciones CRUD sobre ella
public interface ApoderadoRepositorio extends JpaRepository<Apoderado, Long> {
    // No es necesario escribir ningún método adicional, ya que JpaRepository ya provee métodos como:
    // - save() para guardar un apoderado
    // - findById() para buscar un apoderado por su id
    // - findAll() para obtener todos los apoderados
    // - deleteById() para eliminar un apoderado por su id
    // Además de estos, se pueden definir métodos adicionales según las necesidades de la aplicación
}
