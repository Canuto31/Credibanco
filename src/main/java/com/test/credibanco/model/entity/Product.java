package com.test.credibanco.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "producto")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "precio")
    private Double price;

    @Column(name = "cantidad_disponible")
    private Integer amount;

    @ManyToMany(mappedBy = "products")
    private List<Purchase> purchases;
}
