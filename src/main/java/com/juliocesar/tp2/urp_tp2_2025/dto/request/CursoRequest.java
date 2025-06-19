package com.juliocesar.tp2.urp_tp2_2025.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CursoRequest {
    String nombreCurso;
    int idCarrera;
    String codigoCurso;
    int semestre;
    double creditos;
    boolean electivo;

}
