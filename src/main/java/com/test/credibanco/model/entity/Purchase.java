package com.test.credibanco.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

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

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "compra_producto",joinColumns = @JoinColumn(name = "id_compra"), inverseJoinColumns = @JoinColumn(name = "id_producto"))
    private List<Product> products;
}
