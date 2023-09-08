package com.test.credibanco.repository.purchase;

import com.test.credibanco.model.entity.CardStatus;
import com.test.credibanco.model.entity.Purchase;
import com.test.credibanco.model.entity.PurchaseStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseCrudRepository extends CrudRepository<Purchase, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Purchase p SET p.purchaseStatus = :purchaseStatus WHERE p.transactionId = :transactionId")
    void changePurchaseStatus(int transactionId, PurchaseStatus purchaseStatus);
}
