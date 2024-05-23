package org.example;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create the first shop with specific overcharge and expiry discount settings
        Shop shop1 = new Shop(20.0, 15.0, 5, 10.0);

        // Create and deliver food goods with quantities
        FoodGoods apple = new FoodGoods(1, "Apple", 1.0, LocalDate.now().plusDays(3), 10);
        FoodGoods banana = new FoodGoods(2, "Banana", 1.5, LocalDate.now().plusDays(10), 5);
        shop1.deliverGoods(apple);
        shop1.deliverGoods(banana);

        // Create and deliver non-food goods with quantities
        NonFoodGoods shampoo = new NonFoodGoods(3, "Shampoo", 5.0, LocalDate.now().plusDays(30), 20);
        NonFoodGoods soap = new NonFoodGoods(4, "Soap", 2.0, LocalDate.now().plusDays(15), 15);
        shop1.deliverGoods(shampoo);
        shop1.deliverGoods(soap);

        // Sell goods in the first shop
        shop1.sellGoods();

        // Create a cashier for the first shop
        Cashier cashier1 = new Cashier(1, "John Doe", 2500.0);
        shop1.addCashier(cashier1);

        // Create a cash desk with the cashier for the first shop
        CashDesk cashDesk1 = new CashDesk(cashier1);

        // Create a client with a budget for the first shop
        Client client1 = new Client("Jane Smith", 20.0);

        // Client selects goods to buy for the first shop
        var selectedGoods1 = client1.selectGoods(Arrays.asList(apple, banana, shampoo, soap));

        // Process the transaction for the first shop
        Receipt receipt1 = cashDesk1.processTransaction(client1, selectedGoods1);
        if (receipt1 != null) {
            shop1.addReceipt(receipt1);
            System.out.println("Receipt created and saved for Shop 1: " + receipt1);
        }

        // Print financial summary for the first shop
        System.out.println("Shop 1 Financial Summary:");
        System.out.println(shop1);

        // Create the second shop with different settings
        Shop shop2 = new Shop(25.0, 10.0, 7, 15.0);

        // Create and deliver food goods with quantities for the second shop
        FoodGoods orange = new FoodGoods(5, "Orange", 1.2, LocalDate.now().plusDays(4), 12);
        FoodGoods grape = new FoodGoods(6, "Grape", 2.0, LocalDate.now().plusDays(8), 8);
        shop2.deliverGoods(orange);
        shop2.deliverGoods(grape);

        // Create and deliver non-food goods with quantities for the second shop
        NonFoodGoods detergent = new NonFoodGoods(7, "Detergent", 6.0, LocalDate.now().plusDays(40), 10);
        NonFoodGoods toothpaste = new NonFoodGoods(8, "Toothpaste", 3.0, LocalDate.now().plusDays(20), 25);
        shop2.deliverGoods(detergent);
        shop2.deliverGoods(toothpaste);

        // Sell goods in the second shop
        shop2.sellGoods();

        // Create a cashier for the second shop
        Cashier cashier2 = new Cashier(2, "Alice Johnson", 2700.0);
        shop2.addCashier(cashier2);

        // Create a cash desk with the cashier for the second shop
        CashDesk cashDesk2 = new CashDesk(cashier2);

        // Create a client with a budget for the second shop
        Client client2 = new Client("Bob Brown", 30.0);

        // Client selects goods to buy for the second shop
        var selectedGoods2 = client2.selectGoods(Arrays.asList(orange, grape, detergent, toothpaste));

        // Process the transaction for the second shop
        Receipt receipt2 = cashDesk2.processTransaction(client2, selectedGoods2);
        if (receipt2 != null) {
            shop2.addReceipt(receipt2);
            System.out.println("Receipt created and saved for Shop 2: " + receipt2);
        }

        // Print financial summary for the second shop
        System.out.println("Shop 2 Financial Summary:");
        System.out.println(shop2);
    }
}





