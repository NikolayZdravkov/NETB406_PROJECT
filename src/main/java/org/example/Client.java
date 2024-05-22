package org.example;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private double budget;

    public Client(String name, double budget) {
        this.name = name;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public double getBudget() {
        return budget;
    }

    public void deductFromBudget(double amount) {
        if (amount <= budget) {
            budget -= amount;
        }
    }

    public List<Goods> selectGoods(List<Goods> availableGoods) {
        return new ArrayList<>(availableGoods);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", budget=" + budget +
                '}';
    }
}

