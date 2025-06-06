package com.juliocesar.tp2.urp_tp2_2025.service;

import com.juliocesar.tp2.urp_tp2_2025.dto.response.NivelCarreraResponse;
import com.juliocesar.tp2.urp_tp2_2025.entity.NivelCarrera;

import java.util.List;

public interface NivelCarreraService {
    List<NivelCarreraResponse> findAll();
    NivelCarreraResponse findById(int id_nivel);
}
