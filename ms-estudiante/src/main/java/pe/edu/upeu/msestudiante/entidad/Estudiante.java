package pe.edu.upeu.msestudiante.entidad;  // Paquete donde se encuentra la clase

// Importación de las librerías necesarias
import com.fasterxml.jackson.annotation.JsonFormat;  // Para manejar el formato de fecha en las respuestas JSON
import jakarta.persistence.*;  // JPA (Java Persistence API) para la persistencia en la base de datos
import lombok.AllArgsConstructor;  // Lombok para generar un constructor con todos los parámetros
import lombok.Builder;  // Lombok para implementar el patrón de diseño Builder
import lombok.Data;  // Lombok para generar automáticamente getters, setters, toString(), equals(), hashCode()
import lombok.NoArgsConstructor;  // Lombok para generar un constructor sin parámetros
import org.hibernate.annotations.CreationTimestamp;  // Anotación para la fecha de creación automática con Hibernate
import pe.edu.upeu.msestudiante.Dto.EstudianteDto;  // Importa el DTO de Estudiante, usado en el constructor

import java.time.LocalDate;  // Importación de LocalDate para representar fechas

// Clase Estudiante que se mapea a la tabla "estudiante" en la base de datos
@Entity  // Marca la clase como una entidad JPA, mapeada a una tabla en la base de datos
@Data  // Lombok genera automáticamente todos los getters, setters, toString(), equals() y hashCode() de la clase
@NoArgsConstructor  // Lombok genera un constructor sin parámetros
@AllArgsConstructor  // Lombok genera un constructor con todos los parámetros
@Builder  // Lombok genera un constructor con el patrón Builder, que permite crear instancias de la clase de forma más legible
@Table(name = "estudiante")  // Define el nombre de la tabla en la base de datos para esta clase
public class Estudiante {

    @Id  // Marca este campo como la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Indica que el valor de 'id' será generado automáticamente por la base de datos
    @Column(name = "id_estudiante")  // Mapea la columna 'id_estudiante' de la base de datos al campo 'id'
    private Long id;  // Campo que almacena el identificador único del estudiante

    @Column(name = "nombre", nullable = false, length = 50)  // Define la columna 'nombre', no puede ser nula y tiene una longitud máxima de 50 caracteres
    private String nombre;  // Nombre del estudiante

    @Column(name = "apellidoPaterno", nullable = false, length = 50)  // Define la columna 'apellidoPaterno', no puede ser nula y tiene una longitud máxima de 50 caracteres
    private String apellidoPaterno;  // Apellido paterno del estudiante

    @Column(name = "apellidoMaterno", nullable = false, length = 50)  // Define la columna 'apellidoMaterno', no puede ser nula y tiene una longitud máxima de 50 caracteres
    private String apellidoMaterno;  // Apellido materno del estudiante

    @Column(name = "celular", nullable = false, length = 9)  // Define la columna 'celular', no puede ser nula y tiene una longitud máxima de 9 caracteres
    private String celular;  // Número de celular del estudiante

    @Column(name = "correo", nullable = false, length = 50)  // Define la columna 'correo', no puede ser nula y tiene una longitud máxima de 50 caracteres
    private String correo;  // Correo electrónico del estudiante

    // Formato de fecha personalizado para la serialización/deserialización de JSON
    @JsonFormat(pattern = "dd-MM-yyyy")  // Formato de fecha para serialización en JSON
    @Temporal(TemporalType.DATE)  // Indica que solo se almacena la fecha, no la hora
    @Column(name = "fechaNacimineto", nullable = false, length = 50)  // Define la columna 'fechaNacimiento', no puede ser nula
    private LocalDate fechaNacimiento;  // Fecha de nacimiento del estudiante

    // Relación muchos a uno con la entidad Apoderado
    @ManyToOne  // Muchos estudiantes pueden tener un apoderado
    @JoinColumn(name = "id_apoderado", referencedColumnName = "id_apoderado",
            nullable = false, foreignKey = @ForeignKey(name = "FK_APODERADO_ESTUDIANTE"))  // Define la relación con la tabla 'apoderado'
    private Apoderado apoderado;  // El apoderado asociado al estudiante

    // Marca la fecha de registro para que sea asignada automáticamente cuando se cree el registro
    @CreationTimestamp  // La fecha de creación se asigna automáticamente al guardar el registro
    @Column(name = "fechaRegistro", updatable = false)  // Define la columna 'fechaRegistro', que no puede ser actualizada después de la creación
    @JsonFormat(pattern = "dd-MM-yyyy")  // Formato de fecha para serialización en JSON
    private LocalDate fechaRegistro;  // Fecha de registro del estudiante en el sistema

    // Constructor personalizado que recibe un DTO (Data Transfer Object) y un apoderado
    public Estudiante(EstudianteDto dto, Apoderado apoderado) {
        this.nombre = dto.getNombre();  // Asigna el nombre del DTO
        this.apellidoPaterno = dto.getApellidoPaterno();  // Asigna el apellido paterno del DTO
        this.apellidoMaterno = dto.getApellidoMaterno();  // Asigna el apellido materno del DTO
        this.celular = dto.getCelular();  // Asigna el celular del DTO
        this.correo = dto.getCorreo();  // Asigna el correo del DTO
        this.fechaNacimiento = dto.getFechaNacimiento();  // Asigna la fecha de nacimiento del DTO
        this.apoderado = apoderado;  // Asigna el apoderado asociado
        // La fecha de registro se maneja automáticamente con la anotación @CreationTimestamp
    }
}
