package pe.edu.upeu.msinsidencia.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.msinsidencia.Entidad.Insidencia;
import pe.edu.upeu.msinsidencia.Servicio.InsidenciaService;

import java.util.List;

// Indicamos que esta clase será un controlador REST (responderá en formato JSON)
@RestController

// Establece el prefijo de la ruta para todas las peticiones de este controlador
@RequestMapping("/insidencias")
public class InsidenciaControlador {

    // Inyección automática del servicio que contiene la lógica de negocio para 'Insidencia'
    @Autowired
    public InsidenciaService insidenciaService;

    // ============================
    // LISTAR TODAS LAS INCIDENCIAS
    // ============================
    // Maneja las peticiones GET a la URL '/insidencias'
    @GetMapping
    public ResponseEntity<List<Insidencia>> Listar() {
        // Retorna la lista de todas las incidencias con código 200 OK
        return new ResponseEntity<>(insidenciaService.Listar(), HttpStatus.OK);
    }

    // ==================================
    // BUSCAR UNA INCIDENCIA POR SU ID
    // ==================================
    // Maneja las peticiones GET a la URL '/insidencias/{id}'
    @GetMapping("/{id}")
    public ResponseEntity<Insidencia> Buscar(@PathVariable Long id) {
        // Busca la incidencia con el ID especificado
        Insidencia insidencia = insidenciaService.Buscar(id);

        // Si existe la incidencia, se retorna con código 200 OK
        if (insidencia != null) {
            return new ResponseEntity<>(insidencia, HttpStatus.OK);
        } else {
            // Si no se encuentra, se retorna 404 Not Found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ==============================
    // GUARDAR UNA NUEVA INCIDENCIA
    // ==============================
    // Maneja las peticiones POST a la URL '/insidencias'
    @PostMapping
    public ResponseEntity<Insidencia> Guardar(@RequestBody Insidencia insidencia) {
        // Guarda la nueva incidencia enviada en el cuerpo de la solicitud
        Insidencia nuevaInsidencia = insidenciaService.Guardar(insidencia);

        // Retorna la incidencia creada con código 201 Created
        return new ResponseEntity<>(nuevaInsidencia, HttpStatus.CREATED);
    }

    // ============================
    // ACTUALIZAR UNA INCIDENCIA
    // ============================
    // Maneja las peticiones PUT a la URL '/insidencias/{id}'
    @PutMapping("/{id}")
    public ResponseEntity<Insidencia> Actualizar(@PathVariable Long id, @RequestBody Insidencia insidencia) {
        // Busca si existe una incidencia con ese ID
        Insidencia insidenciaExistente = insidenciaService.Buscar(id);

        // Si la incidencia existe, se actualiza
        if (insidenciaExistente != null) {
            // Asegura que el ID de la incidencia a actualizar sea el correcto
            insidencia.setId(id);

            // Llama al servicio para actualizar la incidencia
            Insidencia insidenciaActualizada = insidenciaService.Actualizar(insidencia);

            // Retorna la incidencia actualizada con código 200 OK
            return new ResponseEntity<>(insidenciaActualizada, HttpStatus.OK);
        } else {
            // Si no se encuentra la incidencia, retorna 404 Not Found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // =============================
    // ELIMINAR UNA INCIDENCIA POR ID
    // =============================
    // Maneja las peticiones DELETE a la URL '/insidencias/{id}'
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        // Crea una instancia temporal con el ID de la incidencia a eliminar
        Insidencia insidenciaAEliminar = new Insidencia();
        insidenciaAEliminar.setId(id);

        // Llama al servicio para eliminar la incidencia
        insidenciaService.Eliminar(insidenciaAEliminar);

        // Retorna código 204 No Content para indicar eliminación exitosa
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
