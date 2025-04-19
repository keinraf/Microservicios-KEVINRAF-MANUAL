package pe.edu.upeu.msestudiante.entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Data
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
    private LocalDate fechaRegistro;
}
