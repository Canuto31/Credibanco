package com.test.credibanco.utils;

public enum CardStatusEnum {

    ACTIVA("Activa"),
    INACTIVA("Inactiva"),
    BLOQUEADA("Bloqueada");

    private final String statusName;

    CardStatusEnum(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}
