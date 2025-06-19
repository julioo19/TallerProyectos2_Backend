package com.juliocesar.tp2.urp_tp2_2025.service;

import com.juliocesar.tp2.urp_tp2_2025.dto.request.ProfesorRequest;
import com.juliocesar.tp2.urp_tp2_2025.dto.response.ProfesorResponse;
import com.juliocesar.tp2.urp_tp2_2025.entity.Profesor;
import com.juliocesar.tp2.urp_tp2_2025.mapper.ProfesorMapper;
import com.juliocesar.tp2.urp_tp2_2025.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService{
    ProfesorRepository profesorRepository;
    ProfesorMapper profesorMapper;

    @Autowired
    public ProfesorServiceImpl(ProfesorRepository theProfesorRepository, ProfesorMapper theProfesorMapper){
        profesorRepository = theProfesorRepository;
        profesorMapper = theProfesorMapper;
    }
    @Override
    public List<ProfesorResponse> findAll() {
        return profesorMapper.toProfesorResponseList(profesorRepository.findAll());
    }

    @Override
    public ProfesorRequest save(ProfesorRequest theProfesorRequest) {
        Profesor profesor = profesorMapper.toProfesor(theProfesorRequest);
        return profesorMapper.toProfesorRequest(profesorRepository.save(profesor));
    }

    @Override
    public ProfesorRequest update(int id_profesor, ProfesorRequest theProfesorRequest) {
        Optional<Profesor> result = profesorRepository.findById(id_profesor);
        Profesor profesor = null;
        if (result.isPresent()){
            profesor = result.get();
        }
        else{
            throw new RuntimeException("No se encontro el profesor con el id: " + id_profesor);
        }
        profesorMapper.updateProfesorFromRequest(theProfesorRequest, profesor);
        return profesorMapper.toProfesorRequest(profesorRepository.save(profesor));
    }

    @Override
    public ProfesorResponse findById(int id_profesor) {
        Optional<Profesor> result = profesorRepository.findById(id_profesor);
        Profesor profesor = null;
        if (result.isPresent()){
            profesor = result.get();
        }
        else {
            throw new RuntimeException("No se encontro el profesor con el id: " + id_profesor);
        }
        return profesorMapper.toProfesorResponse(profesor);
    }

    @Override
    public void deleteById(int id_profesor) {
        Optional<Profesor> result = profesorRepository.findById(id_profesor);
        Profesor profesor = null;
        if (result.isPresent()){
            profesor = result.get();
        }
        else {
            throw new RuntimeException("No se encontro el profesor con el id: " + id_profesor);
        }
        profesorRepository.deleteById(id_profesor);
    }
}
