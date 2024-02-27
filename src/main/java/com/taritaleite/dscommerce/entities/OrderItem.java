package com.taritaleite.dscommerce.entities;

import jakarta.persistence.*;
import org.aspectj.weaver.ast.Or;

import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem {

    /*
    Classe de associação com chave primaria multipla/composta com as duas chaves estrangeiras
    de Order e Product
    Requer a criação uma classe a parte para representar a chave primaria OrdemItemPK para representar a chave composta
     */
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();
    private Integer quantity;
    private Double price;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product, Integer quantity, Double price) {

        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public Order getOrder () {
        return id.getOrder();
    }

    public void setOrder (Order order) {
        id.setOrder(order);
    }
    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct (Product product) {
        id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
