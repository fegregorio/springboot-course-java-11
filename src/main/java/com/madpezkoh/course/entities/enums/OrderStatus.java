package com.madpezkoh.course.entities.enums;

public enum OrderStatus {

    PENDING_PAYMENT(1),
    PAYMENT_CONFIRMED(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int step;


    OrderStatus(int step) {
        this.step = step;
    }


    public int getStep() { return step; }

    public static OrderStatus valueOf(int step) {
        if (step > 0 && step < OrderStatus.values().length) {
            return OrderStatus.values()[step - 1];
        }
        else {
            throw new IllegalArgumentException("Invalid request for OrderStatus.");
        }
    }
}
