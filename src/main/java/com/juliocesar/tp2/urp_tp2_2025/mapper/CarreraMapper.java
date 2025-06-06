package com.juliocesar.tp2.urp_tp2_2025.mapper;

import com.juliocesar.tp2.urp_tp2_2025.dto.request.CarreraRequest;
import com.juliocesar.tp2.urp_tp2_2025.dto.response.CarreraResponse;
import com.juliocesar.tp2.urp_tp2_2025.entity.Carrera;

import java.util.List;

public interface CarreraMapper {
    Carrera toCarrera(CarreraRequest carreraRequest);
    CarreraRequest toCarreraRequest(Carrera carrera);
    CarreraResponse toCarreraResponse(Carrera carrera);
    List<CarreraResponse> toCarreraResponseList(List<Carrera> carreras);
    void updateCarreraFromRequest(CarreraRequest carreraRequest, Carrera carrera);
}
