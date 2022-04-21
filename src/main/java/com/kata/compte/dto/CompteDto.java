package com.kata.compte.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * dto compte
 *
 *  @author fellah abdelaziz
 */
public class CompteDto {

    // id unique
    Long id;
    //numero de compte
    String numeroCompte;
    // institulé de compte

    String intitule;
    // code de la banque  par exemple 00034
    String codeBanque;
    // code de l'agence
    String codeAgence;
    // statut : ouvert, cloture,
    String statut;
    //est ce que le compte est active ou descative
    Boolean compteActive;
    // date d'ouverture
    Date dateOuverture;
    // date de  fermeture un compte
    Date dateFermeture;
    // le motif de cloture
    String motifClotureCompte;
    // devise de compte
    String devise;
    // solde en temps reel
    BigDecimal soldeTempsReel;
    //solde disponible
    BigDecimal soldeDisponible;
    //le type de compte : compte courant ,compte epargne
    String typeCompte;
    // le pays
    String pays;
    //la ville
    String ville;
    // code postale
    String codePostal;
    //adresse
    String adresse;
    //telephone
    String telephone;
    String balance;
    String utilisateurAyantCloture;
    // User (Utilisateur qu'utilise l'application (agent de la banque  )
    String utilisateurAyantCree;
    // Banque du client qui a ouvert le compte
    String  swiftBanque;

    public CompteDto() {
    }

    public CompteDto(Long id, String numeroCompte, String intitule, String codeBanque, String codeAgence, String statut, Boolean compteActive, Date dateOuverture, Date dateFermeture, String motifClotureCompte, String devise, BigDecimal soldeTempsReel, BigDecimal soldeDisponible, String typeCompte, String pays, String ville, String codePostal, String adresse, String telephone, String balance, String utilisateurAyantCloture, String utilisateurAyantCree, String swiftBanque) {
        this.id = id;
        this.numeroCompte = numeroCompte;
        this.intitule = intitule;
        this.codeBanque = codeBanque;
        this.codeAgence = codeAgence;
        this.statut = statut;
        this.compteActive = compteActive;
        this.dateOuverture = dateOuverture;
        this.dateFermeture = dateFermeture;
        this.motifClotureCompte = motifClotureCompte;
        this.devise = devise;
        this.soldeTempsReel = soldeTempsReel;
        this.soldeDisponible = soldeDisponible;
        this.typeCompte = typeCompte;
        this.pays = pays;
        this.ville = ville;
        this.codePostal = codePostal;
        this.adresse = adresse;
        this.telephone = telephone;
        this.balance = balance;
        this.utilisateurAyantCloture = utilisateurAyantCloture;
        this.utilisateurAyantCree = utilisateurAyantCree;
        this.swiftBanque = swiftBanque;
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

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getCodeBanque() {
        return codeBanque;
    }

    public void setCodeBanque(String codeBanque) {
        this.codeBanque = codeBanque;
    }

    public String getCodeAgence() {
        return codeAgence;
    }

    public void setCodeAgence(String codeAgence) {
        this.codeAgence = codeAgence;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Boolean getCompteActive() {
        return compteActive;
    }

    public void setCompteActive(Boolean compteActive) {
        this.compteActive = compteActive;
    }

    public Date getDateOuverture() {
        return dateOuverture;
    }

    public void setDateOuverture(Date dateOuverture) {
        this.dateOuverture = dateOuverture;
    }

    public Date getDateFermeture() {
        return dateFermeture;
    }

    public void setDateFermeture(Date dateFermeture) {
        this.dateFermeture = dateFermeture;
    }

    public String getMotifClotureCompte() {
        return motifClotureCompte;
    }

    public void setMotifClotureCompte(String motifClotureCompte) {
        this.motifClotureCompte = motifClotureCompte;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public BigDecimal getSoldeTempsReel() {
        return soldeTempsReel;
    }

    public void setSoldeTempsReel(BigDecimal soldeTempsReel) {
        this.soldeTempsReel = soldeTempsReel;
    }

    public BigDecimal getSoldeDisponible() {
        return soldeDisponible;
    }

    public void setSoldeDisponible(BigDecimal soldeDisponible) {
        this.soldeDisponible = soldeDisponible;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getUtilisateurAyantCloture() {
        return utilisateurAyantCloture;
    }

    public void setUtilisateurAyantCloture(String utilisateurAyantCloture) {
        this.utilisateurAyantCloture = utilisateurAyantCloture;
    }

    public String getUtilisateurAyantCree() {
        return utilisateurAyantCree;
    }

    public void setUtilisateurAyantCree(String utilisateurAyantCree) {
        this.utilisateurAyantCree = utilisateurAyantCree;
    }

    public String getSwiftBanque() {
        return swiftBanque;
    }

    public void setSwiftBanque(String swiftBanque) {
        this.swiftBanque = swiftBanque;
    }
}
