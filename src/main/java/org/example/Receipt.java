package org.example;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Receipt implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final AtomicInteger count = new AtomicInteger(0);
    private static int totalReceipts = 0;
    private static double totalSalesValue = 0.0;

    private int id;
    private Cashier cashier;
    private LocalDateTime dateTime;
    private List<ReceiptItem> items;
    private double totalValue;

    public Receipt(Cashier cashier, List<ReceiptItem> items, double totalValue) {
        this.id = count.incrementAndGet();
        this.cashier = cashier;
        this.dateTime = LocalDateTime.now();
        this.items = items;
        this.totalValue = totalValue;

        totalReceipts++;
        totalSalesValue += totalValue;

        saveToFile();
    }

    public int getId() {
        return id;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public List<ReceiptItem> getItems() {
        return items;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public static int getTotalReceipts() {
        return totalReceipts;
    }

    public static double getTotalSalesValue() {
        return totalSalesValue;
    }

    private void saveToFile() {
        String directoryPath = "receipts";
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(directoryPath + "/" + id + ".ser"))) {
            oos.writeObject(this);
            System.out.println("Receipt saved to: " + directory.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Receipt readFromFile(int id) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("receipts/" + id + ".ser"))) {
            return (Receipt) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", cashier=" + cashier +
                ", dateTime=" + dateTime +
                ", items=" + items +
                ", totalValue=" + totalValue +
                '}';
    }
}




