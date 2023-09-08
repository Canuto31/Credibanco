package com.test.credibanco.repository.purchaseStatus;

import com.test.credibanco.mapper.PurchaseStatusMapper;
import com.test.credibanco.model.dto.PurchaseStatusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PurchaseStatusRepositoryImpl implements PurchaseStatusRepository{

    @Autowired
    private PurchaseStatusCrudRepository repository;

    @Autowired
    private PurchaseStatusMapper mapper;

    @Override
    public Optional<PurchaseStatusDto> findByName(String name) {
        return repository.findByName(name).map(purchaseStatus -> mapper.entityToDto(purchaseStatus));
    }
}
