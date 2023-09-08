package com.test.credibanco.repository.card;

import com.test.credibanco.model.dto.CardDto;
import com.test.credibanco.model.dto.CardStatusDto;

import java.util.Optional;

public interface CardRepository{

    CardDto generateCardNumber(CardDto cardDto);

    void changeCardStatus(String cardId, CardStatusDto cardStatusDto);

    void rechargeCard(String cardId, double newBalance);

    Optional<CardDto> getCardByCardId(String cardId);
}
