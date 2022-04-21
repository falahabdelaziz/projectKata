package com.kata.compte.repository;


import com.kata.compte.entity.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OperationsRepository extends JpaRepository<OperationEntity, Long>, JpaSpecificationExecutor<OperationEntity> {

}
