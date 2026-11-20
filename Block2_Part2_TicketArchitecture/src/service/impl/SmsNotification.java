package service.impl;

import service.NotificationService;

public class SmsNotification implements NotificationService {
    @Override
    public void sendNotification(String message, String recipient) {
        if (recipient == null || recipient.length() < 11 || (!recipient.startsWith("+7") && !recipient.startsWith("8"))) {
            System.out.println("[ПРЕДУПРЕЖДЕНИЕ] Некорректный номер SMS: " + recipient + ". Требуется формат +7XXXXXXXXXX или 8XXXXXXXXXX.");
        }
        System.out.println("[SMS] На номер " + recipient + " отправлено сообщение: " + message);
    }
}
