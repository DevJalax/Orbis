package com.scm.Supply.chain.apis.Entity;

import java.time.LocalDateTime;

import com.scm.Supply.chain.apis.DTO.NotificationChannel;
import com.scm.Supply.chain.apis.DTO.NotificationStatus;
import com.scm.Supply.chain.apis.DTO.NotificationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1000)
    private String message;

    @Column(nullable = false)
    private NotificationType type;

    @Column(nullable = false)
    private NotificationChannel channel;

    @Column(nullable = false)
    private Long recipientId;

    @Column(nullable = false)
    private LocalDateTime sentAt;

    @Column(nullable = false)
    private NotificationStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NotificationType getType() {
		return type;
	}

	public void setType(NotificationType type) {
		this.type = type;
	}

	public NotificationChannel getChannel() {
		return channel;
	}

	public void setChannel(NotificationChannel channel) {
		this.channel = channel;
	}

	public Long getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(Long recipientId) {
		this.recipientId = recipientId;
	}

	public LocalDateTime getSentAt() {
		return sentAt;
	}

	public void setSentAt(LocalDateTime sentAt) {
		this.sentAt = sentAt;
	}

	public NotificationStatus getStatus() {
		return status;
	}

	public void setStatus(NotificationStatus status) {
		this.status = status;
	}

}
