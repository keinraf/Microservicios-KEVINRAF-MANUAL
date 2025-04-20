package pe.edu.upeu.msinsidencia.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.msinsidencia.Entidad.Insidencia;
import pe.edu.upeu.msinsidencia.Servicio.InsidenciaService;

import java.util.List;

@RestController
@RequestMapping("/insidencias")
public class InsidenciaControlador {

    @Autowired
    public InsidenciaService insidenciaService;

    public List<Insidencia> Listar(){
        return insidenciaService.Listar();
    }

    @GetMapping("/{id}")
    public Insidencia Buscar(@PathVariable Long id){
        return insidenciaService.Buscar(id);
    }

    @PostMapping
    public Insidencia Guardar(@RequestBody Insidencia insidencia){
        return insidenciaService.Guardar(insidencia);
    }

    @PutMapping
    public Insidencia Actualizar(@RequestBody Insidencia insidencia){
        return insidenciaService.Actualizar(insidencia);
    }

    @DeleteMapping
    public void eliminar(@RequestBody Insidencia insidencia){
        insidenciaService.Eliminar(insidencia);
    }



}
