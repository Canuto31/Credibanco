package com.test.credibanco.mapper;

import com.test.credibanco.mapper.utils.BaseMapper;
import com.test.credibanco.mapper.utils.MapperUtils;
import com.test.credibanco.model.dto.ProductDto;
import com.test.credibanco.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper implements BaseMapper<ProductDto, Product> {

    @Lazy
    @Autowired
    private MapperUtils utils;

    @Override
    public ProductDto entityToDto(Product entity) {
        ProductDto dto = new ProductDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setAmount(entity.getAmount());

        return dto;
    }

    @Override
    public Product dtoToEntity(ProductDto dto) {
        Product entity = new Product();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setAmount(dto.getAmount());

        return entity;
    }

    @Override
    public List<ProductDto> entitiesToDtos(List<Product> entities) {
        return utils.entitiesToDtos(entities, this::entityToDto);
    }

    @Override
    public List<Product> dtosToEntities(List<ProductDto> dtos) {
        return utils.dtosToEntities(dtos, this::dtoToEntity);
    }
}
