package com.kata.compte.controller;

import com.kata.compte.entity.CompteEntity;
import com.kata.compte.entity.OperationEntity;
import com.kata.compte.service.CompteService;
import com.kata.compte.service.OperationService;
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
public class OperationController {
    @Autowired
    private OperationService operationService;
    private static final Logger LOGGER = LoggerFactory.getLogger(OperationController.class);
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<OperationEntity>> getAllOperations() {
        LOGGER.info(String.format("------------------La liste des operations"));
        return ResponseEntity.ok().body(operationService.getAllOperations());
    }

}
