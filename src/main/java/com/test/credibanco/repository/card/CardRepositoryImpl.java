package com.test.credibanco.repository.card;

import com.test.credibanco.mapper.CardMapper;
import com.test.credibanco.model.dto.CardDto;
import com.test.credibanco.model.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CardRepositoryImpl implements CardRepository{

    @Autowired
    private CardCrudRepository repository;

    @Autowired
    private CardMapper mapper;

    @Override
    public CardDto generateCardNumber(CardDto cardDto) {
        Card card = mapper.dtoToEntity(cardDto);
        return mapper.entityToDto(repository.save(card));
    }

    @Override
    public void activateCard(int cardId, int activeStatus) {
        repository.activateCard(cardId, activeStatus);
    }

    @Override
    public void blockCard(int cardId, int lockedStatus) {
        repository.blockCard(cardId, lockedStatus);
    }

    @Override
    public void rechargeCard(int cardId, double newBalance) {
        repository.rechargeCard(cardId, newBalance);
    }

    @Override
    public Optional<CardDto> getCardById(int cardIdr) {
        return repository.findById(cardIdr).map(card -> mapper.entityToDto(card));
    }

    @Override
    public Optional<CardDto> getCardByCardNumber(String cardNumber) {
        return repository.findByCardNumber(cardNumber).map(card -> mapper.entityToDto(card));
    }
}
