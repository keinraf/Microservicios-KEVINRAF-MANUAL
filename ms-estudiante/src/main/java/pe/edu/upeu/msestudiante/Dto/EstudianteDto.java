package pe.edu.upeu.msestudiante.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;  // Importa la anotación para formatear fechas con Jackson
import lombok.Data;  // Importa la anotación para generar automáticamente los getters, setters y otros métodos comunes

import java.time.LocalDate;  // Importa la clase LocalDate para manejar fechas

@Data  // Anotación de Lombok para generar automáticamente getters, setters, toString(), hashCode(), equals()
public class EstudianteDto {

    private String nombre;  // Nombre del estudiante

    private String apellidoPaterno;  // Apellido paterno del estudiante

    private String apellidoMaterno;  // Apellido materno del estudiante

    private String celular;  // Número de celular del estudiante

    private String correo;  // Correo electrónico del estudiante

    @JsonFormat(pattern = "yyyy-MM-dd")  // Define el formato de la fecha para la deserialización de JSON
    private LocalDate fechaNacimiento;  // Fecha de nacimiento del estudiante

    private Long apoderadoId;  // ID del apoderado (relación Many to One)

    // private LocalDate fechaRegistro; // No es necesario recibirlo, se genera en el backend
}
