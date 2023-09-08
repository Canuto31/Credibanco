package com.test.credibanco.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tarjeta")
@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero_tarjeta")
    private String cardId;

    @ManyToOne
    @JoinColumn(name = "titular")
    private Owner owner;

    @Column(name = "fecha_creacion")
    private Date creationDate;

    @Column(name = "fecha_vencimiento")
    private Date expirationDate;

    @Column(name = "saldo")
    private Double balance;

    @ManyToOne
    @JoinColumn(name = "estado_tarjeta")
    private CardStatus cardStatus;

    @OneToMany(mappedBy = "card")
    private List<Purchase> purchases;
}
