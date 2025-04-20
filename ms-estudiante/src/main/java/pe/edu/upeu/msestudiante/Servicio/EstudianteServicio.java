package pe.edu.upeu.msestudiante.Servicio;  // Paquete donde se encuentra la interfaz del servicio

// Importación de la entidad 'Estudiante'
import pe.edu.upeu.msestudiante.entidad.Estudiante;

import java.util.List;  // Para manejar listas de estudiantes
import java.util.Optional;  // Para manejar objetos que pueden ser nulos (en este caso, Estudiante)

// Interfaz que define las operaciones que se pueden realizar sobre los Estudiantes
public interface EstudianteServicio {

    // Método para listar todos los estudiantes
    List<Estudiante> Listar();  // Devuelve una lista de objetos Estudiante

    // Método para buscar un estudiante por su ID
    Optional<Estudiante> Buscar(Long id);  // Devuelve un objeto Optional que contiene el estudiante si existe, o está vacío si no

    // Método para guardar un nuevo estudiante
    Estudiante Guardar(Estudiante estudiante);  // Guarda un estudiante y devuelve el estudiante guardado

    // Método para modificar los datos de un estudiante existente
    Estudiante Modificar(Long id, Estudiante estudiante);  // Modifica los datos de un estudiante y devuelve el estudiante actualizado

    // Método para eliminar un estudiante por su ID
    void Eliminar(Long id);  // Elimina un estudiante de la base de datos por su ID
}
