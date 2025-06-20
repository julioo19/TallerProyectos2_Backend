package com.juliocesar.tp2.urp_tp2_2025.service;

import com.juliocesar.tp2.urp_tp2_2025.dto.response.NivelCarreraResponse;
import com.juliocesar.tp2.urp_tp2_2025.entity.NivelCarrera;
import com.juliocesar.tp2.urp_tp2_2025.mapper.EstudianteMapperImpl;
import com.juliocesar.tp2.urp_tp2_2025.mapper.NivelCarreraMapperImpl;
import com.juliocesar.tp2.urp_tp2_2025.repository.EstudianteRepository;
import com.juliocesar.tp2.urp_tp2_2025.repository.NivelCarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NivelCarreraServiceImpl implements NivelCarreraService{
    private final NivelCarreraRepository nivelCarreraRepository;
    private final NivelCarreraMapperImpl nivelCarreraDTOMapper;

    @Autowired
    public NivelCarreraServiceImpl(
            NivelCarreraRepository theNivelCarreraRepository,
            NivelCarreraMapperImpl theNivelCarreraMapper){
        nivelCarreraRepository = theNivelCarreraRepository;
        nivelCarreraDTOMapper = theNivelCarreraMapper;
    }

    @Override
    public List<NivelCarreraResponse> findAll() {
        return nivelCarreraDTOMapper.toNivelCarreraResponseList(nivelCarreraRepository.findAll());
    }

    @Override
    public NivelCarreraResponse findById(int id_nivel) {
        Optional<NivelCarrera> result = nivelCarreraRepository.findById(id_nivel);
        NivelCarrera nivelCarrera;
        if (result.isPresent()){
            nivelCarrera = result.get();
        }
        else{
            throw new RuntimeException("No se encontro el nivel de carrera: " + id_nivel);
        }
        return nivelCarreraDTOMapper.toNivelCarreraResponse(nivelCarrera);
    }
}
