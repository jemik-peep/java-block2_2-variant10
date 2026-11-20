package billing;

import model.Subscription;
import service.NotificationService;

public class Billing {
    private final NotificationService notificationService;

    private static int totalSubscribersCount = 0;
    private static double totalRevenue = 0.0;

    public Billing(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void processPayment(Subscription sub, String contact, double finalPrice) {
        totalSubscribersCount++;
        totalRevenue += finalPrice;

        System.out.println("\n--- ФИКСАЦИЯ ОПЛАТЫ ---");
        System.out.println("Клиент: " + sub.getOwnerName() + " | Тариф: " + sub.getPlanType());
        System.out.println("Сумма к списанию: " + finalPrice + " руб.");

        String message = "Ваша оплата на сумму " + finalPrice + " руб. успешно проведена. Спасибо!";
        notificationService.sendNotification(message, contact);
    }

    public static void printGlobalStats() {
        System.out.println("\n==========================================");
        System.out.println("     ГЛОБАЛЬНАЯ СТАТИСТИКА СИСТЕМЫ УЧЕТА     ");
        System.out.println("==========================================");
        System.out.println(" Всего оформлено подписок/билетов : " + totalSubscribersCount);
        System.out.println(" Суммарная выручка по системе     : " + totalRevenue + " руб.");
        System.out.println("==========================================");
    }
}
