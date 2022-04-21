package com.kata.compte.service.implementation;

import com.kata.compte.controller.OperationController;
import com.kata.compte.dto.CompteDto;
import com.kata.compte.dto.RequestCptDto;
import com.kata.compte.entity.CompteEntity;
import com.kata.compte.entity.OperationEntity;
import com.kata.compte.enumeration.TypeOperationEnum;
import com.kata.compte.mapper.CompteMapper;
import com.kata.compte.repository.CompteRepository;
import com.kata.compte.repository.OperationsRepository;
import com.kata.compte.service.CompteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompteServiceImpl implements CompteService {

    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationsRepository operationsRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(CompteServiceImpl.class);
    @Override
    public CompteEntity createCompte(CompteDto compteDto) {
        LOGGER.info(String.format("------------------La Creation d'un compte en cours %1$s", compteDto.getNumeroCompte()));
        CompteEntity compteEntity = CompteMapper.INSTANCE.dtoToEntity(compteDto);
        return compteRepository.save(compteEntity);
    }


    @Override
    public List<CompteEntity> getAllComptes()
    {

        LOGGER.info(String.format("------------------La liste des comptes"));

        return compteRepository.findAll();

    }



    @Override
    public Optional<CompteEntity>  getCompteByNumCptAndCodeSwiftAndClient(String numeroCompte, String codeSwift, String identifiantClient) {
        LOGGER.info(String.format("------------------recuperer un compte par num et swift,client"));
        return Optional.ofNullable(compteRepository.findByNumeroCompteAndSwiftBanqueAndIdentifiantClient(numeroCompte, codeSwift, identifiantClient));
    }

    @Override
    public CompteEntity faitOperation(RequestCptDto request) {
        Optional<CompteEntity> compte =this.getCompteByNumCptAndCodeSwiftAndClient(request.getNumeroCompte(),request.getCodeSwift(),request.getIdentidiantRC());
        if(compte.isPresent()){
            CompteEntity updateCompte =compte.get();
            BigDecimal newSolde ;
            LOGGER.info(String.format("------------------debut d'operation----------"));

            if(TypeOperationEnum.DEPOT.getCode().equals(request.getTypeOperation())){
                LOGGER.info(String.format("------------------depot---------"));
                newSolde =updateCompte.getSoldeDisponible().add(request.getMontant());
            }else{
                LOGGER.info(String.format("------------------retrait---------"));
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
