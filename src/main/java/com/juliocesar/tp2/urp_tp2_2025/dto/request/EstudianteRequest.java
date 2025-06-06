package com.juliocesar.tp2.urp_tp2_2025.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteRequest {
    @NotBlank(message = "El codigo de estudiante es obligatorio")
    String id_estudiante;
    @NotBlank(message = "Debe colocar su nombre")
    String nombre;
    @NotBlank(message = "Debe colocar su apellido")
    String apellido;
    @NotNull(message = "Debe colocar su fecha de nacimiento")
    LocalDate fechaNacimiento;
    @NotBlank(message="Debe colocar su correo institucional")
    String email;
    @NotBlank(message = "Debe colocar su numero telefonico")
    String numeroTelefono;
}
