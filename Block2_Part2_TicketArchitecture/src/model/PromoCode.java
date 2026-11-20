package model;

public class PromoCode {
    private final String codeText;
    private final double discountPercent;

    public PromoCode(String codeText, double discountPercent) {
        this.codeText = codeText;
        this.discountPercent = discountPercent;
    }

    public String getCodeText() {
        return codeText;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }
}
