package com.test.credibanco.service.purchase;

import com.test.credibanco.model.dto.PurchaseDto;
import com.test.credibanco.model.request.PurchaseMakingRequest;
import com.test.credibanco.utils.PurchaseStatusEnum;

import java.util.Optional;

public interface PurchaseService {

    boolean changePurchaseStatus(int transactionId, PurchaseStatusEnum purchaseStatusEnum);

    PurchaseDto makeAPurchase(PurchaseMakingRequest request);

    Optional<PurchaseDto> getPurchaseByTransactionId(int transactionId);
}
