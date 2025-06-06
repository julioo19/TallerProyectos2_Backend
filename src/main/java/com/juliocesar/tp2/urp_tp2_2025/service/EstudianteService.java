package com.juliocesar.tp2.urp_tp2_2025.service;

import com.juliocesar.tp2.urp_tp2_2025.dto.request.EstudianteRequest;
import com.juliocesar.tp2.urp_tp2_2025.dto.response.EstudianteResponse;

import java.util.List;

public interface EstudianteService {
    List<EstudianteResponse> findAll();
    EstudianteRequest save(EstudianteRequest theEstudianterRequest);
    EstudianteResponse findById(String codigo);
    EstudianteRequest update(String codigo, EstudianteRequest estudianteRequest);
    void deleteById(String codigo);
}
