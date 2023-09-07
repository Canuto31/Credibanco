package com.test.credibanco.mapper;

import com.test.credibanco.mapper.utils.BaseMapper;
import com.test.credibanco.mapper.utils.MapperUtils;
import com.test.credibanco.model.dto.CardStatusDto;
import com.test.credibanco.model.entity.CardStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CardStatusMapper implements BaseMapper<CardStatusDto, CardStatus> {

    @Lazy
    @Autowired
    private MapperUtils mapperUtils;

    @Override
    public CardStatusDto entityToDto(CardStatus entity) {
        CardStatusDto dto = new CardStatusDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }

    @Override
    public CardStatus dtoToEntity(CardStatusDto dto) {
        CardStatus entity = new CardStatus();

        entity.setId(dto.getId());
        entity.setName(dto.getName());

        return entity;
    }

    @Override
    public List<CardStatusDto> entitiesToDtos(List<CardStatus> entities) {
        return mapperUtils.entitiesToDtos(entities, this::entityToDto);
    }

    @Override
    public List<CardStatus> dtosToEntities(List<CardStatusDto> dtos) {
        return mapperUtils.dtosToEntities(dtos, this::dtoToEntity);
    }
}
