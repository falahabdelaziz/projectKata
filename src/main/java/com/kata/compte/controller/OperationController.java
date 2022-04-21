package com.kata.compte.controller;

import com.kata.compte.entity.CompteEntity;
import com.kata.compte.entity.OperationEntity;
import com.kata.compte.service.CompteService;
import com.kata.compte.service.OperationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/operations")
@Tag(name = "Les operations")
public class OperationController {
    @Autowired
    private OperationService operationService;
    private static final Logger LOGGER = LoggerFactory.getLogger(OperationController.class);
    @Operation(summary = "liste des operations")
    @ApiResponses(value = {@ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "200", description = "Ok")})
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<OperationEntity>> getAllOperations() {
        LOGGER.info(String.format("------------------La liste des operations"));
        return ResponseEntity.ok().body(operationService.getAllOperations());
    }

}
