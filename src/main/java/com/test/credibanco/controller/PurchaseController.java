package com.test.credibanco.controller;

import com.test.credibanco.model.dto.PurchaseDto;
import com.test.credibanco.model.request.PurchaseAnulationRequest;
import com.test.credibanco.model.request.PurchaseMakingRequest;
import com.test.credibanco.model.response.PurchaseResponse;
import com.test.credibanco.service.purchase.PurchaseService;
import com.test.credibanco.utils.PurchaseStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class PurchaseController {

    @Autowired
    private PurchaseService service;

    @PostMapping("/purchase")
    private ResponseEntity<PurchaseResponse> generatePurchase(@RequestBody PurchaseMakingRequest request) {
        return new ResponseEntity<>(service.makeAPurchase(request), HttpStatus.OK);
    }

    @GetMapping("/{transactionId}")
    private ResponseEntity<PurchaseResponse> getPurchaseByTransactionId(@PathVariable int transactionId) {
        return service.getPurchaseByTransactionId(transactionId).map(purchase -> new ResponseEntity<>(purchase, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/anulation")
    private ResponseEntity<String> anulatePurchase(@RequestBody PurchaseAnulationRequest request) {
        return new ResponseEntity<>(service.changePurchaseStatus(Integer.parseInt(request.getTransactionId()), PurchaseStatusEnum.ANULADA) ? "Anulated" : "Not Found", service.changePurchaseStatus(Integer.parseInt(request.getCardId()), PurchaseStatusEnum.ANULADA) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
