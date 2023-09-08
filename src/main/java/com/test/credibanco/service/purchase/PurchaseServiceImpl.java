package com.test.credibanco.service.purchase;

import com.test.credibanco.mapper.PurchaseResponseMapper;
import com.test.credibanco.model.dto.CardDto;
import com.test.credibanco.model.dto.PurchaseDto;
import com.test.credibanco.model.dto.PurchaseStatusDto;
import com.test.credibanco.model.request.PurchaseMakingRequest;
import com.test.credibanco.model.response.PurchaseResponse;
import com.test.credibanco.repository.purchase.PurchaseRepository;
import com.test.credibanco.service.card.CardService;
import com.test.credibanco.service.others.OtherService;
import com.test.credibanco.utils.CardStatusEnum;
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

    @Autowired
    private PurchaseResponseMapper purchaseResponseMapper;

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
    public PurchaseResponse makeAPurchase(PurchaseMakingRequest request) {
        PurchaseDto purchaseDto = new PurchaseDto();

        Optional<CardDto> cardDtoOptional = cardService.getCardByCardId(request.getCardId());
        purchaseDto.setCard(cardDtoOptional.orElse(null));

        if (purchaseDto.getCard() == null) {
            return createErrorResponse("La tarjeta no está disponible");
        } else if (purchaseDto.getCard().getCardStatus() == null) {
            return createErrorResponse("El estado de la tarjeta no está disponible");
        } else if (purchaseDto.getCard().getCardStatus().getName().equals(CardStatusEnum.INACTIVA.getStatusName()) ||
                purchaseDto.getCard().getCardStatus().getName().equals(CardStatusEnum.BLOQUEADA.getStatusName())) {
            return createErrorResponse("Esta tarjeta no se encuentra activa");
        } else if (purchaseDto.getCard().getBalance() < Double.parseDouble(request.getPrice())) {
            return createErrorResponse("Saldo insuficiente para realizar la compra");
        } else if (purchaseDto.getCard().getOwner() == null) {
            return createErrorResponse("Esta tarjeta no cuenta con propietario");
        }

        purchaseDto.setPrice(Double.parseDouble(request.getPrice()));
        purchaseDto.setTransactionDate(new Date());

        Optional<PurchaseStatusDto> purchaseStatusDtoOptional = otherService.getStatusByNameForPurchase(PurchaseStatusEnum.APROBADA.getStatusName());
        purchaseDto.setPurchaseStatus(purchaseStatusDtoOptional.orElse(null));

        cardService.rechargeCard(request.getCardId(), (Double.parseDouble(request.getPrice()) * -1));

        return purchaseResponseMapper.purchaseDtoToPurchaseResponse(repository.generatePurchase(purchaseDto));
    }

    @Override
    public Optional<PurchaseResponse> getPurchaseByTransactionId(int transactionId) {
        Optional<PurchaseDto> purchaseDto = repository.getPurchaseById(transactionId);
        return purchaseDto.map(purchaseResponseMapper::purchaseDtoToPurchaseResponse);
    }

    private PurchaseResponse createErrorResponse(String errorMessage) {
        PurchaseResponse response = new PurchaseResponse();
        response.setErrorMessage(errorMessage);
        return response;
    }
}
