package com.test.credibanco.repository.cardStatus;

import com.test.credibanco.model.entity.CardStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CardStatusCrudRepository extends CrudRepository<CardStatus, Integer> {

    Optional<CardStatus> findByName(String nombre);
}
