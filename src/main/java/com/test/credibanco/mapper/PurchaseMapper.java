package com.test.credibanco.mapper;

import com.test.credibanco.mapper.utils.BaseMapper;
import com.test.credibanco.mapper.utils.MapperUtils;
import com.test.credibanco.model.dto.PurchaseDto;
import com.test.credibanco.model.entity.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PurchaseMapper implements BaseMapper<PurchaseDto, Purchase> {

    @Lazy
    @Autowired
    private MapperUtils utils;

    @Lazy
    @Autowired
    private CardMapper cardMapper;

    @Lazy
    @Autowired
    private PurchaseStatusMapper purchaseStatusMapper;

    @Override
    public PurchaseDto entityToDto(Purchase entity) {
        PurchaseDto dto = new PurchaseDto();

        dto.setTransactionId(entity.getTransactionId());
        dto.setCard(cardMapper.entityToDto(entity.getCard()));
        dto.setTransactionDate(entity.getTransactionDate());
        dto.setPrice(entity.getPrice());
        dto.setPurchaseStatus(purchaseStatusMapper.entityToDto(entity.getPurchaseStatus()));

        return dto;
    }

    @Override
    public Purchase dtoToEntity(PurchaseDto dto) {
        Purchase entity = new Purchase();

        entity.setTransactionId(dto.getTransactionId());
        entity.setCard(cardMapper.dtoToEntity(dto.getCard()));
        entity.setTransactionDate(dto.getTransactionDate());
        entity.setPrice(dto.getPrice());
        entity.setPurchaseStatus(purchaseStatusMapper.dtoToEntity(dto.getPurchaseStatus()));

        return entity;
    }

    @Override
    public List<PurchaseDto> entitiesToDtos(List<Purchase> entities) {
        return utils.entitiesToDtos(entities, this::entityToDto);
    }

    @Override
    public List<Purchase> dtosToEntities(List<PurchaseDto> dtos) {
        return utils.dtosToEntities(dtos, this::dtoToEntity);
    }
}
