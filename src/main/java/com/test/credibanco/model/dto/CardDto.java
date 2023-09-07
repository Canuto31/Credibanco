package com.test.credibanco.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CardDto {

    private Integer id;

    private Integer cardNumber;

    private OwnerDto owner;

    private Date creationDate;

    private Date ExpirationDate;

    private Double balance;

    private CardStatusDto cardStatus;
}
