package com.kata.compte.mapper;

import com.kata.compte.dto.CompteDto;
import com.kata.compte.entity.CompteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompteMapper {
    CompteMapper INSTANCE = Mappers.getMapper(CompteMapper.class);
    CompteDto entityToDto(CompteEntity compte);
    CompteEntity dtoToEntity(CompteDto dto);
}
