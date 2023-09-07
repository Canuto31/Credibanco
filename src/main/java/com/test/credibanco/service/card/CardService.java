package com.test.credibanco.service.card;

import com.test.credibanco.model.dto.CardDto;

import java.util.Optional;

public interface CardService {

    CardDto generateCardNumber(int cardId);

    boolean activateCard(int cardId);

    boolean blockCard(int cardId);

    boolean rechargeCard(int cardId, double newBalance);

    Optional<CardDto> getCardById(int cardId);
}
