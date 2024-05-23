package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopTest {
    private Shop shop;

    @BeforeEach
    public void setUp() {
        shop = new Shop(20.0, 15.0, 5, 10.0);
    }

    @Test
    public void testCalculateTotalCashierSalaries() {
        Cashier cashier1 = new Cashier(1, "John Doe", 2500.0);
        Cashier cashier2 = new Cashier(2, "Alice Johnson", 2700.0);
        shop.addCashier(cashier1);
        shop.addCashier(cashier2);
        assertEquals(5200.0, shop.calculateTotalCashierSalaries());
    }

    @Test
    public void testCalculateTotalDeliveredGoodsCost() {
        FoodGoods apple = new FoodGoods(1, "Apple", 1.0, LocalDate.now().plusDays(3), 10);
        NonFoodGoods shampoo = new NonFoodGoods(2, "Shampoo", 5.0, LocalDate.now().plusDays(30), 20);
        shop.deliverGoods(apple);
        shop.deliverGoods(shampoo);
        assertEquals(110.0, shop.calculateTotalDeliveredGoodsCost());
    }

    @Test
    public void testCalculateTotalIncome() {
        // Assuming there's a method to simulate a sale and create a receipt
        // For testing, we will manually add receipts
        Cashier cashier = new Cashier(1, "John Doe", 2500.0);
        shop.addCashier(cashier);
        CashDesk cashDesk = new CashDesk(cashier);
        Client client = new Client("Jane Smith", 100.0);
        FoodGoods apple = new FoodGoods(1, "Apple", 1.0, LocalDate.now().plusDays(3), 10);
        NonFoodGoods shampoo = new NonFoodGoods(2, "Shampoo", 5.0, LocalDate.now().plusDays(30), 20);
        shop.deliverGoods(apple);
        shop.deliverGoods(shampoo);
        var selectedGoods = client.selectGoods(Arrays.asList(apple, shampoo));
        Receipt receipt = cashDesk.processTransaction(client, selectedGoods);
        if (receipt != null) {
            shop.addReceipt(receipt);
        }
        assertEquals(receipt.getTotalValue(), shop.calculateTotalIncome());
    }

    @Test
    public void testCalculateProfit() {
        Cashier cashier = new Cashier(1, "John Doe", 2500.0);
        shop.addCashier(cashier);
        CashDesk cashDesk = new CashDesk(cashier);
        Client client = new Client("Jane Smith", 100.0);
        FoodGoods apple = new FoodGoods(1, "Apple", 1.0, LocalDate.now().plusDays(3), 10);
        NonFoodGoods shampoo = new NonFoodGoods(2, "Shampoo", 5.0, LocalDate.now().plusDays(30), 20);
        shop.deliverGoods(apple);
        shop.deliverGoods(shampoo);
        var selectedGoods = client.selectGoods(Arrays.asList(apple, shampoo));
        Receipt receipt = cashDesk.processTransaction(client, selectedGoods);
        if (receipt != null) {
            shop.addReceipt(receipt);
        }
        double totalIncome = shop.calculateTotalIncome();
        double totalSalaries = shop.calculateTotalCashierSalaries();
        double totalGoodsCost = shop.calculateTotalDeliveredGoodsCost();
        assertEquals(totalIncome - (totalSalaries + totalGoodsCost), shop.calculateProfit());
    }
}
