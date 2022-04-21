package com.kata.compte.service;

import com.kata.compte.entity.OperationEntity;
import com.kata.compte.repository.OperationsRepository;
import com.kata.compte.service.implementation.OperationServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class OperationsImplTest {
    // mock repository
    @Mock
    private OperationsRepository operationsRepository;
    //inject service
    @InjectMocks
    private OperationServiceImpl operationService;

    @Test
    public void getAllOperations() {

        List<OperationEntity> operations = new ArrayList();
        operations.add(new OperationEntity());

        given(operationsRepository.findAll()).willReturn(operations);

        List<OperationEntity> expected = operationService.getAllOperations();

        assertEquals(expected, operations);
        verify(operationsRepository).findAll();


    }

}
