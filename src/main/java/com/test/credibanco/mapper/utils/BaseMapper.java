package com.test.credibanco.mapper.utils;

import java.util.List;

public interface BaseMapper<D, E> {

    public D entityToDto(E entity);

    public E dtoToEntity(D dto);

    public List<D> entitiesToDtos(List<E> entities);

    public List<E> dtosToEntities(List<D> dtos);
}
