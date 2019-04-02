package com.aor.refactoring.example3;

public class PercentageDiscount implements Discount {
    private double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    public double applyDiscount(double price) {
        return (percentage < 1) ? price - price * percentage : 0;
    }
}
