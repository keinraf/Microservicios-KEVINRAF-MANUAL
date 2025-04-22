package com.kps.kpsestudianteservicio.Controlador;

import com.kps.kpsestudianteservicio.Entidad.Estudiante;
import com.kps.kpsestudianteservicio.Servicio.EstudianteServicio;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControlador {
    @Autowired
    EstudianteServicio estudianteServicio;
    @Operation(summary = "Obtener estudiantes")
    @GetMapping
    public ResponseEntity<List<Estudiante>> ListarEstudiante(){
        return new ResponseEntity<>(estudianteServicio.Listar(), HttpStatus.OK);
    }
    @Operation(summary = "Buscar estudiante por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> BuscarEstudiante(@PathVariable Long id){
        return new ResponseEntity<>(estudianteServicio.Buscar(id), HttpStatus.OK);
    }
    @Operation(summary = "Guardar estudiante")
    @PostMapping
    public ResponseEntity CrearEstudiante(@RequestBody Estudiante estudiante){
        Estudiante nuevoEstudiante = estudianteServicio.Guardar(estudiante);
        return new ResponseEntity<>(nuevoEstudiante, HttpStatus.CREATED);
    }
    @Operation(summary = "Actualizat estudiante por ID")
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> ActualizarEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante){
        Estudiante estudianteActualizado = estudianteServicio.Actualizar(estudiante);
        return new ResponseEntity<>(estudianteActualizado, HttpStatus.OK);
    }
    @Operation(summary = "Borrar estudiante por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> EliminarEstudiante(@PathVariable Long id){
        Estudiante estudianteEliminado = new Estudiante();
        estudianteEliminado.setId(id);
        estudianteServicio.Eliminar(estudianteEliminado);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
