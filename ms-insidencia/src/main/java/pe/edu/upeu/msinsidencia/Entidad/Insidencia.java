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

@Entity
@Data
@NoArgsConstructor // Si necesitas constructor sin argumentos
@AllArgsConstructor // Si quieres un constructor con todos los argumentos
@Builder
@Table(name = "insidencia")
public class Insidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_insidencia")
    private Long id;

    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;

    @CreationTimestamp
    @Column(name = "fechaRegistro", updatable = false)
    @JsonFormat(pattern = "dd-MM-yyyy") // Ejemplo de formato
    private LocalDate fechaRegistro;

    private Long estudianteId;
    @Transient
    private EstudianteDto estudianteDto;
}
