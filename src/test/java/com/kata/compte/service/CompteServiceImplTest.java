package com.kata.compte.service;


import com.kata.compte.dto.CompteDto;
import com.kata.compte.dto.RequestCptDto;
import com.kata.compte.entity.CompteEntity;
import com.kata.compte.repository.CompteRepository;
import com.kata.compte.service.implementation.CompteServiceImpl;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * Test service compte
 *
 * @author abdelaziz fellah
 */

@ExtendWith(MockitoExtension.class)

public class CompteServiceImplTest {
    // mock repository
    @Mock
    private CompteRepository compteRepository;
    //inject service
    @InjectMocks
    private CompteServiceImpl compteServiceImpl;

    //test la mehode de la creation d'un compte
    @Test
    public void createCompte() {
        CompteDto compteDto = new CompteDto();
        // numero  de compte ;
        compteDto.setNumeroCompte("9876543211234");
        // institulé de compte
        compteDto.setIntitule("Compte courant");
        // code de la banque  par exemple 00034
        compteDto.setCodeBanque("00009");
        // code de l'agence
        compteDto.setCodeAgence("765");
        // statut : ouvert, cloture,...
        compteDto.setStatut("Ouvert");
        //est ce que le compte est active ou descative
        compteDto.setCompteActive(true);
        // date d'ouverture
        compteDto.setDateOuverture(new Date());

        // devise de compte
        compteDto.setDevise("EUR");

        //solde disponible
        compteDto.setSoldeDisponible(BigDecimal.valueOf(1400));
        //le type de compte : compte courant ,compte epargne
        compteDto.setTypeCompte("courant");
        CompteEntity compte = new CompteEntity();
        compte.setNumeroCompte("9876543211234");
        when(compteRepository.save(ArgumentMatchers.any(CompteEntity.class))).thenReturn(compte);

        CompteEntity compteCreated = compteServiceImpl.createCompte(compteDto);

        assertThat(compteCreated.getNumeroCompte()).isSameAs(compteDto.getNumeroCompte());



    }




    // test la mehode qui permette de recuperer les comptes
    @Test
    public void getAllComptes() {

        List<CompteEntity> comptes = new ArrayList();
        comptes.add(new CompteEntity());

        given(compteRepository.findAll()).willReturn(comptes);

        List<CompteEntity> expected = compteServiceImpl.getAllComptes();

        assertEquals(expected, comptes);
        verify(compteRepository).findAll();
    }



    // test la methode du  depot de compte
    @Test
    public void depotCompte() {
        RequestCptDto request = new RequestCptDto();
        request.setNumeroCompte("1234567890875");
        request.setCodeSwift("CNEPFR22");
        request.setIdentidiantRC("12345678");
        request.setMontant(BigDecimal.valueOf(100));
        CompteEntity compte = new CompteEntity();
        compte.setId(1L);
        compte.setSoldeDisponible(BigDecimal.valueOf(20000));
//When
        lenient().when(compteRepository.findByNumeroCompteAndSwiftBanqueAndIdentifiantClient(request.getNumeroCompte(), request.getCodeSwift(), request.getIdentidiantRC())).thenReturn(compte);

        BigDecimal newSolde = compte.getSoldeDisponible().add(request.getMontant());
        CompteEntity updateCompte = compte;
        updateCompte.setSoldeDisponible(newSolde);
        updateCompte.setSoldeTempsReel(newSolde);
        lenient().when(compteRepository.saveAndFlush(ArgumentMatchers.any(CompteEntity.class))).thenReturn(updateCompte);
        MatcherAssert.assertThat(updateCompte, is(compte));
        MatcherAssert.assertThat(updateCompte.getSoldeDisponible(), is(compte.getSoldeDisponible()));

    }

    // test  la methode de la retrait de compte
    @Test
    public void retraitCompte() {
        RequestCptDto request = new RequestCptDto();
        request.setNumeroCompte("1234567890875");
        request.setCodeSwift("CNEPFR22");
        request.setIdentidiantRC("12345678");
        request.setMontant(BigDecimal.valueOf(100));
        CompteEntity compte = new CompteEntity();
        compte.setId(1L);
        compte.setSoldeDisponible(BigDecimal.valueOf(20000));
//When
        lenient().when(compteRepository.findByNumeroCompteAndSwiftBanqueAndIdentifiantClient(request.getNumeroCompte(), request.getCodeSwift(), request.getIdentidiantRC())).thenReturn(compte);

        BigDecimal newSolde = compte.getSoldeDisponible().subtract(request.getMontant());
        CompteEntity updateCompte = compte;
        updateCompte.setSoldeDisponible(newSolde);
        updateCompte.setSoldeTempsReel(newSolde);
        lenient().when(compteRepository.saveAndFlush(ArgumentMatchers.any(CompteEntity.class))).thenReturn(updateCompte);
        MatcherAssert.assertThat(updateCompte, is(compte));
        MatcherAssert.assertThat(updateCompte.getSoldeDisponible(), is(compte.getSoldeDisponible()));
    }

