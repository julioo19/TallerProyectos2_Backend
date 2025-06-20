package com.juliocesar.tp2.urp_tp2_2025.service;

import com.juliocesar.tp2.urp_tp2_2025.dto.request.ProfesorRequest;
import com.juliocesar.tp2.urp_tp2_2025.dto.response.ProfesorResponse;

import java.util.List;

public interface ProfesorService {
    List<ProfesorResponse> findAll();
    ProfesorRequest save(ProfesorRequest theProfesorRequest);
    ProfesorRequest update(int id_profesor, ProfesorRequest theProfesorRequest);
    ProfesorResponse findById(int id_profesor);
    void deleteById(int id_profesor);
}
