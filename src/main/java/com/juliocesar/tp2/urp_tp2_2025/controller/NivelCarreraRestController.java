package com.juliocesar.tp2.urp_tp2_2025.controller;

import com.juliocesar.tp2.urp_tp2_2025.dto.response.NivelCarreraResponse;
import com.juliocesar.tp2.urp_tp2_2025.service.NivelCarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NivelCarreraRestController {

    private NivelCarreraService nivelCarreraService;
    @Autowired
    public NivelCarreraRestController(NivelCarreraService theNivelCarreraService){
        nivelCarreraService = theNivelCarreraService;
    }

    //get all niveles
    @GetMapping("/niveles")
    public ResponseEntity<List<NivelCarreraResponse>> getNiveles(){
        return new ResponseEntity<>(nivelCarreraService.findAll(), HttpStatus.OK);
    }

    //get nivel by id
    @GetMapping("/niveles/{nivelId}")
    public ResponseEntity<NivelCarreraResponse> getNivel(@PathVariable int nivelId){
        return new ResponseEntity<>(nivelCarreraService.findById(nivelId),HttpStatus.OK);
    }
}
