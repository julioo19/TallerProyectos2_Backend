package com.juliocesar.tp2.urp_tp2_2025.service;

import com.juliocesar.tp2.urp_tp2_2025.dto.request.CursoRequest;
import com.juliocesar.tp2.urp_tp2_2025.dto.response.CursoResponse;
import com.juliocesar.tp2.urp_tp2_2025.entity.Carrera;
import com.juliocesar.tp2.urp_tp2_2025.entity.Curso;
import com.juliocesar.tp2.urp_tp2_2025.mapper.CursoMapper;
import com.juliocesar.tp2.urp_tp2_2025.repository.CarreraRepository;
import com.juliocesar.tp2.urp_tp2_2025.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class CursoServiceImpl implements CursoService{

    private final CursoRepository cursoRepository;
    private final CursoMapper cursoMapper;
    private final CarreraRepository carreraRepository;

    @Autowired
    public CursoServiceImpl(CursoRepository theCursoRepository,
                            CursoMapper theCursoMapper, CarreraRepository theCarreraRepository){
        cursoRepository = theCursoRepository;
        cursoMapper = theCursoMapper;
        carreraRepository = theCarreraRepository;
    }
    @Override
    public CursoRequest save(CursoRequest cursoRequest) {
        int idCarrera = cursoRequest.getIdCarrera();
        Optional<Carrera> carreraResult = carreraRepository.findById(idCarrera);
        if (carreraResult.isPresent()){
            Curso curso = cursoMapper.toCurso(cursoRequest);
            return cursoMapper.toCursoRequest(curso);
        }
        else{
            throw new RuntimeException("No se pudo crear el curso: " + cursoRequest.getNombreCurso() + " porque la Carrera: " + idCarrera + " no existe");
        }
    }

    @Override
    public CursoRequest update(int id_carrera, CursoRequest cursoRequest) {
        return null;
    }

    @Override
    public List<CursoResponse> findAll() {
        return cursoMapper.toCursoResponseList(cursoRepository.findAll());
    }

    @Override
    public CursoResponse findById(int id_carrera) {
        Optional<Curso> result = cursoRepository.findById(id_carrera);
        Curso curso;
        if (result.isPresent()){
            curso = result.get();
        }
        else{
            throw new RuntimeException("No se encontro el curso con el ID: " + id_carrera);
        }
        return cursoMapper.toCursoResponse(curso);
    }

    @Override
    public void deleteById(int id_carrera) {

    }
}
