package com.example.casestudy4_springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "status_bill")
public class StatusBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long s_id;

    private String s_name;

    public StatusBill() {
    }

    public StatusBill(Long s_id, String s_name) {
        this.s_id = s_id;
        this.s_name = s_name;
    }

    public Long getS_id() {
        return s_id;
    }

    public void setS_id(Long s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }
}
