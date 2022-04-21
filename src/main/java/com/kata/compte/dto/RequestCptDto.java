package com.kata.compte.dto;

import java.math.BigDecimal;
import java.util.Date;

public class RequestCptDto {



    private Date date;
    private BigDecimal montant;
    private String numeroCompte;
    private String codeSwift ;
    private String identidiantRC;

    private String typeOperation;

    public RequestCptDto() {
    }

    public RequestCptDto(Date date, BigDecimal montant, String numeroCompte, String codeSwift, String identidiantRC, String typeOperation) {
        this.date = date;
        this.montant = montant;
        this.numeroCompte = numeroCompte;
        this.codeSwift = codeSwift;
        this.identidiantRC = identidiantRC;
        this.typeOperation = typeOperation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public String getCodeSwift() {
        return codeSwift;
    }

    public void setCodeSwift(String codeSwift) {
        this.codeSwift = codeSwift;
    }

    public String getIdentidiantRC() {
        return identidiantRC;
    }

    public void setIdentidiantRC(String identidiantRC) {
        this.identidiantRC = identidiantRC;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }
}
