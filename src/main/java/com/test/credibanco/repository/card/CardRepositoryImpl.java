package com.test.credibanco.repository.card;

import com.test.credibanco.mapper.CardMapper;
import com.test.credibanco.mapper.CardStatusMapper;
import com.test.credibanco.model.dto.CardDto;
import com.test.credibanco.model.dto.CardStatusDto;
import com.test.credibanco.model.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CardRepositoryImpl implements CardRepository{

    @Autowired
    private CardCrudRepository repository;

    @Autowired
    private CardMapper cardMapper;

    @Autowired
    private CardStatusMapper cardStatusMapper;

    @Override
    public CardDto generateCardNumber(CardDto cardDto) {
        Card card = cardMapper.dtoToEntity(cardDto);
        return cardMapper.entityToDto(repository.save(card));
    }

    @Override
    public void changeCardStatus(String cardId, CardStatusDto cardStatusDto) {
        repository.changeCardStatus(cardId, cardStatusMapper.dtoToEntity(cardStatusDto));
    }

    @Override
    public void rechargeCard(String cardId, double newBalance) {
        repository.rechargeCard(cardId, newBalance);
    }

    @Override
    public Optional<CardDto> getCardByCardId(String cardId) {
        return repository.findByCardId(cardId).map(card -> cardMapper.entityToDto(card));
    }
}
