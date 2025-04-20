package pe.edu.upeu.msestudiante.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.msestudiante.Dto.EstudianteDto;
import pe.edu.upeu.msestudiante.Dto.EstudianteUpdateDto;
import pe.edu.upeu.msestudiante.Servicio.ApoderadoServicio;
import pe.edu.upeu.msestudiante.Servicio.EstudianteServicio;
import pe.edu.upeu.msestudiante.entidad.Apoderado;
import pe.edu.upeu.msestudiante.entidad.Estudiante;

import java.util.List;
import java.util.Optional;

@RestController  // Indica que esta clase es un controlador REST.
@RequestMapping("/estudiantes")  // Define la ruta base para las solicitudes a este controlador.
public class EstudianteControlador {

    @Autowired  // Inyecta el servicio de estudiantes automáticamente.
    private EstudianteServicio estudianteServicio;

    @Autowired  // Inyecta el servicio de apoderados automáticamente.
    private ApoderadoServicio apoderadoServicio;

    // Obtener todos los estudiantes
    @GetMapping  // Define el método para manejar las solicitudes GET a "/estudiantes".
    public ResponseEntity<List<Estudiante>> listarEstudiante() {
        List<Estudiante> estudiantes = estudianteServicio.Listar();  // Obtiene la lista de estudiantes.
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);  // Devuelve la lista de estudiantes con el código HTTP 200 (OK).
    }

    // Obtener un estudiante por ID
    @GetMapping("/{id}")  // Define el método para manejar las solicitudes GET a "/estudiantes/{id}".
    public ResponseEntity<Estudiante> buscarEstudiante(@PathVariable Long id) {
        Optional<Estudiante> estudiante = estudianteServicio.Buscar(id);  // Busca un estudiante por su ID.
        return estudiante.map(ResponseEntity::ok)  // Si se encuentra el estudiante, devuelve el objeto con un código HTTP 200.
                .orElseGet(() -> ResponseEntity.notFound().build());  // Si no se encuentra, devuelve un código HTTP 404 (No encontrado).
    }

    // Crear un nuevo estudiante y asociar un apoderado (relación Many to One)
    @PostMapping  // Define el método para manejar las solicitudes POST a "/estudiantes".
    public ResponseEntity<Estudiante> guardarEstudiante(@RequestBody EstudianteDto estudianteRequest) {
        Optional<Apoderado> apoderadoOptional = apoderadoServicio.Buscar(estudianteRequest.getApoderadoId());  // Busca el apoderado por su ID.
        if (apoderadoOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Si el apoderado no se encuentra, devuelve un código HTTP 404 (No encontrado).
        }
        Estudiante estudiante = new Estudiante(estudianteRequest, apoderadoOptional.get());  // Crea un nuevo estudiante con el apoderado.
        Estudiante nuevoEstudiante = estudianteServicio.Guardar(estudiante);  // Guarda el nuevo estudiante.
        return new ResponseEntity<>(nuevoEstudiante, HttpStatus.CREATED);  // Devuelve el estudiante creado con el código HTTP 201 (Creado).
    }

    // Actualizar o modificar un estudiante existente
    @PutMapping("/{id}")  // Define el método para manejar las solicitudes PUT a "/estudiantes/{id}".
    public ResponseEntity<Estudiante> modificarEstudiante(@PathVariable Long id, @RequestBody EstudianteUpdateDto estudianteRequest) {
        Optional<Estudiante> estudianteExistenteOptional = estudianteServicio.Buscar(id);  // Busca el estudiante existente por su ID.
        if (estudianteExistenteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();  // Si el estudiante no se encuentra, devuelve un código HTTP 404.
        }
        Estudiante estudianteExistente = estudianteExistenteOptional.get();

        // Actualiza los campos del estudiante con los datos proporcionados en el DTO
        if (estudianteRequest.getNombre() != null) {
            estudianteExistente.setNombre(estudianteRequest.getNombre());
        }
        if (estudianteRequest.getApellidoPaterno() != null) {
            estudianteExistente.setApellidoPaterno(estudianteRequest.getApellidoPaterno());
        }
        if (estudianteRequest.getApellidoMaterno() != null) {
            estudianteExistente.setApellidoMaterno(estudianteRequest.getApellidoMaterno());
        }
        if (estudianteRequest.getCelular() != null) {
            estudianteExistente.setCelular(estudianteRequest.getCelular());
        }
        if (estudianteRequest.getCorreo() != null) {
            estudianteExistente.setCorreo(estudianteRequest.getCorreo());
        }
        if (estudianteRequest.getFechaNacimiento() != null) {
            estudianteExistente.setFechaNacimiento(estudianteRequest.getFechaNacimiento());
        }

        // Si se proporciona un nuevo apoderado, actualiza el apoderado del estudiante
        if (estudianteRequest.getApoderadoId() != null) {
            Optional<Apoderado> apoderadoOptional = apoderadoServicio.Buscar(estudianteRequest.getApoderadoId());
            if (apoderadoOptional.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);  // Si el apoderado no se encuentra, devuelve un código HTTP 400 (Solicitud incorrecta).
            }
            estudianteExistente.setApoderado(apoderadoOptional.get());  // Asocia el nuevo apoderado al estudiante.
        }

        Estudiante estudianteModificado = estudianteServicio.Modificar(id, estudianteExistente);  // Modifica el estudiante en la base de datos.
        return estudianteModificado != null ? ResponseEntity.ok(estudianteModificado)  // Si la modificación es exitosa, devuelve el estudiante modificado con código HTTP 200.
                : ResponseEntity.notFound().build();  // Si no se encuentra el estudiante, devuelve un código HTTP 404 (No encontrado).
    }

    // Eliminar un estudiante por ID
    @DeleteMapping("/{id}")  // Define el método para manejar las solicitudes DELETE a "/estudiantes/{id}".
    public ResponseEntity<Estudiante> eliminarEstudiante(@PathVariable Long id) {
        estudianteServicio.Eliminar(id);  // Llama al servicio para eliminar el estudiante por su ID.
        return ResponseEntity.noContent().build();  // Devuelve un código HTTP 204 (Sin contenido) si la eliminación es exitosa.
    }
}
