package com.kata.compte.controller;

import com.kata.compte.dto.CompteDto;
import com.kata.compte.dto.RequestCptDto;
import com.kata.compte.entity.CompteEntity;
import com.kata.compte.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/compte")
public class CompteController {

    @Autowired
    private CompteService compteService;

    @PostMapping(value = "/create", produces = {"application/json; charset=UTF-8"}, consumes = "application/json")
    @ResponseBody
    public CompteEntity createCompte(@RequestBody CompteDto compteDto) {
        return compteService.createCompte(compteDto);

    }

    @GetMapping(value = "/list", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public List<CompteEntity> getAllComptes() {

        return compteService.getAllComptes();
    }

    // la methode faitOperation qui permette de faire une operation . <<depot ou bien retrait>>
    @GetMapping(value = "/fait-operation", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public CompteEntity faitOperation(@RequestBody RequestCptDto request) {

            return compteService.faitOperation(request);


    }


}
