package com.test.credibanco.repository.cardStatus;

import com.test.credibanco.model.dto.CardStatusDto;

import java.util.Optional;

public interface CardStatusRepository {

    Optional<CardStatusDto> findByName(String name);
}
