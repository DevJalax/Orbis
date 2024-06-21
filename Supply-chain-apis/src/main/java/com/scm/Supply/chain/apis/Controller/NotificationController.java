package com.scm.Supply.chain.apis.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Supply.chain.apis.DTO.NotificationChannel;
import com.scm.Supply.chain.apis.DTO.NotificationStatus;
import com.scm.Supply.chain.apis.DTO.NotificationType;
import com.scm.Supply.chain.apis.Entity.Notification;
import com.scm.Supply.chain.apis.Service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notifications = notificationService.getAllNotifications();
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    @GetMapping("/recipient/{recipientId}")
    public ResponseEntity<List<Notification>> getNotificationsByRecipientId(@PathVariable Long recipientId) {
        List<Notification> notifications = notificationService.getNotificationsByRecipientId(recipientId);
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Notification>> getNotificationsByType(@PathVariable NotificationType type) {
        List<Notification> notifications = notificationService.getNotificationsByType(type);
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    @GetMapping("/channel/{channel}")
    public ResponseEntity<List<Notification>> getNotificationsByChannel(@PathVariable NotificationChannel channel) {
        List<Notification> notifications = notificationService.getNotificationsByChannel(channel);
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Notification>> getNotificationsByStatus(@PathVariable NotificationStatus status) {
        List<Notification> notifications = notificationService.getNotificationsByStatus(status);
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        Notification createdNotification = notificationService.createNotification(notification);
        return new ResponseEntity<>(createdNotification, HttpStatus.CREATED);
    }
}
