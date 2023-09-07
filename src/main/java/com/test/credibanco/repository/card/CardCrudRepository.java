package com.test.credibanco.repository.card;

import com.test.credibanco.model.entity.Card;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CardCrudRepository extends CrudRepository<Card, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Card c SET c.cardStatus = :activeStatus WHERE c.id = :cardId")
    void activateCard(int cardId, int activeStatus);

    @Modifying
    @Transactional
    @Query("UPDATE Card c SET c.cardStatus = :lockedStatus WHERE c.id = :cardId")
    void blockCard(int cardId, int lockedStatus);

    @Modifying
    @Transactional
    @Query("UPDATE Card c SET c.balance = :newBalance WHERE c.id = :cardId")
    void rechargeCard(int cardId, double newBalance);
}
