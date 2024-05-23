package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CashierTest {

    @Test
    public void testGetSalary() {
        Cashier cashier = new Cashier(1, "John Doe", 2500.0);
        assertEquals(2500.0, cashier.getSalary());
    }

    @Test
    public void testGetName() {
        Cashier cashier = new Cashier(1, "John Doe", 2500.0);
        assertEquals("John Doe", cashier.getName());
    }

    @Test
    public void testGetId() {
        Cashier cashier = new Cashier(1, "John Doe", 2500.0);
        assertEquals(1, cashier.getId());
    }
}
