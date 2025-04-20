package pe.edu.upeu.msinsidencia.Servicio.Implementos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.msinsidencia.Dto.EstudianteDto;
import pe.edu.upeu.msinsidencia.Entidad.Insidencia;
import pe.edu.upeu.msinsidencia.Feign.EstudianteFeign;
import pe.edu.upeu.msinsidencia.Repositorio.InsidenciaRepositorio;
import pe.edu.upeu.msinsidencia.Servicio.InsidenciaService;

import java.util.List;
import java.util.Optional;

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
        Optional<Insidencia> insidenciaOptional = insidenciaRepositorio.findById(id);
        if (insidenciaOptional.isPresent()) {
            Insidencia insidencia = insidenciaOptional.get();
            try {
                EstudianteDto estudianteDto = estudianteFeign.buscarEstudiante(insidencia.getEstudianteId()).getBody();
                insidencia.setEstudianteDto(estudianteDto);
            } catch (Exception e) {
                System.err.println("Error al obtener información del estudiante: " + e.getMessage());
                insidencia.setEstudianteDto(null);
            }
            return insidencia;
        }
        return null;
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
        insidenciaRepositorio.delete(insidencia); // Usamos delete() para eliminar
        return insidencia; // Puedes retornar void si prefieres
    }
}