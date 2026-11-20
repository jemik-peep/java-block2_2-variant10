package model;

public class UserSubscription extends Subscription {

    public UserSubscription(String ownerName, double baseMonthlyPrice, String planType) {
        super(ownerName, baseMonthlyPrice, planType);
    }

    @Override
    public double calculateBillingPrice() {
        double tariffMultiplier = switch (getPlanType().toLowerCase()) {
            case "плацкарт", "economy", "s" -> {
                yield 1.0;
            }
            case "купе", "business", "m" -> {
                yield 1.7;
            }
            case "св", "first", "l" -> {
                yield 2.8;
            }
            default -> {
                System.out.println("[ПРЕДУПРЕЖДЕНИЕ] Неизвестный тариф '" + getPlanType() + "'. Применен стандартный коэффициент (1.0).");
                yield 1.0;
            }
        };

        return getBaseMonthlyPrice() * tariffMultiplier;
    }

    public double calculateBillingPrice(PromoCode promoCode) {
        double standardPrice = calculateBillingPrice();
        if (promoCode == null || promoCode.getCodeText() == null || promoCode.getCodeText().isEmpty()) {
            return standardPrice;
        }
        System.out.println("[ПРОМОКОД] Применен промокод: " + promoCode.getCodeText() + " (скидка " + (promoCode.getDiscountPercent() * 100) + "%)");
        return standardPrice * (1.0 - promoCode.getDiscountPercent());
    }
}
