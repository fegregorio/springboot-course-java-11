package com.madpezkoh.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.madpezkoh.course.entities.pk.OrderItemPK;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private final OrderItemPK id = new OrderItemPK();
    private Integer quantity;
    private Double price;


    @Deprecated
    public OrderItem() {}

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }


    public Integer getQuantity() { return quantity; }
    public Double getPrice() { return price; }
    public @JsonIgnore Order getOrder() { return id.getOrder(); }
    public Product getProduct() { return id.getProduct(); }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public void setPrice(Double price) { this.price = price; }
    public void setOrder(Order order) { id.setOrder(order); }
    public void setProduct(Product product) { id.setProduct(product); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        return id.equals(orderItem.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}