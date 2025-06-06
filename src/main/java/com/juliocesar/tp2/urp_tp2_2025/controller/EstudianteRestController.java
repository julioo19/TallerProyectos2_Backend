package com.juliocesar.tp2.urp_tp2_2025.controller;

import com.juliocesar.tp2.urp_tp2_2025.dto.request.EstudianteRequest;
import com.juliocesar.tp2.urp_tp2_2025.dto.response.EstudianteResponse;
import com.juliocesar.tp2.urp_tp2_2025.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EstudianteRestController {

    private EstudianteService estudianteService;

    //Service layer DI
    @Autowired
    public EstudianteRestController(EstudianteService theEstudianteService){
        estudianteService = theEstudianteService;
    }

    //get all students
    @GetMapping("/estudiantes")
    public ResponseEntity<List<EstudianteResponse>> getEstudiantes(){
        return new ResponseEntity<>(estudianteService.findAll(),HttpStatus.OK);
    }

    //get student by id
    @GetMapping("/estudiantes/{estudianteId}")
    public ResponseEntity<EstudianteResponse> getEstudiante(@PathVariable String estudianteId){
        return new ResponseEntity<>(estudianteService.findById(estudianteId),HttpStatus.OK);
    }

    //create student
    @PostMapping("/estudiantes")
    public ResponseEntity<EstudianteRequest> saveEstudiante(@RequestBody EstudianteRequest estudianteRequest){
        System.out.println("Fecha de nacimiento recibida: " + estudianteRequest.getFechaNacimiento());
        return new ResponseEntity<>(estudianteService.save(estudianteRequest), HttpStatus.CREATED);
    }

    //update student
    @PutMapping("/estudiantes/{estudianteId}")
    public ResponseEntity<EstudianteRequest> updateEstudiante(@PathVariable String estudianteId, @RequestBody EstudianteRequest estudianteRequest){
        return new ResponseEntity<>(estudianteService.update(estudianteId, estudianteRequest),HttpStatus.OK);
    }

    //delete student by id
    @DeleteMapping("/estudiantes/{estudianteId}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable String estudianteId){
        estudianteService.deleteById(estudianteId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
