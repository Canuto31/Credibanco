package com.test.credibanco.mapper;

import com.test.credibanco.model.dto.PurchaseDto;
import com.test.credibanco.model.response.PurchaseResponse;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PurchaseResponseMapper {

    public PurchaseResponse purchaseDtoToPurchaseResponse(PurchaseDto purchaseDto) {
        PurchaseResponse purchaseResponse = new PurchaseResponse();

        purchaseResponse.setTransactionId(purchaseDto.getTransactionId());
        purchaseResponse.setCardId(purchaseDto.getCard().getCardId());
        purchaseResponse.setPrice(purchaseDto.getPrice());
        purchaseResponse.setTransactionDate(purchaseDto.getTransactionDate());
        purchaseResponse.setPurchaseStatus(purchaseDto.getPurchaseStatus().getName());

        return purchaseResponse;
    }
}
