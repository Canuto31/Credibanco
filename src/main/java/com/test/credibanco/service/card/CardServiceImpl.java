package com.test.credibanco.service.card;

import com.test.credibanco.model.dto.CardDto;
import com.test.credibanco.repository.card.CardRepository;
import com.test.credibanco.service.others.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository repository;

    @Autowired
    private OtherService otherService;

    @Override
    public CardDto generateCardNumber(int cardId) {
        CardDto cardDto = new CardDto();

        StringBuilder randomNumbers = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(10);
            randomNumbers.append(randomNumber);
        }

        String cardNumber = String.format("%06d%s", cardId, randomNumbers.toString());

        cardDto.setCardNumber(Integer.parseInt(cardNumber));

        return repository.generateCardNumber(cardDto);
    }

    @Override
    public boolean activateCard(int cardId) {
        int idActiveStatus = otherService.getActiveStatusIdOnTheCard();

        if (idActiveStatus == -1) {
            return false;
        }

        return repository.getCardById(cardId).map(card -> {
            repository.activateCard(cardId, idActiveStatus);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean blockCard(int cardId) {
        int idLockedStatus = otherService.getLockedStatusIdOnTheCard();

        if (idLockedStatus == -1) {
            return false;
        }

        return repository.getCardById(cardId).map(card -> {
            repository.blockCard(cardId, idLockedStatus);
            return true;
        }).orElse(false);
    }

    @Override
    public boolean rechargeCard(int cardId, double newBalance) {
        return false;
    }

    @Override
    public Optional<CardDto> getCardById(int cardId) {
        return Optional.empty();
    }
}
