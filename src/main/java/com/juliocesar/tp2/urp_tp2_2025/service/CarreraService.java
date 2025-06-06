package com.juliocesar.tp2.urp_tp2_2025.service;

import com.juliocesar.tp2.urp_tp2_2025.dto.request.CarreraRequest;
import com.juliocesar.tp2.urp_tp2_2025.dto.response.CarreraResponse;

import java.util.List;

public interface CarreraService {
    CarreraRequest save(CarreraRequest theCarreraRequest);
    CarreraRequest update(int id_carrera, CarreraRequest theCarreraRequest);
    List<CarreraResponse> findAll();
    CarreraResponse findById(int id_carrera);
    void deleteById(int id_carrera);
}
