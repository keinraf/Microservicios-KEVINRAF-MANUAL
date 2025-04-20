package pe.edu.upeu.msestudiante.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;  // Importa la anotación para formatear fechas con Jackson
import lombok.Data;  // Importa la anotación para generar automáticamente los getters, setters y otros métodos comunes

import java.time.LocalDate;  // Importa la clase LocalDate para manejar fechas

@Data  // Anotación de Lombok para generar automáticamente getters, setters, toString(), hashCode(), equals()
//El código que compartiste es una clase DTO llamada EstudianteUpdateDto,
// diseñada para actualizar los datos de un estudiante.
// Este DTO es similar al anterior, pero está orientado a
// la actualización de un estudiante existente, permitiendo
// que solo los campos que se proporcionan se actualicen en la base de datos.
public class EstudianteUpdateDto {

    private String nombre;  // Nombre del estudiante (opcional en la actualización)

    private String apellidoPaterno;  // Apellido paterno del estudiante (opcional en la actualización)

    private String apellidoMaterno;  // Apellido materno del estudiante (opcional en la actualización)

    private String celular;  // Número de celular del estudiante (opcional en la actualización)

    private String correo;  // Correo electrónico del estudiante (opcional en la actualización)

    @JsonFormat(pattern = "yyyy-MM-dd")  // Define el formato de la fecha para la deserialización de JSON
    private LocalDate fechaNacimiento;  // Fecha de nacimiento del estudiante (opcional en la actualización)

    private Long apoderadoId;  // ID del apoderado (opcional, se usa si se desea actualizar la relación con el apoderado)

    // Otros campos que se puedan actualizar pueden agregarse en el futuro
    // EstudianteUpdateDto está específicamente orientado a la actualización
    // de un estudiante, mientras que EstudianteDto es para la creación de un
    // nuevo estudiante.
    //
    //El DTO de actualización permite que los campos opcionales sean
    // enviados para cambiar solo lo que se desea actualizar. Esto es
    // útil cuando no se necesita cambiar todos los datos de un estudiante,
    // sino solo una parte de ellos.
}
