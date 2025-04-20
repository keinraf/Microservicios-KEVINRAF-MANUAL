package pe.edu.upeu.msinsidencia.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.msinsidencia.Entidad.Insidencia;
import pe.edu.upeu.msinsidencia.Servicio.InsidenciaService;

import java.util.List;

@RestController
@RequestMapping("/insidencias")
public class InsidenciaControlador {

    @Autowired
    public InsidenciaService insidenciaService;

    @GetMapping
    public ResponseEntity<List<Insidencia>> Listar(){
        return new ResponseEntity<>(insidenciaService.Listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Insidencia> Buscar(@PathVariable Long id){
        Insidencia insidencia = insidenciaService.Buscar(id);
        if (insidencia != null) {
            return new ResponseEntity<>(insidencia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Insidencia> Guardar(@RequestBody Insidencia insidencia){
        Insidencia nuevaInsidencia = insidenciaService.Guardar(insidencia);
        return new ResponseEntity<>(nuevaInsidencia, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Insidencia> Actualizar(@PathVariable Long id, @RequestBody Insidencia insidencia){
        Insidencia insidenciaExistente = insidenciaService.Buscar(id);
        if (insidenciaExistente != null) {
            insidencia.setId(id); // Aseguramos que el ID sea el correcto para la actualización
            Insidencia insidenciaActualizada = insidenciaService.Actualizar(insidencia);
            return new ResponseEntity<>(insidenciaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        Insidencia insidenciaAEliminar = new Insidencia();
        insidenciaAEliminar.setId(id);
        insidenciaService.Eliminar(insidenciaAEliminar);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}