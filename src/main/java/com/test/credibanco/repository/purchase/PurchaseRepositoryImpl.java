package com.test.credibanco.repository.purchase;

import com.test.credibanco.mapper.PurchaseMapper;
import com.test.credibanco.mapper.PurchaseStatusMapper;
import com.test.credibanco.model.dto.PurchaseStatusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseRepositoryImpl implements PurchaseRepository{

    @Autowired
    private PurchaseCrudRepository repository;

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Autowired
    private PurchaseStatusMapper purchaseStatusMapper;

    @Override
    public void changePurchaseStatus(int transactionId, PurchaseStatusDto purchaseStatusDto) {
        repository.changePurchaseStatus(transactionId, purchaseStatusMapper.dtoToEntity(purchaseStatusDto));
    }
}
