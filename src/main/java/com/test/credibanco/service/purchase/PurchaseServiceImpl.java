package com.test.credibanco.service.purchase;

import com.test.credibanco.model.dto.CardDto;
import com.test.credibanco.model.dto.PurchaseDto;
import com.test.credibanco.model.dto.PurchaseStatusDto;
import com.test.credibanco.model.request.PurchaseMakingRequest;
import com.test.credibanco.repository.purchase.PurchaseRepository;
import com.test.credibanco.service.card.CardService;
import com.test.credibanco.service.others.OtherService;
import com.test.credibanco.utils.PurchaseStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PurchaseServiceImpl implements PurchaseService{

    @Autowired
    private PurchaseRepository repository;

    @Autowired
    private CardService cardService;

    @Autowired
    private OtherService otherService;

    @Override
    public boolean changePurchaseStatus(int transactionId, PurchaseStatusEnum purchaseStatusEnum) {
        Optional<PurchaseStatusDto> anulatedStatusOptional = otherService.getStatusByNameForPurchase(purchaseStatusEnum.getStatusName());

        return repository.getPurchaseById(transactionId).map(purchase -> {
            repository.changePurchaseStatus(transactionId, anulatedStatusOptional.orElse(null));
            cardService.rechargeCard(purchase.getCard().getCardId(), purchase.getPrice());
            return true;
        }).orElse(false);
    }

    @Override
    public PurchaseDto makeAPurchase(PurchaseMakingRequest request) {
        PurchaseDto purchaseDto = new PurchaseDto();

        Optional<CardDto> cardDtoOptional = cardService.getCardByCardId(request.getCardId());
        purchaseDto.setCard(cardDtoOptional.orElse(null));

        purchaseDto.setPrice(Double.parseDouble(request.getPrice()));
        purchaseDto.setTransactionDate(new Date());

        Optional<PurchaseStatusDto> purchaseStatusDtoOptional = otherService.getStatusByNameForPurchase(PurchaseStatusEnum.APROBADA.getStatusName());
        purchaseDto.setPurchaseStatus(purchaseStatusDtoOptional.orElse(null));

        cardService.rechargeCard(request.getCardId(), (Double.parseDouble(request.getPrice()) * -1));

        return repository.generatePurchase(purchaseDto);
    }

    @Override
    public Optional<PurchaseDto> getPurchaseByTransactionId(int transactionId) {
        return repository.getPurchaseById(transactionId);
    }
}
