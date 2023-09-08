package com.test.credibanco.repository.card;

import com.test.credibanco.model.entity.Card;
import com.test.credibanco.model.entity.CardStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CardCrudRepository extends CrudRepository<Card, String> {

    Optional<Card> findByCardId(String cardId);

    @Modifying
    @Transactional
    @Query("UPDATE Card c SET c.cardStatus = :cardStatus WHERE c.cardId = :cardId")
    void changeCardStatus(String cardId, CardStatus cardStatus);

    @Modifying
    @Transactional
    @Query("UPDATE Card c SET c.balance = :newBalance WHERE c.cardId = :cardId")
    void rechargeCard(String cardId, double newBalance);
}
