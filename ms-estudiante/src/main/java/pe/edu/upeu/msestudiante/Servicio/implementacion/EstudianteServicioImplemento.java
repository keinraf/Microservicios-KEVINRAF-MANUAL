package pe.edu.upeu.msestudiante.Servicio.implementacion;  // Paquete donde se encuentra la clase de implementación del servicio

// Importación de las librerías necesarias
import org.springframework.beans.factory.annotation.Autowired;  // Para inyección de dependencias en Spring
import org.springframework.stereotype.Service;  // Para indicar que esta clase es un servicio en Spring
import pe.edu.upeu.msestudiante.Repositorio.EstudianteRepositorio;  // Importa el repositorio de Estudiante
import pe.edu.upeu.msestudiante.Servicio.EstudianteServicio;  // Importa la interfaz del servicio de Estudiante
import pe.edu.upeu.msestudiante.entidad.Estudiante;  // Importa la entidad 'Estudiante'

import java.util.List;  // Para trabajar con listas
import java.util.Optional;  // Para manejar objetos que pueden ser nulos (en este caso, Estudiante)

// Anotación para indicar que esta clase es un servicio de Spring
@Service
public class EstudianteServicioImplemento implements EstudianteServicio {

    // Inyección de dependencias para el repositorio de Estudiante
    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    // Método para listar todos los estudiantes
    @Override
    public List<Estudiante> Listar() {
        // Utiliza el repositorio para obtener todos los estudiantes de la base de datos
        return estudianteRepositorio.findAll();
    }

    // Método para buscar un estudiante por su ID
    @Override
    public Optional<Estudiante> Buscar(Long id) {
        // Devuelve un estudiante envuelto en un Optional, para manejar el caso de no encontrarlo
        return estudianteRepositorio.findById(id);
    }

    // Método para guardar un estudiante
    @Override
    public Estudiante Guardar(Estudiante estudiante) {
        // Guarda el estudiante en la base de datos y devuelve el estudiante guardado
        return estudianteRepositorio.save(estudiante);
    }

    // Método para modificar un estudiante existente
    @Override
    public Estudiante Modificar(Long id, Estudiante estudiante) {
        // Establece el ID del estudiante antes de guardarlo (esto asegura que se actualice el registro correcto)
        estudiante.setId(id);
        // Guarda el estudiante modificado en la base de datos y devuelve el estudiante actualizado
        return estudianteRepositorio.save(estudiante);
    }

    // Método para eliminar un estudiante por su ID
    @Override
    public void Eliminar(Long id) {
        // Elimina el estudiante de la base de datos por su ID
        estudianteRepositorio.deleteById(id);
    }
}
