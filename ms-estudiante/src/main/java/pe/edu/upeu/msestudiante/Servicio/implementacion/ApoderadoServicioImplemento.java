package pe.edu.upeu.msestudiante.Servicio.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.msestudiante.Repositorio.ApoderadoRepositorio;
import pe.edu.upeu.msestudiante.Servicio.ApoderadoServicio;
import pe.edu.upeu.msestudiante.entidad.Apoderado;

import java.util.List;
import java.util.Optional;

@Service
public class ApoderadoServicioImplemento implements ApoderadoServicio {
    @Autowired
    private ApoderadoRepositorio apoderadoRepositorio;

    @Override
    public List<Apoderado> Listar() {
        return apoderadoRepositorio.findAll();
    }

    @Override
    public Optional<Apoderado> Buscar(Long id) {
        return apoderadoRepositorio.findById(id);
    }

    @Override
    public Apoderado Guardar(Apoderado apoderado) {
        return apoderadoRepositorio.save(apoderado);
    }

    @Override
    public Apoderado Modificar(Long id, Apoderado apoderado) {
        apoderado.setId(id);
        return apoderadoRepositorio.save(apoderado);
    }

    @Override
    public void Eliminar(Long id) {
        apoderadoRepositorio.deleteById(id);
    }
}
