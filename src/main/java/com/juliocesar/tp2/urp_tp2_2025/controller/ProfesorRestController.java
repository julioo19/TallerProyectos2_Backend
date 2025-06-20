package com.juliocesar.tp2.urp_tp2_2025.controller;

import com.juliocesar.tp2.urp_tp2_2025.dto.request.ProfesorRequest;
import com.juliocesar.tp2.urp_tp2_2025.dto.response.ProfesorResponse;
import com.juliocesar.tp2.urp_tp2_2025.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProfesorRestController {
    private ProfesorService profesorService;

    @Autowired
    public ProfesorRestController(ProfesorService theProfesorService){
        profesorService = theProfesorService;
    }

    @GetMapping("/profesores")
    public ResponseEntity<List<ProfesorResponse>> getProfesores(){
        return new ResponseEntity<>(profesorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/profesores/{profesorId}")
    public ResponseEntity<ProfesorResponse> getProfesor(@PathVariable int profesorId){
        return new ResponseEntity<>(profesorService.findById(profesorId), HttpStatus.OK);
    }

    @PostMapping("/profesores")
    public ResponseEntity<ProfesorRequest> saveProfesor(@RequestBody ProfesorRequest profesorRequest){
        //System.out.println("Apellido profesor: " + profesorRequest.getApellido());
        return new ResponseEntity<>(profesorService.save(profesorRequest), HttpStatus.CREATED);
    }

    @PutMapping("/profesores/{profesorId}")
    public ResponseEntity<ProfesorRequest> updateProfesor(@PathVariable int profesorId, @RequestBody ProfesorRequest profesorRequest){
        return new ResponseEntity<>(profesorService.update(profesorId, profesorRequest), HttpStatus.OK);
    }

    @DeleteMapping("/profesores/{profesorId}")
    public ResponseEntity<Void> deleteProfesor(@PathVariable int profesorId){
        profesorService.deleteById(profesorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

