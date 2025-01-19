package com.estudos.dscommerce.entities;


import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;
    private OrderStatus status;

    //relacionamento muitos para um com a classe User
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Order() {
    }

    public Order(Long id, Instant moment, OrderStatus status, User client) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public Instant getMoment() {
        return moment;
    }

    public Order setMoment(Instant moment) {
        this.moment = moment;
        return this;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Order setStatus(OrderStatus status) {
        this.status = status;
        return this;
    }

    public User getClient() {
        return client;
    }

    public Order setClient(User client) {
        this.client = client;
        return this;
    }
}
