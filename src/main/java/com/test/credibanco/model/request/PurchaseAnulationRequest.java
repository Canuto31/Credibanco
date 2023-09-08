package com.test.credibanco.model.request;

import lombok.Getter;

@Getter
public class PurchaseAnulationRequest {

    private String cardId;
    private String transactionId;
}
