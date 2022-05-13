package com.fundamentos.springboot.fundamentos.controller;

import com.fundamentos.springboot.fundamentos.entity.Valorant;
import com.fundamentos.springboot.fundamentos.repository.ValorantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ValorantController {

    @Autowired
    private ValorantRepository repo;

    @GetMapping("/valorant")
    public ResponseEntity<List<Valorant>> getAllValorant() {
        List<Valorant> listValorant = repo.findAll();

        return new ResponseEntity<List<Valorant>>(listValorant, HttpStatus.OK);
    }


}
