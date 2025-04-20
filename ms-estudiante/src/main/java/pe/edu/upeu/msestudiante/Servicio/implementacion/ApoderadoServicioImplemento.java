package pe.edu.upeu.msestudiante.Servicio.implementacion;  // Paquete donde se encuentra la clase de implementación del servicio

// Importación de las librerías necesarias
import org.springframework.beans.factory.annotation.Autowired;  // Importa la anotación para inyección de dependencias
import org.springframework.stereotype.Service;  // Anotación para indicar que esta clase es un servicio de Spring
import pe.edu.upeu.msestudiante.Repositorio.ApoderadoRepositorio;  // Importa el repositorio de Apoderado
import pe.edu.upeu.msestudiante.Servicio.ApoderadoServicio;  // Importa la interfaz del servicio de Apoderado
import pe.edu.upeu.msestudiante.entidad.Apoderado;  // Importa la entidad 'Apoderado'

import java.util.List;  // Para utilizar listas
import java.util.Optional;  // Para trabajar con objetos que pueden ser nulos (en este caso, Apoderado)

// Anotación para indicar que esta clase es un servicio en Spring
@Service
public class ApoderadoServicioImplemento implements ApoderadoServicio {

    // Inyección de dependencias para el repositorio de Apoderado
    @Autowired
    private ApoderadoRepositorio apoderadoRepositorio;

    // Método para listar todos los apoderados
    @Override
    public List<Apoderado> Listar() {
        // Devuelve todos los apoderados de la base de datos usando el repositorio
        return apoderadoRepositorio.findAll();
    }

    // Método para buscar un apoderado por su ID
    @Override
    public Optional<Apoderado> Buscar(Long id) {
        // Devuelve un apoderado envuelto en un Optional. Si no se encuentra, Optional estará vacío.
        return apoderadoRepositorio.findById(id);
    }

    // Método para guardar un apoderado
    @Override
    public Apoderado Guardar(Apoderado apoderado) {
        // Guarda el apoderado en la base de datos y devuelve el apoderado guardado
        return apoderadoRepositorio.save(apoderado);
    }

    // Método para modificar un apoderado existente
    @Override
    public Apoderado Modificar(Long id, Apoderado apoderado) {
        // Establece el ID del apoderado antes de guardarlo (esto asegura que se actualice el registro existente)
        apoderado.setId(id);
        // Guarda el apoderado actualizado en la base de datos y devuelve el apoderado modificado
        return apoderadoRepositorio.save(apoderado);
    }

    // Método para eliminar un apoderado por su ID
    @Override
    public void Eliminar(Long id) {
        // Elimina el apoderado de la base de datos por su ID
        apoderadoRepositorio.deleteById(id);
    }
}
