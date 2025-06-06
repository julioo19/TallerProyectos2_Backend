package com.juliocesar.tp2.urp_tp2_2025.mapper;

import com.juliocesar.tp2.urp_tp2_2025.dto.request.EstudianteRequest;
import com.juliocesar.tp2.urp_tp2_2025.dto.response.EstudianteResponse;
import com.juliocesar.tp2.urp_tp2_2025.entity.Estudiante;

import java.util.List;

public interface EstudianteMapper {
    Estudiante toEstudiante (EstudianteRequest estudianteRequest);
    EstudianteResponse toEstudianteResponse(Estudiante estudiante);
    EstudianteRequest toEstudianteRequest(Estudiante estudiante);
    List<EstudianteResponse> toEstudianteResponseList(List<Estudiante> estudiantes);
    void updateEstudianteFromRequest(EstudianteRequest estudianteRequest, Estudiante estudiante);
}
