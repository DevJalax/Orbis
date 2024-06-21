package com.scm.Supply.chain.apis.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.DTO.NotificationChannel;
import com.scm.Supply.chain.apis.DTO.NotificationStatus;
import com.scm.Supply.chain.apis.DTO.NotificationType;
import com.scm.Supply.chain.apis.Entity.Notification;
import com.scm.Supply.chain.apis.Repo.NotificationRepository;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationSender notificationSender;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository, NotificationSender notificationSender) {
        this.notificationRepository = notificationRepository;
        this.notificationSender = notificationSender;
    }

    public List<Notification> getNotificationsByRecipientId(Long recipientId) {
        return notificationRepository.findNotificationsByRecipientId(recipientId);
    }

    public List<Notification> getNotificationsByType(NotificationType type) {
        return notificationRepository.findNotificationsByType(type);
    }

    public List<Notification> getNotificationsByChannel(NotificationChannel channel) {
        return notificationRepository.findNotificationsByChannel(channel);
    }

    public List<Notification> getNotificationsByStatus(NotificationStatus status) {
        return notificationRepository.findNotificationsByStatus(status);
    }

    public Notification createNotification(Notification notification) {
        notification.setSentAt(LocalDateTime.now());
        notification.setStatus(NotificationStatus.PENDING);
        Notification savedNotification = notificationRepository.save(notification);
        sendNotification(savedNotification);
        return savedNotification;
    }

    private void sendNotification(Notification notification) {
        try {
            notificationSender.send(notification);
            notification.setStatus(NotificationStatus.SENT);
        } catch (Exception e) {
            notification.setStatus(NotificationStatus.FAILED);
        }
        notificationRepository.save(notification);
    }
}