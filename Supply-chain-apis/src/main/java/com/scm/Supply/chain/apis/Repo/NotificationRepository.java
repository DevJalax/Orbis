package com.scm.Supply.chain.apis.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scm.Supply.chain.apis.DTO.NotificationChannel;
import com.scm.Supply.chain.apis.DTO.NotificationStatus;
import com.scm.Supply.chain.apis.DTO.NotificationType;
import com.scm.Supply.chain.apis.Entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    @Query("SELECT n FROM Notification n WHERE n.recipientId = :recipientId")
    List<Notification> findNotificationsByRecipientId(@Param("recipientId") Long recipientId);

    @Query("SELECT n FROM Notification n WHERE n.type = :type")
    List<Notification> findNotificationsByType(@Param("type") NotificationType type);

    @Query("SELECT n FROM Notification n WHERE n.channel = :channel")
    List<Notification> findNotificationsByChannel(@Param("channel") NotificationChannel channel);

    @Query("SELECT n FROM Notification n WHERE n.status = :status")
    List<Notification> findNotificationsByStatus(@Param("status") NotificationStatus status);
}
