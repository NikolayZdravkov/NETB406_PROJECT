package org.example;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create a shop with specific overcharge and expiry discount settings
        Shop shop = new Shop(20.0, 15.0, 5, 10.0);

        // Create and deliver food goods with quantities
        FoodGoods apple = new FoodGoods(1, "Apple", 1.0, LocalDate.now().plusDays(3), 10);
        FoodGoods banana = new FoodGoods(2, "Banana", 1.5, LocalDate.now().plusDays(10), 5);
        shop.deliverGoods(apple);
        shop.deliverGoods(banana);

        // Create and deliver non-food goods with quantities
        NonFoodGoods shampoo = new NonFoodGoods(3, "Shampoo", 5.0, LocalDate.now().plusDays(30), 20);
        NonFoodGoods soap = new NonFoodGoods(4, "Soap", 2.0, LocalDate.now().plusDays(15), 15);
        shop.deliverGoods(shampoo);
        shop.deliverGoods(soap);

        // Sell goods in the shop
        shop.sellGoods();

        // Create a cashier
        Cashier cashier = new Cashier(1, "John Doe", 2500.0);

        // Create a cash desk with the cashier
        CashDesk cashDesk = new CashDesk(cashier);

        // Create a client with a budget
        Client client = new Client("Jane Smith", 20.0);

        // Client selects goods to buy
        var selectedGoods = client.selectGoods(Arrays.asList(apple, banana, shampoo, soap));

        // Process the transaction
        Receipt receipt = cashDesk.processTransaction(client, selectedGoods);
        if (receipt != null) {
            System.out.println("Receipt created and saved: " + receipt);
        }

        // Read a receipt from file (assuming the id is 1 for this example)
        Receipt savedReceipt = Receipt.readFromFile(1);
        if (savedReceipt != null) {
            System.out.println("Receipt read from file: " + savedReceipt);
        }

        // Print total receipts and total sales value
        System.out.println("Total receipts created: " + Receipt.getTotalReceipts());
        System.out.println("Total value of sold goods: " + Receipt.getTotalSalesValue());
    }
}




