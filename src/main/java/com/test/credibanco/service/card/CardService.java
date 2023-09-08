package com.test.credibanco.service.card;

import com.test.credibanco.model.dto.CardDto;
import com.test.credibanco.model.response.CheckCardBalanceResponse;
import com.test.credibanco.utils.CardStatusEnum;

import java.util.Optional;

public interface CardService {

    CardDto generateCardNumber(int productId);

    boolean changeCardStatus(String cardId, CardStatusEnum cardStatusEnum);

    boolean rechargeCard(String cardId, double newBalance);

    Optional<CheckCardBalanceResponse> getCardBalanceByCardId(String cardId);

    Optional<CardDto> getCardByCardId(String cardId);
}
