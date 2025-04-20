package pe.edu.upeu.msestudiante.Servicio;  // Paquete donde se encuentra la interfaz del servicio

// Importación de la entidad 'Apoderado'
import pe.edu.upeu.msestudiante.entidad.Apoderado;

import java.util.List;  // Para manejar listas
import java.util.Optional;  // Para manejar objetos que pueden ser nulos (en este caso, Apoderado)

// Interfaz que define las operaciones que se pueden realizar sobre los Apoderados
public interface ApoderadoServicio {

    // Método para listar todos los apoderados
    List<Apoderado> Listar();  // Devuelve una lista de objetos Apoderado

    // Método para buscar un apoderado por su ID
    Optional<Apoderado> Buscar(Long id);  // Devuelve un objeto Optional que contiene el apoderado si existe, o está vacío si no

    // Método para guardar un nuevo apoderado
    Apoderado Guardar(Apoderado apoderado);  // Guarda un apoderado y devuelve el apoderado guardado

    // Método para modificar los datos de un apoderado existente
    Apoderado Modificar(Long id, Apoderado apoderado);  // Modifica los datos de un apoderado y devuelve el apoderado actualizado

    // Método para eliminar un apoderado por su ID
    void Eliminar(Long id);  // Elimina un apoderado de la base de datos por su ID
}
