package com.test.credibanco.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CardDto {

    private Integer id;

    private String cardId;

    private OwnerDto owner;

    private Date creationDate;

    private Date ExpirationDate;

    private Double balance;

    private CardStatusDto cardStatus;
}
