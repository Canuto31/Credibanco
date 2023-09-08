package com.test.credibanco.repository.purchaseStatus;

import com.test.credibanco.model.dto.CardStatusDto;
import com.test.credibanco.model.dto.PurchaseStatusDto;

import java.util.Optional;

public interface PurchaseStatusRepository {

    Optional<PurchaseStatusDto> findByName(String name);
}
