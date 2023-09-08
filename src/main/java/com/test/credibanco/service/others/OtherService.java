package com.test.credibanco.service.others;

import com.test.credibanco.model.dto.CardStatusDto;
import com.test.credibanco.model.dto.PurchaseStatusDto;

import java.util.Optional;

public interface OtherService {

    Optional<CardStatusDto> getStatusByNameForCard(String name);

    Optional<PurchaseStatusDto> getStatusByNameForPurchase(String name);
}
