package pe.edu.upeu.msestudiante.entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "apoderado")
public class Apoderado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apoderado")
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

    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;

    @CreationTimestamp
    @Column(name = "fechaRegistro", updatable = false)
    private LocalDate fechaRegistro;
}
