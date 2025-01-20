package com.estudos.dscommerce.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //A coluna vai aceitar um texto longo
    @Column(columnDefinition = "TEXT")
    private String description;
    private Double price;
    private String imgUrl;

    //para não ocorrer repetição de categorias id, JoinColumn é para criar uma chave estrangeira
    @ManyToMany
    @JoinTable(name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    //relacionamento um para muitos com a classe OrderItem pelo id do produto
    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> items = new HashSet<>();

    public Product() {
    }

    public Product(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Product setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Product setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    // A partir de um pruduto pode dar um get em um pedido
    public Set<OrderItem> getItems() {
        return items;
    }

    //converte os elementos do tipo item para os pedidos com uma nova lista de pedidos
    public List<Order> getOrders() {
        return items.stream().map(x -> x.getOrder()).toList();
    }
}
