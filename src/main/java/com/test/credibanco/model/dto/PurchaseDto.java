package com.test.credibanco.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PurchaseDto {

    private Integer id;

    private Date transactionDate;

    private CardDto card;

    private PurchaseStatusDto purchaseStatus;
}
