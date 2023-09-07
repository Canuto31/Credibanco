package com.test.credibanco.repository.card;

import com.test.credibanco.model.dto.CardDto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CardRepository{

    CardDto generateCardNumber(CardDto cardDto);

    void activateCard(int cardId, int activeStatus);

    void blockCard(int cardId, int lockedStatus);

    void rechargeCard(int cardId, double newBalance);

    Optional<CardDto> getCardById(int cardId);
}
