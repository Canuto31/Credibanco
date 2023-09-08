package com.test.credibanco.repository.purchase;

import com.test.credibanco.model.dto.CardStatusDto;
import com.test.credibanco.model.dto.PurchaseStatusDto;

public interface PurchaseRepository {

    void changePurchaseStatus(int transactionId, PurchaseStatusDto purchaseStatusDto);
}
