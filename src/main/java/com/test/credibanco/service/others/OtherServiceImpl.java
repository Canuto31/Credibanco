package com.test.credibanco.service.others;

import com.test.credibanco.model.dto.CardStatusDto;
import com.test.credibanco.repository.cardStatus.CardStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OtherServiceImpl implements OtherService{

    @Autowired
    private CardStatusRepository cardStatusRepository;

    @Override
    public int getActiveStatusIdOnTheCard() {
        Optional<CardStatusDto> activeStatus = cardStatusRepository.findByName("Activa");

        return activeStatus.isPresent() ? activeStatus.get().getId() : -1;
    }

    @Override
    public int getLockedStatusIdOnTheCard() {
        Optional<CardStatusDto> activeStatus = cardStatusRepository.findByName("Bloqueada");

        return activeStatus.isPresent() ? activeStatus.get().getId() : -1;
    }
}
