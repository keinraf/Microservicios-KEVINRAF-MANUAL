package pe.edu.upeu.msinsidencia.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.upeu.msinsidencia.Dto.EstudianteDto;

// ==========================================================
// CLIENTE FEIGN PARA CONECTARSE AL MICROSERVICIO ESTUDIANTE
// ==========================================================

// Define que esta interfaz es un cliente Feign que se conectará al microservicio llamado "ms-estudiante-service"
// La URL base que utilizará será "/estudiantes"
@FeignClient(name = "ms-estudiante-service", path = "/estudiantes")
public interface EstudianteFeign {

    // ===========================================
    // OBTENER UN ESTUDIANTE POR SU ID
    // ===========================================

    // Define una llamada HTTP GET a la ruta "/estudiantes/{id}" del microservicio "ms-estudiante-service"
    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDto> buscarEstudiante(@PathVariable Long id);
    // Este método será implementado automáticamente por Spring Cloud Feign
    // cuando se haga una petición al microservicio estudiante, y retornará los datos del estudiante con ese ID.
}
