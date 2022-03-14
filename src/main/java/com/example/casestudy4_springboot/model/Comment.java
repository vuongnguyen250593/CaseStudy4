package com.example.casestudy4_springboot.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @Size(min = 1, max = 50, message = "Description is max 100 characters")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


    public Comment(Long id, User user_id, String comment, Product product) {
        this.id = id;
        this.user_id = user_id;
        this.comment = comment;
        this.product = product;
    }

    public Comment() {
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
