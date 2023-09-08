package com.test.credibanco.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "compra")
@Data
public class Purchase {

    @Id
    @Column(name ="id_transaccion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;

    @ManyToOne
    @JoinColumn(name = "tarjeta")
    private Card card;

    @Column(name = "precio")
    private double price;

    @Column(name = "fecha_transaccion")
    private Date transactionDate;

    @ManyToOne
    @JoinColumn(name = "estado_compra")
    private PurchaseStatus purchaseStatus;
}
