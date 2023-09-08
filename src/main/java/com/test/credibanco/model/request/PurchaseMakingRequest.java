package com.test.credibanco.model.request;

import lombok.Data;

@Data
public class PurchaseMakingRequest {

    private String cardId;
    private String price;
}
