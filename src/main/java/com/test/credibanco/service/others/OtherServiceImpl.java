package com.test.credibanco.service.others;

import com.test.credibanco.model.dto.CardStatusDto;
import com.test.credibanco.model.dto.PurchaseStatusDto;
import com.test.credibanco.repository.cardStatus.CardStatusRepository;
import com.test.credibanco.repository.purchaseStatus.PurchaseStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OtherServiceImpl implements OtherService{

    @Autowired
    private CardStatusRepository cardStatusRepository;

    @Autowired
    private PurchaseStatusRepository purchaseStatusRepository;

    @Override
    public Optional<CardStatusDto> getStatusByNameForCard(String name) {
        return cardStatusRepository.findByName(name);
    }

    @Override
    public Optional<PurchaseStatusDto> getStatusByNameForPurchase(String name) {
        return purchaseStatusRepository.findByName(name);
    }
}
