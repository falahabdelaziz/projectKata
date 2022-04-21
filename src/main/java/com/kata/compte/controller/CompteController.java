package com.kata.compte.controller;

import com.kata.compte.dto.CompteDto;
import com.kata.compte.dto.RequestCptDto;
import com.kata.compte.entity.CompteEntity;
import com.kata.compte.service.CompteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping(value = "/compte")
@Tag(name = "Gestion de compte")
public class CompteController {

    @Autowired
    private CompteService compteService;
    private static final Logger LOGGER = LoggerFactory.getLogger(CompteController.class);
    @Operation(summary = "creer un compte")
    @ApiResponses(value = {@ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "200", description = "Ok")})
    @PostMapping(value = "/create", produces = {"application/json; charset=UTF-8"}, consumes = "application/json")
    @ResponseBody
    public CompteEntity createCompte(@RequestBody CompteDto compteDto) {

        LOGGER.info(String.format("------------------APPEL WS DE CREATION d'un compte %1$s", compteDto.getNumeroCompte()));
        return compteService.createCompte(compteDto);

    }
    @Operation(summary = "liste des comptes")
    @ApiResponses(value = {@ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "200", description = "Ok")})
    @GetMapping(value = "/list", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public List<CompteEntity> getAllComptes() {
        LOGGER.info(String.format("------------------Recuperer la liste  des compte"));

        return compteService.getAllComptes();
    }

    // la methode faitOperation qui permette de faire une operation . <<depot ou bien retrait>>
    @Operation(summary = "faire  une operation")
    @ApiResponses(value = {@ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "200", description = "Ok")})
    @GetMapping(value = "/fait-operation", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public CompteEntity faitOperation(@RequestBody RequestCptDto request) {
        LOGGER.info(String.format("------------------Debut de faire une operation sur le compte :%1$s", request.getNumeroCompte()));

        return compteService.faitOperation(request);


    }


}
