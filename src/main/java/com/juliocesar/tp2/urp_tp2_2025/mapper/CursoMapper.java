package com.juliocesar.tp2.urp_tp2_2025.mapper;

import com.juliocesar.tp2.urp_tp2_2025.dto.request.CursoRequest;
import com.juliocesar.tp2.urp_tp2_2025.dto.response.CursoResponse;
import com.juliocesar.tp2.urp_tp2_2025.entity.Curso;

import java.util.List;

public interface CursoMapper {
    Curso toCurso(CursoRequest cursoRequest);
    CursoRequest toCursoRequest(Curso curso);
    CursoResponse toCursoResponse(Curso curso);
    List<CursoResponse> toCursoResponseList(List<Curso> cursos);
    void updateCursoFromRequest(CursoRequest cursoRequest, Curso curso);
}
