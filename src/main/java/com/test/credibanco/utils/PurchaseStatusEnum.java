package com.test.credibanco.utils;

import lombok.Getter;

@Getter
public enum PurchaseStatusEnum {

    APROBADA("Aprobada"),
    ANULADA("Anulada");

    private final String statusName;

    PurchaseStatusEnum(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}
