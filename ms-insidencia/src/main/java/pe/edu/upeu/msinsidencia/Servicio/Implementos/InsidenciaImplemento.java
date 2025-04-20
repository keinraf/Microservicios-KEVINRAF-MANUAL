package pe.edu.upeu.msinsidencia.Servicio.Implementos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.msinsidencia.Dto.EstudianteDto;
import pe.edu.upeu.msinsidencia.Entidad.Insidencia;
import pe.edu.upeu.msinsidencia.Feign.EstudianteFeign;
import pe.edu.upeu.msinsidencia.Repositorio.InsidenciaRepositorio;
import pe.edu.upeu.msinsidencia.Servicio.InsidenciaService;

import java.util.List;

@Service
public class InsidenciaImplemento implements InsidenciaService {
    @Autowired
    private EstudianteFeign estudianteFeign;

    @Autowired
    private InsidenciaRepositorio insidenciaRepositorio;

    @Override
    public List<Insidencia> Listar(){
        return insidenciaRepositorio.findAll();
    }

    @Override
    public Insidencia Buscar(Long id){
        Insidencia insidencia = insidenciaRepositorio.findById(id).get();
        insidencia.setEstudianteDto(estudianteFeign.buscarEstudiante(insidencia.getEstudianteId()).getBody());
        return insidenciaRepositorio.findById(id).get();
    }

    @Override
    public Insidencia Guardar(Insidencia insidencia){
        return insidenciaRepositorio.save(insidencia);
    }
    @Override
    public Insidencia Actualizar(Insidencia insidencia){
        return insidenciaRepositorio.save(insidencia);
    }
    @Override
    public Insidencia Eliminar(Insidencia insidencia){
        return insidenciaRepositorio.save(insidencia);
    }
}
