package com.taritaleite.dscommerce.entities;

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

    /*Para realizar o relacionamento de muitos para um
        A classe order possui um usuário
        @JoinColun indica a o nome da chave estrangeira
        @ManyToOne inclui na tabela order um campo com o nome da chave estrangeira
     */
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

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }
}