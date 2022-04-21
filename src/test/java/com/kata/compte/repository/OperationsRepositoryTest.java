package com.kata.compte.repository;

import com.kata.compte.entity.OperationEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OperationsRepositoryTest {

    @Autowired
    private OperationsRepository operationsRepository;


  // test list vides
    @Test
    @Order(1)
    public void getAllOperationsTestEmpty(){

        List<OperationEntity> operations = operationsRepository.findAll();

        Assertions.assertThat(operations.size()).isEqualTo(0);

    }

    // createOperationForTest qui permette de creer une operation pour tester la methode getAllOperationsTest ne pas vides
    @Test
    @Order(2)
    @Rollback(value = false)
    public void createOperationForTest(){

        OperationEntity operation = OperationEntity.builder()
                .numeroCompte("876677787897")
                .codeOperation("8677").dateOperation(new Date())
                .libelle("operation for test")
                .devise("USD")
                .montant(BigDecimal.valueOf(345))
                .balance(BigDecimal.valueOf(345))
                .build();

        operationsRepository.save(operation);

        Assertions.assertThat(operation.getId()).isGreaterThan(0);
    }


    @Test
    @Order(3)
    public void getAllOperationsTestNotEmpty(){

        List<OperationEntity> operations = operationsRepository.findAll();

        Assertions.assertThat(operations.size()).isGreaterThan(0);

    }


}
