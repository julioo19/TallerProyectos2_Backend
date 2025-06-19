package com.juliocesar.tp2.urp_tp2_2025.service;

import com.juliocesar.tp2.urp_tp2_2025.dto.request.CursoRequest;
import com.juliocesar.tp2.urp_tp2_2025.dto.response.CursoResponse;

import java.util.List;


public interface CursoService {
    CursoRequest save(CursoRequest cursoRequest);
    CursoRequest update(int id_carrera, CursoRequest cursoRequest);
    List<CursoResponse> findAll();
    CursoResponse findById(int id_carrera);
    void deleteById(int id_carrera);
}
