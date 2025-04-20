package pe.edu.upeu.msinsidencia.Entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import pe.edu.upeu.msinsidencia.Dto.EstudianteDto;

import java.time.LocalDate;

// ==============================
// CLASE ENTIDAD PARA INSIDENCIA
// ==============================

// Marca esta clase como una entidad JPA que se mapeará a una tabla en la base de datos
@Entity

// Lombok: genera automáticamente getters, setters, toString, equals y hashCode
@Data

// Lombok: constructor vacío requerido por JPA
@NoArgsConstructor

// Lombok: constructor con todos los argumentos (útil para test y construcción rápida)
@AllArgsConstructor

// Lombok: patrón de diseño Builder para construir objetos fácilmente
@Builder

// Define el nombre de la tabla en la base de datos
@Table(name = "insidencia")
public class Insidencia {

    // =====================
    // ID DE LA INCIDENCIA
    // =====================

    // Marca el campo como clave primaria
    @Id

    // Estrategia de generación automática del ID (auto-incremental en MySQL)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Mapea este campo con la columna 'id_insidencia'
    @Column(name = "id_insidencia")
    private Long id;

    // =====================
    // DESCRIPCIÓN
    // =====================

    // Campo obligatorio (no null) y con longitud máxima de 50 caracteres
    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;

    // =====================
    // FECHA DE REGISTRO
    // =====================

    // Genera automáticamente la fecha cuando se crea el registro
    @CreationTimestamp

    // No se puede actualizar este campo una vez registrado
    @Column(name = "fechaRegistro", updatable = false)

    // Define el formato en el que se serializa/deserializa la fecha en JSON
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaRegistro;

    // =====================
    // ID DEL ESTUDIANTE
    // =====================

    // Campo que almacena el ID del estudiante relacionado (sin relación directa con otra entidad)
    private Long estudianteId;

    // =====================
    // DATO DEL ESTUDIANTE (SOLO PARA RESPUESTA)
    // =====================

    // Campo que no será persistido en la base de datos (solo se usa para la respuesta JSON)
    @Transient
    private EstudianteDto estudianteDto;
}
