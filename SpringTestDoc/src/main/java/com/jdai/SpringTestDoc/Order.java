package com.jdai.SpringTestDoc;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO);
    private long orderId;
    private String name;
    private double price;
    private int quantity;

    protected Order() {
    }

    public Order(long orderId, String name, double price, int quantity) {
        this.orderId = orderId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
