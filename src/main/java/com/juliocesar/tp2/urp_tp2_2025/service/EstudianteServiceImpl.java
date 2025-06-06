package com.juliocesar.tp2.urp_tp2_2025.service;

import com.juliocesar.tp2.urp_tp2_2025.dto.request.EstudianteRequest;
import com.juliocesar.tp2.urp_tp2_2025.dto.response.EstudianteResponse;
import com.juliocesar.tp2.urp_tp2_2025.mapper.EstudianteMapperImpl;
import com.juliocesar.tp2.urp_tp2_2025.repository.EstudianteRepository;
import com.juliocesar.tp2.urp_tp2_2025.entity.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class EstudianteServiceImpl implements EstudianteService{

    private EstudianteRepository estudianteRepository;
    private EstudianteMapperImpl estudianteDTOMapper;

    @Autowired
    public EstudianteServiceImpl(EstudianteRepository theEstudianteRepository, EstudianteMapperImpl theEstudianteMapper){
        estudianteRepository = theEstudianteRepository;
        estudianteDTOMapper = theEstudianteMapper;
    }

    @Override
    public List<EstudianteResponse> findAll() {
        return estudianteDTOMapper.toEstudianteResponseList(estudianteRepository.findAll());
    }

    @Transactional
    @Override
    public EstudianteRequest save(EstudianteRequest theEstudianterRequest) {
        Estudiante estudiante = estudianteDTOMapper.toEstudiante(theEstudianterRequest);
        return estudianteDTOMapper.toEstudianteRequest(estudianteRepository.save(estudiante));
    }

    @Override
    public EstudianteResponse findById(String codigo) {
        Optional<Estudiante> result = estudianteRepository.findById(codigo);
        Estudiante estudiante = null;
        if (result.isPresent()){
            estudiante = result.get();
        }
        else{
            throw new RuntimeException("No se encontro el estudiante " + codigo);
        }
        return estudianteDTOMapper.toEstudianteResponse(estudiante);
    }

    @Transactional
    @Override
    public EstudianteRequest update(String codigo, EstudianteRequest estudianteRequest) {
        //Estudiante estudiante = estudianteRepository.findById(codigo).get();
        Optional<Estudiante> result = estudianteRepository.findById(codigo);
        Estudiante estudiante = null;
        if (result.isPresent()){
            estudiante = result.get();
        }
        else{
            throw new RuntimeException("No se encontro el estudiante: " + codigo);
        }
        estudianteDTOMapper.updateEstudianteFromRequest(estudianteRequest, estudiante);
        return estudianteDTOMapper.toEstudianteRequest(estudianteRepository.save(estudiante));
    }

    @Transactional
    @Override
    public void deleteById(String codigo) {
        Optional<Estudiante> result = estudianteRepository.findById(codigo);
        Estudiante estudiante;
        if (result.isPresent()){
            estudiante = result.get();
        }
        else{
            throw new RuntimeException("No se encontro el estudiante: " + codigo);
        }
        estudianteRepository.deleteById(codigo);
    }
}
