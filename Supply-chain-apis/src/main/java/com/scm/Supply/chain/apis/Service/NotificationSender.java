package com.scm.Supply.chain.apis.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.Notification;

@Service
public class NotificationSender {

    private final EmailService emailService;
    private final SmsService smsService;
    private final PushNotificationService pushNotificationService;
    private final InAppNotificationService inAppNotificationService;

    @Autowired
    public NotificationSender(EmailService emailService, SmsService smsService, PushNotificationService pushNotificationService, InAppNotificationService inAppNotificationService) {
        this.emailService = emailService;
        this.smsService = smsService;
        this.pushNotificationService = pushNotificationService;
        this.inAppNotificationService = inAppNotificationService;
    }

    public void send(Notification notification) {
        switch (notification.getChannel()) {
            case EMAIL:
                emailService.send(notification);
                break;
            case SMS:
                smsService.send(notification);
                break;
            case PUSH_NOTIFICATION:
                pushNotificationService.send(notification);
                break;
            case IN_APP:
                inAppNotificationService.send(notification);
                break;
        }
    }
}