package com.test.credibanco.repository.purchase;

import com.test.credibanco.model.dto.CardStatusDto;
import com.test.credibanco.model.dto.PurchaseDto;
import com.test.credibanco.model.dto.PurchaseStatusDto;

import java.util.Optional;

public interface PurchaseRepository {

    PurchaseDto generatePurchase(PurchaseDto purchaseDto);

    Optional<PurchaseDto> getPurchaseById(int transactionId);

    void changePurchaseStatus(int transactionId, PurchaseStatusDto purchaseStatusDto);


}
