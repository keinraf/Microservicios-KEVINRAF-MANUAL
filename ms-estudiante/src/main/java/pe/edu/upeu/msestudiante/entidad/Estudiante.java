package pe.edu.upeu.msestudiante.entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import pe.edu.upeu.msestudiante.Dto.EstudianteDto;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor // Si necesitas constructor sin argumentos
@AllArgsConstructor // Si quieres un constructor con todos los argumentos
@Builder
@Table(name = "estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellidoPaterno", nullable = false, length = 50)
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno", nullable = false, length = 50)
    private String apellidoMaterno;

    @Column(name = "celular", nullable = false, length = 9)
    private String celular;

    @Column(name = "correo", nullable = false, length = 50)
    private String correo;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaNacimineto", nullable = false, length = 50)
    private LocalDate fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "id_apoderado", referencedColumnName = "id_apoderado",
            nullable = false, foreignKey = @ForeignKey(name = "FK_APODERADO_ESTUDIANTE"))
    private Apoderado apoderado;

    @CreationTimestamp
    @Column(name = "fechaRegistro", updatable = false)
    @JsonFormat(pattern = "dd-MM-yyyy") // Ejemplo de formato
    private LocalDate fechaRegistro;

    // ¡AÑADE ESTE CONSTRUCTOR!
    public Estudiante(EstudianteDto dto, Apoderado apoderado) {
        this.nombre = dto.getNombre();
        this.apellidoPaterno = dto.getApellidoPaterno();
        this.apellidoMaterno = dto.getApellidoMaterno();
        this.celular = dto.getCelular();
        this.correo = dto.getCorreo();
        this.fechaNacimiento = dto.getFechaNacimiento();
        this.apoderado = apoderado;
        // La fecha de registro se maneja con @CreationTimestamp
    }


}
