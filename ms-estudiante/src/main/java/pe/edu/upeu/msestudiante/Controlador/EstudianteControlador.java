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

@RestController
@RequestMapping("/estudiante")
public class EstudianteControlador {
    @Autowired
    private EstudianteServicio estudianteServicio;
    @Autowired
    private ApoderadoServicio apoderadoServicio;

    // Obtener todas las estudiantes
    @GetMapping
    public ResponseEntity<List<Estudiante>> listarEstudiante() {
        List<Estudiante> estudiantes = estudianteServicio.Listar();
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }

    // Obtener una estudiante por ID
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> buscarEstudiante(@PathVariable Long id) {
        Optional<Estudiante> estudiante = estudianteServicio.Buscar(id);
        return estudiante.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva estudiante y jale apoderado Many to one
    @PostMapping
    public ResponseEntity<Estudiante> guardarEstudiante(@RequestBody EstudianteDto estudianteRequest) {
        Optional<Apoderado> apoderadoOptional = apoderadoServicio.Buscar(estudianteRequest.getApoderadoId());
        if (apoderadoOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Estudiante estudiante = new Estudiante(estudianteRequest, apoderadoOptional.get());
        Estudiante nuevoEstudiante = estudianteServicio.Guardar(estudiante);
        return new ResponseEntity<>(nuevoEstudiante, HttpStatus.CREATED);
    }


    // Actualizar o modificar una estudiante existente
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> modificarEstudiante(@PathVariable Long id, @RequestBody EstudianteUpdateDto estudianteRequest) {
        Optional<Estudiante> estudianteExistenteOptional = estudianteServicio.Buscar(id);
        if (estudianteExistenteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Estudiante estudianteExistente = estudianteExistenteOptional.get();

        // Actualizar los campos del estudiante existente con los datos del DTO
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

        // Manejar la actualización del apoderado si se proporciona un nuevo apoderadoId
        if (estudianteRequest.getApoderadoId() != null) {
            Optional<Apoderado> apoderadoOptional = apoderadoServicio.Buscar(estudianteRequest.getApoderadoId());
            if (apoderadoOptional.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            estudianteExistente.setApoderado(apoderadoOptional.get());
        }
        Estudiante estudianteModificado = estudianteServicio.Modificar(id, estudianteExistente);
        return estudianteModificado != null ? ResponseEntity.ok(estudianteModificado)
                : ResponseEntity.notFound().build();
    }

    // Eliminar una estudiante por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Estudiante> eliminarEstudiante(@PathVariable Long id) {
        estudianteServicio.Eliminar(id);
        return ResponseEntity.noContent().build();
    }


}
