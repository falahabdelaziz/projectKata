package com.kata.compte.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * l'entité  MOUVEMENT ou bien les transactions qu'ont fait sur un compte
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
@Table(name = "OPERATION_CPT")
public class OperationEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    // identifiant unique de la transaction
    @Id
    @SequenceGenerator(name = "OperationSeq", sequenceName = "OPERATION_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "operationSeq")
    @Column(name = "ID", nullable = false)
    Long id;
   // numero de compte
    @Column(name = "NUMERO_COMPTE")
    String numeroCompte;
    // code d'operation
    @Column(name = "CODE_OPERATION")
    String codeOperation;
    // date d'operation
    @Column(name = "DATE_OPERATION")
    Date dateOperation;
    // devise
    @Column(name = "DEVISE")
    String devise;
    // libelle
    @Column(name = "LIBELLE")
    String libelle;
    // solde en temps reel
    @Column(name = "MONTANT")
    BigDecimal montant;
    //solde disponible
    @Column(name = "BALANCE")
    BigDecimal balance;
    //statut de compte
    @Column(name = "STATUT")
    BigDecimal statut;



}
