package com.example.casestudy4_springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "status_like")
public class StatusLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long s_id;

    private String s_image;

    public StatusLike() {
    }

    public StatusLike(Long s_id, String s_image) {
        this.s_id = s_id;
        this.s_image = s_image;
    }

    public Long getS_id() {
        return s_id;
    }

    public void setS_id(Long s_id) {
        this.s_id = s_id;
    }

    public String getS_image() {
        return s_image;
    }

    public void setS_image(String s_image) {
        this.s_image = s_image;
    }
}