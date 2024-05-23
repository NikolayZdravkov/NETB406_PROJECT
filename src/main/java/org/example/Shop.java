package org.example;

import org.example.FoodGoods;
import org.example.Goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {
    private double foodOverchargePercentage;
    private double nonFoodOverchargePercentage;
    private int daysToExpiryDiscount;
    private double discountPercentage;
    private List<Goods> inventory = new ArrayList<>();
    private List<Cashier> cashiers = new ArrayList<>();
    private List<Receipt> receipts = new ArrayList<>();
    private Map<Goods, Integer> deliveredGoods = new HashMap<>();
    private double totalIncome = 0.0;

    public Shop(double foodOverchargePercentage, double nonFoodOverchargePercentage, int daysToExpiryDiscount, double discountPercentage) {
        this.foodOverchargePercentage = foodOverchargePercentage;
        this.nonFoodOverchargePercentage = nonFoodOverchargePercentage;
        this.daysToExpiryDiscount = daysToExpiryDiscount;
        this.discountPercentage = discountPercentage;
    }

    public void deliverGoods(Goods goods) {
        inventory.add(goods);
        deliveredGoods.put(goods, goods.getQuantity());
    }

    public void sellGoods() {
        // Implementation remains the same
    }

    public void addCashier(Cashier cashier) {
        cashiers.add(cashier);
    }

    public void addReceipt(Receipt receipt) {
        receipts.add(receipt);
        totalIncome += receipt.getTotalValue();
    }

    public double calculateTotalCashierSalaries() {
        double totalSalaries = 0.0;
        for (Cashier cashier : cashiers) {
            totalSalaries += cashier.getSalary();
        }
        return totalSalaries;
    }

    public double calculateTotalDeliveredGoodsCost() {
        double totalCost = 0.0;
        for (Map.Entry<Goods, Integer> entry : deliveredGoods.entrySet()) {
            Goods goods = entry.getKey();
            int quantity = entry.getValue();
            totalCost += goods.getDeliveryPrice() * quantity;
        }
        return totalCost;
    }

    public double calculateTotalIncome() {
        return totalIncome;
    }

    public double calculateProfit() {
        double totalSalaries = calculateTotalCashierSalaries();
        double totalGoodsCost = calculateTotalDeliveredGoodsCost();
        return totalIncome - (totalSalaries + totalGoodsCost);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "totalCashierSalaries=" + calculateTotalCashierSalaries() +
                ", totalDeliveredGoodsCost=" + calculateTotalDeliveredGoodsCost() +
                ", totalIncome=" + calculateTotalIncome() +
                ", profit=" + calculateProfit() +
                '}';
    }
}


