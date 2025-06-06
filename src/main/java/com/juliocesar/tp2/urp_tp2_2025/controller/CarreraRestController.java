package com.juliocesar.tp2.urp_tp2_2025.controller;

import com.juliocesar.tp2.urp_tp2_2025.dto.request.CarreraRequest;
import com.juliocesar.tp2.urp_tp2_2025.dto.response.CarreraResponse;
import com.juliocesar.tp2.urp_tp2_2025.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarreraRestController {

    private CarreraService carreraService;

    @Autowired
    public CarreraRestController(CarreraService theCarreraService){
        carreraService = theCarreraService;
    }

    @GetMapping("/carreras")
    public ResponseEntity<List<CarreraResponse>> getCarreras(){
        return new ResponseEntity<>(carreraService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/carreras/{carreraId}")
    public ResponseEntity<CarreraResponse> getCarrera(@PathVariable int carreraId){
        return new ResponseEntity<>(carreraService.findById(carreraId), HttpStatus.OK);
    }

    @PostMapping("/carreras")
    public ResponseEntity<CarreraRequest> saveCarrera(@RequestBody CarreraRequest carreraRequest){
        return new ResponseEntity<>(carreraService.save(carreraRequest), HttpStatus.CREATED);
    }
}
