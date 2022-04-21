package com.kata.compte.service.implementation;

import com.kata.compte.entity.OperationEntity;
import com.kata.compte.repository.OperationsRepository;
import com.kata.compte.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {
     @Autowired
     private OperationsRepository operationsRepository;
    @Override
    public List<OperationEntity> getAllOperations() {

        return operationsRepository.findAll();
    }
}
