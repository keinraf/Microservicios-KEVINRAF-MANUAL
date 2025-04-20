package pe.edu.upeu.msinsidencia.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.upeu.msinsidencia.Dto.EstudianteDto;
//@FeignClient(name = "ms-estudiante-service-estudiantes", path = "/estudiantes")


@FeignClient(name = "ms-estudiante-service", path = "/estudiantes")
public interface EstudianteFeign {
    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDto> buscarEstudiante(@PathVariable Long id);
}
