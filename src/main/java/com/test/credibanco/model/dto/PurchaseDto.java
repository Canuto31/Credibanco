package com.test.credibanco.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PurchaseDto {

    private Integer transactionId;

    private CardDto card;

    private double price;

    private Date transactionDate;

    private PurchaseStatusDto purchaseStatus;
}
