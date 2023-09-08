package com.test.credibanco.repository.purchaseStatus;

import com.test.credibanco.model.entity.PurchaseStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PurchaseStatusCrudRepository extends CrudRepository<PurchaseStatus, Integer> {

    Optional<PurchaseStatus> findByName(String nombre);
}
