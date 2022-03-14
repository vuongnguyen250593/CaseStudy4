package com.example.casestudy4_springboot.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @DateTimeFormat(pattern = "MM/dd/YYYY")
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Date date;

    @Size(max = 100, message = "The text is max 100 characters")
    private String note;

    @NotNull
    @ManyToOne
    private StatusBill statusBill;

    private double total;


    public Bill() {
    }

    public Bill(Long id, User user, Date date, String note, StatusBill statusBill, double total) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.note = note;
        this.statusBill = statusBill;
        this.total = total;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public StatusBill getStatus() {
        return statusBill;
    }

    public void setStatus(StatusBill statusBill) {
        this.statusBill = statusBill;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
