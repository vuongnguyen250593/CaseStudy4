package com.example.casestudy4_springboot.model;


import javax.persistence.*;

@Entity
@Table(name = "liked")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    private StatusLike statusLike;


    public Like() {
    }

    public Like(Long id, User user, Product product, StatusLike statusLike) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.statusLike = statusLike;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public StatusLike getStatusLike() {
        return statusLike;
    }

    public void setStatusLike(StatusLike statusLike) {
        this.statusLike = statusLike;
    }
}