package com.test.credibanco.mapper;

import com.test.credibanco.mapper.utils.BaseMapper;
import com.test.credibanco.mapper.utils.MapperUtils;
import com.test.credibanco.model.dto.CardStatusDto;
import com.test.credibanco.model.dto.PurchaseStatusDto;
import com.test.credibanco.model.entity.CardStatus;
import com.test.credibanco.model.entity.PurchaseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PurchaseStatusMapper implements BaseMapper<PurchaseStatusDto, PurchaseStatus> {

    @Lazy
    @Autowired
    private MapperUtils utils;

    @Override
    public PurchaseStatusDto entityToDto(PurchaseStatus entity) {
        PurchaseStatusDto dto = new PurchaseStatusDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }

    @Override
    public PurchaseStatus dtoToEntity(PurchaseStatusDto dto) {
        PurchaseStatus entity = new PurchaseStatus();

        entity.setId(dto.getId());
        entity.setName(dto.getName());

        return entity;
    }

    @Override
    public List<PurchaseStatusDto> entitiesToDtos(List<PurchaseStatus> entities) {
        return utils.entitiesToDtos(entities, this::entityToDto);
    }

    @Override
    public List<PurchaseStatus> dtosToEntities(List<PurchaseStatusDto> dtos) {
        return utils.dtosToEntities(dtos, this::dtoToEntity);
    }
}
