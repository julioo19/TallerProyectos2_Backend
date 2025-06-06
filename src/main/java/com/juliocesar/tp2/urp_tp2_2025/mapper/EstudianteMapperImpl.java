package com.juliocesar.tp2.urp_tp2_2025.mapper;

import com.juliocesar.tp2.urp_tp2_2025.dto.request.EstudianteRequest;
import com.juliocesar.tp2.urp_tp2_2025.dto.response.EstudianteResponse;
import com.juliocesar.tp2.urp_tp2_2025.entity.Estudiante;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EstudianteMapperImpl implements EstudianteMapper{


    @Override
    public Estudiante toEstudiante(EstudianteRequest estudianteRequest) {
        if (estudianteRequest == null){
            return null;
        }
        Estudiante estudiante = new Estudiante();
        estudiante.setCodigoEstudiante(estudianteRequest.getId_estudiante());
        estudiante.setNombre(estudianteRequest.getNombre());
        estudiante.setApellido(estudianteRequest.getApellido());
        estudiante.setFechaNacimiento(estudianteRequest.getFechaNacimiento());
        estudiante.setEmail(estudianteRequest.getEmail());
        estudiante.setNumeroTelefono(estudianteRequest.getNumeroTelefono());
        return estudiante;
    }

    @Override
    public EstudianteRequest toEstudianteRequest(Estudiante estudiante) {
        if(estudiante == null){
            return null;
        }
        EstudianteRequest estudianteRequest = new EstudianteRequest();
        estudianteRequest.setId_estudiante(estudiante.getCodigoEstudiante());
        estudianteRequest.setNombre(estudiante.getNombre());
        estudianteRequest.setApellido(estudiante.getApellido());
        estudianteRequest.setFechaNacimiento(estudiante.getFechaNacimiento());
        estudianteRequest.setEmail(estudiante.getEmail());
        estudianteRequest.setNumeroTelefono(estudiante.getNumeroTelefono());
        return estudianteRequest;
    }

    @Override
    public EstudianteResponse toEstudianteResponse(Estudiante estudiante) {
        if (estudiante == null){
            return null;
        }
        String nombreCompleto = estudiante.getNombre() + " " + estudiante.getApellido();
        return new EstudianteResponse(
                estudiante.getCodigoEstudiante(),
                nombreCompleto,
                estudiante.getEmail()
        );
    }

    @Override
    public List<EstudianteResponse> toEstudianteResponseList(List<Estudiante> estudiantes) {
        if (estudiantes == null){
            return null;
        }
        List<EstudianteResponse> listaEstudiantes = new ArrayList<>(estudiantes.size());
        for(Estudiante estudiante : estudiantes){
            listaEstudiantes.add(toEstudianteResponse(estudiante));
        }
        return listaEstudiantes;
    }

    @Override
    public void updateEstudianteFromRequest(EstudianteRequest estudianteRequest, Estudiante estudiante) {
        if (estudianteRequest == null || estudiante == null){
            return;
        }
        estudiante.setNombre(estudianteRequest.getNombre());
        estudiante.setApellido(estudianteRequest.getApellido());
        estudiante.setNumeroTelefono(estudianteRequest.getNumeroTelefono());
    }
}
