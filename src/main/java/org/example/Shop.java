package org.example;

import org.example.FoodGoods;
import org.example.Goods;

import java.util.ArrayList;
import java.util.List;

class Shop {
    private List<Goods> inventory = new ArrayList<>();
    private double foodOverchargePercent;
    private double nonFoodOverchargePercent;
    private int daysToExpiryDiscount;
    private double expiryDiscountPercent;

    public Shop(double foodOverchargePercent, double nonFoodOverchargePercent, int daysToExpiryDiscount, double expiryDiscountPercent) {
        this.foodOverchargePercent = foodOverchargePercent;
        this.nonFoodOverchargePercent = nonFoodOverchargePercent;
        this.daysToExpiryDiscount = daysToExpiryDiscount;
        this.expiryDiscountPercent = expiryDiscountPercent;
    }

    public void deliverGoods(Goods goods) {
        inventory.add(goods);
    }

    public void sellGoods() {
        for (Goods goods : inventory) {
            double sellingPrice;
            if (goods instanceof FoodGoods) {
                sellingPrice = goods.calculateSellingPrice(foodOverchargePercent, daysToExpiryDiscount, expiryDiscountPercent);
            } else {
                sellingPrice = goods.calculateSellingPrice(nonFoodOverchargePercent, daysToExpiryDiscount, expiryDiscountPercent);
            }
            if (sellingPrice > 0) {
                System.out.println("Selling " + goods.getName() + " at price: " + sellingPrice);
            } else {
                System.out.println(goods.getName() + " is expired and cannot be sold.");
            }
        }
    }

    public Goods findGoodsById(int id) {
        for (Goods goods : inventory) {
            if (goods.getId() == id) {
                return goods;
            }
        }
        return null;
    }
}

