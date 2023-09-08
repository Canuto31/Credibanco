package com.test.credibanco.mapper;

import com.test.credibanco.mapper.utils.BaseMapper;
import com.test.credibanco.mapper.utils.MapperUtils;
import com.test.credibanco.model.dto.CardDto;
import com.test.credibanco.model.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CardMapper implements BaseMapper<CardDto, Card> {

    @Lazy
    @Autowired
    private MapperUtils utils;

    @Lazy
    @Autowired
    private OwnerMapper ownerMapper;

    @Lazy
    @Autowired
    private CardStatusMapper cardStatusMapper;


    @Override
    public CardDto entityToDto(Card entity) {
        CardDto dto = new CardDto();

        dto.setProductId(entity.getProductId());
        dto.setCardId(entity.getCardId());
        dto.setBalance(entity.getBalance());
        dto.setCreationDate(entity.getCreationDate());
        dto.setExpirationDate(entity.getExpirationDate());

        dto.setOwner(ownerMapper.entityToDto(entity.getOwner()));
        dto.setCardStatus(cardStatusMapper.entityToDto(entity.getCardStatus()));

        return dto;
    }

    @Override
    public Card dtoToEntity(CardDto dto) {
        Card entity = new Card();

        entity.setProductId(dto.getProductId());
        entity.setCardId(dto.getCardId());
        entity.setBalance(dto.getBalance());
        entity.setCreationDate(dto.getCreationDate());
        entity.setExpirationDate(dto.getExpirationDate());

        entity.setOwner(ownerMapper.dtoToEntity(dto.getOwner()));
        entity.setCardStatus(cardStatusMapper.dtoToEntity(dto.getCardStatus()));

        return entity;
    }

    @Override
    public List<CardDto> entitiesToDtos(List<Card> entities) {
        return utils.entitiesToDtos(entities, this::entityToDto);
    }

    @Override
    public List<Card> dtosToEntities(List<CardDto> dtos) {
        return utils.dtosToEntities(dtos, this::dtoToEntity);
    }
}
