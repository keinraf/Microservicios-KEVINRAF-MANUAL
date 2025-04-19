package pe.edu.upeu.msestudiante.Servicio.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.msestudiante.Repositorio.EstudianteRepositorio;
import pe.edu.upeu.msestudiante.Servicio.EstudianteServicio;
import pe.edu.upeu.msestudiante.entidad.Estudiante;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServicioImplemento implements EstudianteServicio {

    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    @Override
    public List<Estudiante> Listar() {
        return estudianteRepositorio.findAll();
    }

    @Override
    public Optional<Estudiante> Buscar(Long id) {
        return estudianteRepositorio.findById(id);
    }

    @Override
    public Estudiante Guardar(Estudiante estudiante) {
        return estudianteRepositorio.save(estudiante);
    }

    @Override
    public Estudiante Modificar(Long id, Estudiante estudiante) {
        estudiante.setId(id);
        return estudianteRepositorio.save(estudiante);
    }

    @Override
    public void Eliminar(Long id) {
        estudianteRepositorio.deleteById(id);
    }
}
