package com.test.credibanco.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "estado_tarjeta")
@Data
public class CardStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String name;

    @OneToMany(mappedBy = "cardStatus")
    private List<Card> cards;
}
