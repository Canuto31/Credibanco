package com.test.credibanco.utils;

import lombok.Getter;

@Getter
public enum CardStatusEnum {

    ACTIVA("Activa"),
    INACTIVA("Inactiva"),
    BLOQUEADA("Bloqueada");

    private final String statusName;

    CardStatusEnum(String statusName) {
        this.statusName = statusName;
    }

}
