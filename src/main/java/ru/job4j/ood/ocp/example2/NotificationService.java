package ru.job4j.ood.ocp.example2;

/**
 * Если нам нужно кроме отправки сообщения по электронной почте
 * отправлять еще смс сообщения, можно дописать метод sendMessage,
 * Но в данном случае мы нарушим принцип ocp, потому что класс
 * должен быть закрыт для модификации, но открыт для расширения,
 * а мы модифицируем (изменяем) метод.
 * Нужно создать интерфейс NotificationService и в нем поместить
 * метод sendMessage
 */
public class NotificationService {
    public void sendMessage(String typeMessage, String message) {
        if (typeMessage.equals("email")) {
            System.out.println("write email");
            System.out.println("use JavaMailSenderAPI");
        }
        if (typeMessage.equals("sms")) {
            System.out.println("write sms");
            System.out.println("send sms");

        }
    }
}
