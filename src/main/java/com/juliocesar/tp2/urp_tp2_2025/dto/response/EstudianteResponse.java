package com.juliocesar.tp2.urp_tp2_2025.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EstudianteResponse {
    String idEstudiante;
    String nombreCompleto;
    String email;
}
