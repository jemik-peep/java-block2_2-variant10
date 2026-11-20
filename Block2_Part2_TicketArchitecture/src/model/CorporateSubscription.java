package model;

public class CorporateSubscription extends Subscription {
    private final int activeLicensesCount;

    public CorporateSubscription(String ownerName, double baseMonthlyPrice, String planType, int activeLicensesCount) {
        super(ownerName, baseMonthlyPrice, planType);

        if (activeLicensesCount < 1) {
            System.out.println("[ПРЕДУПРЕЖДЕНИЕ] Количество лицензий не может быть < 1. Установлено значение: 1.");
            this.activeLicensesCount = 1;
        } else {
            this.activeLicensesCount = activeLicensesCount;
        }
    }

    @Override
    public double calculateBillingPrice() {
        double tariffMultiplier = switch (getPlanType().toLowerCase()) {
            case "плацкарт", "economy", "s" -> 1.0;
            case "купе", "business", "m" -> 1.7;
            case "св", "first", "l" -> 2.8;
            default -> {
                System.out.println("[ПРЕДУПРЕЖДЕНИЕ] Неизвестный корпоративный тариф '" + getPlanType() + "'. Коэффициент: 1.0.");
                yield 1.0;
            }
        };

        return (getBaseMonthlyPrice() * tariffMultiplier) * activeLicensesCount;
    }

    public double calculateBillingPrice(PromoCode promoCode) {
        System.out.println("[ОШИБКА/ПРЕДУПРЕЖДЕНИЕ] Корпоративным клиентам промокоды не применяются! Расчет идет по стандартному тарифу.");
        return calculateBillingPrice();
    }

    public int getActiveLicensesCount() {
        return activeLicensesCount;
    }
}
