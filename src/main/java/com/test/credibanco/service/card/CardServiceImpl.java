package com.test.credibanco.service.card;

import com.test.credibanco.model.dto.CardDto;
import com.test.credibanco.model.dto.CardStatusDto;
import com.test.credibanco.model.response.CheckCardBalanceResponse;
import com.test.credibanco.repository.card.CardRepository;
import com.test.credibanco.service.others.OtherService;
import com.test.credibanco.utils.CardStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository repository;

    @Autowired
    private OtherService otherService;

    @Override
    public CardDto generateCardNumber(int productId) {
        CardDto cardDto = new CardDto();

        StringBuilder randomNumbers = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(10);
            randomNumbers.append(randomNumber);
        }

        String cardId = String.format("%06d%s", productId, randomNumbers.toString());

        cardDto.setCardId(cardId);
        cardDto.setProductId(productId);

        Date creationDate = new Date();
        cardDto.setCreationDate(new Date());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(creationDate);
        calendar.add(Calendar.YEAR, 3);
        Date expirationDate = calendar.getTime();
        cardDto.setExpirationDate(expirationDate);

        cardDto.setBalance(0.0);

        Optional<CardStatusDto> InactiveStatusOptional = otherService.getStatusByName("Inactiva");
        cardDto.setCardStatus(InactiveStatusOptional.orElse(null));

        return repository.generateCardNumber(cardDto);
    }

    @Override
    public boolean changeCardStatus(String cardId, CardStatusEnum cardStatusEnum) {
        Optional<CardStatusDto> lockedStatusOptional = otherService.getStatusByName(cardStatusEnum.getStatusName());

        return repository.getCardByCardId(cardId).map(card -> {
            repository.changeCardStatus(cardId, lockedStatusOptional.orElse(null));
            return true;
        }).orElse(false);
    }

    @Override
    public boolean rechargeCard(String cardId, double newBalance) {
        return repository.getCardByCardId(cardId).map(card -> {
            repository.rechargeCard(card.getCardId(), card.getBalance() + newBalance);
            return true;
        }).orElse(false);
    }

    @Override
    public Optional<CheckCardBalanceResponse> getCardBalanceByCardId(String cardId) {
        return repository.getCardByCardId(cardId)
                .map(cardDto -> {
                    CheckCardBalanceResponse response = new CheckCardBalanceResponse();
                    response.setBalance(Double.toString(cardDto.getBalance()));
                    return response;
                });
    }
}
