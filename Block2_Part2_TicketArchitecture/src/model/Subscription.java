package model;

public abstract class Subscription {
    private final String ownerName;
    private double baseMonthlyPrice;
    private final String planType;

    public Subscription(String ownerName, double baseMonthlyPrice, String planType) {
        this.ownerName = ownerName;

        if (baseMonthlyPrice <= 0) {
            System.out.println("[ПРЕДУПРЕЖДЕНИЕ] Базовая цена не может быть <= 0. Установлено значение по умолчанию: 100.0");
            this.baseMonthlyPrice = 100.0;
        } else {
            this.baseMonthlyPrice = baseMonthlyPrice;
        }

        this.planType = (planType != null && !planType.isEmpty()) ? planType : "Плацкарт";
    }

    public abstract double calculateBillingPrice();

    public String getOwnerName() {
        return ownerName;
    }

    public double getBaseMonthlyPrice() {
        return baseMonthlyPrice;
    }

    public String getPlanType() {
        return planType;
    }
}
