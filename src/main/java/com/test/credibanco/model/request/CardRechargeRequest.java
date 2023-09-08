package com.test.credibanco.model.request;

import lombok.Data;

@Data
public class CardRechargeRequest {

    private String cardId;
    private String balance;
}
