package com.kata.compte.mapper;

import com.kata.compte.dto.CompteDto;
import com.kata.compte.dto.OperationDto;
import com.kata.compte.entity.CompteEntity;
import com.kata.compte.entity.OperationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OperationMapper {
    OperationMapper INSTANCE = Mappers.getMapper(OperationMapper.class);
    OperationDto entityToDto(OperationEntity operation);
    OperationEntity dtoToEntity(OperationDto dto);
}
