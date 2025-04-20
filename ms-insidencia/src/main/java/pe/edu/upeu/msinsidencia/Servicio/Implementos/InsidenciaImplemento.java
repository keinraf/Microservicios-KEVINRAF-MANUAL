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

@Service // Anotación que indica que esta clase es un componente de servicio manejado por Spring
public class InsidenciaImplemento implements InsidenciaService {

    // Inyección del cliente Feign para consumir el microservicio de estudiantes
    @Autowired
    private EstudianteFeign estudianteFeign;

    // Inyección del repositorio JPA para acceder a la base de datos
    @Autowired
    private InsidenciaRepositorio insidenciaRepositorio;

    // ==========================================
    // LISTAR TODAS LAS INSIDENCIAS
    // ==========================================
    @Override
    public List<Insidencia> Listar(){
        // Recupera todas las insidencias de la base de datos
        return insidenciaRepositorio.findAll();
    }

    // ==========================================
    // BUSCAR INSIDENCIA POR ID Y CARGAR ESTUDIANTE DTO
    // ==========================================
    @Override
    public Insidencia Buscar(Long id){
        // Busca una insidencia por su ID
        Optional<Insidencia> insidenciaOptional = insidenciaRepositorio.findById(id);

        if (insidenciaOptional.isPresent()) {
            Insidencia insidencia = insidenciaOptional.get();

            try {
                // Llamada al microservicio ms-estudiante para obtener datos del estudiante
                EstudianteDto estudianteDto = estudianteFeign.buscarEstudiante(insidencia.getEstudianteId()).getBody();

                // Asigna el objeto DTO al campo @Transient de la insidencia
                insidencia.setEstudianteDto(estudianteDto);
            } catch (Exception e) {
                // Manejo de error si el microservicio no responde o lanza excepción
                System.err.println("Error al obtener información del estudiante: " + e.getMessage());
                insidencia.setEstudianteDto(null); // Evita que falle si no hay respuesta
            }

            return insidencia;
        }

        return null; // Retorna null si no existe una insidencia con ese ID
    }

    // ==========================================
    // GUARDAR NUEVA INSIDENCIA
    // ==========================================
    @Override
    public Insidencia Guardar(Insidencia insidencia){
        // Persiste la nueva insidencia en la base de datos
        return insidenciaRepositorio.save(insidencia);
    }

    // ==========================================
    // ACTUALIZAR UNA INSIDENCIA EXISTENTE
    // ==========================================
    @Override
    public Insidencia Actualizar(Insidencia insidencia){
        // Guarda la insidencia, si ya existe la actualiza (por ID)
        return insidenciaRepositorio.save(insidencia);
    }

    // ==========================================
    // ELIMINAR UNA INSIDENCIA
    // ==========================================
    @Override
    public Insidencia Eliminar(Insidencia insidencia){
        // Elimina la insidencia de la base de datos
        insidenciaRepositorio.delete(insidencia);

        // Retorna la insidencia eliminada (opcional)
        return insidencia;
    }
}
