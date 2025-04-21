package pe.edu.upeu.msestudiante.Controlador;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
@RequestMapping("/estudiantes")
public class EstudianteControlador {

    @Autowired
    private EstudianteServicio estudianteServicio;

    @Autowired
    private ApoderadoServicio apoderadoServicio;

    // Obtener todos los estudiantes
    @Operation(summary = "Obtener todos los estudiantes", description = "Devuelve una lista de todos los estudiantes.")
    @ApiResponse(responseCode = "200", description = "Lista de estudiantes obtenida exitosamente.",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estudiante.class)))
    @GetMapping
    public ResponseEntity<List<Estudiante>> listarEstudiante() {
        List<Estudiante> estudiantes = estudianteServicio.Listar();
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }

    // Obtener un estudiante por ID
    @Operation(summary = "Obtener estudiante por ID", description = "Devuelve un estudiante según el ID proporcionado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estudiante encontrado.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estudiante.class))),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado.", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> buscarEstudiante(@Parameter(description = "ID del estudiante a buscar", required = true) @PathVariable Long id) {
        Optional<Estudiante> estudiante = estudianteServicio.Buscar(id);
        return estudiante.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo estudiante y asociar un apoderado (relación Many to One)
    @Operation(summary = "Crear nuevo estudiante", description = "Crea un nuevo estudiante y lo asocia a un apoderado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Estudiante creado exitosamente.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estudiante.class))),
            @ApiResponse(responseCode = "404", description = "Apoderado no encontrado.", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Estudiante> guardarEstudiante(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Objeto EstudianteDto con los datos del estudiante y el ID del apoderado.", required = true) @RequestBody EstudianteDto estudianteRequest) {
        Optional<Apoderado> apoderadoOptional = apoderadoServicio.Buscar(estudianteRequest.getApoderadoId());
        if (apoderadoOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Estudiante estudiante = new Estudiante(estudianteRequest, apoderadoOptional.get());
        Estudiante nuevoEstudiante = estudianteServicio.Guardar(estudiante);
        return new ResponseEntity<>(nuevoEstudiante, HttpStatus.CREATED);
    }

    // Actualizar o modificar un estudiante existente
    @Operation(summary = "Actualizar estudiante", description = "Actualiza los datos de un estudiante existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estudiante actualizado exitosamente.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estudiante.class))),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta (por ejemplo, apoderado no encontrado).", content = @Content),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado.", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> modificarEstudiante(
            @Parameter(description = "ID del estudiante a actualizar", required = true) @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Objeto EstudianteUpdateDto con los datos a actualizar del estudiante.", required = true) @RequestBody EstudianteUpdateDto estudianteRequest) {
        Optional<Estudiante> estudianteExistenteOptional = estudianteServicio.Buscar(id);
        if (estudianteExistenteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
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
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            estudianteExistente.setApoderado(apoderadoOptional.get());
        }

        Estudiante estudianteModificado = estudianteServicio.Modificar(id, estudianteExistente);
        return estudianteModificado != null ? ResponseEntity.ok(estudianteModificado)
                : ResponseEntity.notFound().build();
    }

    // Eliminar un estudiante por ID
    @Operation(summary = "Eliminar estudiante", description = "Elimina un estudiante según el ID proporcionado.")
    @ApiResponse(responseCode = "204", description = "Estudiante eliminado exitosamente.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Estudiante> eliminarEstudiante(@Parameter(description = "ID del estudiante a eliminar", required = true) @PathVariable Long id) {
        estudianteServicio.Eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

