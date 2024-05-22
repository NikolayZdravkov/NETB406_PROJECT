package org.example;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Goods implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private double deliveryPrice;
    private String category;
    private LocalDate expiryDate;
    private int quantity;

    public Goods(int id, String name, double deliveryPrice, String category, LocalDate expiryDate, int quantity) {
        this.id = id;
        this.name = name;
        this.deliveryPrice = deliveryPrice;
        this.category = category;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int amount) throws InsufficientQuantityException {
        if (quantity >= amount) {
            quantity -= amount;
        } else {
            throw new InsufficientQuantityException(name, amount - quantity);
        }
    }

    public abstract double calculateSellingPrice(double foodOvercharge, double nonFoodOvercharge, double discount);

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deliveryPrice=" + deliveryPrice +
                ", category='" + category + '\'' +
                ", expiryDate=" + expiryDate +
                ", quantity=" + quantity +
                '}';
    }
}

