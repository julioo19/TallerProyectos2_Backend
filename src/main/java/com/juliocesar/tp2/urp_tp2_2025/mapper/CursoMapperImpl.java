package com.juliocesar.tp2.urp_tp2_2025.mapper;

import com.juliocesar.tp2.urp_tp2_2025.dto.request.CursoRequest;
import com.juliocesar.tp2.urp_tp2_2025.dto.response.CursoResponse;
import com.juliocesar.tp2.urp_tp2_2025.entity.Carrera;
import com.juliocesar.tp2.urp_tp2_2025.entity.Curso;
import com.juliocesar.tp2.urp_tp2_2025.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CursoMapperImpl implements CursoMapper{
    private final CarreraMapper carreraMapper;

    @Autowired
    public CursoMapperImpl(CarreraMapper theCarreraMapper){
        carreraMapper = theCarreraMapper;
    }
    @Override
    public Curso toCurso(CursoRequest cursoRequest) {
        if (cursoRequest == null){
            return null;
        }
        Curso curso = new Curso();
        Carrera carrera = new Carrera();
        curso.setNombreCurso(cursoRequest.getNombreCurso());
        carrera.setIdCarrera(cursoRequest.getIdCarrera());
        curso.setCarrera(carrera);
        curso.setCodigoCurso(cursoRequest.getCodigoCurso());
        curso.setSemestre(cursoRequest.getSemestre());
        curso.setCreditos(cursoRequest.getCreditos());
        curso.setElectivo(cursoRequest.isElectivo());
        return curso;
    }

    @Override
    public CursoRequest toCursoRequest(Curso curso) {
        if (curso == null){
            return null;
        }
        CursoRequest cursoRequest = new CursoRequest();
        cursoRequest.setNombreCurso(curso.getNombreCurso());
        cursoRequest.setIdCarrera(curso.getCarrera().getIdCarrera());
        cursoRequest.setCodigoCurso(curso.getCodigoCurso());
        cursoRequest.setSemestre(curso.getSemestre());
        cursoRequest.setElectivo(curso.isElectivo());
        return cursoRequest;
    }

    @Override
    public CursoResponse toCursoResponse(Curso curso) {
        if (curso == null){
            return null;
        }
        return new CursoResponse(
                curso.getNombreCurso(),
                carreraMapper.toCarreraResponse(curso.getCarrera()),
                curso.getCodigoCurso(),
                curso.getSemestre(),
                curso.getCreditos(),
                curso.isElectivo()
        );
    }

    @Override
    public List<CursoResponse> toCursoResponseList(List<Curso> cursos) {
        if (cursos == null){
            return null;
        }
        List<CursoResponse> listaCursos = new ArrayList<>(cursos.size());
        for (Curso curso : cursos){
            listaCursos.add(toCursoResponse(curso));
        }
        return listaCursos;
    }

    @Override
    public void updateCursoFromRequest(CursoRequest cursoRequest, Curso curso) {
        if (cursoRequest == null || curso == null){
            return;
        }
        curso.setNombreCurso(cursoRequest.getNombreCurso());
        Carrera carrera = new Carrera();
        carrera.setIdCarrera(cursoRequest.getIdCarrera());
        curso.setCarrera(carrera);
        curso.setCodigoCurso(cursoRequest.getCodigoCurso());
        curso.setSemestre(cursoRequest.getSemestre());
        curso.setCreditos(cursoRequest.getCreditos());
        curso.setElectivo(cursoRequest.isElectivo());
    }
}
