package pe.edu.upeu.msestudiante.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


import java.time.LocalDate;


@Data
public class EstudianteDto {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String celular;
    private String correo;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;
    private Long apoderadoId;
    // private LocalDate fechaRegistro; // No es necesario recibirlo, se genera en el backend

}
