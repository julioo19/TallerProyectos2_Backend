package com.juliocesar.tp2.urp_tp2_2025.mapper;

import com.juliocesar.tp2.urp_tp2_2025.dto.request.ProfesorRequest;
import com.juliocesar.tp2.urp_tp2_2025.dto.response.ProfesorResponse;
import com.juliocesar.tp2.urp_tp2_2025.entity.Profesor;

import java.util.List;

public interface ProfesorMapper {
    //Convertir un Request a Entity
    Profesor toProfesor(ProfesorRequest theProfesorRequest);
    //Convertir un Entity a Request
    ProfesorRequest toProfesorRequest(Profesor profesor);
    //Convertir un Entity a Response
    ProfesorResponse toProfesorResponse(Profesor profesor);
    //COnvertir una lista de Profesores entity a lista de Profesore response
    List<ProfesorResponse> toProfesorResponseList(List<Profesor> profesores);
    void updateProfesorFromRequest(ProfesorRequest theProfesorRequest, Profesor theProfesor);
}
