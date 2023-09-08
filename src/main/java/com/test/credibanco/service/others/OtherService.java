package com.test.credibanco.service.others;

import com.test.credibanco.model.dto.CardStatusDto;

import java.util.Optional;

public interface OtherService {

    Optional<CardStatusDto> getStatusByName(String name);
}
