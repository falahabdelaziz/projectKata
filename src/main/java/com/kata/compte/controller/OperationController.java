package com.kata.compte.controller;

import com.kata.compte.entity.CompteEntity;
import com.kata.compte.entity.OperationEntity;
import com.kata.compte.service.CompteService;
import com.kata.compte.service.OperationService;
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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<OperationEntity>> getAllOperations() {
        return ResponseEntity.ok().body(operationService.getAllOperations());
    }

}
