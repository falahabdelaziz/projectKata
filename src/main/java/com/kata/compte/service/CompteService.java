package com.kata.compte.service;

import com.kata.compte.dto.CompteDto;
import com.kata.compte.dto.RequestCptDto;
import com.kata.compte.entity.CompteEntity;

import java.util.List;
import java.util.Optional;

/**
 *  Service compte
 * @author abdelaziz fellah
 */
public interface CompteService {

    // la methode createCompte qui permette de  creer un compte
    CompteEntity createCompte(CompteDto compte);
    // la methode getAllComptes qui permette de recuper tous les comptes
    List<CompteEntity> getAllComptes();

    // la methode getCompteById qui permette de recuperer un compte par num de compte  et code swift  de la banque et identifiant de client (donneur d'ordre)
    Optional<CompteEntity> getCompteByNumCptAndCodeSwiftAndClient(String  numeroCompte, String codeSwift , String identifiantClient);


    /**
     *   US 1:
     *
     * In order to save money
     *
     * As a bank client
     *
     * I want to make a deposit in my account
     * @param request
     * @return
     */
    CompteEntity depotCompte(RequestCptDto request);

    /**
     *  US 2:
     *
     * In order to retrieve some or all of my savings
     *
     * As a bank client
     *
     * I want to make a withdrawal from my account
     * @param requestCptDto
     * @return
     */
    CompteEntity retraitCompte(RequestCptDto requestCptDto);
}
