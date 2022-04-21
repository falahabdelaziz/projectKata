package com.kata.compte.dto;

import java.math.BigDecimal;
import java.util.Date;

public class OperationDto {

    private Long id;
    // numero de compte
    private String numeroCompte;
    // code d'operation
    private String codeOperation;
    // date d'operation

    private Date dateOperation;
    // devise

    private String devise;
    // libelle

    private String libelle;
    // solde en temps reel

    private BigDecimal montant;
    //solde disponible
    private BigDecimal balance;
    //statut de compte
    private BigDecimal statut;

    public OperationDto() {
    }

    public OperationDto(Long id, String numeroCompte, String codeOperation, Date dateOperation, String devise, String libelle, BigDecimal montant, BigDecimal balance, BigDecimal statut) {
        this.id = id;
        this.numeroCompte = numeroCompte;
        this.codeOperation = codeOperation;
        this.dateOperation = dateOperation;
        this.devise = devise;
        this.libelle = libelle;
        this.montant = montant;
        this.balance = balance;
        this.statut = statut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public String getCodeOperation() {
        return codeOperation;
    }

    public void setCodeOperation(String codeOperation) {
        this.codeOperation = codeOperation;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getStatut() {
        return statut;
    }

    public void setStatut(BigDecimal statut) {
        this.statut = statut;
    }
}
