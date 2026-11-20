package service.impl;

import service.NotificationService;

public class EmailNotification implements NotificationService {
    @Override
    public void sendNotification(String message, String recipient) {
        if (recipient == null || !recipient.contains("@") || !recipient.contains(".")) {
            System.out.println("[ПРЕДУПРЕЖДЕНИЕ] Некорректный Email: " + recipient + ". Письмо может не дойти.");
        }
        System.out.println("[EMAIL] На адрес " + recipient + " отправлено письмо: " + message);
    }
}
