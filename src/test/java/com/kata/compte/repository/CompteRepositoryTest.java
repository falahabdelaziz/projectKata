package com.kata.compte.repository;


import com.kata.compte.entity.CompteEntity;
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
public class CompteRepositoryTest {
    @Autowired
    private CompteRepository compteRepository;

    // Test method create compte
    @Test
    @Order(1)
    @Rollback(value = false)
    public void createCompteTest(){

        CompteEntity compte = CompteEntity.builder()
                .numeroCompte("4567897654321")
                .soldeDisponible(BigDecimal.valueOf(45645)).dateOuverture(new Date())
                .compteActive(true)
                .devise("USD")
                .typeCompte("compteCourant")
                .build();

        compteRepository.save(compte);

        Assertions.assertThat(compte.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getCompteByIdTest(){

        CompteEntity compte = compteRepository.findById(1L).get();

        Assertions.assertThat(compte.getId()).isEqualTo(1L);

    }

    @Test
    @Order(3)
    public void getAllComptesTest(){

        List<CompteEntity> comptes = compteRepository.findAll();

        Assertions.assertThat(comptes.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateCompteTest(){

        CompteEntity compte = compteRepository.findById(1L).get();

        compte.setSoldeDisponible(BigDecimal.valueOf(1000000));
        compte.setCodeAgence("756");
        compte.setDevise("EUR");
        compte.setTypeCompte("courant");

        CompteEntity compteUpdated =  compteRepository.save(compte);

        Assertions.assertThat(compteUpdated.getDevise()).isEqualTo("EUR");

    }


}
