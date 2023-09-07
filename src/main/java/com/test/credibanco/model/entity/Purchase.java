package com.test.credibanco.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "compra")
@Data
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha_transaccion")
    private Date transactionDate;

    @ManyToOne
    @JoinColumn(name = "tarjeta")
    private Card card;

    @ManyToOne
    @JoinColumn(name = "estado_compra")
    private PurchaseStatus purchaseStatus;
}
