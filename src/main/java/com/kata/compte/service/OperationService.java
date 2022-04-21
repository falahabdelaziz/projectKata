package com.kata.compte.service;


import com.kata.compte.entity.OperationEntity;

import java.util.List;

public interface OperationService {


    // la methode getAllOperations qui permette de recuperer les operations  effectues (historiques )
    /** US3 :
     * In order to check my operations
     *
     * As a bank client
     *
     * I want to see the history (operation, date, amount, balance) of my operations
     *
     *
     *
     */
    List<OperationEntity> getAllOperations();
}
