package com.test.credibanco.service.purchase;

import com.test.credibanco.model.dto.PurchaseDto;
import com.test.credibanco.model.request.PurchaseMakingRequest;
import com.test.credibanco.model.response.PurchaseResponse;
import com.test.credibanco.utils.PurchaseStatusEnum;

import java.util.Optional;

public interface PurchaseService {

    boolean changePurchaseStatus(int transactionId, PurchaseStatusEnum purchaseStatusEnum);

    PurchaseResponse makeAPurchase(PurchaseMakingRequest request);

    Optional<PurchaseResponse> getPurchaseByTransactionId(int transactionId);
}
