package com.kata.compte.repository;


import com.kata.compte.entity.CompteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface CompteRepository extends JpaRepository<CompteEntity, Long> , JpaSpecificationExecutor<CompteEntity> {

   CompteEntity findByNumeroCompteAndSwiftBanqueAndIdentifiantClient(String numeroCompte, String SwiftBanque, String identifiantClient);

}
