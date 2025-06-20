package com.juliocesar.tp2.urp_tp2_2025.mapper;

import com.juliocesar.tp2.urp_tp2_2025.dto.request.CarreraRequest;
import com.juliocesar.tp2.urp_tp2_2025.dto.response.CarreraResponse;
import com.juliocesar.tp2.urp_tp2_2025.entity.Carrera;
import com.juliocesar.tp2.urp_tp2_2025.entity.NivelCarrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarreraMapperImpl implements CarreraMapper{
    private final NivelCarreraMapper nivelCarreraMapper;

    @Autowired
    public CarreraMapperImpl(NivelCarreraMapper theNivelCarreraMapper){
        nivelCarreraMapper = theNivelCarreraMapper;
    }

    @Override
    public Carrera toCarrera(CarreraRequest carreraRequest) {
        if (carreraRequest == null){
            return null;
        }
        Carrera carrera = new Carrera();
        NivelCarrera nivelCarrera = new NivelCarrera();
        carrera.setNombreCarrera(carreraRequest.getNombre());
        carrera.setDuracionAnhos(carreraRequest.getDuracionAnhos());
        carrera.setCursosElectivosRequeridos(carreraRequest.getCursosElectivosRequeridos());
        nivelCarrera.setIdEstadoCarrera(carreraRequest.getIdNivelCarrera());
        carrera.setNivelCarrera(nivelCarrera);
        return carrera;
    }

    @Override
    public CarreraRequest toCarreraRequest(Carrera carrera) {
        if (carrera == null){
            return null;
        }
        CarreraRequest carreraRequest = new CarreraRequest();
        carreraRequest.setNombre(carrera.getNombreCarrera());
        carreraRequest.setDuracionAnhos(carrera.getDuracionAnhos());
        carreraRequest.setCursosElectivosRequeridos(carrera.getCursosElectivosRequeridos());
        carreraRequest.setIdNivelCarrera(carrera.getNivelCarrera().getIdEstadoCarrera());
        return carreraRequest;
    }

    @Override
    public CarreraResponse toCarreraResponse(Carrera carrera) {
        if (carrera == null){
            return null;
        }
        return new CarreraResponse(
                carrera.getNombreCarrera(),
                carrera.getDuracionAnhos(),
                nivelCarreraMapper.toNivelCarreraResponse(carrera.getNivelCarrera())
        );
    }

    @Override
    public List<CarreraResponse> toCarreraResponseList(List<Carrera> carreras) {
        if (carreras == null){
            return null;
        }
        List<CarreraResponse> listaCarreras = new ArrayList<>(carreras.size());
        for(Carrera carrera : carreras){
            listaCarreras.add(toCarreraResponse(carrera));
        }
        return listaCarreras;
    }

    @Override
    public void updateCarreraFromRequest(CarreraRequest carreraRequest, Carrera carrera) {
        if (carreraRequest == null || carrera == null){
            return;
        }
        carrera.setNombreCarrera(carreraRequest.getNombre());
        carrera.setDuracionAnhos(carreraRequest.getDuracionAnhos());
        carrera.setCursosElectivosRequeridos(carreraRequest.getCursosElectivosRequeridos());
        NivelCarrera nivelCarrera = new NivelCarrera();
        nivelCarrera.setIdEstadoCarrera(carreraRequest.getIdNivelCarrera());
        carrera.setNivelCarrera(nivelCarrera);
    }
}
