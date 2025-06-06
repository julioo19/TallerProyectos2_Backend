package com.juliocesar.tp2.urp_tp2_2025.mapper;

import com.juliocesar.tp2.urp_tp2_2025.dto.response.NivelCarreraResponse;
import com.juliocesar.tp2.urp_tp2_2025.entity.NivelCarrera;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NivelCarreraMapperImpl implements NivelCarreraMapper{
    @Override
    public NivelCarreraResponse toNivelCarreraResponse(NivelCarrera nivelCarrera) {
        if (nivelCarrera == null){
            return null;
        }
        return new NivelCarreraResponse(
                nivelCarrera.getNombreNivelCarrera()
        );
    }

    @Override
    public List<NivelCarreraResponse> toNivelCarreraResponseList(List<NivelCarrera> nivelesCarrera) {
        if (nivelesCarrera == null){
            return null;
        }
        List<NivelCarreraResponse> listaNiveles = new ArrayList<>(nivelesCarrera.size());
        for(NivelCarrera nivelCarrera : nivelesCarrera){
            listaNiveles.add(toNivelCarreraResponse(nivelCarrera));
        }
        return listaNiveles;
    }
}