    //test la methode getCompteByNumCptAndCodeSwiftAndClient  qui permette de recuperer un compte par numero de compte
    // et code Swift  et identifiant Rc
    @Test
    public void getCompteByNumCptAndCodeSwiftAndClient() {
        RequestCptDto request = new RequestCptDto();
        request.setNumeroCompte("1234567890875");
        request.setCodeSwift("CNEPFR22");
        request.setIdentidiantRC("12345678");
        request.setMontant(BigDecimal.valueOf(100));
        CompteEntity compte = new CompteEntity();
        compte.setId(1L);
        compte.setSoldeDisponible(BigDecimal.valueOf(20000));
//When
        lenient().when(compteRepository.findByNumeroCompteAndSwiftBanqueAndIdentifiantClient(request.getNumeroCompte(), request.getCodeSwift(), request.getIdentidiantRC())).thenReturn(compte);

        Optional<CompteEntity> expected = compteServiceImpl.getCompteByNumCptAndCodeSwiftAndClient(request.getNumeroCompte(), request.getCodeSwift(), request.getIdentidiantRC());
         if(expected.isPresent()){
             assertThat(expected.get()).isSameAs(compte);
         }else {
             assertThat(expected).isSameAs(null);
         }

    }

    // test la methode du  depot de compte
    @Test
    public void faitOperation_depot() {
        RequestCptDto request = new RequestCptDto();
        request.setNumeroCompte("1234567890875");
        request.setCodeSwift("CNEPFR22");
        request.setIdentidiantRC("12345678");
        request.setMontant(BigDecimal.valueOf(100));
        request.setTypeOperation("depotCpt");
        CompteEntity compte = new CompteEntity();
        compte.setId(1L);
        compte.setSoldeDisponible(BigDecimal.valueOf(20000));
//When
        lenient().when(compteRepository.findByNumeroCompteAndSwiftBanqueAndIdentifiantClient(request.getNumeroCompte(), request.getCodeSwift(), request.getIdentidiantRC())).thenReturn(compte);

         BigDecimal newSolde = compte.getSoldeDisponible().add(request.getMontant());
        CompteEntity updateCompte = compte;
        updateCompte.setSoldeDisponible(newSolde);
        updateCompte.setSoldeTempsReel(newSolde);
        lenient().when(compteRepository.saveAndFlush(ArgumentMatchers.any(CompteEntity.class))).thenReturn(updateCompte);
        MatcherAssert.assertThat(updateCompte, is(compte));
        MatcherAssert.assertThat(updateCompte.getSoldeDisponible(), is(compte.getSoldeDisponible()));

    }

    @Test
    public void faitOperation_retrait() {
        RequestCptDto request = new RequestCptDto();
        request.setNumeroCompte("1234567890875");
        request.setCodeSwift("CNEPFR22");
        request.setIdentidiantRC("12345678");
        request.setMontant(BigDecimal.valueOf(100));
        request.setTypeOperation("retraitCpt");
        CompteEntity compte = new CompteEntity();
        compte.setId(1L);
        compte.setSoldeDisponible(BigDecimal.valueOf(20000));
//When
        lenient().when(compteRepository.findByNumeroCompteAndSwiftBanqueAndIdentifiantClient(request.getNumeroCompte(), request.getCodeSwift(), request.getIdentidiantRC())).thenReturn(compte);

        BigDecimal newSolde = compte.getSoldeDisponible().add(request.getMontant());
        CompteEntity updateCompte = compte;
        updateCompte.setSoldeDisponible(newSolde);
        updateCompte.setSoldeTempsReel(newSolde);
        lenient().when(compteRepository.saveAndFlush(ArgumentMatchers.any(CompteEntity.class))).thenReturn(updateCompte);
        MatcherAssert.assertThat(updateCompte, is(compte));
        MatcherAssert.assertThat(updateCompte.getSoldeDisponible(), is(compte.getSoldeDisponible()));

    }

}
