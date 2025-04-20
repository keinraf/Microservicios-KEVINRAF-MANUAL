package pe.edu.upeu.msestudiante.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.msestudiante.Servicio.ApoderadoServicio;
import pe.edu.upeu.msestudiante.entidad.Apoderado;

import java.util.List;
import java.util.Optional;

@RestController  // Anotación que indica que esta clase será un controlador REST.
@RequestMapping("/apoderados")  // Define la ruta base para este controlador.
public class ApoderadoControlador {

    @Autowired  // Inyecta automáticamente una instancia del servicio "ApoderadoServicio".
    private ApoderadoServicio apoderadoServicio;

    // Obtener todas las Apoderados
    @GetMapping  // Anotación que indica que este método manejará las solicitudes GET a "/apoderados".
    public ResponseEntity<List<Apoderado>> listarApoderado() {
        List<Apoderado> apoderados = apoderadoServicio.Listar();  // Llama al servicio para obtener todos los apoderados.
        return new ResponseEntity<>(apoderados, HttpStatus.OK);  // Devuelve los apoderados con un código de estado HTTP 200 (OK).
    }

    // Obtener una Apoderado por ID
    @GetMapping("/{id}")  // Anotación que indica que este método manejará las solicitudes GET a "/apoderados/{id}".
    public ResponseEntity<Apoderado> buscarApoderado(@PathVariable Long id) {
        Optional<Apoderado> apoderado = apoderadoServicio.Buscar(id);  // Llama al servicio para buscar un apoderado por su ID.
        return apoderado.map(ResponseEntity::ok)  // Si el apoderado existe, devuelve un ResponseEntity con el apoderado y un código HTTP 200.
                .orElseGet(() -> ResponseEntity.notFound().build());  // Si no se encuentra, devuelve un código HTTP 404 (No encontrado).
    }

    // Crear una nueva Apoderado
    @PostMapping  // Anotación que indica que este método manejará las solicitudes POST a "/apoderados".
    public ResponseEntity<Apoderado> guardarApoderado(@RequestBody Apoderado apoderado) {
        Apoderado nuevoApoderado = apoderadoServicio.Guardar(apoderado);  // Llama al servicio para guardar un nuevo apoderado.
        return new ResponseEntity<>(nuevoApoderado, HttpStatus.CREATED);  // Devuelve el nuevo apoderado con un código de estado HTTP 201 (Creado).
    }

    // Actualizar o modificar una Apoderado existente
    @PutMapping("/{id}")  // Anotación que indica que este método manejará las solicitudes PUT a "/apoderados/{id}".
    public ResponseEntity<Apoderado> modificarApoderado(@PathVariable Long id, @RequestBody Apoderado apoderado) {
        Apoderado apoderadoModificado = apoderadoServicio.Modificar(id, apoderado);  // Llama al servicio para modificar un apoderado existente.
        return apoderadoModificado != null ? new ResponseEntity<>(apoderadoModificado, HttpStatus.OK)  // Si se modifica correctamente, devuelve un código HTTP 200.
                : ResponseEntity.notFound().build();  // Si no se encuentra el apoderado, devuelve un código HTTP 404 (No encontrado).
    }

    // Eliminar una Apoderado por ID
    @DeleteMapping("/{id}")  // Anotación que indica que este método manejará las solicitudes DELETE a "/apoderados/{id}".
    public ResponseEntity<Apoderado> eliminarApoderado(@PathVariable Long id) {
        apoderadoServicio.Eliminar(id);  // Llama al servicio para eliminar un apoderado por su ID.
        return ResponseEntity.noContent().build();  // Devuelve un código HTTP 204 (Sin contenido) si la eliminación es exitosa.
    }
}
