package org.example;

import java.time.LocalDate;

public class FoodGoods extends Goods {
    private static final long serialVersionUID = 1L;

    public FoodGoods(int id, String name, double deliveryPrice, LocalDate expiryDate, int quantity) {
        super(id, name, deliveryPrice, "Food", expiryDate, quantity);
    }

    @Override
    public double calculateSellingPrice(double foodOvercharge, double nonFoodOvercharge, double discount) {
        double overcharge = foodOvercharge;
        if (getExpiryDate().isBefore(LocalDate.now().plusDays(5))) {
            return getDeliveryPrice() * (1 + overcharge / 100) * (1 - discount / 100);
        }
        return getDeliveryPrice() * (1 + overcharge / 100);
    }
}

