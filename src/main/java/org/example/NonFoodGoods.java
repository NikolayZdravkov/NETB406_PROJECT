package org.example;

import org.example.Goods;

import java.time.LocalDate;

public class NonFoodGoods extends Goods {
    private static final long serialVersionUID = 1L;

    public NonFoodGoods(int id, String name, double deliveryPrice, LocalDate expiryDate, int quantity) {
        super(id, name, deliveryPrice, "Non-Food", expiryDate, quantity);
    }

    @Override
    public double calculateSellingPrice(double foodOvercharge, double nonFoodOvercharge, double discount) {
        double overcharge = nonFoodOvercharge;
        return getDeliveryPrice() * (1 + overcharge / 100);
    }
}

