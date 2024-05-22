package org.example;

import java.io.Serializable;

public class ReceiptItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private Goods goods;
    private int quantity;
    private double price;

    public ReceiptItem(Goods goods, int quantity, double price) {
        this.goods = goods;
        this.quantity = quantity;
        this.price = price;
    }

    public Goods getGoods() {
        return goods;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ReceiptItem{" +
                "goods=" + goods +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}


