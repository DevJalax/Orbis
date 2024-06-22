package com.scm.Supply.chain.apis.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PushNotificationService {

    private static final Logger logger = LoggerFactory.getLogger(PushNotificationService.class);

    private final FirebaseMessaging firebaseMessaging;

    public PushNotificationService(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }

    public void sendToToken(String token, PushNotificationRequest request) {
        try {
            Message message = getPushNotificationMessage(token, request);
            String response = firebaseMessaging.send(message);
            logger.info("Message sent successfully: {}", response);
        } catch (FirebaseMessagingException e) {
            logger.error(e.getMessage());
        }
    }

    public void sendToTopic(String topic, PushNotificationRequest request) {
        try {
            Message message = getPushNotificationMessageForTopic(topic, request);
            String response = firebaseMessaging.send(message);
            logger.info("Message sent successfully: {}", response);
        } catch (FirebaseMessagingException e) {
            logger.error(e.getMessage());
        }
    }

    private Message getPushNotificationMessage(String token, PushNotificationRequest request) {
        return Message.builder()
                .setToken(token)
                .setNotification(Notification.builder()
                        .setTitle(request.getTitle())
                        .setBody(request.getBody())
                        .build())
                .putData("click_action", request.getClickAction())
                .build();
    }

    private Message getPushNotificationMessageForTopic(String topic, PushNotificationRequest request) {
        return Message.builder()
                .setTopic(topic)
                .setNotification(Notification.builder()
                        .setTitle(request.getTitle())
                        .setBody(request.getBody())
                        .build())
                .putData("click_action", request.getClickAction())
                .build();
    }
}
