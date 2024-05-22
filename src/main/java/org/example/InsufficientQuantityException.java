package org.example;

public class InsufficientQuantityException extends Exception {
    private String goodsName;
    private int missingQuantity;

    public InsufficientQuantityException(String goodsName, int missingQuantity) {
        super("Insufficient quantity for " + goodsName + ". Missing: " + missingQuantity);
        this.goodsName = goodsName;
        this.missingQuantity = missingQuantity;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public int getMissingQuantity() {
        return missingQuantity;
    }
}

