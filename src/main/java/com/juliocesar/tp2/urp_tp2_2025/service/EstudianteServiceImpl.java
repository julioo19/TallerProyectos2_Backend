package com.juliocesar.tp2.urp_tp2_2025.service;

import com.juliocesar.tp2.urp_tp2_2025.dto.request.EstudianteRequest;
import com.juliocesar.tp2.urp_tp2_2025.dto.response.EstudianteResponse;
import com.juliocesar.tp2.urp_tp2_2025.mapper.EstudianteMapperImpl;
import com.juliocesar.tp2.urp_tp2_2025.repository.EstudianteRepository;
import com.juliocesar.tp2.urp_tp2_2025.entity.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class EstudianteServiceImpl implements EstudianteService{

    private EstudianteRepository estudianteRepository;
    private EstudianteMapperImpl estudianteDTOMapper;

    @Autowired
    public EstudianteServiceImpl(EstudianteRepository theEstudianteRepository, EstudianteMapperImpl theEstudianteMapper){
        estudianteRepository = theEstudianteRepository;
        estudianteDTOMapper = theEstudianteMapper;
    }

    @Override
    public List<EstudianteResponse> findAll() {
        return estudianteDTOMapper.toEstudianteResponseList(estudianteRepository.findAll());
    }

    @Transactional
    @Override
    public EstudianteRequest save(EstudianteRequest theEstudianterRequest) {
        theEstudianterRequest.setId_estudiante(generarCodigoEstudiante());
        theEstudianterRequest.setEmail(generarCorreoInstitucional());
        Estudiante estudiante = estudianteDTOMapper.toEstudiante(theEstudianterRequest);
        return estudianteDTOMapper.toEstudianteRequest(estudianteRepository.save(estudiante));
    }

    private String generarCorreoInstitucional(){
        String codigoEstudiante = generarCodigoEstudiante();
        final String formatoUrp = "@urp.edu.pe";
        return codigoEstudiante + formatoUrp;
    }

    private String generarCodigoEstudiante(){
        int anho = calcularAnho();
        int periodo = getPeriodoInscripcion();
        int patronNumero = getSiguienteNumero(anho, periodo);
        return String.valueOf(anho) + periodo + formatearNumero(patronNumero);
    }
    private int calcularAnho(){
        return LocalDate.now().getYear();
    }

    private String formatearNumero(int lastDigitos){
        return String.format("%04d", lastDigitos);
    }

    private int getSiguienteNumero(int anho, int periodo){
        String patron = anho + String.valueOf(periodo);
        Optional<String> ultimoId = estudianteRepository.findLastIDPatronLike(patron + "%");
        if (ultimoId.isEmpty()){
            //primer estudiante de ese periodo
            return 1;
        }
        String ultimoIdCompleto = ultimoId.get();
        String ultimo4Digitos = ultimoIdCompleto.substring(ultimoIdCompleto.length() - 4);
        return Integer.parseInt(ultimo4Digitos) + 1;
    }
    private int getPeriodoInscripcion(){
        int mes = LocalDate.now().getMonthValue();
        if (mes >= 3 && mes <= 7){
            return 1;
        }
        else if (mes >= 8){
            return 2;
        }
        else{
            return 0;
        }
    }

    @Override
    public EstudianteResponse findById(String codigo) {
        Optional<Estudiante> result = estudianteRepository.findById(codigo);
        Estudiante estudiante = null;
        if (result.isPresent()){
            estudiante = result.get();
        }
        else{
            throw new RuntimeException("No se encontro el estudiante " + codigo);
        }
        return estudianteDTOMapper.toEstudianteResponse(estudiante);
    }

    @Transactional
    @Override
    public EstudianteRequest update(String codigo, EstudianteRequest estudianteRequest) {
        //Estudiante estudiante = estudianteRepository.findById(codigo).get();
        Optional<Estudiante> result = estudianteRepository.findById(codigo);
        Estudiante estudiante = null;
        if (result.isPresent()){
            estudiante = result.get();
        }
        else{
            throw new RuntimeException("No se encontro el estudiante: " + codigo);
        }
        estudianteDTOMapper.updateEstudianteFromRequest(estudianteRequest, estudiante);
        return estudianteDTOMapper.toEstudianteRequest(estudianteRepository.save(estudiante));
    }

    @Transactional
    @Override
    public void deleteById(String codigo) {
        //probablemente haya que refactorizar este codigo
        Optional<Estudiante> result = estudianteRepository.findById(codigo);
        Estudiante estudiante = null;
        if (result.isPresent()){
            estudiante = result.get();
        }
        else{
            throw new RuntimeException("No se encontro el estudiante: " + codigo);
        }
        estudianteRepository.deleteById(codigo);
    }
}
