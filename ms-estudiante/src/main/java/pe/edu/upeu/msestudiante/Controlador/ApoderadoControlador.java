package pe.edu.upeu.msestudiante.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.msestudiante.Servicio.ApoderadoServicio;
import pe.edu.upeu.msestudiante.entidad.Apoderado;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apoderado")
public class ApoderadoControlador {

    @Autowired
    private ApoderadoServicio apoderadoServicio;

    // Obtener todas las Apoderados
    @GetMapping
    public ResponseEntity<List<Apoderado>> listarApoderado() {
        List<Apoderado> apoderados = apoderadoServicio.Listar();
        return new ResponseEntity<>(apoderados, HttpStatus.OK);
    }

    // Obtener una Apoderado por ID
    @GetMapping("/{id}")
    public ResponseEntity<Apoderado> buscarApoderado(@PathVariable Long id) {
        Optional<Apoderado> apoderado = apoderadoServicio.Buscar(id);
        return apoderado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva Apoderado
    @PostMapping
    public ResponseEntity<Apoderado> guardarApoderado(@RequestBody Apoderado apoderado) {
        Apoderado nuevoApoderado = apoderadoServicio.Guardar(apoderado);
        return new ResponseEntity<>(nuevoApoderado, HttpStatus.CREATED);
    }


    // Actualizar o modificar una Apoderado existente
    @PutMapping("/{id}")
    public ResponseEntity<Apoderado> modificarApoderado(@PathVariable Long id, @RequestBody Apoderado apoderado) {
        Apoderado apoderadoModificado = apoderadoServicio.Modificar(id, apoderado);
        return apoderadoModificado != null ? new ResponseEntity<>(apoderadoModificado, HttpStatus.OK)
                : ResponseEntity.notFound().build();
    }

    // Eliminar una Apoderado por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Apoderado> eliminarApoderado(@PathVariable Long id) {
        apoderadoServicio.Eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
