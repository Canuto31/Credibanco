package com.test.credibanco.service.card;

import com.test.credibanco.model.dto.CardDto;
import com.test.credibanco.model.response.CheckCardBalanceResponse;

import java.util.Optional;

public interface CardService {

    CardDto generateCardNumber(int cardId);

    boolean activateCard(int cardId);

    boolean blockCard(int cardId);

    boolean rechargeCard(String cardNumber, double newBalance);

    Optional<CheckCardBalanceResponse> getCardBalanceById(int cardId);
}
