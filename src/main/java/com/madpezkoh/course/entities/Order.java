package com.madpezkoh.course.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",
            timezone = "GMT")
    private Instant issuedAt;

    @ManyToOne @JoinColumn(name = "client_id")
    private User client;


    @Deprecated
    public Order() {}

    public Order(Long id, Instant issuedAt, User client) {
        this.id = id;
        this.issuedAt = issuedAt;
        this.client = client;
    }


    public Long getId() { return id; }
    public Instant getIssuedAt() { return issuedAt; }
    public User getClient() { return client; }

    public void setId(Long id) { this.id = id; }
    public void setIssuedAt(Instant issuedAt) { this.issuedAt = issuedAt; }
    public void setClient(User client) { this.client = client; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
