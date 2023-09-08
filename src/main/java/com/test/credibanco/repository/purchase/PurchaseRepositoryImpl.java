package com.test.credibanco.repository.purchase;

import com.test.credibanco.mapper.PurchaseMapper;
import com.test.credibanco.mapper.PurchaseStatusMapper;
import com.test.credibanco.model.dto.PurchaseDto;
import com.test.credibanco.model.dto.PurchaseStatusDto;
import com.test.credibanco.model.entity.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PurchaseRepositoryImpl implements PurchaseRepository{

    @Autowired
    private PurchaseCrudRepository repository;

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Autowired
    private PurchaseStatusMapper purchaseStatusMapper;

    @Override
    public PurchaseDto generatePurchase(PurchaseDto purchaseDto) {
        Purchase purchase = purchaseMapper.dtoToEntity(purchaseDto);
        return purchaseMapper.entityToDto(repository.save(purchase));
    }

    @Override
    public Optional<PurchaseDto> getPurchaseById(int transactionId) {
        return repository.findById(transactionId).map(purchase -> purchaseMapper.entityToDto(purchase));
    }

    @Override
    public void changePurchaseStatus(int transactionId, PurchaseStatusDto purchaseStatusDto) {
        repository.changePurchaseStatus(transactionId, purchaseStatusMapper.dtoToEntity(purchaseStatusDto));
    }
}
