package pe.edu.upeu.msestudiante.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.msestudiante.Servicio.EstudianteServicio;
import pe.edu.upeu.msestudiante.entidad.Estudiante;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudiante")
public class EstudianteControlador {
    @Autowired
    private EstudianteServicio estudianteServicio;

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

    // Crear una nueva estudiante
    @PostMapping
    public ResponseEntity<Estudiante> guardarEstudiante(@RequestBody Estudiante estudiante) {
        Estudiante nuevoEstudiante = estudianteServicio.Guardar(estudiante);
        return new ResponseEntity<>(nuevoEstudiante, HttpStatus.CREATED);
    }


    // Actualizar o modificar una estudiante existente
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> modificarEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        Estudiante estudianteModificado = estudianteServicio.Modificar(id, estudiante);
        return estudianteModificado != null ? new ResponseEntity<>(estudianteModificado, HttpStatus.OK)
                : ResponseEntity.notFound().build();
    }

    // Eliminar una estudiante por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Estudiante> eliminarEstudiante(@PathVariable Long id) {
        estudianteServicio.Eliminar(id);
        return ResponseEntity.noContent().build();
    }


}
