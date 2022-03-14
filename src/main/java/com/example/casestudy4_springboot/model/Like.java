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
    private User user_id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    private StatusLike statusLike;


    public Like() {
    }

    public Like(Long id, User user_id, Product product, StatusLike statusLike) {
        this.id = id;
        this.user_id = user_id;
        this.product = product;
        this.statusLike = statusLike;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
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
