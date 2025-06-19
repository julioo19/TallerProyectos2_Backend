package com.juliocesar.tp2.urp_tp2_2025.mapper;

import com.juliocesar.tp2.urp_tp2_2025.dto.request.ProfesorRequest;
import com.juliocesar.tp2.urp_tp2_2025.dto.response.ProfesorResponse;
import com.juliocesar.tp2.urp_tp2_2025.entity.Profesor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProfesorMapperImpl implements ProfesorMapper{
    @Override
    public Profesor toProfesor(ProfesorRequest theProfesorRequest) {
        if (theProfesorRequest == null){
            return null;
        }
        Profesor profesor = new Profesor();
        profesor.setNombre(theProfesorRequest.getNombre());
        profesor.setApellido(theProfesorRequest.getApellido());
        profesor.setEmail(theProfesorRequest.getEmail());
        profesor.setTelefono(theProfesorRequest.getNumeroTelefono());
        return profesor;
    }

    @Override
    public ProfesorRequest toProfesorRequest(Profesor profesor) {
        if (profesor == null){
            return null;
        }
        ProfesorRequest profesorRequest = new ProfesorRequest();
        profesorRequest.setNombre(profesor.getNombre());
        profesorRequest.setApellido(profesor.getApellido());
        profesorRequest.setEmail(profesor.getEmail());
        profesorRequest.setNumeroTelefono(profesor.getTelefono());
        return profesorRequest;
    }

    @Override
    public ProfesorResponse toProfesorResponse(Profesor profesor) {
        if (profesor == null){
            return null;
        }
        String nombreCompleto = profesor.getNombre() + profesor.getApellido();
        ProfesorResponse profesorResponse = new ProfesorResponse();
        profesorResponse.setNombreCompleto(nombreCompleto);
        profesorResponse.setEmail(profesor.getEmail());
        return profesorResponse;
    }

    @Override
    public List<ProfesorResponse> toProfesorResponseList(List<Profesor> profesores) {
        if (profesores == null){
            return null;
        }
        List<ProfesorResponse> profesorResponseList = new ArrayList<>(profesores.size());
        for (Profesor profesor : profesores){
            profesorResponseList.add(toProfesorResponse(profesor));
        }
        return profesorResponseList;
    }

    @Override
    public void updateProfesorFromRequest(ProfesorRequest theProfesorRequest, Profesor theProfesor) {
        if (theProfesorRequest == null || theProfesor == null){
            return;
        }
        theProfesor.setNombre(theProfesorRequest.getNombre());
        theProfesor.setApellido(theProfesorRequest.getApellido());
        theProfesor.setEmail(theProfesorRequest.getEmail());
        theProfesor.setTelefono(theProfesorRequest.getNumeroTelefono());
    }
}