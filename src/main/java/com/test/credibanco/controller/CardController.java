package com.test.credibanco.controller;

import com.test.credibanco.model.dto.CardDto;
import com.test.credibanco.model.request.CardActivationRequest;
import com.test.credibanco.model.request.CardRechargeRequest;
import com.test.credibanco.model.response.CheckCardBalanceResponse;
import com.test.credibanco.service.card.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService service;

    @GetMapping("/{cardId}/number")
    private ResponseEntity<CardDto> generateCardNumber(@PathVariable int cardId) {
        return new ResponseEntity<>(service.generateCardNumber(cardId), HttpStatus.OK);
    }

    @PostMapping("/enroll")
    private ResponseEntity<String> activateCard(@RequestBody CardActivationRequest request) {
        return new ResponseEntity<>(service.activateCard(Integer.parseInt(request.getCardId())) ? "Activated" : "Not found", service.activateCard(Integer.parseInt(request.getCardId())) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{cardId}")
    private ResponseEntity<String> blockCard(@PathVariable int cardId) {
        return new ResponseEntity<>(service.blockCard(cardId) ? "locked" : "Not found", service.blockCard(cardId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping("/balance")
    private ResponseEntity<String> rechargeCard(@RequestBody CardRechargeRequest request) {
        return new ResponseEntity<>(service.rechargeCard(request.getCardId(), Double.parseDouble(request.getBalance())) ? "recharged" : "Not found", service.rechargeCard(request.getCardId(), Double.parseDouble(request.getBalance())) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/balance/{cardId}")
    private ResponseEntity<CheckCardBalanceResponse> checkCardBalance(@PathVariable String cardId) {
        return service.getCardBalanceById(Integer.parseInt(cardId)).map(cardBalance -> new ResponseEntity<>(cardBalance, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
