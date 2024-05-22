package org.example;

import java.util.ArrayList;
import java.util.List;

public class CashDesk {
    private Cashier cashier;

    public CashDesk(Cashier cashier) {
        this.cashier = cashier;
    }

    public Receipt processTransaction(Client client, List<Goods> goods) {
        double totalCost = 0.0;
        List<ReceiptItem> receiptItems = new ArrayList<>();

        try {
            for (Goods good : goods) {
                int quantity = 1; // Assuming each client buys one unit of each good
                double price = good.calculateSellingPrice(0, 0, 0); // Assuming overcharge and discount logic is handled elsewhere
                good.reduceQuantity(quantity);
                totalCost += price * quantity;
                receiptItems.add(new ReceiptItem(good, quantity, price));
            }

            if (client.getBudget() >= totalCost) {
                client.deductFromBudget(totalCost);
                Receipt receipt = new Receipt(cashier, receiptItems, totalCost);
                return receipt;
            } else {
                System.out.println("Client " + client.getName() + " does not have enough money to buy the goods.");
                return null;
            }
        } catch (InsufficientQuantityException e) {
            System.out.println("Not enough quantity for " + e.getGoodsName() + ". Needed: " + e.getMissingQuantity());
            return null;
        }
    }

    @Override
    public String toString() {
        return "CashDesk{" +
                "cashier=" + cashier +
                '}';
    }
}




