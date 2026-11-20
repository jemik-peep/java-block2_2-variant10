import billing.Billing;
import model.CorporateSubscription;
import model.PromoCode;
import model.UserSubscription;
import service.impl.EmailNotification;
import service.impl.SmsNotification;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== СТАРТ СИСТЕМЫ БРОНИРОВАНИЯ БИЛЕТОВ ===");

        Billing userBilling = new Billing(new SmsNotification());
        UserSubscription userSub = new UserSubscription("Иван Иванов", -50.0, "Купе");
        PromoCode promo = new PromoCode("TRAIN2026", 0.20);

        double userPrice = userSub.calculateBillingPrice(promo);
        userBilling.processPayment(userSub, "+79991234567", userPrice);

        Billing corpBilling = new Billing(new EmailNotification());
        CorporateSubscription corpSub = new CorporateSubscription("ООО 'Рога и Копыта'", 2500.0, "СВ", 5);

        double corpPrice = corpSub.calculateBillingPrice(promo);
        corpBilling.processPayment(corpSub, "finance@roga-kopita.ru", corpPrice);

        Billing.printGlobalStats();
    }
}
