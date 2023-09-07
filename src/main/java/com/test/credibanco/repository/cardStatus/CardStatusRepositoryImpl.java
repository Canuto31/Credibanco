package com.test.credibanco.repository.cardStatus;

import com.test.credibanco.mapper.CardStatusMapper;
import com.test.credibanco.model.dto.CardStatusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CardStatusRepositoryImpl implements CardStatusRepository {

    @Autowired
    private CardStatusCrudRepository repository;

    @Autowired
    private CardStatusMapper mapper;

    @Override
    public Optional<CardStatusDto> findByName(String name) {
        return repository.findByName(name).map(cardStatus -> mapper.entityToDto(cardStatus));
    }
}
