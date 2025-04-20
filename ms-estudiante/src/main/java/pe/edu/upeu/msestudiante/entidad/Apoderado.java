package pe.edu.upeu.msestudiante.entidad;  // Paquete donde se encuentra la clase

// Importación de las librerías necesarias
import jakarta.persistence.*;  // JPA (Java Persistence API) para la persistencia en la base de datos
import lombok.AllArgsConstructor;  // Lombok para generar un constructor con todos los parámetros
import lombok.Builder;  // Lombok para implementar el patrón de diseño Builder
import lombok.Data;  // Lombok para generar automáticamente getters, setters, toString(), equals(), hashCode()
import lombok.NoArgsConstructor;  // Lombok para generar un constructor sin parámetros
import org.hibernate.annotations.CreationTimestamp;  // Anotación para la fecha de creación automática con Hibernate

import java.time.LocalDate;  // Importación de LocalDate para representar fechas

// Clase Apoderado que se mapea a la tabla "apoderado" en la base de datos
@Builder  // Lombok genera un constructor con el patrón Builder, que permite crear instancias de la clase de forma más sencilla y legible
@NoArgsConstructor  // Lombok genera un constructor sin parámetros
@AllArgsConstructor  // Lombok genera un constructor con todos los parámetros
@Data  // Lombok genera automáticamente todos los getters, setters, toString(), equals() y hashCode() de la clase
@Entity  // Marca la clase como una entidad de JPA que será mapeada a una tabla en la base de datos
@Table(name = "apoderado")  // Define el nombre de la tabla en la base de datos para esta entidad
public class Apoderado {

    @Id  // Marca este campo como la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Indica que el valor de 'id' será generado automáticamente por la base de datos
    @Column(name = "id_apoderado")  // Mapea la columna 'id_apoderado' de la base de datos al campo 'id'
    private Long id;  // Campo que almacena el identificador único del apoderado

    @Column(name = "nombre", nullable = false, length = 50)  // Define la columna 'nombre', no puede ser nula y tiene una longitud máxima de 50 caracteres
    private String nombre;  // Nombre del apoderado

    @Column(name = "apellidoPaterno", nullable = false, length = 50)  // Define la columna 'apellidoPaterno', no puede ser nula y tiene una longitud máxima de 50 caracteres
    private String apellidoPaterno;  // Apellido paterno del apoderado

    @Column(name = "apellidoMaterno", nullable = false, length = 50)  // Define la columna 'apellidoMaterno', no puede ser nula y tiene una longitud máxima de 50 caracteres
    private String apellidoMaterno;  // Apellido materno del apoderado

    @Column(name = "celular", nullable = false, length = 9)  // Define la columna 'celular', no puede ser nula y tiene una longitud máxima de 9 caracteres
    private String celular;  // Número de celular del apoderado

    @Column(name = "correo", nullable = false, length = 50)  // Define la columna 'correo', no puede ser nula y tiene una longitud máxima de 50 caracteres
    private String correo;  // Correo electrónico del apoderado

    @Column(name = "direccion", nullable = false, length = 50)  // Define la columna 'direccion', no puede ser nula y tiene una longitud máxima de 50 caracteres
    private String direccion;  // Dirección del apoderado

    @CreationTimestamp  // Anotación de Hibernate que establece este campo con la fecha de creación cuando se inserta un nuevo registro
    @Column(name = "fechaRegistro", updatable = false)  // Define la columna 'fechaRegistro', y evita que se actualice después de la creación del registro
    private LocalDate fechaRegistro;  // Fecha en la que se registró el apoderado

}
