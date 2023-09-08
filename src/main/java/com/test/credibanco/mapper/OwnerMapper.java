package com.test.credibanco.mapper;

import com.test.credibanco.mapper.utils.BaseMapper;
import com.test.credibanco.mapper.utils.MapperUtils;
import com.test.credibanco.model.dto.OwnerDto;
import com.test.credibanco.model.entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OwnerMapper implements BaseMapper<OwnerDto, Owner> {

    @Lazy
    @Autowired
    private MapperUtils utils;

    @Override
    public OwnerDto entityToDto(Owner entity) {
        OwnerDto dto = new OwnerDto();

        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());

        return dto;
    }

    @Override
    public Owner dtoToEntity(OwnerDto dto) {
        Owner entity = new Owner();

        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());

        return entity;
    }

    @Override
    public List<OwnerDto> entitiesToDtos(List<Owner> entities) {
        return utils.entitiesToDtos(entities, this::entityToDto);
    }

    @Override
    public List<Owner> dtosToEntities(List<OwnerDto> dtos) {
        return utils.dtosToEntities(dtos, this::dtoToEntity);
    }
}
