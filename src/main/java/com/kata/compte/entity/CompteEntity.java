package com.kata.compte.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * l'entité compte
 *
 * @author fellah abdelaziz
 */
@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "COMPTE")
public class CompteEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    //id unique
    @Id
    @SequenceGenerator(name = "compteSeq", sequenceName = "COMPTE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "compteSeq")
    @Column(name = "ID", nullable = false)
    Long id;
    //numero de compte
    @Column(name = "NUMERO_COMPTE")
    String numeroCompte;
    // institulé de compte
    @Column(name = "INTITULE")
    String intitule;
    // code de la banque  par exemple 00034
    @Column(name = "CODE_BANQUE")
    String codeBanque;
    // code de l'agence
    @Column(name = "CODE_AGENCE")
    String codeAgence;
    // statut : ouvert, cloture,
    @Column(name = "STATUT")
    String statut;
    //est ce que le compte est active ou descative
    @Column(name = "COMPTE_ACTIVE")
    Boolean compteActive;
    // date d'ouverture
    @Column(name = "DATE_OUVERTURE")
    @Temporal(TemporalType.TIMESTAMP)
    Date dateOuverture;
    // date de  fermeture un compte
    @Column(name = "DATE_FERMETURE")
    @Temporal(TemporalType.TIMESTAMP)
    Date dateFermeture;
    // le motif de cloture
    @Column(name = "MOTIF_CLOTURE_COMPTE")
    String motifClotureCompte;
    // devise de compte
    @Column(name = "DEVISE")
    String devise;
    // solde en temps reel
    @Column(name = "SOLDE_TEMPS_REEL")
    BigDecimal soldeTempsReel;
    //solde disponible
    @Column(name = "SOLDE_DISPONIBLE")
    BigDecimal soldeDisponible;
    //le type de compte : compte courant ,compte epargne
    @Column(name = "TYPE_COMPTE")
    String typeCompte;
    // le pays
    @Column(name = "PAYS")
    String pays;
    //la ville
    @Column(name = "VILLE")
    String ville;
    // code postale
    @Column(name = "CODE_POSTALE")
    String codePostal;
    //adresse
    @Column(name = "ADRESSE")
    String adresse;
    //telephone
    @Column(name = "TELEPHONE")
    String telephone;
    @Column(name = "BALANCE")
    String balance;
    //  User (Utilisateur qu'utilise l'application (agent de la banque  )
    @Column(name = "UTILISATEUR_CLOTURE_ID")
    String utilisateurAyantCloture;
    // User (Utilisateur qu'utilise l'application (agent de la banque  )
    @Column(name = "UTILISATEUR_AYANT_CREE_ID")
    String utilisateurAyantCree;
    // Banque du client qui a ouvert le compte
    @Column(name = "SWIFT_ID")
    String  swiftBanque;
    // -->identifiant de client
    // --> identifiant  relation commerciale ou bien  Numero de tiers
    @Column(name = "IDENTIFIANT_CLIENT")
    String  identifiantClient;
}
