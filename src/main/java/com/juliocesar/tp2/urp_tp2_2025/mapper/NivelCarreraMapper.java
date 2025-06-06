package com.juliocesar.tp2.urp_tp2_2025.mapper;

import com.juliocesar.tp2.urp_tp2_2025.dto.response.NivelCarreraResponse;
import com.juliocesar.tp2.urp_tp2_2025.entity.NivelCarrera;

import java.util.List;

public interface NivelCarreraMapper {
    NivelCarreraResponse toNivelCarreraResponse(NivelCarrera nivelCarrera);
    List<NivelCarreraResponse> toNivelCarreraResponseList(List<NivelCarrera> nivelesCarrera);
}
