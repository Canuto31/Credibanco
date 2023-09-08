package com.test.credibanco.model.response;

import com.test.credibanco.model.dto.PurchaseStatusDto;
import lombok.Data;

import java.util.Date;

@Data
public class PurchaseResponse {

    private Integer transactionId;

    private String cardId;

    private double price;

    private Date transactionDate;

    private String purchaseStatus;

    private String errorMessage;
}
