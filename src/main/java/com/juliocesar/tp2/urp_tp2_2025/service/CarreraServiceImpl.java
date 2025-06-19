package com.juliocesar.tp2.urp_tp2_2025.service;

import com.juliocesar.tp2.urp_tp2_2025.dto.request.CarreraRequest;
import com.juliocesar.tp2.urp_tp2_2025.dto.response.CarreraResponse;
import com.juliocesar.tp2.urp_tp2_2025.entity.Carrera;
import com.juliocesar.tp2.urp_tp2_2025.entity.NivelCarrera;
import com.juliocesar.tp2.urp_tp2_2025.mapper.CarreraMapper;
import com.juliocesar.tp2.urp_tp2_2025.repository.CarreraRepository;
import com.juliocesar.tp2.urp_tp2_2025.repository.NivelCarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CarreraServiceImpl implements CarreraService {
    private final CarreraRepository carreraRepository;
    private final NivelCarreraRepository nivelCarreraRepository;
    private final CarreraMapper carreraDTOMapper;

    @Autowired
    public CarreraServiceImpl(CarreraRepository theCarreraRepository,
                              CarreraMapper theCarreraDTOMapper,
                              NivelCarreraRepository theNivelCarreraRepository){
        carreraRepository = theCarreraRepository;
        carreraDTOMapper = theCarreraDTOMapper;
        nivelCarreraRepository = theNivelCarreraRepository;
    }

    @Transactional
    @Override
    public CarreraRequest save(CarreraRequest theCarreraRequest) {
        int idNivelCarrera = theCarreraRequest.getIdNivelCarrera();
        Optional<NivelCarrera> nivelCarreraResult = nivelCarreraRepository.findById(idNivelCarrera);
        NivelCarrera nivelCarrera;
        if (nivelCarreraResult.isPresent()){
            nivelCarrera = nivelCarreraResult.get();
        }
        else{
            throw new RuntimeException("No se puede crear la carrera: " + theCarreraRequest.getNombre() + " porque el Nivel de carrera: " + idNivelCarrera + " no existe");
        }
        Carrera carrera = carreraDTOMapper.toCarrera(theCarreraRequest);
        return carreraDTOMapper.toCarreraRequest(carreraRepository.save(carrera));
    }


    @Transactional
    @Override
    public CarreraRequest update(int id_carrera, CarreraRequest theCarreraRequest) {
        Optional<Carrera> result = carreraRepository.findById(id_carrera);
        int idNivelCarrera = theCarreraRequest.getIdNivelCarrera();
        Optional<NivelCarrera> nivelResult = nivelCarreraRepository.findById(idNivelCarrera);
        Carrera carrera;
        NivelCarrera nivelCarrera;
        if (result.isPresent()){
            carrera = result.get();
        }
        else{
            throw new RuntimeException("No se encontro la carrera con id: " + id_carrera);
        }
        if (nivelResult.isPresent()){
            nivelCarrera = nivelResult.get();
        }
        else{
            throw new RuntimeException("No se puede modificar la carrera: " + theCarreraRequest.getNombre() + " porque el Nivel de carrera: " + idNivelCarrera + " no existe");
        }
        carreraDTOMapper.updateCarreraFromRequest(theCarreraRequest,carrera);
        return  carreraDTOMapper.toCarreraRequest(carreraRepository.save(carrera));
    }

    @Override
    public List<CarreraResponse> findAll() {
        return carreraDTOMapper.toCarreraResponseList(carreraRepository.findAll());
    }

    @Override
    public CarreraResponse findById(int id_carrera) {
        Optional<Carrera> result = carreraRepository.findById(id_carrera);
        Carrera carrera;
        if (result.isPresent()){
            carrera = result.get();
        }
        else{
            throw new RuntimeException("No se encontro la carrera con id: " + id_carrera);
        }
        return carreraDTOMapper.toCarreraResponse(carrera);
    }

    @Override
    public void deleteById(int id_carrera) {
        /* refactorizar codigo
        Optional<Carrera> result = carreraRepository.findById(id_carrera);
        Carrera carrera = null;
        if (result.isPresent()){
            carrera = result.get();
        }
        else{
            throw new RuntimeException("No se encontro la carrera: " + id_carrera);
        }
        carreraRepository.deleteById(id_carrera);
         */
        carreraRepository.findById(id_carrera).orElseThrow(() -> new RuntimeException("No se encontro la carrera: " + id_carrera));
        carreraRepository.deleteById(id_carrera);
    }
}
