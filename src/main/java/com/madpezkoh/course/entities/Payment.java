package com.madpezkoh.course.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant paymentDate;

    @OneToOne
    @MapsId
    private Order order;


    @Deprecated
    public Payment() {}

    public Payment(Long id, Instant paymentDate, Order order) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.order = order;
    }


    public Long getId() { return id; }
    public Instant getPaymentDate() { return paymentDate; }
    public Order getOrder() { return order; }

    public void setId(Long id) { this.id = id; }
    public void setPaymentDate(Instant paymentDate) { this.paymentDate = paymentDate; }
    public void setOrder(Order order) { this.order = order; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        return id.equals(payment.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
