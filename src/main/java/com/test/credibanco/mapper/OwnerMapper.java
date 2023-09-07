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
        return null;
    }

    @Override
    public Owner dtoToEntity(OwnerDto dto) {
        return null;
    }

    @Override
    public List<OwnerDto> entitiesToDtos(List<Owner> entities) {
        return null;
    }

    @Override
    public List<Owner> dtosToEntities(List<OwnerDto> dtos) {
        return null;
    }
}
