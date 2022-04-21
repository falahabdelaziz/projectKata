package com.kata.compte.service.implementation;

import com.kata.compte.dto.CompteDto;
import com.kata.compte.dto.RequestCptDto;
import com.kata.compte.entity.CompteEntity;
import com.kata.compte.entity.OperationEntity;
import com.kata.compte.repository.CompteRepository;
import com.kata.compte.repository.OperationsRepository;
import com.kata.compte.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CompteServiceImpl implements CompteService {

    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationsRepository operationsRepository;
    @Override
    public CompteEntity createCompte(CompteDto compteDto) {
          CompteEntity compteEntity = new  CompteEntity();
        compteEntity.setNumeroCompte(compteDto.getNumeroCompte());
        compteEntity.setTypeCompte(compteDto.getTypeCompte());
        compteEntity.setSoldeDisponible(compteDto.getSoldeDisponible());
        compteEntity.setSoldeTempsReel(compteDto.getSoldeDisponible());
        compteEntity.setDevise(compteDto.getDevise());


        return compteRepository.save(compteEntity);
    }


    @Override
    public List<CompteEntity> getAllComptes()
    {
        return compteRepository.findAll();
    }



    @Override
    public Optional<CompteEntity>  getCompteByNumCptAndCodeSwiftAndClient(String numeroCompte, String codeSwift, String identifiantClient) {
        return Optional.ofNullable(compteRepository.findByNumeroCompteAndSwiftBanqueAndIdentifiantClient(numeroCompte, codeSwift, identifiantClient));
    }

    @Override
    public CompteEntity faitOperation(RequestCptDto request) {
        Optional<CompteEntity> compte =this.getCompteByNumCptAndCodeSwiftAndClient(request.getNumeroCompte(),request.getCodeSwift(),request.getIdentidiantRC());
        if(compte.isPresent()){
            CompteEntity updateCompte =compte.get();
            BigDecimal newSolde ;
            if("depotCpt".equals(request.getTypeOperation())){
                newSolde =updateCompte.getSoldeDisponible().add(request.getMontant());
            }else{
                 newSolde =updateCompte.getSoldeDisponible().subtract(request.getMontant());
            }
            updateCompte.setSoldeDisponible(newSolde);
            updateCompte.setSoldeTempsReel(newSolde);
            CompteEntity updatedCpt =compteRepository.saveAndFlush(updateCompte);
            if(updatedCpt!=null){
                OperationEntity operation = new OperationEntity();
                operation.setDateOperation(new Date());
                operation.setCodeOperation("TN"+updatedCpt.getId()+Math.random());
                operation.setNumeroCompte(updatedCpt.getNumeroCompte());
                operation.setLibelle("operation de CPT"+updatedCpt.getNumeroCompte());
                operation.setMontant(request.getMontant());
                operation.setBalance(updatedCpt.getSoldeDisponible());
                operationsRepository.save(operation);

            }
            return  updatedCpt;
        }else {
            throw new IllegalArgumentException("le compte n'existe pas ");
        }

    }

    @Override
    @Deprecated
    public CompteEntity retraitCompte(RequestCptDto requestCptDto) {

        Optional<CompteEntity> compte =this.getCompteByNumCptAndCodeSwiftAndClient(requestCptDto.getNumeroCompte(),requestCptDto.getCodeSwift(),requestCptDto.getIdentidiantRC());
        if(compte.isPresent()){
            CompteEntity updateCompte =compte.get();
            BigDecimal newSolde =updateCompte.getSoldeDisponible().subtract(requestCptDto.getMontant());
            updateCompte.setSoldeDisponible(newSolde);
            updateCompte.setSoldeTempsReel(newSolde);
            return compteRepository.saveAndFlush(updateCompte);
        }else {
            throw new IllegalArgumentException("le compte n'existe pas ");
        }

    }

    @Override
    @Deprecated
    public CompteEntity depotCompte(RequestCptDto requestCptDto) {

        Optional<CompteEntity> compte =this.getCompteByNumCptAndCodeSwiftAndClient(requestCptDto.getNumeroCompte(),requestCptDto.getCodeSwift(),requestCptDto.getIdentidiantRC());
        if(compte.isPresent()){
            CompteEntity updateCompte =compte.get();
            BigDecimal newSolde =updateCompte.getSoldeDisponible().add(requestCptDto.getMontant());
            updateCompte.setSoldeDisponible(newSolde);
            updateCompte.setSoldeTempsReel(newSolde);
            return compteRepository.saveAndFlush(updateCompte);
        }else {
            throw new IllegalArgumentException("le compte n'existe pas ");
        }

    }
}
