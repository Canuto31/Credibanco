package com.test.credibanco.mapper.utils;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class MapperUtils {

    public <T, E> List<T> entitiesToDtos(List<E> entities, Function<E, T> entityToDtoFunction) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream().map(entityToDtoFunction).collect(Collectors.toList());
    }

    public <T, E> List<E> dtosToEntities(List<T> dtos, Function<T, E> dtoToEntityFunction) {
        if (dtos == null) {
            return Collections.emptyList();
        }
        return dtos.stream().map(dtoToEntityFunction).collect(Collectors.toList());
    }

}
